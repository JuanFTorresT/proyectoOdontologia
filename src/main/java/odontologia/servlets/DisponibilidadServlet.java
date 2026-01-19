package odontologia.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import service.DisponibilidadService;
import ondontologia.model.BloqueDisponible;

@WebServlet("/disponibilidad")
public class DisponibilidadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LocalDate start = LocalDate.parse(request.getParameter("start"));
        LocalDate end = LocalDate.parse(request.getParameter("end"));

        List<Map<String, Object>> eventos = new ArrayList<>();

        LocalDate fecha = start;
        while (!fecha.isAfter(end)) {

            List<BloqueDisponible> bloques = DisponibilidadService.obtenerDisponibilidad(fecha);

            for (BloqueDisponible b : bloques) {
                Map<String, Object> e = new HashMap<>();
                e.put("title", "Disponible");
                e.put("start", fecha + "T" + b.getInicio());
                e.put("end", fecha + "T" + b.getFin());
                e.put("color", "#2ecc71");

                Map<String, Object> props = new HashMap<>();
                props.put("idOdontologo", b.getIdOdontologo());
                props.put("doctor", b.getNombreOdontologo());
                e.put("extendedProps", props);

                eventos.add(e);
            }

            fecha = fecha.plusDays(1);
        }

        response.setContentType("application/json");
        new ObjectMapper().writeValue(response.getWriter(), eventos);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

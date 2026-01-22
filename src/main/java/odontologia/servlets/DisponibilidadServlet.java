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

@WebServlet("/DisponibilidadServlet")
public class DisponibilidadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	//Se crean dos variables para traer el valor que se está recibiendo del fetch que está haciendo la peticion HTTP al get del servlet y pasando el valor de start y end.
        LocalDate start = LocalDate.parse(request.getParameter("start"));//fecha de hoy
        LocalDate end = LocalDate.parse(request.getParameter("end"));//de hoy en 15 días

        //Se crea una arraylist que va a contener mapas que son los eventos !!!ESTO NO LO ENTIENDO DEL TODO!!!
        List<Map<String, Object>> eventos = new ArrayList<>();

        //establece a fecha el valor de hoy que es recibido por parametros en la peticion get
        LocalDate fecha = start;
        //mientras que hoy despues sea despues que dentro de 15 días sea falso entonces va a ejutar el bucle while
        while (!fecha.isAfter(end)) {

        	//se crea una lista de bloques disponibles usando el metodo obtenerDisponibilidad de disponibilidad service pasandole como argumento la fecha de hoy
            List<BloqueDisponible> bloques = DisponibilidadService.obtenerDisponibilidad(fecha);

            //por cada bloque disponible encontrado en la lista de bloques disponibles se va a hacer lo siguiente:
            for (BloqueDisponible b : bloques) {
            	
            	//se va a crear un nuevo Hashmap que en realidad es un evento para agregarlo a el arraylist de eventos.
                Map<String, Object> e = new HashMap<>();
                
                //a ese evento se le va a establecer un titulo, hora de inicio, hora de fin y un color.
                e.put("title", "Disponible");
                e.put("start", fecha + "T" + b.getInicio());
                e.put("end", fecha + "T" + b.getFin());
                e.put("color", "#2ecc71");

                //Se va crear un hashmap de propiedades extendidas del evento
                Map<String, Object> props = new HashMap<>();
                
                // como propiedades se van a agregar el id del odontologo y el nombre.
                props.put("idOdontologo", b.getIdOdontologo());
                props.put("doctor", b.getNombreOdontologo());
                e.put("extendedProps", props);

                //al final se va a agregar ese evento a la lista de eventos.
                eventos.add(e);
            }

            // la fecha ahora es la fecha anterior + 1. en este caso hasta llegar a 15
            fecha = fecha.plusDays(1);
        }

        //le dice al fetch que se le va a enviar un json
        response.setContentType("application/json;charset=UTF-8");
        
        /*
         * ObjectMapper es una clase de jackson que convierte objetos java en JSON, se llama serialziacion
         * response.getWriter() obtiene el stream de salida de la respuesta HTTP, es donde se escribe lo que el servidor va a devolver al fetch, que en este caso son los eventos.
         * 
         * setContentType → digo que es JSON
		 * ObjectMapper   → convierto Java a JSON
		 * writer  		  → lo envío
         */
        new ObjectMapper().writeValue(response.getWriter(), eventos);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

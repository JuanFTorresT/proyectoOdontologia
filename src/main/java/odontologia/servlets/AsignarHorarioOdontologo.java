package odontologia.servlets;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import odntologia.DAO.OdontologoDAO;
import ondontologia.model.Horario;

/**
 * Servlet implementation class AsignarHorarioOdontologo
 */
@WebServlet("/AsignarHorarioOdontologo")
public class AsignarHorarioOdontologo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OdontologoDAO ondontologoDAO = new OdontologoDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsignarHorarioOdontologo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//asignacion de horario
		
		String accion = request.getParameter("accionAsignarHorario");




		
		if ("AsignarHorario".equals(accion)) {
			LocalTime horaInicio = LocalTime.parse(request.getParameter("horaInicio"));
			LocalTime horaFin = LocalTime.parse(request.getParameter("horaFin"));
			
			System.out.println(horaInicio);
			System.out.println(horaFin);
			int idOdontologo = Integer.parseInt(request.getParameter("idOdontologo"));
			Horario horario = new Horario(horaInicio, horaFin);
			ondontologoDAO.asignarHorario(idOdontologo, horario);
		}
		

	}

}

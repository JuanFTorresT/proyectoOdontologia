package odontologia.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import odntologia.DAO.PacienteDAO;
import ondontologia.model.Odontologo;
import ondontologia.model.Paciente;

/**
 * Servlet implementation class CrearPacienteServlet
 */
@WebServlet("/CrearPacienteServlet")
public class CrearPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PacienteDAO pacienteDAO = new PacienteDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearPacienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		//Creacion del odontologo
		String nombre = request.getParameter("nombrePaciente");
		String apellido = request.getParameter("apellidoPaciente");
		String identificiacion = request.getParameter("identificacionPaciente");
		LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimientoPaciente"));
		String direccion = request.getParameter("direccionPaciente");
		String celular = request.getParameter("celularPaciente");
		boolean seguro = request.getParameter("seguro") != null;
		String tipoSangre = request.getParameter("tipoSangre");

		
		Paciente nuevoPaciente = new Paciente(identificiacion, nombre, apellido, fechaNacimiento, direccion, celular, seguro, tipoSangre);
		
		
		
		try {
			pacienteDAO.registrarPaciente(nuevoPaciente);
			response.sendRedirect(request.getContextPath() + "/CargarPacientesServlet");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

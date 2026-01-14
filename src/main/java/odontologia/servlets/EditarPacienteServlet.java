package odontologia.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import odntologia.DAO.PacienteDAO;
import ondontologia.model.Paciente;

/**
 * Servlet implementation class EditarPacienteServlet
 */
@WebServlet("/EditarPacienteServlet")
public class EditarPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PacienteDAO pacienteDAO = new PacienteDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPacienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if("buscarPorId".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			Paciente paciente = pacienteDAO.buscarPorId(id);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			
			String fecha = paciente.getFechaNacimiento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

			String json = "{"
			        + "\"id\":" + paciente.getId() + ","
			        + "\"nombre\":\"" + paciente.getNombre() + "\","
			        + "\"apellido\":\"" + paciente.getApellido() + "\","
			        + "\"identificacion\":\"" + paciente.getIdentificacion() + "\","
			        + "\"fechaNacimiento\":\"" + fecha + "\","
			        + "\"direccion\":\"" + paciente.getDireccion() + "\","
			        + "\"celular\":\"" + paciente.getCelular() + "\","
			        + "\"seguro\":" + paciente.isTieneSeguro() + ","
			        + "\"tipoSangre\":\"" + paciente.getTipoSangre() + "\""
			        + "}";

		        response.getWriter().write(json);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("🔥 DO POST EDITAR PACIENTE 🔥");
		
		request.setCharacterEncoding("UTF-8");
		
		//Creacion del odontologo
		int id = Integer.parseInt(request.getParameter("idEditarPaciente"));
		String nombre = request.getParameter("editarNombrePaciente");
		String apellido = request.getParameter("editarApellidoPaciente");
		String identificiacion = request.getParameter("editarIdentificacionPaciente");
		LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("editarFechaNacimientoPaciente"));
		String direccion = request.getParameter("editarDireccionPaciente");
		String celular = request.getParameter("editarCelularPaciente");
		boolean seguro = request.getParameter("editarSeguro") != null;
		String tipoSangre = request.getParameter("editarTipoSangre");

		
		Paciente nuevoPaciente = new Paciente(identificiacion, nombre, apellido, fechaNacimiento, direccion, celular, seguro, tipoSangre);
		

		
		nuevoPaciente.setId(id);
		
		
		
		try {
			pacienteDAO.editarPaciente(nuevoPaciente);
			response.sendRedirect(request.getContextPath() + "/CargarPacientesServlet");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

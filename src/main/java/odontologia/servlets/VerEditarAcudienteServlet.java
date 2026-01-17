package odontologia.servlets;

import java.io.Console;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import odntologia.DAO.AcudienteDAO;
import ondontologia.model.Acudiente;
import ondontologia.model.Paciente;

/**
 * Servlet implementation class VerEditarAcudienteServlet
 */
@WebServlet("/VerEditarAcudienteServlet")
public class VerEditarAcudienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AcudienteDAO acudienteDAO = new AcudienteDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerEditarAcudienteServlet() {
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
			
			Acudiente acudiente = acudienteDAO.buscarPorId(id);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			
			String fecha = acudiente.getFechaNacimiento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			

			String json = "{"
			        + "\"id\":" + acudiente.getIdAcudiente() + ","
			        + "\"nombre\":\"" + acudiente.getNombre() + "\","
			        + "\"apellido\":\"" + acudiente.getApellido() + "\","
			        + "\"identificacion\":\"" + acudiente.getIdentificacion() + "\","
			        + "\"fechaNacimiento\":\"" + fecha + "\","
			        + "\"direccion\":\"" + acudiente.getDireccion() + "\","
			        + "\"celular\":\"" + acudiente.getCelular() + "\","
			        + "\"parentesco\":\"" + acudiente.getParentesco() + "\""
			        + "}";

		        response.getWriter().write(json);
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		

		//Creacion del acudiente
		int idPaciente = Integer.parseInt(request.getParameter("idEditarPaciente"));
//		int idAcudiente = Integer.parseInt(request.getParameter("verEditarIdAcudiente"));
		String nombre = request.getParameter("verEditarNombreAcudiente");
		String apellido = request.getParameter("verEditarApellidoAcudiente");
		String identificiacion = request.getParameter("verEditarIdentificacionAcudiente");
		LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("verEditarFechaNacimientoAcudiente"));
		String direccion = request.getParameter("verEditarDireccionAcudiente");
		String celular = request.getParameter("verEditarCelularAcudiente");
		String parentesco = request.getParameter("verEditarParentescoAcudiente");

		System.out.println("El id del paciente es: " + idPaciente);
		
		Acudiente acudiente = new Acudiente(idPaciente, identificiacion, nombre, apellido, fechaNacimiento, direccion, celular, parentesco);


		

		
		
		
		try {
			if (acudienteDAO.buscarPorId(idPaciente)==null) {
				acudienteDAO.registrarAcudiente(acudiente);
				response.sendRedirect(request.getContextPath() + "/CargarPacientesServlet");
			}else {
				acudienteDAO.editarAcudiente(acudiente);
				response.sendRedirect(request.getContextPath() + "/CargarPacientesServlet");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

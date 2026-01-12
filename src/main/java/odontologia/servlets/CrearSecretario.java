package odontologia.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import odntologia.DAO.OdontologoDAO;
import odntologia.DAO.SecretarioDAO;
import ondontologia.model.Conexion;
import ondontologia.model.Odontologo;
import ondontologia.model.Secretario;
import ondontologia.model.Usuario;

/**
 * Servlet implementation class ValidarRegistro
 */
@WebServlet("/CrearSecretario")
public class CrearSecretario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SecretarioDAO secretarioDAO = new SecretarioDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearSecretario() {
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
		request.setCharacterEncoding("UTF-8");
		//Creacion del odontologo
		String nombre = request.getParameter("nombreSecretario");
		String apellido = request.getParameter("apellidoSecretario");
		String identificiacion = request.getParameter("identificacionSecretario");
		LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimientoSecretario"));
		String direccion = request.getParameter("direccionSecretario");
		String celular = request.getParameter("celularSecretario");
		String sector = request.getParameter("sector");

		
		Secretario nuevoSecretario = new Secretario(identificiacion, nombre, apellido, fechaNacimiento, direccion, celular, sector);
	
		try {
			secretarioDAO.registrarSecretario(nuevoSecretario);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//creacion del usuario
		
		String usuario = request.getParameter("usuarioSecretario");
		String contrasena = request.getParameter("contrasenaSecretario");
		String repetirContrasena = request.getParameter("repetirContrasenaSecretario");
		String rol = "Secretario";
		
		if(contrasena.equals(repetirContrasena)) {
			Usuario nuevoUsuario = new Usuario(usuario, contrasena, rol);
			
			try {
				secretarioDAO.registrarUsuarioSecretario(nuevoUsuario);
				response.sendRedirect(request.getContextPath() + "/CargarUsuariosServlet");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Las contraseñas no coinciden");
		}
		


		
		
		
	}

}

package odontologia.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import odntologia.DAO.OdontologoDAO;
import ondontologia.model.Conexion;
import ondontologia.model.Horario;
import ondontologia.model.Odontologo;
import ondontologia.model.Usuario;

/**
 * Servlet implementation class ValidarRegistro
 */
@WebServlet("/CrearOdontologo")
public class CrearOdontologo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OdontologoDAO ondontologoDAO = new OdontologoDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearOdontologo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//Creacion del odontologo
		String nombre = request.getParameter("nombreOdontologo");
		String apellido = request.getParameter("apellidoOdontologo");
		String identificiacion = request.getParameter("identificacionOdontologo");
		LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimientoOdontologo"));
		String direccion = request.getParameter("direccionOdontologo");
		String celular = request.getParameter("celularOdontologo");
		String especialidad = request.getParameter("especialidad");

		
		Odontologo nuevoOdontologo = new Odontologo(identificiacion, nombre, apellido, fechaNacimiento, direccion, celular, especialidad);
		
		
		try {
			ondontologoDAO.registrarOdontologo(nuevoOdontologo);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//creacion del usuario
		
		String usuario = request.getParameter("usuarioOdontologo");
		String contrasena = request.getParameter("contrasenaOdontologo");
		String repetirContrasena = request.getParameter("repeticionContrasenaOdontologo");
		String rol = "Odontologo";
		
		if(contrasena.equals(repetirContrasena)) {
			Usuario nuevoUsuario = new Usuario(usuario, contrasena, rol);
			try {
				ondontologoDAO.registrarUsuarioOdontologo(nuevoUsuario);
				response.sendRedirect(request.getContextPath() + "/CargarUsuariosServlet");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		

		


		
		
		
	}

}

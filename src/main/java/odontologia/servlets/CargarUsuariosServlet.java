package odontologia.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import odntologia.DAO.OdontologoDAO;
import odntologia.DAO.SecretarioDAO;
import ondontologia.model.Odontologo;
import ondontologia.model.Secretario;

/**
 * Servlet implementation class OdontologoServlet
 */
@WebServlet("/CargarUsuariosServlet")
public class CargarUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OdontologoDAO ondontologoDAO = new OdontologoDAO();
	private SecretarioDAO secretarioDAO = new SecretarioDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargarUsuariosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<Odontologo> listaOdontologos = ondontologoDAO.obtenerListaOdontologos();
		List<Secretario> listaSecretarios = secretarioDAO.obtenerListaSecretarios();

		request.setAttribute("listaOdontologos", listaOdontologos);
		request.setAttribute("listaSecretarios", listaSecretarios);
		request.getRequestDispatcher("usuarios.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

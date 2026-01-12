package odontologia.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import odntologia.DAO.PacienteDAO;

/**
 * Servlet implementation class EliminarPacienteServlet
 */
@WebServlet("/EliminarPacienteServlet")
public class EliminarPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PacienteDAO pacienteDAO = new PacienteDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarPacienteServlet() {
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
		
		
		String action = request.getParameter("accionEliminar");
		
		if ("eliminar".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			pacienteDAO.EliminarPaciente(id);
			response.sendRedirect(request.getContextPath() + "/CargarPacientesServlet");
		}
		
		
	}

}

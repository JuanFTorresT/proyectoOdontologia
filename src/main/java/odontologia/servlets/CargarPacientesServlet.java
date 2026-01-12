package odontologia.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import odntologia.DAO.OdontologoDAO;
import odntologia.DAO.PacienteDAO;
import odntologia.DAO.SecretarioDAO;
import ondontologia.model.Odontologo;
import ondontologia.model.Paciente;
import ondontologia.model.Secretario;

/**
 * Servlet implementation class OdontologoServlet
 */
@WebServlet("/CargarPacientesServlet")
public class CargarPacientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PacienteDAO pacienteDAO = new PacienteDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargarPacientesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<Paciente> listaPacientes = pacienteDAO.obtenerListaPacientes();
		
		System.out.println(listaPacientes);

		request.setAttribute("listaPacientes", listaPacientes);

		request.getRequestDispatcher("pacientes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}

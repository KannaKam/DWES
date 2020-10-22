package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpleadoDAO;
import model.Empleado;

/**
 * Servlet implementation class EmpleadoServlet
 */
@WebServlet("/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String action = request.getParameter("action");

	        try {
	            switch (action) {
	                case "insert":
	                    insertarEmpleado(request, response);
	                    break;
	                case "lista":
	                	listarEmpleados(request, response);
	                    break;
	                case"eliminar":
	                	eliminarEmpleado(request, response);
	                	break;
	                case "editar":
	                    actualizarEmpleado(request,response);
	                    break;
	                case "menu":
	                    paginaPrincipal(request,response);
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void listarEmpleados(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Empleado > listaEmpleado = EmpleadoDAO.listarEmpleados();
		        request.setAttribute("listaEmpleado", listaEmpleado);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/lista.jsp");
		        dispatcher.forward(request, response);
		    }
	
	 private void insertarEmpleado(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        String nombre = request.getParameter("nombre");
			        String dni = request.getParameter("dni");
			        String sexo = request.getParameter("sexo");
			        int anyos =Integer.parseInt(request.getParameter("anyos")) ;
			        int categoria = Integer.parseInt(request.getParameter("categoria")) ;
			        Empleado empleado = new Empleado(nombre, dni, sexo, anyos, categoria);
			        EmpleadoDAO.insertarEmpleado(empleado);
			    }
	 
	 private void paginaPrincipal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	        dispatcher.forward(request, response);
	 }
	 private void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
			        String dni = request.getParameter("dni");
			        EmpleadoDAO.eliminarEmpleado(dni);
			        listarEmpleados(request,response);

			    }
	 private void actualizarEmpleado(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
			        
			        String dni = request.getParameter("dni");
			        
			        Empleado empleado = EmpleadoDAO.extraerEmpleado(dni);
			        request.setAttribute("empleado",empleado);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/editarEmpleado.jsp");
			        dispatcher.forward(request, response);
			        
			        
			    }
}

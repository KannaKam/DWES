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
import dao.*;


/**
 * Servlet implementation class ServletEmpleado
 */
@WebServlet("/ServletEmpleado")
public class ServletEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletEmpleado() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String action = request.getParameter("action");

		switch (action) {
		    case "mostrar":
		        mostrarEmpleado(request, response);
		        break;
		    case "form":
		    	cargarFormulario(request, response);
		    	break;
		}
	}

	private void gestionarEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String dni = request.getParameter("dni");
		System.out.println(dni);
		Empleado empleado = EmpleadoDAO.buscarEmpleado(dni);
		request.setAttribute("empleado", empleado);
		Nomina nomina = NominaDAO.buscarNomina(dni);
		request.setAttribute("nomina", nomina);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/consulta.jsp");
		dispatcher.forward(request, response);
		}
	
private void cargarFormulario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	RequestDispatcher dispatcher = request.getRequestDispatcher("/form.jsp");
    dispatcher.forward(request, response);
	}
	private void mostrarEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List < Empleado > listaEmpleado = EmpleadoDAO.mostrarEmpleados();
        request.setAttribute("listaEmpleado", listaEmpleado);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

		switch (action) {
		    case "gestionar":
		    	gestionarEmpleado(request, response);
		    	break;
		}
		doGet(request, response);
	}

}

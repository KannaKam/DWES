package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;

/**
 * Servlet implementation class ServletPelicula
 */
@WebServlet("/ServletPelicula")
public class ServletPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPelicula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

		switch (action) {
		case "buscar":
			buscarPeliculas(request, response);
			break;
		case "form":
			cargarFormulario(request, response);
			break;
		case "mostrar":
			mostrarInfo(request, response);
			break;
		case "login":
			cargarLogin(request, response);
			break;
		}
	}

	private void buscarPeliculas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String director = request.getParameter("director");
		List<Pelicula> listaPeliculas = PeliculaDAO.buscarPeliculas(director);
		if(listaPeliculas.size() == 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("listaPeliculas", listaPeliculas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/peliculas.jsp");
			dispatcher.forward(request, response);
		}
		
	}
	private void cargarFormulario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/form.jsp");
	    dispatcher.forward(request, response);
		}
	private void cargarLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
	    dispatcher.forward(request, response);
		}
	private void mostrarInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
		    
		}
		doGet(request, response);
	}

}

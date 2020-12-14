package filmografiamvc.controlador;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import filmografiamvc.entidades.*;
import filmografiamvc.servicio.*;



@Controller
@RequestMapping("/controlador")
public class Controlador {
	
	private HttpSession sesion;
	private List<Director> directores = new ArrayList<Director>();
	
	@Autowired
	private ServicioPelicula servicio;
	
	@Autowired
	private ServicioDirector servicioDirector;
	
	@Autowired
	private ServicioAdmin servicioAdmin;
	
	
	@GetMapping("/paginaPrincipal")
	public String paginaPrincipal(HttpServletRequest request) {
			sesion = request.getSession();
		return "paginaPrincipal";
	}
	@GetMapping("/info")
	public String info() {

		return "info";
	}
	@GetMapping("/loginPage")
	public String loginPage() {

		return "login";
	}

	@GetMapping("/director")
	public String paginaBusqueda() {
		
		return "busquedaDirector";
	}
	@GetMapping("/listaDirectores")
	public String listaDirectores(Model model, HttpServletRequest request) {
		sesion = request.getSession();
		sesion.setAttribute("directores", directores);
		directores = servicioDirector.mostrarDirectores();
		return "listaDirectores";
	}
	@GetMapping("/lista")
	public String listaPeliculas(@RequestParam("director") String director, Model model, HttpServletRequest request) {
		List<Pelicula> peliculas = servicio.buscarPelicula(director);
		sesion = request.getSession();
		sesion.setAttribute("directores", directores);
		if (peliculas.isEmpty()) {
			return "paginaError";
		}else {
			model.addAttribute("peliculas", peliculas);
			Director directorNuevo = new Director (director);
			directores.add(directorNuevo);
			sesion.setAttribute("directores", directores);
			servicioDirector.guardarDirector(directorNuevo);
		}
		return "/lista";
	}
	
	
	@GetMapping("/formulario")
	public String crearPelicula(Model model) {

		Pelicula pelicula = new Pelicula();

		model.addAttribute("pelicula", pelicula);

		return "formulario";
	}
	
	@PostMapping("/login")
	public String logUsuario(@RequestParam("nombre")String nombre, @RequestParam("pass") String pass, Model model, HttpServletRequest request) {
		
		sesion = request.getSession();
		List<Admin> administradores = servicioAdmin.listaAdmin();
		
		for(int i = 0; i<administradores.size(); i++) {
			if(!(administradores.isEmpty()) && administradores.get(i).getNombre().equals(nombre) && administradores.get(i).getPass().equals(pass)) {
				sesion.setAttribute("logged", true);
			}
		}
		return "redirect:/controlador/paginaPrincipal";
	}
	
	@GetMapping("/actualizar")
	public String actualizarPelicula(@RequestParam("id") int id, Model model) {
		
		Pelicula pelicula = servicio.traerPelicula(id);
		
		model.addAttribute("pelicula", pelicula);
		
		return "/guardarPelicula";
	}
	
	@PostMapping("/guardarPelicula")
	public String guardar(@ModelAttribute("pelicula") Pelicula pelicula) {

		List<Pelicula> peliculas = servicio.mostrarPeliculas();
		boolean flag = false;
		
		for(Pelicula peli : peliculas) {
			if(peli.getId() == pelicula.getId()) {
				flag = true;
			}
		}
		if(flag) {
			servicio.guardarPelicula(pelicula);
		}else {
			Pelicula nuevaPelicula = new Pelicula();
			nuevaPelicula.setDirector(pelicula.getDirector());
			nuevaPelicula.setFecha(pelicula.getFecha());
			nuevaPelicula.setTitulo(pelicula.getTitulo());
			servicio.guardarPelicula(nuevaPelicula);
		}
		return "redirect:/controlador/paginaPrincipal";
	}
	
	@GetMapping("/eliminar")
	public String eliminarEmpleado(@RequestParam("id") int id) {

		servicio.borrarPelicula(id);

		return "redirect:/controlador/paginaPrincipal";
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {

		sesion = request.getSession();
		sesion.setAttribute("logged", false);
		sesion.invalidate();
		
		return "redirect:/controlador/paginaPrincipal";
	}
	
}

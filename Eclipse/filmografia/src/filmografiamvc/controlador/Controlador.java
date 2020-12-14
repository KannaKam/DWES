package filmografiamvc.controlador;


import java.util.List;

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
	
	@Autowired
	private ServicioPelicula servicio;
	
	@Autowired
	private ServicioDirector servicioDirector;
	
	@Autowired
	private ServicioAdmin servicioAdmin;
	
	
	@GetMapping("/paginaPrincipal")
	public String paginaPrincipal() {

		return "paginaPrincipal";
	}
	
	@GetMapping("/lista")
	public String listaPeliculas(@RequestParam("director") String director, Model model) {
		List<Pelicula> peliculas = servicio.buscarPelicula(director);
		if (peliculas.isEmpty()) {
			return "paginaError";
		}else {
			model.addAttribute("peliculas", peliculas);
			Director directorNuevo = new Director (director);
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
	public String log(@RequestParam("nombre")String nombre, @RequestParam("pass") String pass, Model model) {
		
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		
		if(admin.getNombre().equals(nombre) && admin.getPass().equals(pass)) {
			admin.setLogged(true);
			return "login";
		}else {
			return "errorLogin";
		}
	}
	
	@GetMapping("/actualizar")
	public String actualizarPelicula(@RequestParam("id") int id, Model model) {
		
		Pelicula pelicula = servicio.traerPelicula(id);
		
		model.addAttribute("pelicula", pelicula);
		
		return "formulario";
	}
	
	@PostMapping("/guardarPelicula")
	public String guardar(@ModelAttribute("pelicula") Pelicula pelicula) {

		Pelicula peliculaNueva = new Pelicula();
		
			
			peliculaNueva.setDirector(pelicula.getDirector());
			peliculaNueva.setFecha(pelicula.getFecha());
			peliculaNueva.setTitulo(pelicula.getTitulo());
			servicio.guardarPelicula(peliculaNueva);

		return "redirect:/controlador/paginaPrincipal";
	}
	
	@GetMapping("/eliminar")
	public String eliminarEmpleado(@RequestParam("id") int id) {

		servicio.borrarPelicula(id);

		return "redirect:/controlador/paginaPrincipal";
	}
	
}

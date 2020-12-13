package cinemvc.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cinemvc.entidades.*;
import cinemvc.servicio.*;



@Controller
@RequestMapping("/controlador")
public class Controlador {
	
	@Autowired
	private ServicioPelicula servicio;

	@GetMapping("/paginaPrincipal")
	public String paginaPrincipal() {

		return "paginaPrincipal";
	}
	
	@GetMapping("/lista")
	public String listaPeliculas(@RequestParam("director") String director, Model model) {
		List<Pelicula> peliculas = servicio.buscarPelicula(director);
		model.addAttribute("peliculas", peliculas);

		for(Pelicula pelicula:peliculas) {
			if(pelicula.getDirector().equals(director)) {
				
				model.addAttribute("director", pelicula.getDirector());
				model.addAttribute("titulo", pelicula.getTitulo());
				model.addAttribute("fecha", pelicula.getFecha());
				
			}else {
				return "paginaError";
			}
		}
		return "/lista";
		
	}
	
	@GetMapping("/formulario")
	public String crearPelicula(Model model) {

		Pelicula pelicula = new Pelicula();

		model.addAttribute("pelicula", pelicula);

		return "formulario";
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

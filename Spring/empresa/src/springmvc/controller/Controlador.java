package springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.entity.Empleado;
import springmvc.entity.Nomina;
import springmvc.service.EmpleadoService;

@Controller
@RequestMapping("/controlador")
public class Controlador {

	@Autowired
	private EmpleadoService empleadoService;
	

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

	}
	
	@GetMapping("/paginaPrincipal")
	public String paginaPrincipal() {
		
		return "pagina-principal";
	}

	@GetMapping("/buscarSueldo")
	public String formularioSueldo() {

		return "buscar-sueldo";
	}

	@GetMapping("/lista")
	public String listaEmpleados(Model model) {

		List<Empleado> empleados = empleadoService.listaEmpleados();

		model.addAttribute("empleados", empleados);

		return "lista-empleados";
	}

	@GetMapping("/formulario")
	public String formulario(Model model) {

		Empleado empleado = new Empleado();

		model.addAttribute("empleado", empleado);

		return "formulario";
	}

	@PostMapping("/guardarEmpleado")
	public String guardar(Model model, @Valid @ModelAttribute("empleado") Empleado empleado,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			model.addAttribute("empleado", empleado);

			return "formulario";

		} else {

			int sueldo;

			if (empleado.getNomina().getDni() == null || empleado.getNomina().getDni().isEmpty()) {

				Nomina nomina = new Nomina();

				sueldo = nomina.sueldo(empleado.getCategoria(), empleado.getAntiguedad());

				nomina.setDni(empleado.getDni());
				nomina.setSueldo(sueldo);

				empleado.setNomina(nomina);
				empleadoService.guardarEmpleado(empleado);

			} else {
				sueldo = empleado.getNomina().sueldo(empleado.getCategoria(), empleado.getAntiguedad());
				empleado.getNomina().setId(empleado.getId());
				;
				empleado.getNomina().setSueldo(sueldo);
				empleadoService.guardarEmpleado(empleado);

			}

			return "redirect:/controlador/lista";
		}
	}

	@GetMapping("/actualizar")
	public String recogerEmpleado(@RequestParam("empleadoId") int id, Model model) {

		Empleado empleado = empleadoService.recogerEmpleado(id);

		model.addAttribute("empleado", empleado);

		return "formulario";
	}

	@GetMapping("/eliminar")
	public String eliminarEmpleado(@RequestParam("empleadoId") int id) {

		empleadoService.eliminarEmpleado(id);

		return "redirect:/controlador/lista";
	}

	@PostMapping("/sueldo")
	public String pruebaEmpleado(@RequestParam("dni") String dni, Model model) {

		Nomina nomina = empleadoService.recogerSueldo(dni);

		model.addAttribute("nombre", nomina.getEmpleado().getNombre());
		model.addAttribute("sueldo", nomina.getSueldo());

		return "buscar-sueldo";
	}
}

package springmvc.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.entidades.*;
import springmvc.servicio.*;



@Controller
@RequestMapping("/controlador")
public class Controlador {
	
	@Autowired
	private ServicioEmpleado servicio;

	@GetMapping("/paginaPrincipal")
	public String paginaPrincipal(Model model) {
		
		List<Empleado> empleados = servicio.listarEmpleados();

		model.addAttribute("empleados", empleados);

		return "paginaPrincipal";
	}
	@PostMapping("/salario")
	public String mostrarSalario(@RequestParam("dni") String dni, Model model) {

		Nomina nomina = servicio.traerSueldo(dni);
		
		List<Empleado> empleados = servicio.listarEmpleados();

		model.addAttribute("empleados", empleados);

		for(Empleado empleado:empleados) {
			if(empleado.getDni().equals(dni)) {
				
				model.addAttribute("nombre", nomina.getEmpleado().getNombre());
				model.addAttribute("sueldo", nomina.getSueldo());
				
			} else {
				return "paginaError";
			}
		}
		return "paginaPrincipal";
	}
	@GetMapping("/formulario")
	public String crearUsuario(Model model) {

		Empleado empleado = new Empleado();

		model.addAttribute("empleado", empleado);

		return "formulario";
	}
	
}

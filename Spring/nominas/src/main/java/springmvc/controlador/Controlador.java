package springmvc.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}

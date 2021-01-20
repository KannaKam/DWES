package com.nominas.nomina.servicio;

import com.nominas.nomina.entidades.Empleado;
import com.nominas.nomina.entidades.Nomina;

import java.util.List;



public interface ServicioEmpleado {

	public Empleado traerEmpleado(int id);
	public Nomina traerSueldo(String dni);
	public List<Empleado> listarEmpleados();
	public void guardarEmpleado(Empleado empleado);
	public void borrarEmpleado(int id);
	
}

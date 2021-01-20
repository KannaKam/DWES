package com.nominas.nomina.repositorio;

import com.nominas.nomina.entidades.Empleado;
import com.nominas.nomina.entidades.Nomina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
	
	@Query("FROM Nomina WHERE id = ?1")
	public Nomina getNomina(String dniEmpleado);
	
}

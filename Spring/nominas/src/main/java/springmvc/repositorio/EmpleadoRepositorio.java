package springmvc.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import springmvc.entidades.*;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer>{
	
	@Query("FROM Nomina WHERE dni = ?1")
	public Nomina getNomina(String dni);
	
}

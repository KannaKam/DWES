package filmografiamvc.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import filmografiamvc.entidades.Admin;

public interface AdminRepositorio extends JpaRepository<Admin, String>{

	@Query(value = "SELECT * FROM admin where nombre = ?1 AND pass = ?1", nativeQuery = true)
	public Admin log(String nombre, String pass);
	
}

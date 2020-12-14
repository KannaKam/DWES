package filmografiamvc.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import filmografiamvc.entidades.Director;

@Repository
public interface DirectoresRepositorio extends JpaRepository<Director, String> {

	
	@Query(value = "SELECT * FROM directores", nativeQuery = true)
	public List<Director> getDirector();

	
	
}

package filmografiamvc.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import filmografiamvc.entidades.Pelicula;

@Repository
public interface CineRepositorio extends JpaRepository<Pelicula, Integer> {

	
	@Query(value = "SELECT * FROM pelicula where director = ?1", nativeQuery = true)
	public List<Pelicula> getPelicula(String director);
	
	
	
}

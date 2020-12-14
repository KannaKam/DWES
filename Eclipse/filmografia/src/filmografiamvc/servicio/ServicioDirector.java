package filmografiamvc.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import filmografiamvc.entidades.Director;

@Service
public interface ServicioDirector {

	public List <Director> mostrarDirectores();
	
	public void guardarDirector(Director director);
	
}

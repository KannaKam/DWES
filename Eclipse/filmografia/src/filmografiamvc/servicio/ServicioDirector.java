package filmografiamvc.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import filmografiamvc.entidades.Director;

@Service
public interface ServicioDirector {

	public List <Director> listaDirectores();
	
	public void guardarDirector(Director director);
	
}

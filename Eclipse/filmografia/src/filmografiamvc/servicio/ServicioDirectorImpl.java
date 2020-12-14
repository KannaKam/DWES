package filmografiamvc.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import filmografiamvc.entidades.Director;
import filmografiamvc.repositorio.DirectoresRepositorio;

@Service
public class ServicioDirectorImpl implements ServicioDirector {

	@Autowired
	DirectoresRepositorio repositorio; 
	
	@Override
	@Transactional
	public List<Director> listaDirectores() {
		List<Director> directores = repositorio.findAll();
		
		return directores;
	}

	@Override
	@Transactional
	public void guardarDirector(Director director) {
		repositorio.save(director);
		
	}

}

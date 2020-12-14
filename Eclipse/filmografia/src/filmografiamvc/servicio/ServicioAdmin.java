package filmografiamvc.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import filmografiamvc.entidades.Admin;


@Service
public interface ServicioAdmin {

	public Admin log(String nombre, String pass);
	public List <Admin> listaAdmin();
}

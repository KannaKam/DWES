package filmografiamvc.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServicioAdminImpl implements ServicioAdmin{

	@Autowired
	private ServicioAdmin servicio;
	
	@Override
	public void log(String nombre, String pass) {
		servicio.log(nombre, pass);
	}
}

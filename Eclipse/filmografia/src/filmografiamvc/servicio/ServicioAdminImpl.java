package filmografiamvc.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filmografiamvc.entidades.Admin;
import filmografiamvc.repositorio.AdminRepositorio;


@Service
public class ServicioAdminImpl implements ServicioAdmin{

	@Autowired
	private AdminRepositorio repositorio;
	
	@Override
	public Admin log(String nombre, String pass) {
		Admin admin = repositorio.log(nombre, pass);
		return admin;
	}

	@Override
	public List<Admin> listaAdmin() {
		List<Admin> administradores = repositorio.findAll();
		return administradores;
	}
}

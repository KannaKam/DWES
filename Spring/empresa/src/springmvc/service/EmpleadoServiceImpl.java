package springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.entity.Empleado;
import springmvc.entity.Nomina;
import springmvc.repository.EmpleadoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    @Transactional
    public Empleado recogerEmpleado(int id) {
    	
    	Optional<Empleado> optionalEmpleado = empleadoRepository.findById(id);
    	
    	if(optionalEmpleado.isPresent()) {
    		
    		return optionalEmpleado.get();
    	} else {
    		
    		return null;
    	}
    	
    	
    	
    }

    @Override
    @Transactional
    public Nomina recogerSueldo(String dni) {

        return empleadoRepository.getNomina(dni);
    }

    @Override
    @Transactional
    public List<Empleado> listaEmpleados() {

        return empleadoRepository.findAll();
    }

    @Override
    @Transactional
    public void guardarEmpleado(Empleado empleado) {

    	empleadoRepository.save(empleado);
    }

    @Override
    @Transactional
    public void eliminarEmpleado(int id) {

    	empleadoRepository.deleteById(id);
    }
}

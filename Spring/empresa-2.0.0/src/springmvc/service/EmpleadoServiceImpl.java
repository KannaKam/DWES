package springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.entity.Empleado;
import springmvc.entity.Nomina;
import springmvc.repository.EmpleadoDAO;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoDAO empleadoDAO;

    @Override
    @Transactional
    public Empleado recogerEmpleado(int id) {

        return empleadoDAO.recogerEmpleado(id);
    }

    @Override
    @Transactional
    public Nomina recogerSueldo(String dni) {

        return empleadoDAO.recogerSueldo(dni);
    }

    @Override
    @Transactional
    public List<Empleado> listaEmpleados() {

        return empleadoDAO.listaEmpleados();
    }

    @Override
    @Transactional
    public void guardarEmpleado(Empleado empleado) {

        empleadoDAO.guardarEmpleado(empleado);
    }

    @Override
    @Transactional
    public void eliminarEmpleado(int id) {

        empleadoDAO.eliminarEmpleado(id);
    }
}

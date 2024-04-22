package org.iesbelen.semanaculturalempresas.service;

import org.iesbelen.semanaculturalempresas.domain.Empleados;
import org.iesbelen.semanaculturalempresas.exception.EmpleadosNotFoundException;
import org.iesbelen.semanaculturalempresas.exception.EmpresaNotFoundException;
import org.iesbelen.semanaculturalempresas.repository.EmpleadoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;
    public EmpleadoService (EmpleadoRepository empleadoRepository){this.empleadoRepository = empleadoRepository;}
    public List<Empleados> all(){return this.empleadoRepository.findAll();}
    public Empleados find(Long id){
        return this.empleadoRepository.findById(id).orElseThrow(()-> new EmpleadosNotFoundException(id));
    }

    //CRUD
    public Empleados create(Empleados empleados){return this.empleadoRepository.save(empleados);}

    public void delete(Long id) {
        this.empleadoRepository.findById(id).map(empleados -> {this.empleadoRepository.delete(empleados);
                    return empleados;})
                .orElseThrow(() -> new EmpleadosNotFoundException(id));
    }
    public Empleados replace(Long id, Empleados empleados) {

        return this.empleadoRepository.findById(id).map( e -> (id.equals(empleados.getIdEmpleado())  ?
                        this.empleadoRepository.save(empleados) : null))
                .orElseThrow(() -> new EmpleadosNotFoundException(id));
    }
}

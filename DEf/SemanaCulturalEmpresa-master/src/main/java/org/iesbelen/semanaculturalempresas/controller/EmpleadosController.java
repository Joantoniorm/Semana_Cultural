package org.iesbelen.semanaculturalempresas.controller;
import lombok.extern.slf4j.Slf4j;

import org.iesbelen.semanaculturalempresas.domain.Empleados;
import org.iesbelen.semanaculturalempresas.service.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Slf4j
@RestController
@CrossOrigin(origins = "http//localhost:4200")
@RequestMapping("/empleados")
public class EmpleadosController  {
    private final EmpleadoService empleadoService;

    public EmpleadosController(EmpleadoService empleadoService) {this.empleadoService=empleadoService;}
    @GetMapping({"","/"})
    public List<Empleados> all(){
        log.info("Accediendo a todas los empleados");
        return this.empleadoService.all();
    }

    @GetMapping("/{id}")
    public Empleados find (@PathVariable("id")long id){return this.empleadoService.find(id);}



    //Crud que no uso
    @PostMapping({"","/"})
    public Empleados newEmpleado(@RequestBody Empleados empleados) {
        return this.empleadoService.create(empleados);
    }

    @PutMapping("/{id}")
    public Empleados replaceEmpleados(@PathVariable("id") long id, @RequestBody Empleados empleados) {
        return this.empleadoService.replace(id, empleados);
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteEmpleado(@PathVariable("id") Long id) {
        this.empleadoService.delete(id);
    }


}
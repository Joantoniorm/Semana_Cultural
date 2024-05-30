package org.iesbelen.semanaculturalempresas.command;

import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.iesbelen.semanaculturalempresas.domain.*;
import org.iesbelen.semanaculturalempresas.repository.*;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class DBOperationRunner implements CommandLineRunner {
    @Autowired
    EmpresaRepository empresaRepo;
    @Autowired
    CategoriaRepository categoriaRepo;
    @Autowired
    LenguajeRepository lenguajeRepo;
    @Autowired
    CalleRepository calleRepo;
    @Autowired
    EmpleadoRepository empleadosRepo;

    @Override
    public void run(String... args) throws Exception {

        Categoria tecnologia;
            tecnologia = new Categoria();
            tecnologia.setId(1);
            tecnologia.setNombre("Tecnologia");
            categoriaRepo.save(tecnologia);

        Categoria ia;
        ia = new Categoria();
        ia.setId(2);
        ia.setNombre("Inteligencia Artificial");
        categoriaRepo.save(ia);


        Lenguaje lenguaje1;
            lenguaje1 = new Lenguaje();
            lenguaje1.setId(1);
            lenguaje1.setNombre("Java");
            lenguajeRepo.save(lenguaje1);


        Lenguaje lenguaje2;
            lenguaje2 = new Lenguaje();
            lenguaje2.setId(2);
            lenguaje2.setNombre("Python");
            lenguajeRepo.save(lenguaje2);



        Calle calle1 = calleRepo.findByNombre("Calle 1");
        if (calle1 == null) {

            calle1 = new Calle();
            calle1.setNombre("Calle 1");
            calle1.setCP(12345);
            calleRepo.save(calle1);
        }

        Calle calle2 = calleRepo.findByNombre("Calle 2");
        if (calle2 == null) {

            calle2 = new Calle();
            calle2.setNombre("Calle 2");
            calle2.setCP(54321);
            calleRepo.save(calle2);
        }

        //If debido a que peta debido a que la tabla intermedia entre empresa-categoria ya existe con esos datos.
        if (!empresaRepo.existsById(1L)) {
            Empresa empresa1 = crearEmpresa(1, "Contenidos Digitales Avventa", "Desde que Accenture se estableció en España en 1965, ha sido un actor clave en la modernización e internacionalización de empresas de todos los sectores e industrias. Hoy, seguimos liderando la transformación y generamos valor 360º para todos nuestros grupos de interés. Siempre a la vanguardia. Siempre comprometidos con los resultados.\n" +
                    "\n", "https://www.pta.es/wp-content/uploads/2020/04/Accenture_.png", 36.734621, -4.557152, tecnologia, Set.of(lenguaje1), calle1);
            empresaRepo.save(empresa1);

            Empleados empleado1;

            empleado1 = crearEmpleado(1,"Juan", empresa1);
            empleadosRepo.save(empleado1);

            Empleados empleado2;

            empleado2 = crearEmpleado(2,"María", empresa1);
            empleadosRepo.save(empleado2);
        }

        if (!empresaRepo.existsById(2L)) {
            Empresa empresa2 = crearEmpresa(2,"A-Novo","Como centro líder en reparación de tecnología, ANOVO cuenta con unas instalaciones de más de 21000 m2 para poder ofrecer sus servicios a nuestros clientes. 3 naves estratégicas," +
                            " Málaga, Madrid y Las Palmas, que reciben a diario miles de dispositivos para gestionar su servicio postventa, a muchos de los cuales se da entrada en los laboratorios para su reparación.",
                    "https://www.pta.es/wp-content/uploads/2020/03/anovo.jpg",36.741047, -4.554149, tecnologia, Set.of(lenguaje2), calle2);
            empresaRepo.save(empresa2);
            Empleados empleado1;

            empleado1 = crearEmpleado(3,"Manda", empresa2);
            empleadosRepo.save(empleado1);

            Empleados empleado2;

            empleado2 = crearEmpleado(4,"Paco", empresa2);
            empleadosRepo.save(empleado2);
        }

        if (!empresaRepo.existsById(3L)) {
            Empresa empresa3 = crearEmpresa(3,"AANoiseControl","AANoiseControl es una empresa de ingeniería acústica asentada en el Parque Tecnológico de Málaga que ofrece sus servicios en toda Andalucía",
                    "https://www.pta.es/wp-content/uploads/2020/04/logo-aanoisecontrol.jpg",36.719286, -4.496849, tecnologia, Set.of(lenguaje2), calle2);
            empresaRepo.save(empresa3);
            Empleados empleado1;

            empleado1 = crearEmpleado(5,"Laura", empresa3);
            empleadosRepo.save(empleado1);

            Empleados empleado2;

            empleado2 = crearEmpleado(6,"Jose", empresa3);
            empleadosRepo.save(empleado2);
        }

    }

        private Empresa crearEmpresa(long id,String nombre, String descripcion, String imagenUrl, double latitud, double altitud, Categoria categoria, Set<Lenguaje> lenguajes, Calle calle) {
        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(id);
        empresa.setNombre(nombre);
        empresa.setDescripcion(descripcion);
        empresa.setImagen_url(imagenUrl);
        empresa.setLatitud(latitud);
        empresa.setAltitud(altitud);

        Set<Categoria> categorias = new HashSet<>();
        categorias.add(categoria);
        empresa.setCategoria(categorias);
        empresa.setLenguaje(lenguajes);
        empresa.setCalle(calle);

        return empresa;
    }

    private Empleados crearEmpleado(long id,String nombre, Empresa empresa) {
        Empleados empleado = new Empleados();
        empleado.setIdEmpleado(id);
        empleado.setNombre(nombre);
        empleado.setEmpresas(empresa);
        return empleado;
    }
}
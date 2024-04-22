package org.iesbelen.semanaculturalempresas.command;
import org.antlr.v4.runtime.misc.Array2DHashSet;
import org.iesbelen.semanaculturalempresas.domain.Categoria;
import org.iesbelen.semanaculturalempresas.domain.Empleados;
import org.iesbelen.semanaculturalempresas.domain.Empresa;
import org.iesbelen.semanaculturalempresas.repository.CategoriaRepository;
import org.iesbelen.semanaculturalempresas.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class DBOperationRunner implements CommandLineRunner {
    @Autowired
    EmpresaRepository empresa;
    @Autowired
    CategoriaRepository categoria;
    @Override
    public void run(String... args) throws Exception {
        categoria.saveAll(List.of(
                new Categoria(1,"Tecnologia",)
        ));
        empresa.saveAll(List.of(
                new Empresa(1,"Contenidos Digitales Avventa","Desde que Accenture se estableció en España en 1965, ha sido un actor clave en la modernización e internacionalización de empresas de todos los sectores e industrias. Hoy, seguimos liderando la transformación y generamos valor 360º para todos nuestros grupos de interés. Siempre a la vanguardia. Siempre comprometidos con los resultados.\n" +
                        "\n","https://www.pta.es/wp-content/uploads/2020/04/Accenture_.png",36.734621, -4.557152,new HashSet<>(List.of(new Categoria())), new ArrayList<>(List.of(new Empleados())))

        ));
    }
}

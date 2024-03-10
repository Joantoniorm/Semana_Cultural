package org.iesbelen.semanaculturalempresas.command;
import org.iesbelen.semanaculturalempresas.domain.Empresa;
import org.iesbelen.semanaculturalempresas.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DBOperationRunner implements CommandLineRunner {
    @Autowired
    EmpresaRepository empresa;
    @Override
    public void run(String... args) throws Exception {
        empresa.saveAll(List.of(
                new Empresa(1,"Contenidos Digitales Avventa","Desde que Accenture se estableció en España en 1965, ha sido un actor clave en la modernización e internacionalización de empresas de todos los sectores e industrias. Hoy, seguimos liderando la transformación y generamos valor 360º para todos nuestros grupos de interés. Siempre a la vanguardia. Siempre comprometidos con los resultados.\n" +
                        "\n","https://www.pta.es/wp-content/uploads/2020/04/Accenture_.png",36.734621, -4.557152),
                new Empresa(2,"A-Novo","Como centro líder en reparación de tecnología, ANOVO cuenta con unas instalaciones de más de 21000 m2 para poder ofrecer sus servicios a nuestros clientes. 3 naves estratégicas, Málaga, Madrid y Las Palmas, que reciben a diario miles de dispositivos para gestionar su servicio postventa, a muchos de los cuales se da entrada en los laboratorios para su reparación.","https://www.pta.es/wp-content/uploads/2020/03/anovo.jpg",36.741047, -4.554149),
                new Empresa(3,"AANoiseControl","AANoiseControl es una empresa de ingeniería acústica asentada en el Parque Tecnológico de Málaga que ofrece sus servicios en toda Andalucía","https://www.pta.es/wp-content/uploads/2020/04/logo-aanoisecontrol.jpg",36.719286, -4.496849),
                new Empresa(4,"Mister Pato","Consultoría y mentorización para la transformación digital de la\n" +
                        "empresa. Desde asesoramiento y acompañamiento en la\n" +
                        "implementación e integración de soluciones existentes en el mercado,\n" +
                        "hasta el diseño y desarrollo de software a medida para cubrir aspectos\n" +
                        "específicos de la empresa.","https://www.pta.es/wp-content/uploads/2023/07/mrpato.png",36.735714, -4.557532),
                new Empresa(5,"Huawei Technologies Spain","Servicios telecomunicaciones; Soporte técnico a redes del cliente.","https://www.pta.es/wp-content/uploads/2020/03/huawei-technologies-spain.jpg",36.734208, -4.556376),
                new Empresa(6,"Vodafone España, S.A.U.","Vodafone España S.A.U., es la filial española de la compañía multinacional británica Vodafone y ofrece servicios de telefonía, Internet y televisión (Vodafone TV).\n" +
                        "\n" +
                        "Fue lanzado como marca comercial en España, el 27 de octubre de 2001, tras la adquisición de Airtel por parte de Vodafone. Las posteriores adquisiciones de Tele2 España en 2007, y de Ono en 2014, lo consolidan como el segundo operador multimodal del país, y el tercero en telefonía móvil.","https://www.pta.es/wp-content/uploads/2020/04/logo-vodafone.jpg",36.734854, -4.547910
                ),
                new Empresa(7,"IHMAN – Interfaces Hombre Máquina Avanzados","La empresa IHMAN es una empresa tecnológica cuya misión fundamental es el desarrollo de proyectos de alta ingeniería para empresas e industria.\n" +
                        "\n" +
                        "Está formada por un equipo de ingenieros en Telecomunicación e Informática que han trabajado en campos muy diversos. El equipo directivo de IHMAN forma parte a su vez del grupo de investigación DIANA de la Universidad de Málaga.\n" +
                        "\n" +
                        "La empresa desarrolla dos líneas de trabajo. Por un lado los sistemas de control, más concretamente en redes de control autoconfigurables e inalámbricas donde son especialistas, sistemas de ultrabajo consumo, localización y navegación indoor, etc, y por otro la línea de Realidad Virtual, con reconstrucción de yacimientos arqueológicos, sistemas de visión estereoscópica etc. El dominio de esta serie de tecnologías, junto con otras de gestión de bases de datos y control vía internet, permiten afrontar proyectos de muy diversa índole y de gran complejidad. El alto grado de formación requerido para manejar y combinar estas nuevas tecnologías son barreras de entrada muy altas, pero ampliamente superadas por nuestro equipo, estas características hacen que IHMAN sea unas de las empresas con mayor capacidad para llevar a cabo todo el proceso de desarrollo de un proyecto de alta complejidad. Por ello, son ya muchas las empresas de gran prestigio, que confían su I+D+i, a IHMAN."
                ,"https://www.pta.es/wp-content/uploads/2020/04/ihman.jpeg",36.737391, -4.551682),
                new Empresa(8,"Tecnilógica","Tecnilógica, forma parte de Accenture, y se sitúa como la compañía líder en España especializada en servicios de Ingeniería y desarrollo de Productos tecnológicos y Digitales, cuenta con más de 4000 profesionales de las nuevas tecnologías.\n" +
                        "\n" +
                        "Son expertos en digitalización, negocio inteligente, Cloud, gestión del dato, productos y plataformas, así como Liquid Am.","https://www.pta.es/wp-content/uploads/2020/04/Tecnil%C3%B3gica-Ecosistemas.png",36.737134, -4.552410)
        ));
    }
}

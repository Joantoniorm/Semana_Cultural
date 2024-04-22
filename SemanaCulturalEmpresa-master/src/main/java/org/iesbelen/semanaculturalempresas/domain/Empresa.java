package org.iesbelen.semanaculturalempresas.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name="empresa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_empresa")
    private long idEmpresa;

    private String nombre;

    @Column(name="descripcion", columnDefinition = "LONGTEXT")
    private String descripcion;

    @Column(name="imagen_url", columnDefinition = "LONGTEXT")
    private String imagen_url;

    private double latitud;
    private double altitud;

    @ManyToMany
    @JoinTable(
            name = "empresa_categoria",
            joinColumns = @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria"))
    Set<Categoria> categoria = new HashSet<>();

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Empleados> empleados;

    @ManyToOne()
    @JoinColumn(name = "empresas-calle")
    private Calle calle;

    @ManyToMany
    @JoinTable(
            name = "empresa_lenguaje",
            joinColumns = @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa"),
            inverseJoinColumns = @JoinColumn(name = "id_lenguaje", referencedColumnName = "id_lenguaje"))
    Set<Lenguaje> lenguaje = new HashSet<>();
}

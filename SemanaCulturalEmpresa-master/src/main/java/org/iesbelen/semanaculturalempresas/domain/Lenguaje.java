package org.iesbelen.semanaculturalempresas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="lenguaje")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lenguaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lenguaje")
    private long id;
    @Column (name = "nombre")
    private String nombre;
    @ManyToMany(
            mappedBy = "lenguaje")
    Set<Empresa> empresa = new HashSet<>();
}

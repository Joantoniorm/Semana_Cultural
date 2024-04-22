package org.iesbelen.semanaculturalempresas.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @ManyToMany(
            mappedBy = "categoria")
    Set <Empresa> empresa = new HashSet<>();


}

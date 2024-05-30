package org.iesbelen.semanaculturalempresas.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name="calle")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calle")
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name="CP")
    private long CP;
    @OneToMany(mappedBy = "calle", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Empresa> empresas;
}

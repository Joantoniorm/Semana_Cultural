package org.iesbelen.semanaculturalempresas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="empleados")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private long idEmpleado;
    private String nombre;
    @ManyToOne()
    @JoinColumn(name = "id_empleado")
    private Empresa empresas;
}
package org.iesbelen.semanaculturalempresas.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
}

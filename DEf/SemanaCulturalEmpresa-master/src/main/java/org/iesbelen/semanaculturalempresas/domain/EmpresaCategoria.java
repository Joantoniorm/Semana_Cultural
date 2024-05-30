package org.iesbelen.semanaculturalempresas.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empresa_categoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaCategoria {
    @Id
    @Column(name="id_empresa")
    private long id_empresa;
    @Id
    @Column(name="id_categoria")
    private long id_categoria;
}

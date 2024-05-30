package org.iesbelen.semanaculturalempresas.repository;
import org.iesbelen.semanaculturalempresas.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    @Query("SELECT e FROM Empresa e LEFT JOIN FETCH e.categoria WHERE e.nombre = :nombre")
    Empresa findByNombre(@Param("nombre") String nombre);
}

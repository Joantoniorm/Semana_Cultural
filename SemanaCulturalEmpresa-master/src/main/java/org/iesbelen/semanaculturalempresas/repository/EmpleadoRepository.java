package org.iesbelen.semanaculturalempresas.repository;

import org.iesbelen.semanaculturalempresas.domain.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleados, Long> {
}

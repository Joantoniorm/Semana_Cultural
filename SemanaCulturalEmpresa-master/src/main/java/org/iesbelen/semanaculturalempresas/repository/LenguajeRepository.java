package org.iesbelen.semanaculturalempresas.repository;

import org.iesbelen.semanaculturalempresas.domain.Lenguaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LenguajeRepository extends JpaRepository<Lenguaje, Long> {
}

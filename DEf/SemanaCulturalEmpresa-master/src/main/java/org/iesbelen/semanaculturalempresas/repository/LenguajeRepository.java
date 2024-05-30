package org.iesbelen.semanaculturalempresas.repository;

import org.iesbelen.semanaculturalempresas.domain.Lenguaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LenguajeRepository extends JpaRepository<Lenguaje, Long> {
    Lenguaje findByNombre(String nombre);
}

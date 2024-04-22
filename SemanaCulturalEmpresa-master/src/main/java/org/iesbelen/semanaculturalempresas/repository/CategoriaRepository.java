package org.iesbelen.semanaculturalempresas.repository;

import org.iesbelen.semanaculturalempresas.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
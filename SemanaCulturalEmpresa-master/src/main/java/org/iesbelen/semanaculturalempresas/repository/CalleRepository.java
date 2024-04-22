package org.iesbelen.semanaculturalempresas.repository;

import org.iesbelen.semanaculturalempresas.domain.Calle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalleRepository extends JpaRepository<Calle,Long> {
}

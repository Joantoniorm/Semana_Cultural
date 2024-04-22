package org.iesbelen.semanaculturalempresas.repository;
import org.iesbelen.semanaculturalempresas.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}

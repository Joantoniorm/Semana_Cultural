package org.iesbelen.semanaculturalempresas.service;

import org.iesbelen.semanaculturalempresas.domain.EmpresaCategoria;

import org.iesbelen.semanaculturalempresas.repository.EmpresaCategoriaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpresaCategoriaService {
    private final EmpresaCategoriaRepository empresa_catRep;
    public EmpresaCategoriaService(EmpresaCategoriaRepository empresa_catRep){this.empresa_catRep=empresa_catRep;}

}

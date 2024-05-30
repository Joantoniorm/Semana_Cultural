package org.iesbelen.semanaculturalempresas.service;

import org.iesbelen.semanaculturalempresas.domain.Categoria;
import org.iesbelen.semanaculturalempresas.domain.Empresa;
import org.iesbelen.semanaculturalempresas.exception.CategoriaNotFoundException;
import org.iesbelen.semanaculturalempresas.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> all() {
        return this.categoriaRepository.findAll();
    }

    public Categoria save(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    public Categoria find(Long id) {
        return this.categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }

    public Categoria replace(Long id, Categoria categoria) {

        return this.categoriaRepository.findById(id).map( p -> (id.equals(categoria.getId())  ?
                        this.categoriaRepository.save(categoria) : null))
                .orElseThrow(() -> new CategoriaNotFoundException(id));

    }

    public void delete(Long id) {
        this.categoriaRepository.findById(id).map(p -> {this.categoriaRepository.delete(p);
                    return p;})
                .orElseThrow(() -> new CategoriaNotFoundException(id));
    }
    public Map<Long, Empresa> obtenerEmpresasPorCategoria(Long idCategoria) {
        Categoria categoria = categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new CategoriaNotFoundException(idCategoria));
        Map<Long, Empresa> empresasMap = new HashMap<>();
        for (Empresa empresa : categoria.getEmpresa()) {
            empresasMap.put(empresa.getIdEmpresa(), empresa);
        }
        return empresasMap;
    }

}

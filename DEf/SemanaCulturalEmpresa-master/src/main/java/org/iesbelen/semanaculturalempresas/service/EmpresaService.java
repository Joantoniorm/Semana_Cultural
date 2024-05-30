package org.iesbelen.semanaculturalempresas.service;

import org.iesbelen.semanaculturalempresas.domain.Categoria;
import org.iesbelen.semanaculturalempresas.exception.EmpresaNotFoundException;
import org.iesbelen.semanaculturalempresas.repository.EmpresaRepository;
import org.iesbelen.semanaculturalempresas.domain.Empresa;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmpresaService {
        private final EmpresaRepository empresaRepository;
        public EmpresaService (EmpresaRepository empresaRepository){this.empresaRepository = empresaRepository;}
        public List<Empresa> all(){return this.empresaRepository.findAll();}
        public Empresa find(Long id) {
            return this.empresaRepository.findById(id).orElseThrow(()-> new EmpresaNotFoundException(id));
        }

        //CRUD
        public Empresa create(Empresa empresa){return this.empresaRepository.save(empresa);}

        public void delete(Long id) {
                this.empresaRepository.findById(id).map(empresa -> {this.empresaRepository.delete(empresa);
                                return empresa;})
                        .orElseThrow(() -> new EmpresaNotFoundException(id));
        }
        public Empresa replace(Long id, Empresa empresa) {

                return this.empresaRepository.findById(id).map( e -> (id.equals(empresa.getIdEmpresa())  ?
                                this.empresaRepository.save(empresa) : null))
                        .orElseThrow(() -> new EmpresaNotFoundException(id));
        }
        public String getCategoria(long idEmpresa) {
                Optional<Empresa> empresaOptional = empresaRepository.findById(idEmpresa);
                if (empresaOptional.isPresent()) {
                        Set<Categoria> categorias = empresaOptional.get().getCategoria();
                        if (!categorias.isEmpty()) {
                                Categoria categoria = categorias.iterator().next();
                                return categoria.getNombre();
                        }
                }
                return "Categoría no encontrada";
        }

}

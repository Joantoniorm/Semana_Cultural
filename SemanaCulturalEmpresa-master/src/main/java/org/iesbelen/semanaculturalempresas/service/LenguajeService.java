package org.iesbelen.semanaculturalempresas.service;

import org.iesbelen.semanaculturalempresas.domain.Empresa;
import org.iesbelen.semanaculturalempresas.domain.Lenguaje;
import org.iesbelen.semanaculturalempresas.exception.EmpresaNotFoundException;
import org.iesbelen.semanaculturalempresas.exception.LenguajeNotFoundException;
import org.iesbelen.semanaculturalempresas.repository.LenguajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LenguajeService {
    private final LenguajeRepository lenguajeRepository;
    public LenguajeService (LenguajeRepository lenguajeRepository){this.lenguajeRepository = lenguajeRepository;}
    public List<Lenguaje> all(){return this.lenguajeRepository.findAll();}
    public Lenguaje find (Long id){
        return this.lenguajeRepository.findById(id).orElseThrow(()->new LenguajeNotFoundException(id));
    }
    public Lenguaje create(Lenguaje lenguaje){return this.lenguajeRepository.save(lenguaje);}

    public void delete(Long id) {
        this.lenguajeRepository.findById(id).map(lenguaje -> {this.lenguajeRepository.delete(lenguaje);
                    return lenguaje;})
                .orElseThrow(() -> new EmpresaNotFoundException(id));
    }
    public Lenguaje replace(Long id, Lenguaje lenguaje) {

        return this.lenguajeRepository.findById(id).map( e -> (id.equals(lenguaje.getId())  ?
                        this.lenguajeRepository.save(lenguaje) : null))
                .orElseThrow(() -> new LenguajeNotFoundException(id));
    }
}

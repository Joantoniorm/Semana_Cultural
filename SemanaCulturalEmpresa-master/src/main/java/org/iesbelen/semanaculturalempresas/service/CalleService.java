package org.iesbelen.semanaculturalempresas.service;

import org.iesbelen.semanaculturalempresas.domain.Calle;
import org.iesbelen.semanaculturalempresas.exception.CalleNotFoundException;
import org.iesbelen.semanaculturalempresas.repository.CalleRepository;

import java.util.List;

public class CalleService {
    private final CalleRepository calleRepository;

    public CalleService(CalleRepository calleRepository) {
        this.calleRepository = calleRepository;
    }

    public List<Calle> all() {
        return this.calleRepository.findAll();
    }

    public Calle save(Calle calle) {
        return this.calleRepository.save(calle);
    }

    public Calle one(Long id) {
        return this.calleRepository.findById(id)
                .orElseThrow(() -> new CalleNotFoundException(id));
    }

    public Calle replace(Long id, Calle calle) {

        return this.calleRepository.findById(id).map( p -> (id.equals(calle.getId())  ?
                        this.calleRepository.save(calle) : null))
                .orElseThrow(() -> new CalleNotFoundException(id));

    }

    public void delete(Long id) {
        this.calleRepository.findById(id).map(p -> {this.calleRepository.delete(p);
                    return p;})
                .orElseThrow(() -> new CalleNotFoundException(id));
}
}

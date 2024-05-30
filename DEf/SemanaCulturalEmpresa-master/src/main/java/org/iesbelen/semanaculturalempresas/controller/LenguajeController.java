package org.iesbelen.semanaculturalempresas.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.semanaculturalempresas.domain.Lenguaje;
import org.iesbelen.semanaculturalempresas.service.LenguajeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/lenguaje")
public class LenguajeController {
    private final LenguajeService lenguajeService;

    public LenguajeController(LenguajeService lenguajeService) {
        this.lenguajeService = lenguajeService;
    }

    @GetMapping({"","/"})
    public List<Lenguaje> all() {
        log.info("Accediendo a todas las lenguaje");
        return this.lenguajeService.all();
    }

    @PostMapping({"","/"})
    public Lenguaje newLenguaje(@RequestBody Lenguaje lenguaje) {
        return this.lenguajeService.save(lenguaje);
    }

    @GetMapping("/{id}")
    public Lenguaje one(@PathVariable("id") Long id) {
        return this.lenguajeService.find(id);
    }

    @PutMapping("/{id}")
    public Lenguaje replaceLenguaje(@PathVariable("id") Long id, @RequestBody Lenguaje lenguaje) {
        return this.lenguajeService.replace(id, lenguaje);
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteLenguaje(@PathVariable("id") Long id) {
        this.lenguajeService .delete(id);
    }


}
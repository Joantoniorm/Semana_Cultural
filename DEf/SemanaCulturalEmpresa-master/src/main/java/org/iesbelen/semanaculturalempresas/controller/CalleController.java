package org.iesbelen.semanaculturalempresas.controller;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Call;
import org.iesbelen.semanaculturalempresas.domain.Calle;
import org.iesbelen.semanaculturalempresas.service.CalleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/calle")
public class CalleController {
    private final CalleService calleService;

    public CalleController(CalleService calleService) {
        this.calleService = calleService;
    }

    @GetMapping({"","/"})
    public List<Calle> all() {
        log.info("Accediendo a todas las calles");
        return this.calleService.all();
    }

    @PostMapping({"","/"})
    public Calle newCalle(@RequestBody Calle calle) {
        return this.calleService.save(calle);
    }

    @GetMapping("/{id}")
    public Calle one(@PathVariable("id") Long id) {
        return this.calleService.one(id);
    }

    @PutMapping("/{id}")
    public Calle replaceCalle(@PathVariable("id") Long id, @RequestBody Calle calle) {
        return this.calleService.replace(id, calle);
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCalle(@PathVariable("id") Long id) {
        this.calleService.delete(id);
    }


}

package org.iesbelen.semanaculturalempresas.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.semanaculturalempresas.domain.Categoria;
import org.iesbelen.semanaculturalempresas.domain.Empresa;
import org.iesbelen.semanaculturalempresas.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping({"","/"})
    public List<Categoria> all() {
        log.info("Accediendo a todas las categorias");
        return this.categoriaService.all();
    }

    @PostMapping({"","/"})
    public Categoria newCategoria(@RequestBody Categoria categoria) {
        return this.categoriaService.save(categoria);
    }

    @GetMapping("/{id}")
    public Categoria find(@PathVariable("id") Long id) {
        return this.categoriaService.find(id);
    }

    @PutMapping("/{id}")
    public Categoria replaceCategoria(@PathVariable("id") Long id, @RequestBody Categoria categoria) {
        return this.categoriaService.replace(id, categoria);
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable("id") Long id) {
        this.categoriaService.delete(id);
    }
    @GetMapping("/{id}/empresas")
    public ResponseEntity<Map<Long, Empresa>> obtenerEmpresasPorCategoria(@PathVariable Long id) {
        Map<Long, Empresa> empresasMap = categoriaService.obtenerEmpresasPorCategoria(id);
        return ResponseEntity.ok(empresasMap);
    }

}

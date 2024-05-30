package org.iesbelen.semanaculturalempresas.controller;import lombok.extern.slf4j.Slf4j;import org.iesbelen.semanaculturalempresas.domain.Empresa;import org.iesbelen.semanaculturalempresas.service.EmpresaService;import org.springframework.http.HttpStatus;import org.springframework.web.bind.annotation.*;import java.util.List;@Slf4j@RestController@CrossOrigin(origins = "http//localhost:4200")@RequestMapping("/empresa")public class EmpresaController  {    private final EmpresaService empresaService;    public EmpresaController(EmpresaService empresaService) {this.empresaService=empresaService;}    @GetMapping({"","/"})    public List<Empresa> all(){        log.info("Accediendo a todas las empresas");        return this.empresaService.all();    }    @GetMapping("/{id}")    public Empresa find (@PathVariable("id")long id){return this.empresaService.find(id);}    @GetMapping("/{idEmpresa}/categoria")    public String getCategoria(@PathVariable("idEmpresa") long idEmpresa) {        return empresaService.getCategoria(idEmpresa);    }    //Crud que no uso    @PostMapping({"","/"})    public Empresa newEmpresa(@RequestBody Empresa empresa) {        return this.empresaService.create(empresa);    }    @PutMapping("/{id}")    public Empresa replaceEmpresa(@PathVariable("id") long id, @RequestBody Empresa empresa) {        return this.empresaService.replace(id, empresa);    }    @ResponseBody    @ResponseStatus(HttpStatus.NO_CONTENT)    @DeleteMapping("/{id}")    public void deleteEmpresa(@PathVariable("id") Long id) {        this.empresaService.delete(id);    }}
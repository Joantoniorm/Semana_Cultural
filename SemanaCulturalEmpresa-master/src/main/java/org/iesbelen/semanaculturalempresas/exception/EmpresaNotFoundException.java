package org.iesbelen.semanaculturalempresas.exception;

public class EmpresaNotFoundException extends RuntimeException{
    public EmpresaNotFoundException(Long id){super("Not found Pelicula with id: "+ id);}
}

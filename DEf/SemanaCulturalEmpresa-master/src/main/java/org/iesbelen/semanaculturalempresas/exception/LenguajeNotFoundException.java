package org.iesbelen.semanaculturalempresas.exception;

public class LenguajeNotFoundException extends RuntimeException {
    public LenguajeNotFoundException(Long id){super("Not found lenguaje with id"+id);}
}

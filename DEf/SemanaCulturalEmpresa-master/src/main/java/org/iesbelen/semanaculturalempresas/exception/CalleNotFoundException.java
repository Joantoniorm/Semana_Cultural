package org.iesbelen.semanaculturalempresas.exception;

public class CalleNotFoundException extends RuntimeException {
    public CalleNotFoundException (Long id){super("Not found Calle with id"+ id);}
}

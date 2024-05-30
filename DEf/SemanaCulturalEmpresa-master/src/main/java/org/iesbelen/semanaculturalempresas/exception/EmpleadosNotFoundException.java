package org.iesbelen.semanaculturalempresas.exception;

public class EmpleadosNotFoundException extends RuntimeException{
    public  EmpleadosNotFoundException (Long id){super("Not found Empresa with id: "+ id);}

}

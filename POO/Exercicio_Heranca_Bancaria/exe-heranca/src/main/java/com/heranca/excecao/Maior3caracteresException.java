package com.heranca.excecao;

public class Maior3caracteresException extends IllegalArgumentException{
    
    public Maior3caracteresException(String campo){
        super(campo + " deve ser maior que 3 caracteres.");
    }
}
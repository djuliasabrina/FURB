package com.loja;

public class ValorMenorZeroException extends IllegalArgumentException{

    public ValorMenorZeroException(String campo){
        super(campo + " deve ser maior ou igual a zero.");
    }
}

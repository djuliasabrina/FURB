package com.empresa.excecao;

public class CampoDeveSerPreenchidoException extends IllegalArgumentException {

    public CampoDeveSerPreenchidoException(String campo){
        super(campo + " deve ser preenchido.");
    }
    
}

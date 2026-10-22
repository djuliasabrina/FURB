package com.empresa.excecao;

public class ValorNaoPodeSerNegativoException extends IllegalArgumentException{

    public ValorNaoPodeSerNegativoException(String campo){
        super(campo + " valor não pode ser negativo (deve ser maior que 0).");
    }
    
}

package com.heranca;

import java.util.ArrayList;
import java.util.List;

public class Programador extends Funcionario{

    private List<String> linguagens;

    public Programador(String nome, double salarioBase){
        super(nome, salarioBase);
        linguagens = new ArrayList<String>();
    }

    public void incluirLinguagem(String linguagem){
        if (linguagem == null) {
            throw new IllegalArgumentException("Linguagem deve ser preenchida.");
        }

        linguagens.add(linguagem);
    }

    public void removerLinguagem(String linguagem){
        if (!linguagens.contains(linguagem)) {
            throw new IllegalArgumentException("Essa linguagem não está incluida.");
        }

        // OU
        /* 
        for(String l : linguagens){
            if (!l.equalsIgnoreCase(linguagem)) {
                throw new IllegalArgumentException("Essa linguagem não está incluida.");
            }
        }
        */

        linguagens.remove(linguagem);
    }
        
    public List<String> getLinguagens() {
        return linguagens;
    }

    public boolean conheceJava(){
        for(String l : linguagens){
            if (l.equalsIgnoreCase("java")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double calcularSalario() {

        if (conheceJava()) {
            return getSalarioBase() + (getSalarioBase() * 0.20);
        }


        return getSalarioBase();
    }
}

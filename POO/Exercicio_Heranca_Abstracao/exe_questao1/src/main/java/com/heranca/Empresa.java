package com.heranca;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String nome;
    private List<Funcionario> funcionarios;

    public Empresa(String nome) {
        setNome(nome);
        funcionarios = new ArrayList<Funcionario>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido...");
        }
        this.nome = nome;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void incluirFuncionario(Funcionario f){
        if (f == null) {
            throw new IllegalArgumentException("Funcionário deve ser preenchido.");
        }

        funcionarios.add(f);
    }

    public void removerFuncionario(Funcionario f){
      
            if (!funcionarios.contains(f)) {
                throw new IllegalArgumentException("Funcionário não cadastrado.");
            }
        

        funcionarios.remove(f);
    }

    public double calcularCustosSalarios(){
        double total = 0;

        for(Funcionario f : funcionarios){
            total += f.calcularSalario();
        }

        return total;
    }
}

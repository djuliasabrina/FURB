package com.heranca;

public abstract class Funcionario {

    private String nome;
    private double salarioBase;

    public Funcionario(String nome, double salarioBase){
        setNome(nome);
        setSalarioBase(salarioBase);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome deve ser preenchido.");
        }
        this.nome = nome;
    }
    public double getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(double salarioBase) {
        if (salarioBase <= 0) {
            throw new IllegalArgumentException("Salário base deve ser maior que 0.");
        }
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalario();

    
}

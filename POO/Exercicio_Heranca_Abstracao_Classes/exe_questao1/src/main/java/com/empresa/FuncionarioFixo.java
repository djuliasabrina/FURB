package com.empresa;

public class FuncionarioFixo extends Funcionario{

    private double salarioBase;

    public FuncionarioFixo(String nome, String matricula, double salarioBase){
        super(nome, matricula);
        setSalarioBase(salarioBase);
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) throws IllegalArgumentException{
        if (salarioBase <= 0) {
            throw new IllegalArgumentException("Salário Base deve ser maior que 0.");
        }
        this.salarioBase = salarioBase;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase();
    }
    
}

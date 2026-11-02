package com.empresa;

public class FuncionarioComissado extends Funcionario {

    private double salarioBase;
    private double totalVendas;
    private int percentualComissao;

    public FuncionarioComissado(String nome, String matricula, double salarioBase, double totalVendas,
            int percentualComissao) {
        super(nome, matricula);
        setSalarioBase(salarioBase);
        setTotalVendas(totalVendas);
        setPercentualComissao(percentualComissao);
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if (salarioBase <= 0) {
            throw new IllegalArgumentException("Salário Base deve ser maior que 0.");
        }
        this.salarioBase = salarioBase;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        if (totalVendas < 0) {
            throw new IllegalArgumentException("Total de vendas deve ser positivo.");
        }
        this.totalVendas = totalVendas;
    }

    public int getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(int percentualComissao) {
        if (percentualComissao <= 0) {
            throw new IllegalArgumentException("Percentual da comissão deve ser maior que 0.");
        }
        this.percentualComissao = percentualComissao;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + (getTotalVendas() * getPercentualComissao() / 100.0);
    }

}

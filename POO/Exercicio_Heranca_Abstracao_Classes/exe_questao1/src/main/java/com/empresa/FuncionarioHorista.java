package com.empresa;

public class FuncionarioHorista extends Funcionario{
    
    private double horasTrabalhadas;
    private double valorHora;

    public FuncionarioHorista(String nome, String matricula, double horasTrabalhadas, double valorHora){
        super(nome, matricula);
        setHorasTrabalhadas(horasTrabalhadas);
        setValorHora(valorHora);
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }
    public void setHorasTrabalhadas(double horasTrabalhadas) throws IllegalArgumentException{
        if (horasTrabalhadas < 0) {
            throw new IllegalArgumentException("Horas trabalhadas deve ser positivo.");
        }
        this.horasTrabalhadas = horasTrabalhadas;
    }
    public double getValorHora() {
        return valorHora;
    }
    public void setValorHora(double valorHora) throws IllegalArgumentException{
        if (valorHora <= 0) {
            throw new IllegalArgumentException("Valor da hora deve ser maior que 0.");
        }
        this.valorHora = valorHora;
    }

    @Override
    public double calcularSalario() {
        return getHorasTrabalhadas() * getValorHora();
    }


}

package com.empresa;

public class Onibus extends Veiculo {

    private int qtdPassageiros;

    public Onibus(String placa, double capacidadeTanque, double consumoBase, int qtdPassageiros){
            
        super(placa, capacidadeTanque, consumoBase);
        setQtdPassageiros(qtdPassageiros);
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    public void setQtdPassageiros(int qtdPassageiros) {
        if (qtdPassageiros < 0) {
            throw new IllegalArgumentException("A quantidade de passageiros não pode ser negativa.");
        }
        this.qtdPassageiros = qtdPassageiros;
    }


    public double calcularConsumo(){
        int grupoDeDez = qtdPassageiros / 10;
        double reducao = grupoDeDez * 0.05;

        return getConsumoBase() * (1 - reducao);
    }


}

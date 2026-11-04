package com.locadora;

public class Moto extends Veiculo {

    private boolean possuiCilindradas;

    public Moto(String placa, String modelo, double valorDiaria, boolean possuiCilipossuiCilindradas) {
        super(placa, modelo, valorDiaria);
        setPossuiCilindradas(possuiCilipossuiCilindradas);
    }

    public boolean isPossuiCilindradas() {
        return possuiCilindradas;
    }

    public void setPossuiCilindradas(boolean possuiCilindradas) {
        this.possuiCilindradas = possuiCilindradas;
    }

    @Override
    public double calcularAluguel() {
        double valor = getValorDiaria() * getQtdDias();
        if (getQtdDias() > 7) {
            double desconto = possuiCilindradas ? 0.05 : 0.10;
            valor -= valor * desconto;
        }
        return valor;
    }

    @Override
    public String imprimirDados() {
        return "[Moto] " + super.imprimirDados() + " | Possui cilindradas: " + (possuiCilindradas ? "Sim" : "Não");
    }

}

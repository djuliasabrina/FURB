package com.empresa;

public class Carro extends Veiculo {

    private boolean arCondicionado;

    public Carro(String placa, double capacidadeTanque, double consumoBase, boolean arCondicionado) {
        super(placa, capacidadeTanque, consumoBase);
        setArCondicionado(arCondicionado);

    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public double calcularConsumo(){
        // Verifica se o arCondicionado esta ligado e a eficiencia cai 10%
        if (arCondicionado) {
            return getConsumoBase() * 0.90;
        }

        return getConsumoBase();
    }

}

package com.empresa;

import com.empresa.excecao.CampoDeveSerPreenchidoException;
import com.empresa.excecao.ValorNaoPodeSerNegativoException;

public abstract class Veiculo {

    private String placa;
    private double capacidadeTanque;
    private double consumoBase;

    public Veiculo(String placa, double capacidadeTanque, double consumoBase) {

        setPlaca(placa);
        setCapacidadeTanque(capacidadeTanque);
        setConsumoBase(consumoBase);

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) throws ValorNaoPodeSerNegativoException {
        if (placa == null || placa.isBlank()) {
            throw new CampoDeveSerPreenchidoException("Placa");
        }
        this.placa = placa;
    }

    public double getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public void setCapacidadeTanque(double capacidadeTanque) throws ValorNaoPodeSerNegativoException {
        if (capacidadeTanque <= 0) {
            throw new ValorNaoPodeSerNegativoException("Capacidade do tanque");
        }
        this.capacidadeTanque = capacidadeTanque;
    }

    public double getConsumoBase() {
        return consumoBase;
    }

    public void setConsumoBase(double consumoBase) throws ValorNaoPodeSerNegativoException {
        if (consumoBase <= 0) {
            throw new ValorNaoPodeSerNegativoException("Consumo Base");
        }
        this.consumoBase = consumoBase;
    }

    // Cada veiculo tem seu proprio consumo (KM / L)
    public abstract double calcularConsumo();


    public double calcularAutonomia() {
        return capacidadeTanque * calcularConsumo();

    }

    public double calcularLitrosNecessarios(double distancia){
        if (distancia <= 0) {
            throw new IllegalArgumentException("A distância deve ser maior que zero.");
        }

        return distancia / calcularConsumo();
    }

    public double custoDeViagem(double distancia, double precoCombustivel){
        if (precoCombustivel <= 0) {
            throw new IllegalArgumentException("O preço do combustível deve ser maior que zero.");
        }
        
        return calcularLitrosNecessarios(distancia) * precoCombustivel;
    }


}

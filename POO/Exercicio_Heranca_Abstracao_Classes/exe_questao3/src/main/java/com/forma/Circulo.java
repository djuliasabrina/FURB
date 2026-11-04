package com.forma;

public class Circulo extends FormaGeometrica{

    private double raio;

    public Circulo(String cor, double raio){
        super(cor);
        setRaio(raio);
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public float area() {
        return 0;
    }

    @Override
    public float perimetro() {
        // TODO Auto-generated method stub
        return 0;
    }


    
}

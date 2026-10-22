package com.biblioteca;

public class Dvd extends ItemBiblioteca{

    public Dvd(String titulo, int prazoBase, double valorMultaPorDia, boolean emprestado){
        super(titulo, prazoBase, valorMultaPorDia, emprestado);
    }

    @Override 
    public double calcularMulta(int diasDeAtraso){
        if (diasDeAtraso < getPrazoBase()) {
            return 0;
        }

        return  (diasDeAtraso * getValorMultaPorDia());
    }
    
}

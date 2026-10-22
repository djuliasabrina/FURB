package com.biblioteca;

public class ItemBiblioteca {

    private String titulo;
    private int prazoBase;
    private double valorMultaPorDia;
    private boolean emprestado;

    public ItemBiblioteca(String titulo, int prazoBase, double valorMultaPorDia, boolean emprestado) {
        setTitulo(titulo);
        setPrazoBase(prazoBase);
        setValorMultaPorDia(valorMultaPorDia);
        setEmprestado(emprestado);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo deve ser preenchido.");
        }
        this.titulo = titulo;
    }

    public int getPrazoBase() {
        return prazoBase;
    }

    public void setPrazoBase(int prazoBase) {
        if (prazoBase <= 0) {
            throw new IllegalArgumentException("Prazo base deve ser positivo.");
        }
        this.prazoBase = prazoBase;
    }

    public double getValorMultaPorDia() {
        return valorMultaPorDia;
    }

    public void setValorMultaPorDia(double valorMultaPorDia) {
        if (valorMultaPorDia < 0) {
            throw new IllegalArgumentException("Valor da multa deve ser positiva.");
        }
        this.valorMultaPorDia = valorMultaPorDia;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public double calcularMulta(int diasDeAtraso) {
        return diasDeAtraso * 0.50;
    }

}

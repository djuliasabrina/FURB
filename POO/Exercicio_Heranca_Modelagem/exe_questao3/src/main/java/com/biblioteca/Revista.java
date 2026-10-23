package com.biblioteca;

public class Revista extends ItemBiblioteca {

    public Revista(String titulo, boolean emprestado, boolean devolvido) {
        super(titulo, emprestado, devolvido);
    }

    @Override
    public double calcularMulta(int diasDeAtraso) {
        if (diasDeAtraso < 0) {
            throw new IllegalArgumentException("Dias de atraso não podem ser negativos.");
        }

        if (!isEmprestado()) {
            throw new IllegalStateException(
                    "O item não foi emprestado.");
        }

        if (!isDevolvido()) {
            throw new IllegalStateException(
                    "O item ainda não foi devolvido.");
        }

        return diasDeAtraso * 0.30;

    }

}

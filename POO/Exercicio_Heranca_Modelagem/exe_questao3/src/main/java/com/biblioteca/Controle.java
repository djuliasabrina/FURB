package com.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Controle {

    private List<ItemBiblioteca> itemBibliotecas;

    public Controle() {
        itemBibliotecas = new ArrayList<ItemBiblioteca>();
    }

    public List<ItemBiblioteca> getItemBibliotecas() {
        return itemBibliotecas;
    }

    public void addItemBiblioteca(ItemBiblioteca itemBiblioteca) {
        if (itemBiblioteca == null) {
            throw new IllegalArgumentException("Item deve ser preenchido.");
        }

        itemBibliotecas.add(itemBiblioteca);
    }

    public String imprimirMultaCalculada(ItemBiblioteca itemBiblioteca, int diasDeAtraso) {
        if (itemBibliotecas == null) {
            throw new IllegalArgumentException("Nenhum item cadastrado.");
        }
        String dados = "";

        double multa = 0;

        for (ItemBiblioteca i : itemBibliotecas) {
            if (itemBiblioteca == i) {
                multa = i.calcularMulta(diasDeAtraso);
                dados += "Titulo: " + i.getTitulo() + " - Multa Calculada: " + multa;
            }
        }

        return dados;

    }
}

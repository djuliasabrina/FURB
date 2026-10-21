package com.loja;

import java.util.ArrayList;
import java.util.List;

public class Campanha {

    private List<Produto> produtos;

    public Campanha() {
        produtos = new ArrayList<Produto>();
    }

    public void addProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto deve ser preenchido.");
        }

        produtos.add(produto);
    }

    public String imprimir() {
        String dados = "";

        for (Produto p : produtos) {
            dados += "Nome: " + p.getNome() + "\nPreço R$";

            if (p instanceof Smartphone) {
                Smartphone prodSmartphone = (Smartphone) p;
                dados += prodSmartphone.precoComDesconto();
            } else if (p instanceof Notebook) {
                Notebook notebook = (Notebook) p;
                dados += notebook.getPreco() - notebook.desconto();
            }

            dados += " - Garantia: " + p.getMesesGarantia() + "\n";
        }

        return dados;

    }

    public double precoTotal() {
        double total = 0;

        for (Produto p : produtos) {
            if (p instanceof Notebook) {
                Notebook n = (Notebook) p;
                total += n.getPreco() - n.desconto();
            } else {
                Smartphone s = (Smartphone) p;
                total += s.precoComDesconto();
            }
        }

        return total;
    }

}

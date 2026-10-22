package com.loja;

public abstract class Produto {

    private String nome;
    private double preco;
    private int mesesGarantia;

    public Produto(String nome, double preco, int mesesGarantia) {
        setNome(nome);
        setPreco(preco);
        setMesesGarantia(mesesGarantia);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome deve ser preenchido.");
        }
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) throws ValorMenorZeroException {
        if (preco < 0) {
            throw new ValorMenorZeroException("Preço");
        }
        this.preco = preco;
    }

    public int getMesesGarantia() {
        return mesesGarantia;
    }

    public void setMesesGarantia(int mesesGarantia) throws ValorMenorZeroException {
        if (mesesGarantia < 0) {
            throw new ValorMenorZeroException("Quantidade de meses para garantia");
        }
        this.mesesGarantia = mesesGarantia;
    }

    // Isso é usado quando as classes filhas são obrigadas a ter, e a classe pai não tem como implementar
    public abstract double desconto(); // Todas as classes filhas são obrigadas a implementar esse método
    

}

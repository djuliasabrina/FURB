package com.loja;

public class Smartphone extends Produto {

    private int armazenamento;
    private boolean banda5g;

    public Smartphone(double preco, int mesesGarantia, int armazenamento, boolean banda5g) {
        super("Smartphone", preco, mesesGarantia);
        setArmazenamento(armazenamento);
        setBanda5g(banda5g);
    }

    public int getArmazenamento() throws ValorMenorZeroException {
        if (armazenamento < 0) {
            throw new ValorMenorZeroException("Armazenamento");
        }
        return armazenamento;
    }

    public void setArmazenamento(int armazenamento) {
        this.armazenamento = armazenamento;
    }

    public boolean isBanda5g() {
        return banda5g;
    }

    public void setBanda5g(boolean banda5g) {
        this.banda5g = banda5g;
    }

    @Override 
    public double desconto() {
        if (banda5g) {
            return getPreco() * 0.05;
        }

        return 0;
    }

    public double precoComDesconto() {
        if (banda5g) {
            return getPreco() * 0.95;
        }

        return getPreco();
    }

    @Override
    public int getMesesGarantia() {
        if (this.armazenamento >= 256) {
            return super.getMesesGarantia() + 3;
        }

        return super.getMesesGarantia();
    }

}

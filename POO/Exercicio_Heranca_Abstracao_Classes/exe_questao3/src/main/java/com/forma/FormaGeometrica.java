package com.forma;

public abstract class FormaGeometrica {

    private String cor;

    public FormaGeometrica(String cor){
        setCor(cor);
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public abstract float area();

    public abstract float perimetro();
    
}

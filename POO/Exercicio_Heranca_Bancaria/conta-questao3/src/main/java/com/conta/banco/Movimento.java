package com.conta.banco;

public class Movimento {

    private double valor;

    public Movimento(double valor, TipoMovimento tipo) {
        setValor(valor);
    }

    public LocalDate getData() {
        return getData();
    }

    public LocalTime getHora() {
        return getHora();
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que 0.");
        }
        this.valor = valor;
    }

    public TipoMovimento getTipoMovimento(){
        return getTipoMovimento();
    }

}

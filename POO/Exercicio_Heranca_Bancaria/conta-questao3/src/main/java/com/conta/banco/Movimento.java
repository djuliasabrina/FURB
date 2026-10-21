package com.conta.banco;

import java.time.LocalDate;
import java.time.LocalTime;

public class Movimento {

    private double valor;
    private LocalDate data;
    private LocalTime hora;
    private TipoMovimento tipoMovimento;

    public Movimento(double valor, TipoMovimento tipo) {
        setValor(valor);
        this.tipoMovimento = tipo;
        this.data = LocalDate.now();
        this.hora = LocalTime.now();
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

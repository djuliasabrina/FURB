package com.heranca.banco;

import com.heranca.modelo.Cliente;

public class ContaEspecial extends ContaBancaria {

    private double limiteCredito;
    private double saldoLimiteCredito; // Parte 2: os lugares que envolvem este atributo não precisa constar para a
                                       // solução Parte 1

    public ContaEspecial(String numero, Cliente titular, double limiteCredito) throws IllegalArgumentException {
        super(numero, titular); // Super chama o construtor da classe superior e deve ficar sempre na primeira
                                // linha
        setLimiteCredito(limiteCredito);
    }

    public ContaEspecial(String numero, double saldo, Cliente titular, double limiteCredito)
            throws IllegalArgumentException {
        super(numero, saldo, titular); // Super chama o construtor da classe superior e deve ficar sempre na primeira
                                       // linha
        setLimiteCredito(limiteCredito);
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) throws IllegalArgumentException {
        if (limiteCredito < 0) {
            throw new IllegalArgumentException("Limite de crédito deve ser positivo.");
        }
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void sacar(double valor) throws IllegalArgumentException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que 0.");
        }

        if (valor > (getSaldo() + limiteCredito)) {
            throw new IllegalArgumentException("Não há limite de saldo suficiente para saque." +
                    "\nValor atual R$" + (getSaldo() + limiteCredito));
        }

        // Forma 1: (modificar método set da classe ContaBancaria)
        // setSaldo(getSaldo() - valor);

        // Forma 2:
        if (valor > super.getSaldo()) {
            double valorExcedente = valor - super.getSaldo();
            setSaldo(0);
            saldoLimiteCredito -= valorExcedente;
        } else {
            setSaldo(super.getSaldo() - valor);
        }

    }

    @Override
    public double getSaldo() {
        if (saldoLimiteCredito == getLimiteCredito()) {
            return super.getSaldo();
        }
        return saldoLimiteCredito * -1;
    }

}
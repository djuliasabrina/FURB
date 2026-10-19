package banco;

import excecao.CampoVazioException;
import modelo.Cliente;

public class ContaBancaria {

    private String numero;
    private double saldo;
    private Cliente titular;

    // Conta com saldo
    public ContaBancaria(String numero, double saldo, Cliente titular) throws CampoVazioException{
        setNumero(numero);
        setSaldo(saldo);
        setTitular(titular);
    }

    // Conta sem saldo
    public ContaBancaria(String numero, Cliente titular) {
        setNumero(numero);
        setTitular(titular);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) throws CampoVazioException {
        if (numero == null || numero.isBlank()) {
            throw new CampoVazioException("Número da conta");
        }
        this.numero = numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) throws CampoVazioException {
        if (titular == null) {
            throw new CampoVazioException("Titular");
        }
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) throws IllegalArgumentException {
        if (saldo < 0) {
            throw new IllegalArgumentException("Saldo informado deve ser positivo.");
        }
        this.saldo = saldo;
    }

    public void depositar(double valor) throws IllegalArgumentException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que 0.");
        }

        // FORMAS DIFERENTES
        // setSaldo(getSaldo() + valor);
        // this.saldo += valor;
        this.setSaldo(getSaldo() + valor);

    }

    public void sacar(double valor) throws IllegalArgumentException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que 0.");
        }
        if (valor > this.saldo) {
            throw new IllegalArgumentException("Valor deve ser menor que o saldo da conta. " +
                    "\nSaldo atual R$" + saldo);
        }

        // setSaldo(getSaldo() - valor);
        this.saldo -= valor;

    }

    public void transferir(ContaBancaria contaDestino, double valor) throws CampoVazioException {
        if (contaDestino == null) {
            throw new CampoVazioException("Conta báncaria de destino.");
        }

        this.sacar(valor);
        contaDestino.depositar(valor);
    }

}

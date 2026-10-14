package heranca;

public class ContaBancaria {

    private String numero;
    private double saldo;
    private Cliente titular;

    public ContaBancaria(String numero, String nome, Cliente titular) {
        setNumero(numero);
        setSaldo(saldo);
        setTitular(titular);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor < 0) {
            System.out.println("Valor dever ser maior que 0!");
        }
        saldo = saldo + valor;

    }

    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("O valor deve ser menor ou igual que o saldo disponível");
        }
        saldo = saldo - valor;

    }

    public void transferir(ContaBancaria contaDestino, double valor) {
        if (valor <= saldo) {
            contaDestino.setSaldo(valor);
        }

        System.out.println("O valor deve ser menor ou igual que o saldo disponível");
    }

}

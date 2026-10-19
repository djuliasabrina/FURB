package sistema;

import banco.ContaBancaria;
import banco.ContaEspecial;
import modelo.Cliente;

public class Sistema {

    public Sistema() {
        Cliente cliente1 = new Cliente("Djulia", "SLA");
        ContaBancaria c1 = new ContaBancaria("123", cliente1);
        ContaEspecial conta1 = new ContaEspecial("123", cliente1, 100);
        conta1.depositar(20);
        System.out.println("SALDO: " + conta1.getSaldo());
        conta1.sacar(50);
        System.out.println("SALDO: " + conta1.getSaldo());

        ContaEspecial teste = new ContaEspecial("22", cliente1, 100);

        System.out.println(teste.getSaldo());

    }

    public static void main(String[] args) throws Exception {
        new Sistema();
    }
}

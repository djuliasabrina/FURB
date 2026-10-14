package sistema;

import heranca.Cliente;
import heranca.ContaBancaria;

public class Sistema {

    public Sistema(){
        Cliente cliente1 = new Cliente("Djulia", "SLA");
        ContaBancaria c1 = new ContaBancaria("12", "BD DA DJU", cliente1);
        c1.depositar(600);
        System.out.println("SALDO: " + c1.getSaldo());
        c1.sacar(554);
        System.out.println("SALDO: " + c1.getSaldo());
    }
    public static void main(String[] args) throws Exception {
        new Sistema();
    }
}

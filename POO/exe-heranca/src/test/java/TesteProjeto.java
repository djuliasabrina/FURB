import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.heranca.banco.ContaBancaria;
import com.heranca.banco.ContaEspecial;
import com.heranca.modelo.Cliente;

class TesteProjeto {

    @Test
    void test() {
        assertTrue(true);
        assertEquals("Luciana", "Luciana");
    }

    @Test
    void testarSetCliente() {
        Cliente c1 = new Cliente("Luciana", "Rua Antonio da Veiga");
        assertEquals(c1.getNome(), "Luciana");
        assertEquals(c1.getEndereco(), "Rua Antonio da Veiga");
    }

    @Test
    void sacarValorPositivoContaBase() {
        ContaBancaria conta = new ContaBancaria("123", 100, new Cliente("Luciana", "Rua XV"));
        conta.sacar(50);
        assertEquals(conta.getSaldo(), 50);
    }

    @Test
    void sacarValorNegativoContaBase() {

        ContaBancaria conta = new ContaBancaria("123", 100, new Cliente("Luciana", "Rua XV"));

        // IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> {
        //     conta.sacar(150);
        // });

        // assertEquals("Valor deve ser menor que o saldo da conta. "
        // + "Saldo atual R$100.0", excecao.getMessage());

        assertThrows(RuntimeException.class, () -> {
            conta.sacar(150);
        });
    }

    @Test
    void sacarValorSuperiorSaldo() {
        Cliente c2 = new Cliente("Djulia", "Rua Brusque");
        ContaEspecial conta1 = new ContaEspecial(100, "22", c2, 0);
        conta1.depositar(20);
        conta1.sacar(50);

        assertEquals(-30, conta1.getSaldo());

    }

    @Test
    void sacarValorSuperiorSaldoMasInferiorLimite() {
        Cliente dj = new Cliente("Dju", "Teste");
        ContaEspecial conta2 = new ContaEspecial(100, "2", dj, 0);
        conta2.depositar(20);
        conta2.sacar(120);

        assertEquals(-100, conta2.getSaldo());
    }

    @Test
    void sacarValorSuperiorSaldoELimite() {
        Cliente c2 = new Cliente("Djulia", "Timbó");
        ContaEspecial conta3 = new ContaEspecial(100, "1", c2, 0);
        conta3.depositar(20);

        // IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> {
        //     conta3.sacar(120.01);
        // });

        // assertEquals("Valor deve ser menor que o saldo da conta. " +
        // "\nSaldo atual R$120.0", excecao.getMessage());

        assertThrows(RuntimeException.class, () -> {
            conta3.sacar(120.01);
        });

    }
}
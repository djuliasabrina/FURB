import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.heranca.banco.ContaBancaria;
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

        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> {
            conta.sacar(150);
        });

        assertEquals("Valor deve ser menor que o saldo da conta. "
                + "Saldo atual R$100.0", excecao.getMessage());
    }
}
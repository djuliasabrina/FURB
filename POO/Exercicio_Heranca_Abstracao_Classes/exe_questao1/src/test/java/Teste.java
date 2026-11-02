import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.empresa.Empresa;
import com.empresa.FuncionarioComissado;
import com.empresa.FuncionarioFixo;
import com.empresa.FuncionarioHorista;

public class Teste {

    @Test
    void testarCalcularSalarioFuncionarioFixo() {
        FuncionarioFixo bruno = new FuncionarioFixo("Bruno", "123", 1000);
        assertEquals(bruno.calcularSalario(), 1000);
    }

    @Test
    void testarCalcularSalarioFuncionarioComissado() {
        FuncionarioComissado djulia = new FuncionarioComissado("Djulia", "2222", 1000, 15, 10);
        assertEquals(djulia.calcularSalario(), 1001.5);
    }

    @Test
    void testarCalcularSalarioFuncionarioHorista() {
        FuncionarioHorista davi = new FuncionarioHorista("Davi", "1515", 48, 30);
        assertEquals(davi.calcularSalario(), 1440);
    }

    @Test
    void testarExibirDadosFuncionario() {
        FuncionarioComissado djulia = new FuncionarioComissado("Djulia", "2222", 1000, 15, 10);
        assertEquals(djulia.exibirDados(), "Nome: Djulia\nMatrícula: 2222");
    }

    @Test
    void testarExibirDadosTodosFuncionarios() {
        FuncionarioFixo bruno = new FuncionarioFixo("Bruno", "123", 1000);
        FuncionarioHorista davi = new FuncionarioHorista("Davi", "1515", 48, 30);
        FuncionarioComissado djulia = new FuncionarioComissado("Djulia", "2222", 1000, 1500, 10);
        Empresa empresa = new Empresa("Teste");

        empresa.addFuncionario(bruno);
        empresa.addFuncionario(davi);
        empresa.addFuncionario(djulia);

        assertEquals(
                "Nome: Bruno\nMatrícula: 123\nSalário: 1000.0\n" +
                        "Nome: Davi\nMatrícula: 1515\nSalário: 1440.0\n" +
                        "Nome: Djulia\nMatrícula: 2222\nSalário: 1150.0\n",
                empresa.exibirDadosTodosFuncionarios());
    }

    @Test
    void testarRemoverFuncionario() {
        Empresa empresa = new Empresa("Teste");
        FuncionarioFixo bruno = new FuncionarioFixo("Bruno", "123", 1000);
        empresa.addFuncionario(bruno);
        empresa.removerFuncionario(bruno);

        assertEquals(0, empresa.calcularValorTotalFolhaPagamento(), 0.001);
    }

    @Test
    void testarCalcularValorTotalFolhaPagamento() {
        Empresa empresa = new Empresa("Teste");
        empresa.addFuncionario(new FuncionarioFixo("Bruno", "123", 1000));
        empresa.addFuncionario(new FuncionarioHorista("Davi", "1515", 48, 30));
        empresa.addFuncionario(new FuncionarioComissado("Djulia", "2222", 1000, 1500, 10));

        assertEquals(3590.0, empresa.calcularValorTotalFolhaPagamento(), 0.001);
    }

    @Test
    void testarExibirDadoUmFuncionario() {
        Empresa empresa = new Empresa("Teste");
        empresa.addFuncionario(new FuncionarioFixo("Bruno", "123", 1000));

        assertEquals("Nome: Bruno\nMatrícula: 123\nSalário: 1000.0\n",
                empresa.exibirDadoUmFuncionario("123"));
        assertEquals("", empresa.exibirDadoUmFuncionario("999"));
    }

}

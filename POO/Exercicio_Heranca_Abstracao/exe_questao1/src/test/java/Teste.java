import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.heranca.Empresa;
import com.heranca.Programador;
import com.heranca.Venda;
import com.heranca.Vendedor;

public class Teste {

    private static final double DELTA = 0.001;

    private Empresa empresa;
    private Vendedor luiz;
    private Vendedor paula;
    private Programador julio;
    private Programador ana;
    private Programador anderson;

    @BeforeEach
    void montarEmpresa() {
        empresa = new Empresa("Minha Empresa");

        luiz = new Vendedor("Luiz", 1000, 10);
        luiz.incluirVenda(new Venda(200));
        luiz.incluirVenda(new Venda(100));

        paula = new Vendedor("Paula", 1200, 7);
        paula.incluirVenda(new Venda(500));
        paula.incluirVenda(new Venda(350));
        paula.incluirVenda(new Venda(280));

        julio = new Programador("Julio", 1000);
        julio.incluirLinguagem("C");
        julio.incluirLinguagem("Java");

        ana = new Programador("Ana", 1000);
        ana.incluirLinguagem("Java");
        ana.incluirLinguagem("C#");

        anderson = new Programador("Anderson", 1200);
        anderson.incluirLinguagem("Phyton");

        empresa.incluirFuncionario(luiz);
        empresa.incluirFuncionario(paula);
        empresa.incluirFuncionario(julio);
        empresa.incluirFuncionario(ana);
        empresa.incluirFuncionario(anderson);
    }

    // ---------- Vendedor ----------

    @Test
    void testarSalarioLuiz() {
        assertEquals(1030.00, luiz.calcularSalario(), DELTA);
    }

    @Test
    void testarSalarioPaula() {
        assertEquals(1279.10, paula.calcularSalario(), DELTA);
    }

    @Test
    void testarVendedorSemVendas() {
        Vendedor v = new Vendedor("Teste", 1000, 10);
        assertEquals(1000.00, v.calcularSalario(), DELTA);
    }

    @Test
    void testarPercentualComissao() {
        assertEquals(10, luiz.getPercentualComissao(), DELTA);
        assertEquals(7, paula.getPercentualComissao(), DELTA);
    }

    @Test
    void testarIncluirVendaNula() {
        assertThrows(IllegalArgumentException.class, () -> luiz.incluirVenda(null));
    }

    // ---------- Programador ----------

    @Test
    void testarSalarioProgramadorComJava() {
        assertEquals(1200.00, julio.calcularSalario(), DELTA);
        assertEquals(1200.00, ana.calcularSalario(), DELTA);
    }

    @Test
    void testarSalarioProgramadorSemJava() {
        assertEquals(1200.00, anderson.calcularSalario(), DELTA);
    }

    @Test
    void testarConheceJava() {
        assertTrue(julio.conheceJava());
        assertTrue(ana.conheceJava());
        assertFalse(anderson.conheceJava());
    }

    @Test
    void testarBonusJavaAoIncluirLinguagem() {
        Programador p = new Programador("Novo", 1000);
        assertEquals(1000.00, p.calcularSalario(), DELTA);

        p.incluirLinguagem("Java");
        assertEquals(1200.00, p.calcularSalario(), DELTA);
    }

    @Test
    void testarRemoverLinguagem() {
        julio.removerLinguagem("Java");
        assertFalse(julio.conheceJava());
        assertEquals(1000.00, julio.calcularSalario(), DELTA);
    }

    @Test
    void testarRemoverLinguagemInexistente() {
        assertThrows(IllegalArgumentException.class, () -> julio.removerLinguagem("Rust"));
    }

    @Test
    void testarIncluirLinguagemNula() {
        assertThrows(IllegalArgumentException.class, () -> julio.incluirLinguagem(null));
    }

    // ---------- Empresa ----------

    @Test
    void testarCustoTotal() {
        assertEquals(5909.10, empresa.calcularCustosSalarios(), DELTA);
    }

    @Test
    void testarQuantidadeFuncionarios() {
        assertEquals(5, empresa.getFuncionarios().size());
    }

    @Test
    void testarRemoverFuncionario() {
        empresa.removerFuncionario(luiz);

        assertEquals(4, empresa.getFuncionarios().size());
        assertEquals(4879.10, empresa.calcularCustosSalarios(), DELTA);
    }

    @Test
    void testarRemoverFuncionarioNaoCadastrado() {
        Vendedor outro = new Vendedor("Outro", 1000, 5);
        assertThrows(IllegalArgumentException.class, () -> empresa.removerFuncionario(outro));
    }

    @Test
    void testarIncluirFuncionarioNulo() {
        assertThrows(IllegalArgumentException.class, () -> empresa.incluirFuncionario(null));
    }

    @Test
    void testarNomeEmpresaInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Empresa(""));
        assertThrows(IllegalArgumentException.class, () -> new Empresa(null));
    }

    // ---------- Funcionario (validações) ----------

    @Test
    void testarNomeFuncionarioInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Vendedor("", 1000, 10));
    }

    @Test
    void testarSalarioBaseInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Programador("Teste", 0));
        assertThrows(IllegalArgumentException.class, () -> new Programador("Teste", -100));
    }
}
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.loja.Campanha;
import com.loja.Notebook;
import com.loja.Produto;
import com.loja.Smartphone;

public class TestesCampanhas {

    /*
     * Para funcionar a classe não pode ser instanciada
     * 
     * @Test
     * void testarProduto(){
     * Produto p = new Produto("Nome", 20, 4);
     * assertEquals(p.getNome(), "Nome");
     * assertEquals(p.getPreco(), 20);
     * assertEquals(p.getMesesGarantia(), 4);
     * }
     */

    @Test
    void testarSmartphone() {
        Smartphone s = new Smartphone(1000, 4, 250, true);
        assertEquals(s.getNome(), "Smartphone");
        assertEquals(s.getPreco(), 1000);
        assertEquals(s.getMesesGarantia(), 4);
        assertEquals(s.getArmazenamento(), 250);
        assertTrue(s.isBanda5g());

        s.setArmazenamento(256);
        assertEquals(s.getMesesGarantia(), 7);
        assertEquals(s.desconto(), 50);
        assertEquals(s.precoComDesconto(), 950);
    }

    @Test
    void testarNotebook() {
        Notebook n = new Notebook("Notebook", 5000, 3, 10, false);
        assertEquals(n.getNome(), "Notebook");
        assertEquals(n.getPreco(), 5000);
        assertEquals(n.getMesesGarantia(), 3);
        assertEquals(n.getRam(), 10);
        assertFalse(n.isSsd());

        n.setRam(16);
        n.setSsd(true);
        assertEquals(n.getMesesGarantia(), 9);
        assertEquals(n.desconto(), 400);
        assertEquals(n.precoComDesconto(), 4600);
    }

    @Test
    void testarCampanha() {
        Notebook n1 = new Notebook("Note", 3000, 3, 16, false);
        Notebook n2 = new Notebook("Note", 1000, 2, 8, true);
        Smartphone s1 = new Smartphone(500, 1, 256, true);

        Campanha campanha = new Campanha();
        campanha.addProduto(n1); // 9 meses de garantia | 3000
        campanha.addProduto(n2); // 2 meses de garantia | 920
        campanha.addProduto(s1); // 4 meses de garantia | 475

        assertEquals(campanha.precoTotal(), 4395);
        assertEquals(campanha.imprimir(),
                "Nome: Note\nPreço R$3000.0 - Garantia: 9\nNome: Note\nPreço R$920.0 - Garantia: 2\nNome: Smartphone\nPreço R$475.0 - Garantia: 4\n");

    }

}


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.biblioteca.Dvd;
import com.biblioteca.Livro;
import com.biblioteca.Revista;

public class Testes {

    @Test
    void testarCalcularMultaDvd() {
        Dvd dvd = new Dvd("Dvd", true, true);
        Dvd dvd2 = new Dvd("Dvd2", true, false);
        Dvd dvd3 = new Dvd("Dvd3", false, false);
        dvd3.emprestar();
        dvd3.devolver();

        assertEquals(dvd.calcularMulta(5), 6);

        // verifica especificamente a exceção lançada quando o DVD ainda não foi
        // devolvido.
        assertThrows(IllegalStateException.class, () -> dvd2.calcularMulta(5));

        assertEquals(dvd3.calcularMulta(5), 6);
    }

    @Test
    void testarCalcularMultaRevista() {
        Revista revista = new Revista("Revista", true, true);

        assertEquals(2.4, revista.calcularMulta(8), 0.1);
    }

    @Test
    void testarCalcularMultaLivro() {
        Livro livro = new Livro("Livro", true, true);

        assertEquals(1.5, livro.calcularMulta(2), 0.1);
    }



}



// import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import com.biblioteca.Controle;
// import com.biblioteca.Dvd;
// import com.biblioteca.ItemBiblioteca;
// import com.biblioteca.Livro;
// import com.biblioteca.Revista;

// public class Testes {

//     private Controle controle;

//     @BeforeEach
//     void configurar() {
//         controle = new Controle();
//     }

//     // ==========================================
//     // TESTES DE ItemBiblioteca
//     // ==========================================

//     @Test
//     void testarCriarItem() {
//         ItemBiblioteca item =
//                 new ItemBiblioteca("Item", false, false);

//         assertEquals("Item", item.getTitulo());
//         assertFalse(item.isEmprestado());
//         assertFalse(item.isDevolvido());
//     }

//     @Test
//     void testarTituloVazio() {
//         assertThrows(
//             IllegalArgumentException.class,
//             () -> new ItemBiblioteca("", false, false)
//         );
//     }

//     @Test
//     void testarTituloNulo() {
//         assertThrows(
//             IllegalArgumentException.class,
//             () -> new ItemBiblioteca(null, false, false)
//         );
//     }

//     @Test
//     void testarAlterarTitulo() {
//         ItemBiblioteca item =
//                 new ItemBiblioteca("Antigo", false, false);

//         item.setTitulo("Novo");

//         assertEquals("Novo", item.getTitulo());
//     }

//     @Test
//     void testarAlterarTituloVazio() {
//         ItemBiblioteca item =
//                 new ItemBiblioteca("Livro", false, false);

//         assertThrows(
//             IllegalArgumentException.class,
//             () -> item.setTitulo(" ")
//         );
//     }

//     @Test
//     void testarMultaPadrao() {
//         ItemBiblioteca item =
//                 new ItemBiblioteca("Item", true, true);

//         assertEquals(2.50, item.calcularMulta(5), 0.01);
//     }

//     @Test
//     void testarMultaPadraoZeroDias() {
//         ItemBiblioteca item =
//                 new ItemBiblioteca("Item", true, true);

//         assertEquals(0.0, item.calcularMulta(0), 0.01);
//     }

//     @Test
//     void testarMultaPadraoDiasNegativos() {
//         ItemBiblioteca item =
//                 new ItemBiblioteca("Item", true, true);

//         assertThrows(
//             IllegalArgumentException.class,
//             () -> item.calcularMulta(-1)
//         );
//     }

//     @Test
//     void testarMultaItemNaoEmprestado() {
//         ItemBiblioteca item =
//                 new ItemBiblioteca("Item", false, false);

//         assertThrows(
//             IllegalStateException.class,
//             () -> item.calcularMulta(5)
//         );
//     }

//     @Test
//     void testarMultaItemNaoDevolvido() {
//         ItemBiblioteca item =
//                 new ItemBiblioteca("Item", true, false);

//         assertThrows(
//             IllegalStateException.class,
//             () -> item.calcularMulta(5)
//         );
//     }

//     // ==========================================
//     // TESTES DE EMPRESTIMO E DEVOLUCAO
//     // ==========================================

//     @Test
//     void testarEmprestarItem() {
//         ItemBiblioteca item =
//                 new ItemBiblioteca("Livro", false, false);

//         item.emprestar();

//         assertTrue(item.isEmprestado());
//         assertFalse(item.isDevolvido());
//     }

//     @Test
//     void testarEmprestarDuasVezes() {
//         ItemBiblioteca item =
//                 new ItemBiblioteca("Livro", false, false);

//         item.emprestar();

//         assertThrows(
//             IllegalArgumentException.class,
//             () -> item.emprestar()
//         );
//     }

//     @Test
//     void testarDevolverItem() {
//         ItemBiblioteca item =
//                 new ItemBiblioteca("Livro", false, false);

//         item.emprestar();
//         item.devolver();

//         assertTrue(item.isEmprestado());
//         assertTrue(item.isDevolvido());
//     }

//     @Test
//     void testarDevolverSemEmprestimo() {
//         ItemBiblioteca item =
//                 new ItemBiblioteca("Livro", false, false);

//         assertThrows(
//             IllegalArgumentException.class,
//             () -> item.devolver()
//         );
//     }

//     @Test
//     void testarDevolverDuasVezes() {
//         ItemBiblioteca item =
//                 new ItemBiblioteca("Livro", false, false);

//         item.emprestar();
//         item.devolver();

//         assertThrows(
//             IllegalArgumentException.class,
//             () -> item.devolver()
//         );
//     }

//     @Test
//     void testarNovoEmprestimoAposDevolucao() {
//         ItemBiblioteca item =
//                 new ItemBiblioteca("Livro", false, false);

//         item.emprestar();
//         item.devolver();
//         item.emprestar();

//         assertTrue(item.isEmprestado());
//         assertFalse(item.isDevolvido());
//     }

//     // ==========================================
//     // TESTES DE Livro
//     // ==========================================

//     @Test
//     void testarCalcularMultaLivro() {
//         Livro livro = new Livro("Livro", true, true);

//         assertEquals(1.50, livro.calcularMulta(2), 0.01);
//     }

//     @Test
//     void testarMultaLivroZeroDias() {
//         Livro livro = new Livro("Livro", true, true);

//         assertEquals(0.0, livro.calcularMulta(0), 0.01);
//     }

//     @Test
//     void testarMultaLivroMuitosDias() {
//         Livro livro = new Livro("Livro", true, true);

//         assertEquals(75.0, livro.calcularMulta(100), 0.01);
//     }

//     @Test
//     void testarMultaLivroNegativa() {
//         Livro livro = new Livro("Livro", true, true);

//         assertThrows(
//             IllegalArgumentException.class,
//             () -> livro.calcularMulta(-1)
//         );
//     }

//     @Test
//     void testarMultaLivroNaoDevolvido() {
//         Livro livro = new Livro("Livro", true, false);

//         assertThrows(
//             IllegalStateException.class,
//             () -> livro.calcularMulta(2)
//         );
//     }

//     // ==========================================
//     // TESTES DE Revista
//     // ==========================================

//     @Test
//     void testarCalcularMultaRevista() {
//         Revista revista =
//                 new Revista("Revista", true, true);

//         assertEquals(2.40, revista.calcularMulta(8), 0.01);
//     }

//     @Test
//     void testarMultaRevistaZeroDias() {
//         Revista revista =
//                 new Revista("Revista", true, true);

//         assertEquals(0.0, revista.calcularMulta(0), 0.01);
//     }

//     @Test
//     void testarMultaRevistaMuitosDias() {
//         Revista revista =
//                 new Revista("Revista", true, true);

//         assertEquals(30.0, revista.calcularMulta(100), 0.01);
//     }

//     @Test
//     void testarMultaRevistaNegativa() {
//         Revista revista =
//                 new Revista("Revista", true, true);

//         assertThrows(
//             IllegalArgumentException.class,
//             () -> revista.calcularMulta(-1)
//         );
//     }

//     @Test
//     void testarMultaRevistaNaoDevolvida() {
//         Revista revista =
//                 new Revista("Revista", true, false);

//         assertThrows(
//             IllegalStateException.class,
//             () -> revista.calcularMulta(8)
//         );
//     }

//     // ==========================================
//     // TESTES DE Dvd
//     // ==========================================

//     @Test
//     void testarCalcularMultaDvd() {
//         Dvd dvd = new Dvd("Dvd", true, true);

//         assertEquals(6.0, dvd.calcularMulta(5), 0.01);
//     }

//     @Test
//     void testarMultaDvdZeroDias() {
//         Dvd dvd = new Dvd("Dvd", true, true);

//         assertEquals(0.0, dvd.calcularMulta(0), 0.01);
//     }

//     @Test
//     void testarMultaDvdMuitosDias() {
//         Dvd dvd = new Dvd("Dvd", true, true);

//         assertEquals(120.0, dvd.calcularMulta(100), 0.01);
//     }

//     @Test
//     void testarMultaDvdNegativa() {
//         Dvd dvd = new Dvd("Dvd", true, true);

//         assertThrows(
//             IllegalArgumentException.class,
//             () -> dvd.calcularMulta(-1)
//         );
//     }

//     @Test
//     void testarMultaDvdNaoDevolvido() {
//         Dvd dvd = new Dvd("Dvd", true, false);

//         assertThrows(
//             IllegalStateException.class,
//             () -> dvd.calcularMulta(5)
//         );
//     }

//     // ==========================================
//     // TESTES DE Controle
//     // ==========================================

//     @Test
//     void testarAdicionarItem() {
//         ItemBiblioteca item =
//                 new Livro("Livro", false, false);

//         controle.addItemBiblioteca(item);

//         assertEquals(1, controle.getItemBibliotecas().size());
//         assertTrue(controle.getItemBibliotecas().contains(item));
//     }

//     @Test
//     void testarAdicionarItemNulo() {
//         assertThrows(
//             IllegalArgumentException.class,
//             () -> controle.addItemBiblioteca(null)
//         );
//     }

//     @Test
//     void testarAdicionarItensVariados() {
//         controle.addItemBiblioteca(
//                 new Livro("Livro", false, false));

//         controle.addItemBiblioteca(
//                 new Revista("Revista", false, false));

//         controle.addItemBiblioteca(
//                 new Dvd("Dvd", false, false));

//         assertEquals(3, controle.getItemBibliotecas().size());
//     }

//     @Test
//     void testarImprimirMultaLivro() {
//         ItemBiblioteca livro =
//                 new Livro("Livro", true, true);

//         controle.addItemBiblioteca(livro);

//         String resultado =
//                 controle.imprimirMultaCalculada(livro, 2);

//         assertTrue(resultado.contains("Livro"));
//         assertTrue(resultado.contains("1,50")
//                 || resultado.contains("1.50"));
//     }

//     @Test
//     void testarImprimirMultaItemNaoCadastrado() {
//         ItemBiblioteca livro =
//                 new Livro("Livro", true, true);

//         assertThrows(
//             IllegalArgumentException.class,
//             () -> controle.imprimirMultaCalculada(livro, 2)
//         );
//     }
// }

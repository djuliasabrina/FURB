package Normal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {

        // Cadastro de livros
        Livro livro1 = new Livro("L001", "Clean Code");
        Livro livro2 = new Livro("L002", "Efetive Java");
        Livro livro3 = new Livro("L003", "Domain-Driven Design");

        List<Livro> catalogo = new ArrayList<>();
        catalogo.add(livro1);
        catalogo.add(livro2);
        catalogo.add(livro3);

        // Cadastro de cliente
        Cliente cliente1 = new Cliente("C001", "Djulia Santos", "djulia@email.com");

        // Registro de empréstimo
        Emprestimo emprestimo1 = new Emprestimo(cliente1, LocalDate.now());
        emprestimo1.adicionarLivro(livro1);
        emprestimo1.adicionarLivro(livro3);

        // Exibição dos dados
        System.out.println("=== Catálogo de livros ===");
        for (Livro l : catalogo) {
            System.out.println(l);
        }

        System.out.println("\n=== Cliente cadastrado ===");
        System.out.println(cliente1);

        System.out.println("\n=== Empréstimo realizado ===");
        System.out.println(emprestimo1);

        System.out.println("\nLivros deste empréstimo:");
        for (Livro l : emprestimo1.getLivros()) {
            System.out.println("- " + l.getTitulo());
        }
    }
}
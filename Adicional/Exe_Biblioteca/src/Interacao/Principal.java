package Interacao;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Principal {

    private static List<Livro> livros = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Emprestimo> emprestimos = new ArrayList<>();

    public static void main(String[] args) {

        int opcao = 0;

        do {
            String menu = "=== BIBLIOTECA ===\n" +
                    "1 - Cadastrar livro\n" +
                    "2 - Cadastrar cliente\n" +
                    "3 - Realizar empréstimo\n" +
                    "4 - Listar livros\n" +
                    "5 - Listar clientes\n" +
                    "6 - Listar empréstimos\n" +
                    "0 - Sair";

            String entrada = JOptionPane.showInputDialog(null, menu, "Menu", JOptionPane.PLAIN_MESSAGE);

            if (entrada == null) break; // usuário clicou em cancelar

            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                case 3:
                    realizarEmprestimo();
                    break;
                case 4:
                    listarLivros();
                    break;
                case 5:
                    listarClientes();
                    break;
                case 6:
                    listarEmprestimos();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (opcao != 0);

        System.exit(0);
    }

    private static void cadastrarLivro() {
        String codigo = JOptionPane.showInputDialog("Código do livro:");
        if (codigo == null) return;

        String titulo = JOptionPane.showInputDialog("Título do livro:");
        if (titulo == null) return;

        livros.add(new Livro(codigo, titulo));
        JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
    }

    private static void cadastrarCliente() {
        String codigo = JOptionPane.showInputDialog("Código do cliente:");
        if (codigo == null) return;

        String nome = JOptionPane.showInputDialog("Nome do cliente:");
        if (nome == null) return;

        String email = JOptionPane.showInputDialog("E-mail do cliente:");
        if (email == null) return;

        clientes.add(new Cliente(codigo, nome, email));
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
    }

    private static void realizarEmprestimo() {
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cadastre um cliente antes de realizar um empréstimo.");
            return;
        }
        if (livros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cadastre um livro antes de realizar um empréstimo.");
            return;
        }

        Cliente cliente = escolherCliente();
        if (cliente == null) return;

        Emprestimo emprestimo = new Emprestimo(cliente, LocalDate.now());

        boolean continuar = true;
        while (continuar) {
            Livro livro = escolherLivro();
            if (livro == null) break;

            emprestimo.adicionarLivro(livro);

            int resposta = JOptionPane.showConfirmDialog(null,
                    "Livro \"" + livro.getTitulo() + "\" adicionado.\nDeseja adicionar outro livro?",
                    "Continuar", JOptionPane.YES_NO_OPTION);

            continuar = (resposta == JOptionPane.YES_OPTION);
        }

        if (emprestimo.getLivros().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Empréstimo cancelado: nenhum livro foi selecionado.");
            return;
        }

        emprestimos.add(emprestimo);
        JOptionPane.showMessageDialog(null, "Empréstimo registrado com sucesso!\n\n" + emprestimo);
    }

    private static Cliente escolherCliente() {
        String[] opcoes = new String[clientes.size()];
        for (int i = 0; i < clientes.size(); i++) {
            opcoes[i] = clientes.get(i).getCodigo() + " - " + clientes.get(i).getNome();
        }

        String escolha = (String) JOptionPane.showInputDialog(null, "Selecione o cliente:",
                "Cliente", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == null) return null;

        String codigoEscolhido = escolha.split(" - ")[0];
        for (Cliente c : clientes) {
            if (c.getCodigo().equals(codigoEscolhido)) return c;
        }
        return null;
    }

    private static Livro escolherLivro() {
        String[] opcoes = new String[livros.size()];
        for (int i = 0; i < livros.size(); i++) {
            opcoes[i] = livros.get(i).getCodigo() + " - " + livros.get(i).getTitulo();
        }

        String escolha = (String) JOptionPane.showInputDialog(null, "Selecione o livro:",
                "Livro", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == null) return null;

        String codigoEscolhido = escolha.split(" - ")[0];
        for (Livro l : livros) {
            if (l.getCodigo().equals(codigoEscolhido)) return l;
        }
        return null;
    }

    private static void listarLivros() {
        if (livros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Livro l : livros) {
            sb.append(l.getCodigo()).append(" - ").append(l.getTitulo()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void listarClientes() {
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Cliente c : clientes) {
            sb.append(c.getCodigo()).append(" - ").append(c.getNome())
              .append(" (").append(c.getEmail()).append(")\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum empréstimo registrado.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Emprestimo e : emprestimos) {
            sb.append(e).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
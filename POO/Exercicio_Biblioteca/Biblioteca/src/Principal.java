import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

    private List<Cliente> clientes;
    private List<Livro> livros;
    private List<Emprestimo> emprestimos;

    public Principal() {

        clientes = new ArrayList<Cliente>();
        livros = new ArrayList<Livro>();
        emprestimos = new ArrayList<Emprestimo>();

        String menuPrincipal = "\n0 - Sair \n1 - Cadastrar cliente \n2 - Cadastrar livro \n3 - Fazer um empréstimo \n4 - Listar clientes \n5 - Listar livros \n6 - Listar empréstimos";

        int opcao = 0;

        do {
            String op = JOptionPane.showInputDialog(null, menuPrincipal);
            opcao = Integer.parseInt(op);

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarLivro();
                    break;
                case 3:
                    fazerEmprestimo();
                    break;
                case 4:
                    listarClientes();
                    break;
                case 5:
                    listarLivros();
                    break;
                case 6:
                    listarEmprestimos();
                    break;
                case 0:
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida...", "ERRO", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opcao != 0);

    }


    private void listarEmprestimos() {
        String dadosEmprestimos = "--- LISTANDO EMPRÉSTIMOS ---";

        for (int i = 0; i < emprestimos.size(); i++) {
            dadosEmprestimos += "\nEmpréstimo " + (i + 1) + emprestimos.get(i).imprimirDados();
        }

        JOptionPane.showMessageDialog(null, dadosEmprestimos);
    }

    private void listarLivros() {

        if (livros == null) {
            JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String dado = "--- LISTANDO LIVROS ---";
        int l = 0;
        for (Livro livro : livros) {
            dado += "\nLivro " + (l + 1) + "\nCódigo: " + livro.getCdLivro() + "\nTítulo: " + livro.getTitulo() + "\n";
            l++;
        }
        JOptionPane.showMessageDialog(null, dado);
    }

    private void listarClientes() {
        if (clientes == null) {
            JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String dados = "--- LISTANDO CLIENTES ---";
        int c = 0;
        for (Cliente cliente : clientes) {
            dados += "\nCliente " + (c + 1) + "\nNome: " + cliente.getNome() + "\nCódigo: "
                    + cliente.getCdCliente() + "\nE-mail: " + cliente.getEmail() + "\n";

            c++;
        }

        JOptionPane.showMessageDialog(null, dados);
    }

    private void cadastrarLivro() {
        String cd = JOptionPane.showInputDialog("Informe o código do livro: ");
        int cdLivro = Integer.parseInt(cd);
        String titulo = JOptionPane.showInputDialog("Informe o titulo do livro: ");

        Livro livro = new Livro(cdLivro, titulo);

        livros.add(livro);
    }

    private void fazerEmprestimo() {

        // LIVRO
        List<Livro> livrosEscolhidos = new ArrayList<Livro>();
        String dadosLivros = "";
        // Exibindo lista de livros
        for (int i = 0; i < livros.size(); i++) {
            dadosLivros += "\nCódigo: " + livros.get(i).getCdLivro() + "\nTítulo: "
                    + livros.get(i).getTitulo() + "\n";
        }

        int op;

        do {
            String livroEscolhido = JOptionPane.showInputDialog(null, dadosLivros + "\nInforme o código do livro: ");

            for (Livro livro : livros) {
                if (livro.getCdLivro() == Integer.parseInt(livroEscolhido)) {
                    livrosEscolhidos.add(livro); // Adiciona o livro na lista de livrosEscolhidos
                }
            }

            op = JOptionPane.showOptionDialog(null, "Deseja incluir mais algum livro: ", "ESCOLHA",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (op == JOptionPane.YES_OPTION) {

            }

        } while (op == JOptionPane.YES_OPTION);

        // CLIENTE
        String dadosClientes = "";

        for (int j = 0; j < clientes.size(); j++) {
            dadosClientes += "\nCódigo: " + clientes.get(j).getCdCliente() + "\nNome: " + clientes.get(j).getNome()
                    + "\nE-mail: " + clientes.get(j).getEmail() + "\n";
        }

        String clienteEscolhido = JOptionPane.showInputDialog(null, dadosClientes + "\nInforme o código do cliente: ");

        Cliente clienteEncontrado = null;

        for (Cliente cliente : clientes) {
            if (cliente.getCdCliente() == Integer.parseInt(clienteEscolhido)) {
                clienteEncontrado = cliente;
            }
        }

        Emprestimo emprestimo = new Emprestimo(livrosEscolhidos, clienteEncontrado, new Date());

        emprestimos.add(emprestimo);
    }

    private void cadastrarCliente() {
        String nome = JOptionPane.showInputDialog("Informe o nome do cliente: ");
        String cd = JOptionPane.showInputDialog("Informe o código do cliente: ");
        int cdCliente = Integer.parseInt(cd);
        String email = JOptionPane.showInputDialog("Informe o email do cliente: ");

        Cliente cliente = new Cliente(nome, cdCliente, email);

        clientes.add(cliente);

    }

    public static void main(String[] args) {
        new Principal();
    }
}

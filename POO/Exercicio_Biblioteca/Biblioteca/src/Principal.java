import java.util.ArrayList;
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

        String menuPrincipal = "\n1 - Cadastrar cliente \n2 - Cadastrar livro \n3 - Fazer um emprestimo \n4 - Listar clientes \n5 - Listar livros \n6 - Listar emprestimos";

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarEmprestimos'");
    }

    private void listarLivros() {

        if (livros == null) {
            JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String dados = "";
        for (Livro livro : livros) {
            dados += "\nCódigo: " + livro.getCdLivro() + "\nTítulo: " + livro.getTitulo();
        }
        JOptionPane.showMessageDialog(null, dados);
    }

    private void listarClientes() {
        if (clientes == null) {
            JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String listaClientes = "Clientes cadastrados: ";
        for (int i = 0; i < clientes.size(); i++) {
            listaClientes = listaClientes + "\nNome: " + clientes.get(i).getNome() + "\nCódigo: "
                    + clientes.get(i).getCdCliente() + "\nE-mail: " + clientes.get(i).getEmail();
        }

        JOptionPane.showMessageDialog(null, listaClientes);
    }

    private void cadastrarLivro() {
        String cd = JOptionPane.showInputDialog("Informe o código do livro: ");
        int cdLivro = Integer.parseInt(cd);
        String titulo = JOptionPane.showInputDialog("Informe o titulo do livro: ");

        Livro livro = new Livro(cdLivro, titulo);

        livros.add(livro);
    }

    private void fazerEmprestimo() {
        String livroEscolhido = JOptionPane.showInputDialog("Informe o livro escolhido: ");
        String cliente = JOptionPane.showInputDialog("Informe o nome do cliente: ");

        Emprestimo emprestimo = new Emprestimo();

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

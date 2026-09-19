package view;

import javax.swing.JOptionPane;
import controller.Controle;
import model.Pedido;
import model.SorveteVendido;

public class Sistema {

    private Controle controle;

    public Sistema() {
        controle = new Controle("Sorveteria Gelato & Cia");

        String menu = "--- MENU SORVETERIA ---" +
                "\n1 - Cadastrar sorvete em um pedido" +
                "\n2 - Remover sorvete pelo nome" +
                "\n3 - Qtd total de sorvetes em um pedido" +
                "\n4 - Sorvete que possui maior nome" +
                "\n5 - Qtd de sorvetes de um sabor no pedido" +
                "\n6 - Adicionar pedido" +
                "\n7 - Localizar pedido pelo ID" +
                "\n8 - Qtd de pedidos realizados por cliente" +
                "\n9 - Pedido com maior quantidade de sorvetes" +
                "\n0 - Sair\n\n";

        int opcao = -1;

        do {
            try {
                String op = JOptionPane.showInputDialog(menu + "Escolha uma opção:");
                
                if (op == null) { // Caso o usuário clique em Cancelar
                    break;
                }

                opcao = Integer.parseInt(op);

                switch (opcao) {
                    case 1:
                        cadastrarSorvete();
                        break;
                    case 2:
                        removerSorvetePeloNome();
                        break;
                    case 3:
                        qtdTotalSorvetesExistentesPedido();
                        break;
                    case 4:
                        sorvetePossuiMaiorNome();
                        break;
                    case 5:
                        qtdSorvetesDaqueleSaborPedido();
                        break;
                    case 6:
                        adicionarPedido();
                        break;
                    case 7:
                        localizarPedidoPeloID();
                        break;
                    case 8:
                        qtdPedidosRealizadosPeloCliente();
                        break;
                    case 9:
                        pedidoPossuiMaiorQtdSorvetes();
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Saindo do sistema...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida! Digite apenas números inteiros.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }

        } while (opcao != 0);
    }

    // --- OPCÃO 1: Cadastrar Sorvete em um Pedido ---
    private void cadastrarSorvete() {
        int idPedido = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do pedido:"));
        Pedido p = controle.localizarPedidoPeloID(idPedido);

        if (p == null) {
            JOptionPane.showMessageDialog(null, "Pedido não encontrado!");
            return;
        }

        String nome = JOptionPane.showInputDialog("Nome do sorvete (ex: Picolé, Sundae):");
        String sabor = JOptionPane.showInputDialog("Sabor do sorvete:");
        float preco = Float.parseFloat(JOptionPane.showInputDialog("Preço do sorvete (R$):"));

        SorveteVendido sorvete = new SorveteVendido(nome, sabor, preco);
        p.cadastrarSorvete(sorvete);

        JOptionPane.showMessageDialog(null, "Sorvete adicionado ao Pedido #" + idPedido + " com sucesso!");
    }

    // --- OPCÃO 2: Remover Sorvete Pelo Nome ---
    private void removerSorvetePeloNome() {
        int idPedido = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do pedido:"));
        Pedido p = controle.localizarPedidoPeloID(idPedido);

        if (p == null) {
            JOptionPane.showMessageDialog(null, "Pedido não encontrado!");
            return;
        }

        String nome = JOptionPane.showInputDialog("Nome do sorvete a ser removido:");
        boolean removido = p.removerSorvetePeloNome(nome);

        if (removido) {
            JOptionPane.showMessageDialog(null, "Sorvete removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Sorvete não encontrado no pedido.");
        }
    }

    // --- OPCÃO 3: Quantidade Total em um Pedido ---
    private void qtdTotalSorvetesExistentesPedido() {
        int idPedido = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do pedido:"));
        Pedido p = controle.localizarPedidoPeloID(idPedido);

        if (p == null) {
            JOptionPane.showMessageDialog(null, "Pedido não encontrado!");
            return;
        }

        JOptionPane.showMessageDialog(null, "Total de sorvetes no Pedido #" + idPedido + ": " 
                + p.qtdTotalSorvetesExistentesPedido());
    }

    // --- OPCÃO 4: Sorvete com Maior Nome ---
    private void sorvetePossuiMaiorNome() {
        int idPedido = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do pedido:"));
        Pedido p = controle.localizarPedidoPeloID(idPedido);

        if (p == null) {
            JOptionPane.showMessageDialog(null, "Pedido não encontrado!");
            return;
        }

        String maiorNome = p.sorvetePossuiMaiorNome();
        if (maiorNome != null) {
            JOptionPane.showMessageDialog(null, "Sorvete com maior nome: " + maiorNome);
        } else {
            JOptionPane.showMessageDialog(null, "O pedido não possui sorvetes cadastrados.");
        }
    }

    // --- OPCÃO 5: Quantidade de Sorvetes por Sabor ---
    private void qtdSorvetesDaqueleSaborPedido() {
        int idPedido = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do pedido:"));
        Pedido p = controle.localizarPedidoPeloID(idPedido);

        if (p == null) {
            JOptionPane.showMessageDialog(null, "Pedido não encontrado!");
            return;
        }

        String sabor = JOptionPane.showInputDialog("Informe o sabor para pesquisa:");
        int qtd = p.qtdSorvetesDaqueleSaborPedido(sabor);

        JOptionPane.showMessageDialog(null, "Quantidade de sorvetes do sabor '" + sabor + "': " + qtd);
    }

    // --- OPCÃO 6: Adicionar Pedido ---
    private void adicionarPedido() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do novo pedido:"));
        
        if (controle.localizarPedidoPeloID(id) != null) {
            JOptionPane.showMessageDialog(null, "Já existe um pedido com esse ID!");
            return;
        }

        String cliente = JOptionPane.showInputDialog("Nome do cliente:");
        Pedido novoPedido = new Pedido(id, cliente);
        controle.adicionarPedido(novoPedido);

        JOptionPane.showMessageDialog(null, "Pedido #" + id + " cadastrado com sucesso!");
    }

    // --- OPCÃO 7: Localizar Pedido pelo ID ---
    private void localizarPedidoPeloID() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do pedido:"));
        Pedido p = controle.localizarPedidoPeloID(id);

        if (p != null) {
            JOptionPane.showMessageDialog(null, "Pedido encontrado:\nID: " + p.getIdentificador() 
                    + "\nCliente: " + p.getNomeCliente() 
                    + "\nQtd de Sorvetes: " + p.qtdTotalSorvetesExistentesPedido());
        } else {
            JOptionPane.showMessageDialog(null, "Pedido não encontrado!");
        }
    }

    // --- OPCÃO 8: Quantidade de Pedidos por Cliente ---
    private void qtdPedidosRealizadosPeloCliente() {
        String cliente = JOptionPane.showInputDialog("Nome do cliente:");
        int qtd = controle.qtdPedidosRealizadosPeloCliente(cliente);

        JOptionPane.showMessageDialog(null, "O cliente '" + cliente + "' realizou " + qtd + " pedido(s).");
    }

    // --- OPCÃO 9: Pedido com Maior Quantidade de Sorvetes ---
    private void pedidoPossuiMaiorQtdSorvetes() {
        Pedido maiorPedido = controle.pedidoPossuiMaiorQtdSorvetes();

        if (maiorPedido != null) {
            JOptionPane.showMessageDialog(null, "Pedido com maior qtd de sorvetes:\nID: " 
                    + maiorPedido.getIdentificador() 
                    + "\nCliente: " + maiorPedido.getNomeCliente() 
                    + "\nQtd Sorvetes: " + maiorPedido.qtdTotalSorvetesExistentesPedido());
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum pedido cadastrado na sorveteria.");
        }
    }

    public static void main(String[] args) {
        new Sistema();
    }
}
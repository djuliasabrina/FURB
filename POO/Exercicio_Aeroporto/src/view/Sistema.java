import java.util.List;

import javax.swing.JOptionPane;

import controller.Aeroporto;
import model.Aeronave;
import model.Voo;

public class Sistema {

    private Aeroporto aeroporto;

    public Sistema() {
        this.aeroporto = new Aeroporto(1, "Aeroporto Internacional", "Blumenau"); // Instancia o unico aeroporto

        String menu = "--- MENU ---" + "\n1 - Adicionar voo" +
                "\n2 - Buscar voo pelo número" +
                "\n3 - Remover voo" +
                "\n4 - Listar todos os voos" +
                "\n5 - Adicionar aeronave" +
                "\n0 - Sair" + "\n";

        int opcao = 0;
        do {
            String op = JOptionPane.showInputDialog(menu + "Digite a opção escolhida: ");
            opcao = Integer.parseInt(op);

            switch (opcao) {
                case 1:
                    adicionarVoo();
                    break;

                case 2:
                    buscarVoo();
                    break;

                case 3:
                    removerVoo();
                    break;

                case 4:
                    listarTodosVoos();
                    break;

                case 5:
                    cadastrarAeronave();
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida...", "ERRO", JOptionPane.ERROR_MESSAGE);
                    break;
            }

        } while (opcao != 0);
    }

    private void cadastrarAeronave() {
        try {
            String cd = JOptionPane.showInputDialog("Código da aeronave: ");
            int cdAeronave = Integer.parseInt(cd);
            String modelo = JOptionPane.showInputDialog("Modelo: ");
            String cap = JOptionPane.showInputDialog("Capacidade máxima de passageiros: ");
            int capMaxPassageiros = Integer.parseInt(cap);

            Aeronave aeronave = new Aeronave(cdAeronave, modelo, capMaxPassageiros);
            aeroporto.cadastrarAeronave(aeronave);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarTodosVoos() {
        try {
            String msg = aeroporto.listarVoos();

            JOptionPane.showMessageDialog(null, msg);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removerVoo() {
        try {
            String nr = JOptionPane.showInputDialog("Digite o número do voo que deseja excluir: ");
            int numero = Integer.parseInt(nr);

            boolean removido = aeroporto.removerVoo(numero);

            if (removido) {
                JOptionPane.showMessageDialog(null, "Voo removido com sucesso!", "SUCESSO",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao remover voo!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarVoo() {
        try {
            String nr = JOptionPane.showInputDialog("Digite o número do voo que deseja buscar: ");
            int numero = Integer.parseInt(nr);

            String msg = "--- INFORMAÇÕES DO VOO " + numero + " ---\n";
            msg += aeroporto.buscarVooPeloNumero(numero);

            JOptionPane.showMessageDialog(null, msg);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void adicionarVoo() {
        try {
            String nr = JOptionPane.showInputDialog("Digite o número do voo: ");
            int numeroVoo = Integer.parseInt(nr);
            String destino = JOptionPane.showInputDialog("Digite o destino do voo: ");
            String qtd = JOptionPane.showInputDialog("Digite a quantidade de passageiros do voo: ");
            int qtdPassageiros = Integer.parseInt(qtd);
            String hrPrevista = JOptionPane.showInputDialog("Digite a hora prevista: ");

            String dados = aeroporto.listarAeronaves();
            String nrAeronave = JOptionPane.showInputDialog(dados + "Digite o número da aeronave: ");
            int numeroAeronave = Integer.parseInt(nrAeronave);

            List<Aeronave> aeronaves = aeroporto.getAeronaves();
            Aeronave aeronaveEscolhida = null;
            for (Aeronave a : aeronaves) {
                if (a.getCdAeronave() == numeroAeronave) {
                    aeronaveEscolhida = a;
                }
            }

            Voo voo = new Voo(numeroVoo, destino, qtdPassageiros, hrPrevista, aeronaveEscolhida);
            aeroporto.cadastrarVoo(voo);

            JOptionPane.showMessageDialog(null, "Voo cadastrado!!!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void main(String[] args) throws Exception {
        new Sistema();
    }

    // .
}

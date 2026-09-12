package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.Veterinario;
import model.Animal;
import model.Dono;

public class Sistema {

    private Veterinario veterinario;


    public Sistema() {

        veterinario = new Veterinario("Teste"); // para não deixar a lista vazia

        String menu = "--- MENU ---" +
                "\n1 - Cadastrar um novo animal" +
                "\n2 - Buscar animal por nome" +
                "\n3 - Alterar informações" +
                "\n4 - Excluir animal" +
                "\n5 - Listar todos os animais" +
                "\n6 - Calcular média de peso de um animal" +
                "\n7 - Calcular média de peso de todos os animais" +
                "\n8 - Animal que possui a maior média de peso" +
                "\n9 - Quantidade de animais que têm o peso acima da média" +
                "\n10 - Animais que pertencem a um dono" +
                "\n11- Quantidade de animais que pertencem a um dono" +
                "\n12 - Dados para contato do dono do animal" +
                "\n13 - Cadastrar dono" +
                "\n0 - Sair" + "\n";

        int opcao = 0;
        do {
            // Exibindo o menu
            String op = JOptionPane.showInputDialog(menu + "\nDigite a opção escolhida: ");
            opcao = Integer.parseInt(op);

            switch (opcao) {
                case 1:
                    cadastrarNovoAnimal();
                    break;

                case 2:
                    buscarAnimalPorNome();
                    break;

                case 3:
                    alterarInformacoes();
                    break;

                case 4:
                    excluirAnimal();
                    break;

                case 5:
                    listarTodosAnimais();
                    break;

                case 6:
                    calcularMediaPesoUmAnimal();
                    break;

                case 7:
                    calcularMediaPesoTodosAnimal();
                    break;

                case 8:
                    animalMaiorMediaPeso();
                    break;

                case 9:
                    qtdAnimaisPesoAcimaMedia();
                    break;

                case 10:
                    animaisPertencentesDono();
                    break;

                case 11:
                    qtdAnimaisPertencentesDono();
                    break;

                case 12:
                    dadosContatosDonoAnimal();
                    break;

                case 13:
                    cadastrarDonoAnimal();
                    break;

                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida...", "ERRO", JOptionPane.ERROR_MESSAGE);
                    break;
            }

        } while (opcao != 0);

    }

    public void cadastrarDonoAnimal() {
        try {
            String nomeDono = JOptionPane.showInputDialog("Nome do dono: ");
            String telefone = JOptionPane.showInputDialog("Telefone para contato: ");

            Dono dono = new Dono(nomeDono, telefone);
            veterinario.cadastrarDonoAnimal(dono);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void dadosContatosDonoAnimal() {
        try {
            String nomeAnimal = JOptionPane.showInputDialog("Digite o nome do animal: ");

            String dados = veterinario.dadosContatosDonoAnimal(nomeAnimal);

            JOptionPane.showMessageDialog(null, "--- EXIBINDO DADOS DO DONO DO ANIMAL ---" + dados);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void qtdAnimaisPertencentesDono() {
        try {
            String nomeDono = JOptionPane.showInputDialog("Digite o nome do dono: ");

            int qtd = veterinario.qtdAnimaisPertenceDono(nomeDono);

            JOptionPane.showMessageDialog(null, "Quantidade de animais que pertencentes ao dono: " + qtd);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void animaisPertencentesDono() {
        try {
            String nomeDono = JOptionPane.showInputDialog("Digite o nome do dono: ");
            String dados = veterinario.animaisPertencentesDono(nomeDono);

            JOptionPane.showMessageDialog(null, dados);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void qtdAnimaisPesoAcimaMedia() {

        try {
            float media = veterinario.calcularMediaPesoTodos();

            int qtd = veterinario.qtdAnimaisPesoAcimaMedia(media);

            JOptionPane.showMessageDialog(null,
                    "A quantidade de animais acima da média (" + media + ") " + "é: " + qtd);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void animalMaiorMediaPeso() {

        try {
            Animal animal = veterinario.animalMaiorMediaPeso();
            String msg = "\nNome: " + animal.getNome() +
                    "\nEspécie: " + animal.getEspecie() +
                    "\nDono: " + animal.getDono().getNome() +
                    "\nMédia dos pesos: " + animal.calcularMedia();

            JOptionPane.showMessageDialog(null, "A maior média de peso é do animal: " + msg);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calcularMediaPesoTodosAnimal() {

        try {
            float mediaTodos = veterinario.calcularMediaPesoTodos();

            JOptionPane.showMessageDialog(null,
                    "A média do peso de todos os animais é: " + String.format("%.2f", mediaTodos));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void calcularMediaPesoUmAnimal() {

        try {
            String dados = veterinario.listarAnimais();
            String nome = JOptionPane
                    .showInputDialog(dados + "\nDigite o nome do animal que deseja calcular a média: ");

            Animal animal = veterinario.buscar(nome);
            float media = animal.calcularMedia();

            JOptionPane.showMessageDialog(null, "A média do peso do animal é: " + String.format("%.2f", media));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void listarTodosAnimais() {
        try {
            JOptionPane.showMessageDialog(null, veterinario.listarAnimais());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void excluirAnimal() {
        try {
            String dados = veterinario.listarAnimais();
            String nome = JOptionPane.showInputDialog(dados + "\nDigite o nome do animal que deseja excluir: ");
            boolean sucesso = veterinario.excluirAnimal(nome);

            if (sucesso == true) {
                JOptionPane.showMessageDialog(null, "Animal excluido com sucesso!", "SUCESSO",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void alterarInformacoes() {
        try {
            String nomeAntigo = JOptionPane.showInputDialog("Digite o nome antigo do animal: ");

            String nomeAnimal = JOptionPane.showInputDialog("Nome do animal: ");
            String especie = JOptionPane.showInputDialog("Espécie do animal: ");

            // Exibindo donos cadastrados
            List<Dono> donos = veterinario.getDonos();
            String dados = "--- EXIBINDO DONOS CADASTRADOS ---";
            for (Dono dono : donos) {
                dados += "\nNome: " + dono.getNome() + "\nTelefone: " + dono.getTelefone() + "\n";
            }
            String dono = JOptionPane.showInputDialog(dados + "\nDigite o nome do dono do animal: ");
            Dono donoEscolhido = null;

            for (Dono nomeDono : donos) {
                if (nomeDono.getNome().equalsIgnoreCase(dono)) {
                    donoEscolhido = nomeDono;
                    break;
                }
            }

            String p1 = JOptionPane.showInputDialog("Informe o peso 1 do animal: ");
            float peso1 = Float.parseFloat(p1);

            String p2 = JOptionPane.showInputDialog("Informe o peso 2 do animal: ");
            float peso2 = Float.parseFloat(p2);

            String p3 = JOptionPane.showInputDialog("Informe o peso 3 do animal: ");
            float peso3 = Float.parseFloat(p3);

            Animal animal = new Animal(nomeAnimal, especie, donoEscolhido, peso1, peso2, peso3);

            boolean sucesso = veterinario.alterarInformacoes(nomeAntigo, animal);

            if (sucesso == true) {
                JOptionPane.showMessageDialog(null, "Informações alteradas com sucesso!", "SUCESSO",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao alterar as informações!", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void buscarAnimalPorNome() {
        try {
            String nome = JOptionPane.showInputDialog("Informe o nome do animal: ");

            String animal = veterinario.buscarPorNome(nome);

            JOptionPane.showMessageDialog(null, "Informações do animal: " + animal);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void cadastrarNovoAnimal() {
        try {
            String nomeAnimal = JOptionPane.showInputDialog("Nome do animal: ");
            String especie = JOptionPane.showInputDialog("Espécie do animal: ");

            // Exibindo donos cadastrados
            List<Dono> donos = veterinario.getDonos();
            String dados = "--- EXIBINDO DONOS CADASTRADOS ---";
            for (Dono dono : donos) {
                dados += "\nNome: " + dono.getNome() + "\nTelefone: " + dono.getTelefone() + "\n";
            }
            String dono = JOptionPane.showInputDialog(dados + "\nDigite o nome do dono do animal: ");
            Dono donoEscolhido = null;

            for (Dono nomeDono : donos) {
                if (nomeDono.getNome().equalsIgnoreCase(dono)) {
                    donoEscolhido = nomeDono;
                    break;
                }
            }

            String p1 = JOptionPane.showInputDialog("Informe o peso 1 do animal: ");
            float peso1 = Float.parseFloat(p1);

            String p2 = JOptionPane.showInputDialog("Informe o peso 2 do animal: ");
            float peso2 = Float.parseFloat(p2);

            String p3 = JOptionPane.showInputDialog("Informe o peso 3 do animal: ");
            float peso3 = Float.parseFloat(p3);

            Animal animal = new Animal(nomeAnimal, especie, donoEscolhido, peso1, peso2, peso3);
            veterinario.cadastrarAnimal(animal);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) throws Exception {
        new Sistema();
    }
}
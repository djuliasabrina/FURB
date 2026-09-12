package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.Veterinario;
import model.Animal;
import model.Dono;

public class Sistema {

    private Veterinario veterinario;
    private List<Dono> donos;
    private List<Animal> animais;

    public Sistema() {
        
        veterinario = new Veterinario("Teste"); // para não deixar a lista vazia
        donos = new ArrayList<Dono>();
        animais = new ArrayList<Animal>();

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
                "\n13 - Cadastrar dono" + "\n";

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

        // TODO Auto-generated method stub

        throw new UnsupportedOperationException("Unimplemented method 'dadosContatosDonoAnimal'");

    }

    private void qtdAnimaisPertencentesDono() {

        // TODO Auto-generated method stub

        throw new UnsupportedOperationException("Unimplemented method 'qtdAnimaisPertencentesDono'");

    }

    private void animaisPertencentesDono() {

        // TODO Auto-generated method stub

        throw new UnsupportedOperationException("Unimplemented method 'animaisPertencentesDono'");

    }

    private void qtdAnimaisPesoAcimaMedia() {

        float media = veterinario.calcularMediaPesoTodos();

        int qtd = veterinario.qtdAnimaisPesoAcimaMedia(media);

        JOptionPane.showMessageDialog(null, "A quantidade de animais acima da média (" + media + ") " + "é: " + qtd);

    }

    private void animalMaiorMediaPeso() {

        Animal animal = veterinario.animalMaiorMediaPeso();
        String msg = "\nNome: " + animal.getNome() + 
        "\nEspécie: " + animal.getEspecie() +
        "\nDono: " + animal.getDono().getNome() + 
        "\nMédia dos pesos: " + animal.calcularMedia();

        JOptionPane.showMessageDialog(null, "A maior média de peso é do animal: " + msg);

    }

    private void calcularMediaPesoTodosAnimal() {

        float mediaTodos = veterinario.calcularMediaPesoTodos();

        JOptionPane.showMessageDialog(null, "A média do peso de todos os animais é: " + String.format("%.2f", mediaTodos));

    }

    private void calcularMediaPesoUmAnimal() {
       
        String dados = veterinario.listarAnimais();
        String nome = JOptionPane.showInputDialog(dados + "\nDigite o nome do animal que deseja calcular a média: ");

        Animal animal = veterinario.buscarPorNome(nome);
         float media = animal.calcularMedia();


        JOptionPane.showMessageDialog(null, "A média do peso do animal é: " + String.format("%.2f", media));

    }

    private void listarTodosAnimais() {
        JOptionPane.showMessageDialog(null, veterinario.listarAnimais());
    }

    private void excluirAnimal() {
        String dados = veterinario.listarAnimais();
        String nome = JOptionPane.showInputDialog(dados + "\nDigite o nome do animal que deseja excluir: ");
        veterinario.excluirAnimal(nome);

        if (veterinario.excluirAnimal(nome) == true) {
            JOptionPane.showMessageDialog(null, "Animal excluido com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao excluir!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void alterarInformacoes() {

        // TODO Auto-generated method stub

        throw new UnsupportedOperationException("Unimplemented method 'alterarInformacoes'");

    }

    private void buscarAnimalPorNome() {

        // TODO Auto-generated method stub

        throw new UnsupportedOperationException("Unimplemented method 'buscarAnimalPorNome'");

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

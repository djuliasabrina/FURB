package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.Turma;
import model.Aluno;

public class Principal {

    private List<Turma> turmas;
    private List<Aluno> alunos;

    public Principal() {
        turmas = new ArrayList<Turma>();
        alunos = new ArrayList<Aluno>();

        String menu = "--- MENU ---\n" +
                "\n1 - Cadastrar Aluno" +
                "\n2 - Buscar aluno pelo nome" +
                "\n3 - Alterar informações" +
                "\n4 - Excluir aluno" +
                "\n5 - Listar todos os alunos" +
                "\n6 - Calcular média da turma" +
                "\n7 - Aluno com maior média" +
                "\n8 - Quantidade de alunos acima da média" +
                "\n9 - Calcular média de um aluno" +
                "\n0 - Sair";

        int op = 0;

        do {
            String opcao = JOptionPane.showInputDialog(menu);
            op = Integer.parseInt(opcao);

            switch (op) {
                case 1:

                    try {
                        cadastrarAluno();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    }

                    break;

                case 2:

                    try {
                        buscarAlunoNome();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 3:

                    try {
                        alterarInformacoes();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 4:

                    try {
                        excluirAluno();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 5:

                    try {
                        listarTodosAlunos();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 6:

                    try {
                        calcularMediaTurma();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 7:

                    try {
                        alunoMaiorNota();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 8:

                    try {
                        qtdAlunosAcimaMedia();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 9:

                    try {
                        calcularMediaTurma();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 0:
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida...", "ERRO", JOptionPane.ERROR_MESSAGE);
                    break;
            }

        } while (op != 0);
    }

    private void qtdAlunosAcimaMedia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'qtdAlunosAcimaMedia'");
    }

    private void alunoMaiorNota() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alunoMaiorNota'");
    }

    private void calcularMediaTurma() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularMediaTurma'");
    }

    private void listarTodosAlunos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodosAlunos'");
    }

    private void excluirAluno() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluirAluno'");
    }

    private void alterarInformacoes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterarInformacoes'");
    }

    private void buscarAlunoNome() {

        String nomeEscolhido = JOptionPane.showInputDialog("Digite o nome do aluno que deseja buscar: ");

        // Turma aluno = new Turma(nomeEscolhido, alunos);
        // aluno.buscarAluno(nomeEscolhido);

        // System.out.println("TESTE: " + aluno);

        // Aluno a = buscarAlunoNome(nomeEscolhido);
    }

    private void cadastrarAluno() {
        String nome = JOptionPane.showInputDialog("Nome do aluno: ");
        String n1 = JOptionPane.showInputDialog("Nota 1: ");
        float nota1 = Integer.parseInt(n1);
        String n2 = JOptionPane.showInputDialog("Nota 2: ");
        float nota2 = Integer.parseInt(n2);
        String n3 = JOptionPane.showInputDialog("Nota 3: ");
        float nota3 = Integer.parseInt(n3);

        Aluno aluno = new Aluno(nome, nota1, nota2, nota3);

        alunos.add(aluno);

        JOptionPane.showMessageDialog(null, "Aluno cadastrado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new Principal();
    }

}

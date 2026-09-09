// package view;
// import java.util.ArrayList;
// import java.util.List;

// import javax.swing.JOptionPane;

// import controller.Turma;
// import model.Aluno;

// public class Sistema {

//     private List<Turma> turmas;
//     private List<Aluno> alunos;

//     public Sistema() {
//         turmas = new ArrayList<Turma>();
//         alunos = new ArrayList<Aluno>();

//         String menu = "--- MENU ---\n";
//         menu += "\n1 - Cadastrar Aluno \n2 - Buscar aluno pelo nome" +
//                 "\n3 - Alterar informações \n4 - Excluir aluno " +
//                 "\n5 - Listar todos os alunos \n6 - Calcular media da turma" +
//                 "\n7 - Aluno com maior nota \n8 - Quantidade de alunos acima da média" +
//                 "\n9 - Calcular média de um aluno";

//         int op = 0;

//         do {
//             String opcao = JOptionPane.showInputDialog(menu);
//             op = Integer.parseInt(opcao);

//             switch (op) {
//                 case 1:
//                     cadastrarAluno();
//                     break;

//                 case 2:
//                     buscarAlunoNome();
//                     break;

//                 case 3:
//                     alterarInformacoes();
//                     break;

//                 case 4:
//                     excluirAluno();
//                     break;

//                 case 5:
//                     listarTodosAlunos();
//                     break;

//                 case 6:
//                     calcularMediaTurma();
//                     break;

//                 case 7:
//                     alunoMaiorNota();
//                     break;

//                 case 8:
//                     qtdAlunosAcimaMedia();
//                     break;

//                 case 9:
//                     calcularMediaAluno();
//                     break;

//                 case 0:
//                     break;

//                 default:
//                     JOptionPane.showMessageDialog(null, "Opção inválida...", "ERRO", JOptionPane.ERROR_MESSAGE);
//                     break;
//             }

//         } while (op != 0);
//     }

//     // Métodos
//     public void cadastrarAluno() {
//         String nome = JOptionPane.showInputDialog("Nome do aluno: ");
//         String n1 = JOptionPane.showInputDialog("Nota 1: ");
//         float nota1 = Integer.parseInt(n1);
//         String n2 = JOptionPane.showInputDialog("Nota 2: ");
//         float nota2 = Integer.parseInt(n2);
//         String n3 = JOptionPane.showInputDialog("Nota 3: ");
//         float nota3 = Integer.parseInt(n3);

//         Aluno aluno = new Aluno(nome, nota1, nota2, nota3);

//         alunos.add(aluno);

//         JOptionPane.showMessageDialog(null, "Aluno cadastrado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

//     }

//     private void buscarAlunoNome() {
//         String nomeProcurado = JOptionPane.showInputDialog("Digite o nome do aluno que deseja buscar: ");
//         String dadosBusca = "---- INFORMAÇÕES ----";

//         for (Aluno aluno : alunos) {
//             if (aluno.getNomeAluno().equals(nomeProcurado)) {
//                 // dadosBusca += "\nNome: " + nomeProcurado + "\nNota 1: " + aluno.getNota1()
//                 //         + "\nNota 2: " + aluno.getNota2() + "\nNota 3: " + aluno.getNota3() + "\nMédia: " + aluno.calcularMedia() + "\n";

//                 dadosBusca += aluno.imprimir();
//                 break;
//             }
//         }

//         JOptionPane.showMessageDialog(null, dadosBusca);
//     }

//     private void alterarInformacoes() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'alterarInformacoes'");
//     }

//     private void excluirAluno() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'excluirAluno'");
//     }

//     private void listarTodosAlunos() {
//         String dadosLista = "--- LISTANDO ALUNOS ---";
//         int a = 0;

//         for (Aluno aluno : alunos) {
//             dadosLista += "\nAluno " + (a + 1) + "\nNome: " + aluno.getNomeAluno() + "\nNota 1: " + aluno.getNota1()
//                     + "\nNota 2: " + aluno.getNota2() + "\nNota 3: " + aluno.getNota3() + "\n";
//             a++;
//         }

//         JOptionPane.showMessageDialog(null, dadosLista);
//     }

//     private void calcularMediaTurma() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'calcularMediaTurma'");
//     }

//     private void alunoMaiorNota() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'alunoMaiorNota'");
//     }

//     private void qtdAlunosAcimaMedia() {
//         int qtd = 0;

//         for (Aluno aluno : alunos) {
//             if (aluno.calcularMedia() >= 7) {
//                 qtd++;
//             }
//         }

//         JOptionPane.showMessageDialog(null, "Quantidade de alunos acima da média: " + qtd);
//     }

//     private void calcularMediaAluno() {
//         String dadosMedia = "--- ALUNOS CADASTRADOS ---";

//         for (Aluno aluno : alunos) {
//             dadosMedia += "\nNome: " + aluno.getNomeAluno() + "\nNota 1: " + aluno.getNota1()
//                     + "\nNota 2: " + aluno.getNota2() + "\nNota 3: " + aluno.getNota3() + "\n";
//         }

//         String nomeEscolhido = JOptionPane.showInputDialog(null, dadosMedia + "Digite o nome do aluno escolhido: ");

//         String mediaCalculada = "";
//         for (Aluno aluno : alunos) {
//             if (nomeEscolhido.equals(aluno.getNomeAluno())) {
//                 mediaCalculada += "Nome: " + nomeEscolhido + "\nMédia: " + aluno.calcularMedia();
//             }
//         }

//         JOptionPane.showMessageDialog(null, mediaCalculada);

//     }

//     public static void main(String[] args) {
//         new Sistema();
//     }
// }

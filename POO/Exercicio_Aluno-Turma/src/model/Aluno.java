package model;

public class Aluno {

    private String nomeAluno;
    private float nota1;
    private float nota2;
    private float nota3;

    // Construtor
    public Aluno(String nomeAluno, float nota1, float nota2, float nota3) throws IllegalArgumentException {
        setNomeAluno(nomeAluno);
        setNota1(nota1);
        setNota2(nota2);
        setNota3(nota3);
    }

    // Getters
    public String getNomeAluno() {
        return nomeAluno;
    }

    public float getNota1() {
        return nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public float getNota3() {
        return nota3;
    }

    // Setters
    public void setNomeAluno(String nomeAluno) throws IllegalArgumentException {
        // if (nomeAluno != null && !nomeAluno.isBlank() && nomeAluno.length() >= 3) {
        // this.nomeAluno = nomeAluno;
        // } else {
        // JOptionPane.showMessageDialog(null, "Nome do aluno deve ser preenchido (>=
        // 3)!", "ERRO",
        // JOptionPane.ERROR_MESSAGE);
        // }

        if (nomeAluno == null || nomeAluno.isBlank()) {
            throw new IllegalArgumentException("Nome inválido...");
        }

        this.nomeAluno = nomeAluno;

    }

    public void setNota1(float nota1) throws IllegalArgumentException {
        // if (nota1 >= 0 || nota1 <= 10) {
        // this.nota1 = nota1;
        // } else {
        // JOptionPane.showMessageDialog(null, "Nota deverá estar entre (0 á 10)!",
        // "ERRO", JOptionPane.ERROR_MESSAGE);
        // }

        if (nota1 < 0 || nota1 > 10) {
            throw new IllegalArgumentException("Nota deverá estar entre (0 á 10)!");
        }

        this.nota1 = nota1;

    }

    public void setNota2(float nota2) throws IllegalArgumentException {
        // if (nota2 >= 0 || nota2 <= 10) {
        // this.nota2 = nota2;
        // } else {
        // JOptionPane.showMessageDialog(null, "Nota deverá estar entre (0 á 10)!",
        // "ERRO", JOptionPane.ERROR_MESSAGE);
        // }

        if (nota2 < 0 || nota2 > 10) {
            throw new IllegalArgumentException("Nota deverá estar entre (0 á 10)!");
        }

        this.nota2 = nota2;
    }

    public void setNota3(float nota3) throws IllegalArgumentException {
        // if (nota3 >= 0 || nota3 <= 10) {
        // this.nota3 = nota3;
        // } else {
        // JOptionPane.showMessageDialog(null, "Nota deverá estar entre (0 á 10)!",
        // "ERRO", JOptionPane.ERROR_MESSAGE);
        // }

        if (nota3 < 0 || nota3 > 10) {
            throw new IllegalArgumentException("Nota deverá estar entre (0 á 10)!");
        }

        this.nota3 = nota3;
    }

    // Método
    public float calcularMedia() {
        float media = (nota1 + nota2 + nota3) / 3;
        return media;
    }

    public String imprimir() {
        return "Notas: " + "Nota 1: " + nota1 + "\nNota 2: " + nota2 + "\nNota 3: " + nota3;
    }

}

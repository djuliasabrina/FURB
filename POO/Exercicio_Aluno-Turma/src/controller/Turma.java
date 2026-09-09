package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Aluno;

public class Turma {

    private String nomeTurma;
    private List<Aluno> alunos;

    // Construtor
    public Turma(String nomeTurma, List<Aluno> alunos) {
        // Instanciar a lista
        alunos = new ArrayList<Aluno>();

        setNomeTurma(nomeTurma);
        setAlunos(alunos);
    }

    // Getters
    public String getNomeTurma() {
        return nomeTurma;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    // Setters
    public void setNomeTurma(String nomeTurma) throws IllegalArgumentException {

        if (nomeTurma == null || nomeTurma.isBlank()) {
            throw new IllegalArgumentException("Nome inválido...");
        }

        this.nomeTurma = nomeTurma;

    }

    public void setAlunos(List<Aluno> alunos) throws IllegalArgumentException {
        // if (alunos != null) {
        //     this.alunos = alunos;
        // } else {
        //     JOptionPane.showMessageDialog(null, "Lista de alunos vazia...", "ERRO", JOptionPane.ERROR_MESSAGE);
        // }

        if (alunos == null) {
            throw new IllegalArgumentException("Lista de alunos vazia...");
        }

        this.alunos = alunos;

    }

    // Adicional da prof
    public void addAluno(Aluno aluno) {
        if (aluno != null) {
            this.alunos.add(aluno);
        } else {
            JOptionPane.showMessageDialog(null, "Aluno deve ser informado...", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Aluno buscarAluno(String nome) {
        if (nome != null) {
            for (Aluno a : alunos) {
                if (a.getNomeAluno().equalsIgnoreCase(nome)) {
                    return a;
                }
            }
        }

        return null;
    }

    // Métodos pedidos no enunciado

}

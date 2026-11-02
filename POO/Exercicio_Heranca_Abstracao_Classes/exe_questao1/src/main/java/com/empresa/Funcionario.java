package com.empresa;

public abstract class Funcionario {

    private String nome;
    private String matricula;

    public Funcionario(String nome, String matricula){
        setNome(nome);
        setMatricula(matricula);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException{
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome deve ser preenchido.");
        }
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) throws IllegalArgumentException{
        if (matricula == null || matricula.isBlank()) {
            throw new IllegalArgumentException("Matrícula deve ser preenchida.");
        }
        this.matricula = matricula;
    }

    public abstract double calcularSalario();

    public String exibirDados(){
        String dados = "";

        dados += "Nome: " + getNome() + "\nMatrícula: " + getMatricula();

        return dados;
    }

}

package model;

public class Dono {

    private String nome;
    private String telefone;

    // Construtor
    public Dono(String nome, String telefone) throws IllegalArgumentException{
        setNome(nome);
        setTelefone(telefone);
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    // Setters
    public void setNome(String nome) throws IllegalArgumentException {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome dever ser preenchido...");
        }
        this.nome = nome;
    }

    public void setTelefone(String telefone) throws IllegalArgumentException {
        if (telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException("Telefone dever ser preenchido...");
        }

        this.telefone = telefone;
    }

}

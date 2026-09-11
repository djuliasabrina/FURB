package model;

public class Animal {

    private String nome;
    private String especie;
    private Dono dono;
    private float peso1;
    private float peso2;
    private float peso3;

    // Construtor
    public Animal(String nome, String especie, Dono dono, float peso1, float peso2, float peso3) throws IllegalArgumentException{
        setNome(nome);
        setEspecie(especie);
        setDono(dono);
        setPeso1(peso1);
        setPeso2(peso2);
        setPeso3(peso3);
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public Dono getDono() {
        return dono;
    }

    public float getPeso1() {
        return peso1;
    }

    public float getPeso2() {
        return peso2;
    }

    public float getPeso3() {
        return peso3;
    }

    // Setters
    public void setNome(String nome) throws IllegalArgumentException{
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome deve ser preenchido...");
        }else if (nome.length() < 3) {
            throw new IllegalArgumentException("Nome deve ter mais de 3 caracteres...");
        }

        this.nome = nome;
    }

    public void setEspecie(String especie) throws IllegalArgumentException{
        if (especie == null || especie.isBlank()) {
            throw new IllegalArgumentException("Espécie deve ser preenchido...");
        }

        this.especie = especie;
    }

    public void setDono(Dono dono) throws IllegalArgumentException{
        if (dono == null) {
            throw new IllegalArgumentException("Dono deve ser cadastrado...");
        }

        this.dono = dono;
    }

    public void setPeso1(float peso1) throws IllegalArgumentException{
        if (peso1 < 0) {
            throw new IllegalArgumentException("Peso 1 deve ser maior que 0!");
        }

        this.peso1 = peso1;
    }

        public void setPeso2(float peso2) throws IllegalArgumentException{
        if (peso2 < 0) {
            throw new IllegalArgumentException("Peso 2 deve ser maior que 0!");
        }

        this.peso2 = peso2;
    }

        public void setPeso3(float peso3) throws IllegalArgumentException{
        if (peso3 < 0) {
            throw new IllegalArgumentException("Peso 3 deve ser maior que 0!");
        }

        this.peso3 = peso3;
    }

    // Método
    public float calcularMedia(){
        float media = (peso1 + peso2 + peso3) / 3;
        
        return media;
    }
}

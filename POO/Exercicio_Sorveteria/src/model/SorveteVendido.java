package model;

public class SorveteVendido {
    
    private String nome;
    private String sabor;
    private float preco;

    // Construtor
    public SorveteVendido(String nome, String sabor, float preco){
        setNome(nome);
        setSabor(sabor);
        setPreco(preco);
    }

    // Getters
    public String getNome(){
        return nome;
    }

    public String getSabor(){
        return sabor;
    }

    public float getPreco(){
        return preco;
    }

    // Setters
    public void setNome(String nome) throws IllegalArgumentException{
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome deve ser preenchido!");
        }

        this.nome = nome;
    }

    public void setSabor(String sabor) throws IllegalArgumentException{
        if (sabor == null || sabor.isBlank()) {
            throw new IllegalArgumentException("Sabor deve ser preenchido!");
        }

        this.sabor = sabor;
    }

    public void setPreco(float preco) throws IllegalArgumentException{

        if (preco < 0){
            throw new IllegalArgumentException("`Preço deve ser informado!");
        }

        this.preco = preco;
    }


}

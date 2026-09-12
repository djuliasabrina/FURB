package controller;

import java.util.ArrayList;
import java.util.List;

import model.Animal;
import model.Dono;

public class Veterinario {

    private String nome;
    private List<Animal> animais;
    private List<Dono> donos;

    // Construtor
    public Veterinario(String nome) throws IllegalArgumentException {
        setNome(nome);
        animais = new ArrayList<Animal>();
        donos = new ArrayList<Dono>();
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public List<Dono> getDonos() {
        return donos;
    }

    // Setters
    public void setNome(String nome) throws IllegalArgumentException {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome deve ser preenchido...");
        } else if (nome.length() < 3) {
            throw new IllegalArgumentException("Nome deve ter mais de 3 caracteres...");
        }

        this.nome = nome;
    }

    public void setAnimais(List<Animal> animais) throws IllegalArgumentException {
        if (animais == null) {
            throw new IllegalArgumentException("Animal deve ser cadastrado primeiro!!!");
        }

        this.animais = animais;
    }

    // Métodos
    public void cadastrarAnimal(Animal animal) {
        if (animal != null) {
            animais.add(animal); // Adiciona na lista
        } else {
            throw new IllegalArgumentException("Animal dever ser informado!");
        }
    }

    public Animal buscarPorNome(String nome) {
        if (animais != null) {
            for (Animal animal : animais) {
                if (animal.getNome().equalsIgnoreCase(nome)) {
                    return animal;
                }
            }
        }

        return null;
    }

    public boolean alterarInformacoes(String nomeAntigo, Animal novoAnimal) {
        if (animais != null) {
            for (int i = 0; i < animais.size(); i++) {
                if (animais.get(i).getNome().equalsIgnoreCase(nomeAntigo)) {
                    animais.set(i, novoAnimal);
                    return true;
                }
            }
        }

        return false;
    }

    public boolean excluirAnimal(String nome) {
        Animal animal = buscarPorNome(nome);

        if (animais != null) {
            animais.remove(animal);
            return true;
        }

        return false;
    }

    public String listarAnimais() {

        String dados = "--- LISTANDO ---";
        for(Animal animal: animais){
            dados += "\nNome: " + animal.getNome() + "\nEspécie: " + animal.getEspecie() + "\nDono: " + animal.getDono().getNome() + "\nPeso 1: " + animal.getPeso1() +
             "\nPeso 2: " + animal.getPeso2() + "\nPeso 3: " + animal.getPeso3() + "\n";
        }

        return dados;
    }

    public float calcularMediaPesoTodos() {
        float mediaPesoTodos = 0;

        for (Animal animal : animais) {
            mediaPesoTodos += animal.calcularMedia(); // Soma todas as médias
        }

        mediaPesoTodos = mediaPesoTodos / animais.size(); // Pega todas as médias e divide pela quantidade de animais

        return mediaPesoTodos; // Retorna essa média de todos
    }

    public Animal animalMaiorMediaPeso() {
        Animal maiorMedia = animais.get(0);

        for (int i = 1; i < animais.size(); i++) {
            if (animais.get(i).calcularMedia() > maiorMedia.calcularMedia()) {
                maiorMedia = animais.get(i);
            }
        }

        return maiorMedia;
    }

    public int qtdAnimaisPesoAcimaMedia(float valorMedia) {
        int qtd = 0;

        for (Animal animal : animais) {
            if (animal.calcularMedia() > valorMedia) {
                qtd++;
            }
        }

        return qtd;
    }

    public List<Animal> animaisPertencentesDono(String nomeDono) {
        List<Animal> animaisPertecence = new ArrayList<>(); // Cria uma lista de animais que pertencem aquele dono

        for (Animal animal : animais) {
            if (animal.getDono().getNome() == nomeDono) { // Verifica se o animal possui o mesmo nome do dono procurado
                animaisPertecence.add(animal); // Se achar adiciona na lista nova (animaisPertence)
            }
        }

        return animaisPertecence; // Retorna a lista animaisPertence
    }

    public int qtdAnimaisPertenceDono(String nome) {
        int qtd = 0;

        for (Animal animal : animais) {
            if (animal.getDono().getNome() == nome) {
                qtd++;
            }
        }

        return qtd;
    }

    public String dadosContatosDonoAnimal(String nome) {

        for (Animal animal : animais) {
            if (animal.getNome() == nome) {
                return "\nNome do dono: " + animal.getDono().getNome() + "\nTelefone: "
                        + animal.getDono().getTelefone();
            }
        }

        return null;
    }

    public void cadastrarDonoAnimal(Dono dono) throws IllegalArgumentException {
        if (dono != null) {
            donos.add(dono);
        } else {
            throw new IllegalArgumentException("Dono deve ser informado!");
        }
    }

}

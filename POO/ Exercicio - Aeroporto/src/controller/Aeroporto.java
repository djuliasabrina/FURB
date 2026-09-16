package controller;

import java.util.ArrayList;
import java.util.List;

import model.Aeronave;
import model.Voo;

public class Aeroporto {

    private int cdAeroporto;
    private String nome;
    private String cidade;
    private List<Voo> voos;
    private List<Aeronave> aeronaves;
    private Aeronave aeronave;

    // Construtor
    public Aeroporto(int cdAeroporto, String nome, String cidade) {
        setCdAeroporto(cdAeroporto);
        setNome(nome);
        setCidade(cidade);
        
        voos = new ArrayList<Voo>();
        aeronaves = new ArrayList<Aeronave>();
        aeronave = new Aeronave(123, "Timbó", 41);
    }

    // Getters
    public int getCdAeroporto() {
        return cdAeroporto;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public List<Voo> getVoos() {
        return voos;
    }

    public List<Aeronave> getAeronaves(){
        return aeronaves;
    }

    // Setters
    public void setCdAeroporto(int cdAeroporto) throws IllegalArgumentException {
        if (cdAeroporto > 0) {
            this.cdAeroporto = cdAeroporto;
        } else {
            throw new IllegalArgumentException("Código do aeroporto deve ser maior que 0!");
        }
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if (nome != null && !nome.isBlank()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome deve ser infomado...");
        }
    }

    public void setCidade(String cidade) throws IllegalArgumentException {
        if (cidade != null && !cidade.isBlank()) {
            this.cidade = cidade;
        } else {
            throw new IllegalArgumentException("Cidade deve ser infomado...");
        }
    }

    public void setVoos(List<Voo> voos) throws IllegalArgumentException {
        if (voos != null) {
            this.voos = voos;
        } else {
            throw new IllegalArgumentException("Voo deve ser cadastrado primeiro!");
        }
    }

    // Métodos
    public void cadastrarVoo(Voo voo) throws IllegalArgumentException {
        if (voo == null) {
            throw new IllegalArgumentException("Voo deve ser informado...");
        }

        for (Voo v : voos) {
            if (v.getNumeroVoo() == voo.getNumeroVoo()) {
                throw new IllegalArgumentException("Já existem um voo com esse número!");
            }
        }

        voos.add(voo);

    }

    public String buscarVooPeloNumero(int numero) throws IllegalArgumentException {
        if (voos == null) {
            throw new IllegalArgumentException("Nenhum voo com cadastrado...");
        }

        for (Voo voo : voos) {
            if (voo.getNumeroVoo() == numero) {
                return voo.imprimir();
            } else {
                throw new IllegalArgumentException("Nenhum voo com esse número...");
            }
        }

        return null;
    }

    public boolean removerVoo(int numero) throws IllegalArgumentException {
        if (voos == null) {
            throw new IllegalArgumentException("Nenhum voo com cadastrado...");
        }

        boolean removido = false;

        for (Voo voo : voos) {
            if (voo.getNumeroVoo() == numero) {
                voos.remove(voo);
                removido = true;
                return true;
            }
        }

        if (!removido) {
            throw new IllegalArgumentException("Nenhum voo com esse número...");
        }

        return false;
    }

    public String listarVoos() throws IllegalArgumentException{
        if (voos == null) {
            throw new IllegalArgumentException("Nenhum voo com cadastrado...");
        }

        String dados = "--- LISTANDO VOOS ---";

        for (int i = 0; i < voos.size(); i++) {
            dados += voos.get(i).imprimir();
        }

        return dados;
    }

    public String listarAeronaves() throws IllegalArgumentException{
        if (aeronaves == null) {
            throw new IllegalArgumentException("Nenhuma aeronave cadastrada...");
        }

        String dados = "-- LISTANDO AERONAVES ---";

        for(Aeronave aeronave: aeronaves){
            dados += aeronave.imprimir();
        }

        return dados;
    }

    
}

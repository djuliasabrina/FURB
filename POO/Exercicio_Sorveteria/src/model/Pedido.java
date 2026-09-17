package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int identificador;
    private String nomeCliente;
    private List<SorveteVendido> sorvetes;

    public Pedido(){
        setIdentificador(identificador);
        setNomeCliente(nomeCliente);

        sorvetes = new ArrayList<SorveteVendido>();
    }

    // Getters
    public int getIdentificador() {
        return identificador;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public List<SorveteVendido> getSorvetes() {
        return sorvetes;
    }

    // Setters
    public void setIdentificador(int identificador) throws IllegalArgumentException {
        if (identificador < 0) {
            throw new IllegalArgumentException("Identificador não pode ser negativo!");
        }

        this.identificador = identificador;
    }

    public void setNomeCliente(String nomeCliente) throws IllegalArgumentException{
        if (nomeCliente == null || nomeCliente.isBlank()) {
            throw new IllegalArgumentException("Nome do cliente deve ser preenchido!");
        }

        this.nomeCliente = nomeCliente;
    }

    // Métodos
    public void cadastrarSorvete(SorveteVendido sorvete) throws IllegalArgumentException{
        if (sorvete == null) {
            throw new IllegalArgumentException("Sorteve deve ser preenchido.");
        }

        sorvetes.add(sorvete);
    }

    public boolean removerSorvetePeloNome(String nome){

        if (sorvetes == null) {
            throw new IllegalArgumentException("Nenhum sorvete cadastrado!");
        }

        for(SorveteVendido sorvete: sorvetes){
            if (sorvete.getNome().equalsIgnoreCase(nome)) {
                sorvetes.remove(sorvete);
                return true;
            }
        }
        return false;
    }


}

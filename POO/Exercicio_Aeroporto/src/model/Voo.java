package model;

import java.util.List;

public class Voo {

    private int numeroVoo;
    private String destino;
    private int qtdPassageiros;
    private String hrPrevista;
    private Aeronave aeronave;

    public Voo(int numeroVoo, String destino, int qtdPassageiros, String hrPrevista, Aeronave aeronave) throws IllegalArgumentException{
        setNumeroVoo(numeroVoo);
        setDestino(destino);
        setQtdPassageiros(qtdPassageiros);
        setHrPrevista(hrPrevista);
        setAeronave(aeronave);
    }

    // Getters
    public int getNumeroVoo() {
        return numeroVoo;
    }

    public String getDestino() {
        return destino;
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    public String getHrPrevista() {
        return hrPrevista;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    // Setters
    public void setNumeroVoo(int numeroVoo) throws IllegalArgumentException {
        if (numeroVoo > 0) {
            this.numeroVoo = numeroVoo;
        } else {
            throw new IllegalArgumentException("Número do voo não pode ser negativo!");
        }
    }

    public void setDestino(String destino) throws IllegalArgumentException{
        if (destino != null && !destino.isBlank()) {
            this.destino = destino;
        } else {
            throw new IllegalArgumentException("Destino deve ser informado...");
        }
    }

    public void setQtdPassageiros(int qtdPassageiros) throws IllegalArgumentException{
        if (qtdPassageiros <= 0) {
            throw new IllegalArgumentException("Quantidade de passageiros deve ser maior que 0!");
        }
        if (this.aeronave != null && qtdPassageiros > this.aeronave.getCapMaxPassageiros()) {
            throw new IllegalArgumentException("Quantidade de passageiros ultrapassou o limite da aeronave!");
        }

        this.qtdPassageiros = qtdPassageiros;
    }

    public void setHrPrevista(String hrPrevista) throws IllegalArgumentException{
        if (hrPrevista != null && !hrPrevista.isBlank()) {
            this.hrPrevista = hrPrevista;
        }else{
            throw new IllegalArgumentException("Hora prevista dever ser informada!");
        }
    }

    public void setAeronave(Aeronave aeronave){
        if (aeronave != null) {
            this.aeronave = aeronave;
        }else{
            throw new IllegalArgumentException("Aeronave deve ser adicionada primeiro!");
        }
    }

    // Métodos
    public String imprimir(){
        return "\nNúmero: " + getNumeroVoo() + "\nDestino: " + getDestino() + "\nQuantidade de passageiros: " + getQtdPassageiros() + "\nHora prevista: " + getHrPrevista() +
        "\nCódigo da aeronave: " + aeronave.getCdAeronave() + "\n";
    }

    
    
    // .
}

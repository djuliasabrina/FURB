package model;

public class Aeronave {

    private int cdAeronave;
    private String modelo;
    private int capMaxPassageiros;

    public Aeronave(int cdAeronave, String modelo, int capMaxPassageiros) throws IllegalArgumentException {
        setCdAeronave(cdAeronave);
        setModelo(modelo);
        setCapMaxPassageiros(capMaxPassageiros);
    }

    // Getters
    public int getCdAeronave() {
        return cdAeronave;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapMaxPassageiros() {
        return capMaxPassageiros;
    }

    // Setters
    public void setCdAeronave(int cdAeronave) throws IllegalArgumentException {

        if (cdAeronave > 0) {
            this.cdAeronave = cdAeronave;
        } else {
            throw new IllegalArgumentException("Código da aeronave inválido...");
        }
    }

    public void setModelo(String modelo) throws IllegalArgumentException {
        if (modelo != null && !modelo.isBlank()) {
            this.modelo = modelo;
        } else {
            throw new IllegalArgumentException("Modelo inválido...");
        }
    }

    public void setCapMaxPassageiros(int capMaxPassageiros) throws IllegalArgumentException {
        // Limite = 500 passageiros
        if (capMaxPassageiros <= 0) {
            throw new IllegalArgumentException("Quantidade de passageiros não pode ser negativa!");
        }

        this.capMaxPassageiros = capMaxPassageiros;
    }

    // Métodos
    public String imprimir() {
        return "\nCódigo da aeronave: " + getCdAeronave() + "\nModelo: " + modelo
                + "\nCapacidade máxima de passageiros: " + getCapMaxPassageiros() + "\n";
    }
    
    // .
}

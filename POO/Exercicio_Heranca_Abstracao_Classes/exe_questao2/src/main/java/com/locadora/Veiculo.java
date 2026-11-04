public abstract class Veiculo {

    private String placa;
    private String modelo;
    private double valorDiaria;
    private int qtdDias;

    public Veiculo(String placa, String modelo, double valorDiaria) {
        setPlaca(placa);
        setModelo(modelo);
        setValorDiaria(valorDiaria);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public int getQtdDias() {
        return qtdDias;
    }

    public void setQtdDias(int qtdDias) {
        this.qtdDias = qtdDias;
    }

    public abstract double calcularAluguel();

    public String imprimirDados() {
        return "Placa: " + placa
                + " | Modelo: " + modelo
                + " | Diária: R$ " + String.format("%.2f", valorDiaria)
                + " | Dias: " + qtdDias
                + " | Aluguel: R$ " + String.format("%.2f", calcularAluguel());
    }

}

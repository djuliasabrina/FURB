package heranca;
public class ContaEspecial {

    private double limiteCredito;

    public ContaEspecial(){
        setLimiteCredito(limiteCredito);
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public void sacar(double valor){
        if (valor <= limiteCredito) {
            limiteCredito = limiteCredito - valor;
        }
        
        System.out.println("Valor dever ser menor que o limite! ");
    }
    
}

package heranca;

public class SubClasse extends SuperClasse {

    private int n3;

    public SubClasse(int n1, int n2, int n3) {
        super(n1, n2);
        setN3(n3);
    }

    public int getN3() {
        return n3;
    }

    public void setN3(int n3) {
        this.n3 = n3;
    }

    public int somar() {
        // return numero1 + numero2 + n3;
        //return getNumero1() + getNumero2() + n3;
        return numero1 + numero2 + n3; // Foi mudado o numero1 e numero2 de private para protected
    }

    @Override // Método sobreescreve o método da classe superior
    public int dividir(){
        if (n3 != 0) {
            return (numero1 + numero2) / n3;
        }

        return 0;
    }

}
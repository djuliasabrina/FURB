public class Produto {

    private String nome;
    private float valorUnitario;
    

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            System.out.println("Nome deve ser preenchido...");
        }else if (nome.length() < 2) {
            System.out.println("Nome do produto deve ter no mínimo 2 caracteres");
        }else{
             this.nome = nome;
        }
    }
    public float getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(float valorUnitario) {
        if (valorUnitario > 0) {
            this.valorUnitario = valorUnitario;
        }else{
            System.out.println("Valor deve ser maior que R$00,00");
        }
        
    }

}

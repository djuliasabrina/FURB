public class ItemComanda {

    private Produto produto;
    private int quantidade;

    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        if (produto != null) {
            this.produto = produto;
        }else{
            System.out.println("Produto deve ser informado...");
        }
        
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        if (quantidade > 0) {
            this.quantidade = quantidade;
        }else{
            System.out.println("Quantidade deve ser maior que 00...");
        }
        
    }

}

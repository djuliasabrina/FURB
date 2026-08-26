import java.util.ArrayList;
import java.util.List;

public class Comanda {

    private int numero;
    private List<ItemComanda> itens;
    private int qtdAtualProduto;

    public Comanda() {
        itens = new ArrayList<ItemComanda>();

        // qtdAtualProduto = 0;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero > 0) {
            this.numero = numero;
        } else {
            System.out.println("Número da comanda dever ser positivo...");
        }

    }

    public List<ItemComanda> getItemComanda() {
        return itens;
    }

    public void setItemComanda(List<ItemComanda> itens) {
        if (itens != null) {
            this.itens = itens;
        } else {
            System.out.println("Item deve ser informado...");
        }

    }

    public void addItem(ItemComanda item) {
        if (item == null) {
            System.out.println("Item deve ser informado");
        } else {
            // itens[qtdAtualProduto] = item;
            // qtdAtualProduto++;
            itens.add(item);
        }

    }

    // public void imprimirComanda(){
    // System.out.println("Número da comanda: " + getNumero());
    // System.out.println("Quantidade de itens: " + qtdAtualProduto);

    // for(int i = 0; i < qtdAtualProduto; i++){
    // System.out.println("Item " + (i + 1));
    // System.out.println("Nome: " + itens[i].getProduto().getNome());
    // System.out.println("Valor unitário: " +
    // itens[i].getProduto().getValorUnitario());
    // System.out.println("Quantidade: " + itens[i].getProduto().getNome());
    // }

    // }

    public String imprimirComanda() {
        String dados = "";
        dados += numero;

        for (int i = 0; i < itens.size(); i++) {
            dados += "\nNome: " + itens.get(i).getProduto().getNome() +
                    "\nValor unitário: " + itens.get(i).getProduto().getValorUnitario() +
                    "\nQuantidade: " + itens.get(i).getQuantidade();

            if (itens.get(i).getQuantidade() == 1) {
                dados += " item\n";
            } else {
                dados += " itens\n";
            }
        }

        return dados;

    }
}

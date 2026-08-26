import java.util.Scanner;

import javax.swing.JOptionPane;

public class Caixa {

        private Scanner s;

        private Comanda comanda;
        private Produto[] produto;
        private ItemComanda[] itens;



 

    public Caixa() {
        s = new Scanner(System.in);

        Produto p1 = new Produto();
        // p1.setNome("Pãozinho");
        // p1.setValorUnitario(2);
        String nome = JOptionPane.showInputDialog("Digite o nome do produto: ");
        String valor = JOptionPane.showInputDialog("Digite o preço do produto: ");
        float valorFloat = Float.parseFloat(valor);

        p1.setNome(nome);
        p1.setValorUnitario(valorFloat);

        Produto p2 = new Produto();
        p2.setNome("Leite");
        p2.setValorUnitario(4);

        ItemComanda item1 = new ItemComanda();
        item1.setProduto(p1);
        item1.setQuantidade(2);

        ItemComanda item2 = new ItemComanda();
        item2.setProduto(p2);
        item2.setQuantidade(1);

        ItemComanda item3 = new ItemComanda();
        item3.setProduto(p1);
        item3.setQuantidade(10);

        Comanda c1 = new Comanda();
        c1.setNumero(1);
        c1.addItem(item2);

        Comanda c2 = new Comanda();
        c2.setNumero(2);
        c2.addItem(item3);

        JOptionPane.showMessageDialog(null, c1.imprimirComanda());
        JOptionPane.showMessageDialog(null, c2.imprimirComanda());


    }

    public static void main(String[] args) throws Exception {
       new Caixa();
    }
}

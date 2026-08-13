
public class Sistema {
	
	public Sistema() {
		
		Produto p1 = new Produto();
		
		p1.setNome("Caneta");
		p1.setPrecoVenda(2);
		p1.setQtdExistente(44);
		p1.setDisponivel(false);
		
		System.out.println("Produto: " + p1.getNome() + "\nPreço de venda: " +
		p1.getPrecoVenda() + "\nQuantidade existente: " + p1.getQtdExistente() + 
		"\n" + p1.getDisponivel());
		
	}
	
	
	public static void main(String[] args) {
		new Sistema();
	}

}

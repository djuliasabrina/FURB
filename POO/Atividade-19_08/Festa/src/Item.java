
public class Item {
	private String nome;
	private int qtd;

	//Getters
	public String getNome() {
		return nome;
	}
	
	public int getQtd() {
		return qtd;
	}
	
	
	//Setters
	public void setNome(String nome) {
		if(nome != null && !nome.isEmpty() && nome.length() >= 3) {
			this.nome = nome;
		}else {
			System.out.println("Nome deve ser preenchido!");
		}
		
	}
	
	public void setQtd(int qtd) {
		if(qtd >= 0) {
			this.qtd = qtd;
		}else {
			System.out.println("Quantidade indisponível...");
		}
		
	}

}


public class Tema {
	private Item[] itens;
	private float valor_aluguel;
	private TOALHA toalha;
	private String nome;
	
	
	//Getters
	public Item[] getItens() {
		return itens;
	}
	
	public float getValor_aluguel() {
		return valor_aluguel;
	}
	
	public TOALHA getToalha() {
		return toalha;
	}
	
	public String getNome() {
		return nome;
	}
	
	//Setters
	public void setItens(Item[] itens) {
		if(itens != null) {
			this.itens = itens;
		}else {
			System.out.println("Item deve ser informado...");
		}
		
	}
	
	public void setValor_aluguel(float valor_aluguel) {
		if(valor_aluguel > 0){
			this.valor_aluguel = valor_aluguel;
		}else {
			System.out.println("Valor do aluguel inválido...");
		}
		
	}
	
	public void setToalha(TOALHA toalha) {
		if(toalha != null) {
			this.toalha = toalha;
		}else {
			System.out.println("Cor de toalha inválido...");
		}
		
	}
	
	public void setNome(String nome) {
		if(nome != null && !nome.isEmpty() && nome.length() >= 3) {
			this.nome = nome;
		}else {
			System.out.println("Nome deve ser preenchido!");
		}
		
	}
}


public class Produto {
	private String nome;
	private float precoVenda;
	private int qtdExistente;
	private boolean disponivel;
	
	//Getters
	public String getNome() {
		return nome;
	}
	
	public float getPrecoVenda() {
		return precoVenda;
	}
	
	public int getQtdExistente() {
		return qtdExistente;
	}
	
	public boolean getDisponivel() {
		return disponivel;
	}
	
	//Setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	public void setQtdExistente(int qtdExistente) {
		this.qtdExistente = qtdExistente;
	}
	
	public void setDisponivel(boolean disponivel) {
		if(disponivel == false) {
			System.out.println("Produto indisponível para venda");
		}else {
			System.out.println("Produto disponível para venda");
		}
		this.disponivel = disponivel;
	}
}

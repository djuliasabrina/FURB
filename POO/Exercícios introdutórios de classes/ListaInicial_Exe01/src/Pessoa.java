
public class Pessoa {
	
	private String nome;
	private int idade;
	private int altura;
	private boolean maiorIdade; //Esse é opcional

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome.trim().equals("") || nome.trim().length() < 3) {
			System.out.println("Nome inválido");
		} else {
		this.nome = nome;
		}
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		if(idade < 0 & idade > 120) {
			System.out.println("Idade Inválida");
		}else {
			this.idade = idade;
		}
		
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public boolean getMaiorIdade() {
		if(idade > 18) {
			maiorIdade = true;
		} else {
			maiorIdade = false;
		}
		return maiorIdade;
	}
	public void setMaiorIdade(boolean maiorIdade) {
		this.maiorIdade = maiorIdade;
	}
	
}
 
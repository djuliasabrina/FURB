import java.util.Date;

public class Cliente {
	
	private String telefone;
	private String nome;
	private Date dataPrimeira;
	
	//Getters
	public String getTelefone() {
		return telefone;
	}

	public String getNome() {
		return nome;
	}
	
	public Date getDataPrimeira() {
		return dataPrimeira;
	}
	
	//Setters
	public void setTelefone(String telefone) {
		if(telefone != null && !telefone.isEmpty() && telefone.length() >= 3) {
			this.telefone = telefone;
		}else {
			System.out.println("Número de telefone inválido...");
		}
		
	}
	
	public void setNome(String nome) {
		if(nome != null && !nome.isEmpty() && nome.length() >= 3) {
			this.nome = nome;
		}else {
			System.out.println("Nome deve ser preenchido!");
		}
		
	}
	
	public void setDataPrimeira(Date dataPrimeira) {
		this.dataPrimeira = dataPrimeira;
	}
}

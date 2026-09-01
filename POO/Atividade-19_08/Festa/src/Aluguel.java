import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aluguel {
	private Date data;
	private int hora_inicio;
	private int hora_termino;
	private List<Tema> temas;
	private List<Cliente> cliente;
	private String endereco;

	public Aluguel(){
		temas = new ArrayList<Tema>();
		cliente = new ArrayList<Cliente>();
	}
	
	//Getters
	public Date getData() {
		return data;
	}
	
	public int getHora_inicio() {
		return hora_inicio;
	}
	
	public int getHora_termino() {
		return hora_termino;
	}
	
	public List<Tema> getTemas() {
		return temas;
	}
	
	public List<Cliente> getCliente() {
		return cliente;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	//Setters
	public void setData(Date data) {
		this.data = data;
	}
	
	public void setHora_inicio(int hora_inicio) {
		if(hora_inicio >= 0 && hora_inicio <= 23) {
			this.hora_inicio = hora_inicio;
		}else {
			System.out.println("A hora deve estar entre 0 e 23");
		}
		
	}
	
	public void setHora_termino(int hora_termino) {
		if(hora_termino >= 0 && hora_termino <= 23) {
			this.hora_termino = hora_termino;
		}else {
			System.out.println("A hora deve estar entre 0 e 23");
		}
		
	}
	
	public void setTemas(List<Tema> temas) {
		if(temas != null) {
			this.temas = temas;
		}else {
			System.out.println("Um tema dever ser informado!");
		}
		
	}
	
	public void setCliente(List<Cliente> cliente) {
		if(cliente != null) {
			this.cliente = cliente;
		}else {
			System.out.println("Um cliente dever ser informado!");
		}
	}
	
	public void setEndereco(String endereco) {
		if(endereco != null && !endereco.isEmpty() && endereco.length() > 5) {
			this.endereco = endereco;
		}else {
			System.out.println("Endereço deve ser preenchido...");
		}
		
	}

}


public class Sistema {
	
	public Sistema() {
		Pessoa p1 = new Pessoa();
		Pessoa p2 = new Pessoa();
		
		p1.setNome("Maria");
		p2.setNome("");
		p2.setNome("Luciana");
		p2.setIdade(16);
		
		System.out.println(p1.getNome() + " " + p2.getNome() + "\nIdade: " + p2.getIdade());
	
		
	}

	public static void main(String[] args) {
		new Sistema();
	}
}

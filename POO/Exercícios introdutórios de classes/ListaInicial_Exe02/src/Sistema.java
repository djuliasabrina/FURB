
public class Sistema {
	
	public Sistema() {
		Aluno a1 = new Aluno();
		
		a1.setNome("Braian");
		a1.setNrmatricula(121);
		a1.setNota(8);
		
		System.out.println("Nome: " + a1.getNome() + "\nMatricula: " + a1.getNrMatricula() + "\nNota: " + a1.getNota());
		
	}
	
	
	
	public static void main(String[] args) {
		new Sistema();
	}

}

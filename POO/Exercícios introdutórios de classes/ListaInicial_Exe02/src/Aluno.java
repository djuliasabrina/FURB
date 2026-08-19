
public class Aluno {

	private String nome;
	private int nrMatricula;
	private float nota;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if(nome.trim().equals("") || nome.trim().length() < 3) {
			System.out.println("Nome inválido...");
		}else {
			
		this.nome = nome;
		
		}
	}
	
	public int getNrMatricula() {
		return nrMatricula;
	}
	
	public void setNrmatricula(int nrMatricula) {
		this.nrMatricula = nrMatricula;
	}
	
	public float getNota() {
		return nota;
	}
	
	public void setNota(float nota) {
		if(nota < 7) {
			System.out.println("Aluno REPROVADO");
		}else if(nota >= 7){
			System.out.println("Aluno APROVADO");
		}
		this.nota = nota;
		
	}
}

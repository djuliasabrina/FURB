
public class Livro {
	private String titulo;
	private Autor autor;
	private int qtdPaginas;
	private int anoPublicacao;
	
	//Getters
	public String getTitulo() {
		return titulo;
	}
	
	public Autor getAutor() {
		return autor;
	}
	
	public int getQtdPaginas() {
		return qtdPaginas;
	}
	
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	
	//Setters
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public void setQtdPaginas(int qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}
	
	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
}

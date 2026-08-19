
public class Sistema {
	
	public Sistema() {
		
		Autor autor = new Autor();
		Livro livro = new Livro();
		
		autor.setNome("Gui");
		livro.setTitulo("Harry Potter");
		livro.setQtdPaginas(41);
		livro.setAnoPublicacao(2020);
		
		System.out.println("Autor: " + autor.getNome() + 
				"\nTítulo: " + livro.getTitulo() +
				"\nQuantidade de páginas: " + livro.getQtdPaginas() + 
				"\nAno de publicação: " + livro.getAnoPublicacao()
				);
		
	}

	public static void main(String[] args) {
		new Sistema();
	}
}

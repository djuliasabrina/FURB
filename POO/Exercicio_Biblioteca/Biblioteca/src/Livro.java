import javax.swing.JOptionPane;

public class Livro {

    private int cdLivro;
    private String titulo;

    // Construtor
    public Livro(int cdLivro, String titulo) {
        setCdLivro(cdLivro);
        setTitulo(titulo);
    }

    // Getters
    public int getCdLivro() {
        return cdLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    // Setters
    public void setCdLivro(int cdLivro) {
        if (cdLivro > 0) {
            this.cdLivro = cdLivro;
        } else {
            JOptionPane.showMessageDialog(null, "Código do livro deve ser maior que ZERO!", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.isBlank() && titulo.length() >= 3) {
            this.titulo = titulo;
        } else {
            JOptionPane.showMessageDialog(null, "Titulo do livro inválido...", "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

    public String imprimirDados(){
        return getCdLivro() + " - " + getTitulo();
    }
}

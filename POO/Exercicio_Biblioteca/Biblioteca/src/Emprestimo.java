import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class Emprestimo {

    private List<Livro> livros;
    private Cliente cliente;
    private Date dataEmprestimo;

    // Construtor
    public Emprestimo(List<Livro> livros, Cliente cliente, Date dataEmprestimo) {

        setLivro(livros);
        setCliente(cliente);
        setDataEmprestimo(new Date()); // data atual

       // livros = new ArrayList<Livro>();
     
    }

    // Getters
    public List<Livro> getLivro() {
        return livros;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    // Setters
    public void setLivro(List<Livro> livros) {
        if (livros != null) {
            this.livros = livros;
        } else {
            JOptionPane.showMessageDialog(null, "Livro deve ser cadastrado primeiro!", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setCliente(Cliente cliente) {
        if (cliente != null) {
            this.cliente = cliente;
        } else {
            JOptionPane.showMessageDialog(null, "Cliente deve ser cadastrado primeiro!", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        if (dataEmprestimo == null) {
            JOptionPane.showMessageDialog(null, "Data deve ser informada!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }else{
        this.dataEmprestimo = dataEmprestimo;
        }
    }



    // Método de adição para adicionar livros na lista
    public void addLivro(Livro livro){
        if (livro == null) {
            JOptionPane.showMessageDialog(null, "Livro dever ser informado!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }else{
            livros.add(livro);
        }
    }

    // public String imprimirDados(){
    //     String dados = dataEmprestimo.toString() + "\n";
    //     dados += cliente.imprimirDados() + "\n";

    //     for(Livro l: livros){
    //         dados += l.imprimirDados() + "\n";
    //     }

    //     return dados;
    // }

    public String imprimirDados(){
        String dados = "";
        dados += "\n--- CLIENTE --- " + cliente.imprimirDados() + "\n";

        dados += "--- LIVROS ---";
        for(Livro livro: livros){
            dados +=  livro.imprimirDados() + "\n";
        }

        dados += "\nData do empréstimo: " + dataEmprestimo.toString() + "\n";

        return dados;
    }
}

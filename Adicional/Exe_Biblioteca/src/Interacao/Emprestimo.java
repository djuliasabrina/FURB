package Interacao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Emprestimo {

    private Cliente cliente;
    private LocalDate dataEmprestimo;
    private List<Livro> livros;

    public Emprestimo(Cliente cliente, LocalDate dataEmprestimo) {
        this.cliente = cliente;
        this.dataEmprestimo = dataEmprestimo;
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void removerLivro(Livro livro) {
        livros.remove(livro);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Emprestimo{cliente=").append(cliente.getNome())
          .append(", dataEmprestimo=").append(dataEmprestimo)
          .append(", livros=[");
        for (int i = 0; i < livros.size(); i++) {
            sb.append(livros.get(i).getTitulo());
            if (i < livros.size() - 1) sb.append(", ");
        }
        sb.append("]}");
        return sb.toString();
    }
}
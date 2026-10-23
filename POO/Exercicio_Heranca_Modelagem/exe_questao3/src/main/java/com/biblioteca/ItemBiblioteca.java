package com.biblioteca;

public class ItemBiblioteca {

    private String titulo;
    private boolean emprestado;
    private boolean devolvido;

    public ItemBiblioteca(String titulo, boolean emprestado, boolean devolvido) {
        // Define o título do item usando o método setTitulo()
        setTitulo(titulo);

        // O this indica que estamos acessando o atributo do objeto.
        // O emprestado, sem this, é o parâmetro recebido no construtor.
        this.emprestado = emprestado;

        // Inicializa o atributo devolvido com o valor recebido.
        // O this diferencia o atributo do parâmetro de mesmo nome.
        this.devolvido = devolvido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo deve ser preenchido.");
        }
        this.titulo = titulo;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        if (devolvido && isEmprestado() == false) {
            throw new IllegalArgumentException("Esse item não foi emprestado.");
        }
        this.devolvido = devolvido;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public void emprestar() {
        if (isEmprestado() && !isDevolvido()) {
            throw new IllegalArgumentException("Esse item já está emprestado.");
        }

        emprestado = true;
        devolvido = false;

    }

    public void devolver() {
        if (!isEmprestado() || isDevolvido()) {
            throw new IllegalArgumentException("Esse item não tem nenhuma pendência.");
        }

        devolvido = true;
    }

    public double calcularMulta(int diasDeAtraso) {
        if (diasDeAtraso < 0) {
            throw new IllegalArgumentException("Dias de atraso não podem ser negativos.");
        }
        if (!isEmprestado() || !isDevolvido()) {
            return 0;
        }
        return diasDeAtraso * 0.50; // Multa Padrão
    }

}

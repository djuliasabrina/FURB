package com.conta.modelo;

import com.conta.excecao.CampoVazioException;
import com.conta.excecao.Maior3caracteresException;

public class Cliente {

    private String nome;
    private String endereco;

    public Cliente(String nome, String endereco) throws CampoVazioException, Maior3caracteresException{
        setNome(nome);
        setEndereco(endereco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws CampoVazioException, Maior3caracteresException {
        if (nome == null || nome.isBlank()) {
            throw new CampoVazioException("Nome");
        }
        if (nome.length() < 3) {
            throw new Maior3caracteresException("Nome");
        }
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) throws CampoVazioException, Maior3caracteresException {
        if (endereco == null || endereco.isBlank()) {
            throw new CampoVazioException("Endereço");
        }
        if (endereco.length() < 3) {
            throw new Maior3caracteresException("Endereço");
        }
        this.endereco = endereco;
    }

}
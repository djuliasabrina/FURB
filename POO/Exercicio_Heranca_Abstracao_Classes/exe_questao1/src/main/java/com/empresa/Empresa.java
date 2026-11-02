package com.empresa;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String nomeEmpresa;
    private List<Funcionario> funcionarios;

    public Empresa(String nomeEmpresa) {
        setNomeEmpresa(nomeEmpresa);
        funcionarios = new ArrayList<Funcionario>();
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) throws IllegalArgumentException {
        if (nomeEmpresa == null || nomeEmpresa.isBlank()) {
            throw new IllegalArgumentException("Nome da empresa deve ser preenchido.");
        }
        this.nomeEmpresa = nomeEmpresa;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void addFuncionario(Funcionario funcionario) throws IllegalArgumentException {
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário deve ser preenchido.");
        }

        funcionarios.add(funcionario);
    }

    public void removerFuncionario(Funcionario funcionario) throws IllegalArgumentException {
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário deve ser preenchido.");
        }

        funcionarios.remove(funcionario);
    }

    public String exibirDadosTodosFuncionarios(){
        String dados = "";

        for(Funcionario f : funcionarios){
            dados += f.exibirDados() + "\nSalário: " + f.calcularSalario() + "\n";
        }

        return dados;
    }

    public String exibirDadoUmFuncionario(String matricula){
        String dados = "";

        for(Funcionario f : funcionarios){
            if (f.getMatricula().equalsIgnoreCase(matricula)) {
                dados += f.exibirDados() + "\nSalário: " + f.calcularSalario() + "\n";
            }
        }

        return dados;
    }

    public double calcularValorTotalFolhaPagamento(){
        double total = 0;

        for(Funcionario f : funcionarios){
            total += f.calcularSalario();
        }

        return total;
    }

}

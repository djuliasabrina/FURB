package com.empresa;

import java.util.ArrayList;
import java.util.List;

public class Transporte {

    private List<Veiculo> veiculos;

    public Transporte() {
        veiculos = new ArrayList<Veiculo>();
    }

    public void addVeiculo(Veiculo veiculo) throws IllegalArgumentException {
        if (veiculo == null) {
            throw new IllegalArgumentException("Veiculo deve ser preenchido.");
        }

        veiculos.add(veiculo);
    }

    public Veiculo veiculoMaisEconomico(double precoCombustivel) {

        if (veiculos == null) {
            throw new IllegalStateException("Não existem veículos cadastrados.");
        }

        Veiculo veiculoEconomico = veiculos.get(0);

        for (Veiculo v : veiculos) {
            if (v.custoDeViagem(350, precoCombustivel) < veiculoEconomico.custoDeViagem(350, precoCombustivel)) {
                veiculoEconomico = v;
            }

        }

        return veiculoEconomico;
    }

}

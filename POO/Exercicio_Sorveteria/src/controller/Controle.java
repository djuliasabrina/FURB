package controller;

import java.util.ArrayList;
import java.util.List;

import model.Pedido;

public class Controle {

    private List<Pedido> pedidos;
    private String nome;

    public Controle(String nome) {
        pedidos = new ArrayList<>();

        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome deve ser preenchido!");
        }

        this.nome = nome;
    }

    public void adicionarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido deve ser preenchido...");
        }

        pedidos.add(pedido);
    }

    public Pedido localizarPedidoPeloID(int id) {

        for (Pedido pedido : pedidos) {
            if (pedido.getIdentificador() == id) {
                return pedido;
            }
        }

        return null;

    }

    public int qtdPedidosRealizadosPeloCliente(String nomeCliente) {
        int qtd = 0;

        for (Pedido pedido : pedidos) {
            if (pedido.getNomeCliente().equalsIgnoreCase(nomeCliente)) {
                qtd++;
            }
        }

        return qtd;
    }

    public Pedido pedidoPossuiMaiorQtdSorvetes() {
        Pedido pedidoMaiorqtd = pedidos.get(0);

        for (Pedido p : pedidos) {
            if (p.qtdTotalSorvetesExistentesPedido() > pedidoMaiorqtd.qtdTotalSorvetesExistentesPedido()) {
                pedidoMaiorqtd = p;
            }
        }

        return pedidoMaiorqtd;

    }

}

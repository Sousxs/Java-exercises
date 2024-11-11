package project;

import java.util.*;

class Jogador {
    private Sala salaAtual;
    private Inventario inventario;

    public Jogador(Sala salaInicial) {
        this.salaAtual = salaInicial;
        this.inventario = new Inventario();
    }

    public void mover(String direcao) {
        Sala novaSala = salaAtual.getSaida(direcao);
        if (novaSala != null) {
            salaAtual = novaSala;
            System.out.println(salaAtual.getDescricao());
            salaAtual.listarItens();
        } else {
            System.out.println("Não há saída nessa direção.");
        }
    }

    public void pegarItem(String nomeItem) {
        Item item = salaAtual.removerItem(nomeItem);
        if (item != null) {
            inventario.adicionarItem(item);
            System.out.println("Você pegou o item: " + item.getNome());
        } else {
            System.out.println("Item não encontrado na sala.");
        }
    }
    
    public void droparItem(String nomeItem) {
        Item item = inventario.removerItem(nomeItem);
        if (item != null) {
            salaAtual.adicionarItem(item);
            System.out.println("Você dropou o item: " + item.getNome());
        } else {
            System.out.println("O item não está no seu inventário.");
        }
    }


    public void mostrarInventario() {
        inventario.listarItens();
    }
}


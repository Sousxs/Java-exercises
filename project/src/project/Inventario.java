package project;

import java.util.*;

class Inventario {
    private List<Item> itens;

    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public Item removerItem(String nomeItem) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                itens.remove(item);
                return item;
            }
        }
        return null;
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("O inventário está vazio.");
        } else {
            System.out.println("Itens no inventário:");
            for (Item item : itens) {
                System.out.println("- " + item.getNome());
            }
        }
    }
}

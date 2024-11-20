import java.util.*;

class Inventario {
    private List<Item> itens;
    private static final int CAPACIDADE_MAXIMA = 6; // definir tamanho do inventario

    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public boolean adicionarItem(Item item) {
        if (itens.size() >= CAPACIDADE_MAXIMA) {
            return false;
        } else {
            itens.add(item);
            return true;
        }
    }

    public boolean estaCheio() {
        return itens.size() >= CAPACIDADE_MAXIMA;
    }

    public Item removerItem(String nomeItem) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                itens.remove(item);
                return item;
            }
        }
        System.out.println(nomeItem + " não está no inventário.");
        return null;
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("O inventário está vazio.");
        } else {
            System.out.println("Itens no inventário: ");
            for (Item item : itens) {
                System.out.println("- "+item.getNome());
            }
        }
    }
    public boolean possuiItem(String nomeItem) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                return true;
            }
        }
        return false;
    }
}

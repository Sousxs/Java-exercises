package src;

import java.util.*;

class Sala {
    private String nome;
    private String descricao;
    private Map<String, Sala> saidas;
    private List<Item> itens;
    private Npc npcs;
    private String itemNecessario;
    private boolean aberta;

    public Sala(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.saidas = new HashMap<>();
        this.itens = new ArrayList<>();
        this.itemNecessario = null;
        this.npcs = null;
        this.aberta = false;
    }

    public Npc getNpcs() {
        return npcs;
    }

    public void setNpcs(Npc npcs) {
        this.npcs = npcs;
    }

    public void setSaida(String direcao, Sala sala) {
        saidas.put(direcao, sala);
    }

    public Sala getSaida(String direcao) {
        return saidas.get(direcao);
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


    public String getDescricao() {
        return descricao;
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Não vejo nada aqui.");
        } else {
            System.out.println("Itens na sala: ");
            for (Item item : itens) {
                System.out.println("- "+item.getNome());
            }
            System.out.println();
        }
    }

    private boolean executado = false;

    public void listarSala() {
        if (npcs != null && !executado) {
            System.out.println("Parece que encontrei alguém aqui! ");
            this.npcs.Conversar();
            executado = true;
        }
        if (itens.isEmpty()) {
            System.out.println("Não vejo nada aqui.");
        } else {
            System.out.println("Itens na sala: ");
            for (Item item : itens) {
                System.out.println("- "+item.getNome());
            }
            System.out.println();
        }
    }

}

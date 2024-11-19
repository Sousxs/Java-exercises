import java.lang.classfile.instruction.SwitchCase;
import java.util.*;

class Sala {
    private String nome;
    private String descricao;
    private Map<String, Sala> saidas;
    private List<Item> itens;
    private Npc npcs;
    private String itemNecessario;
    private Open openavel;

    public Sala(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.saidas = new HashMap<>();
        this.itens = new ArrayList<>();
        this.itemNecessario = null;
        this.npcs = null;
        this.openavel = null;
    }

    public void conversacao(String comando) {
        if (npcs != null) {
            switch (comando) {
                case "conversar":
                case "Conversar":
                case "C":
                case "Falar":
                    npcs.Conversar();
                    break;
            }
        } else {
            System.out.println("Não há NPCs nesta sala para conversar.");
        }
    }

    public

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

    public void setItemNecessario(String itemNecessario) {
        this.itemNecessario = itemNecessario;
    }

    public String getItemNecessario() {
        return itemNecessario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Não há itens aqui.");
        } else {
            System.out.println("Itens na sala:");
            for (Item item : itens) {
                System.out.println("- " + item.getNome());
            }
            if (openavel != null) {
                System.out.println("- " + openavel.getNome() + "(Esse item depende de: " + openavel.falarChave() + ")");
            }
            if (npcs != null) {
                System.out.println("NPC na sala: ");
                System.out.println("Nome: " + npcs.getNome());
            } else {
                System.out.println("Não há NPCs nesta sala.");
            }
        }
    }

}

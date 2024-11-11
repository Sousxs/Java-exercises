import java.util.*;

class Sala {
    private String nome;
    private String descricao;
    private Map<String, Sala> saidas;
    private List<Item> itens;
    private String itemNecessario;

    public Sala(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.saidas = new HashMap<>();
        this.itens = new ArrayList<>();
        this.itemNecessario = null;
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
        }
    }
}

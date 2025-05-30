import java.util.ArrayList;
import java.util.List;

public class Open extends Item {
    private List<Item> itensDentro;
    private boolean aberto;
    private Item chave;

    public Open(String nome, Item chave) {
        super(nome);
        this.itensDentro = new ArrayList<>();
        this.aberto = false;
        this.chave = chave;
    }

    public void adicionarItem(Item item) {
        itensDentro.add(item);
    }

    public Item getChave() {
        return chave;
    }

    public void setChave(Item chave) {
        this.chave = chave;
    }
    public String falarChave() {
        return chave != null ? chave.getNome() : "Nenhuma chave necessária";
    }
    public boolean compararChaves(Item chaveJogador) {
        return chaveJogador != null && chaveJogador.getNome().equalsIgnoreCase(chave.getNome());
    }

    public void abrir(Item chaveJogador) {
        if (chave == null || compararChaves(chaveJogador)) {
            if (!aberto) {
                System.out.println("Você abriu o " + getNome() + ". Itens revelados:");
                if (itensDentro.isEmpty()) {
                    System.out.println("Este item está vazio.");
                } else {
                    for (Item item : itensDentro) {
                        System.out.println("- " + item.getNome());
                    }
                }
                aberto = true;
            } else {
                System.out.println("Este item já está aberto e não pode ser fechado.");
            }
        } else {
            System.out.println("Você não tem a chave necessária para abrir este item.");
        }
    }

}

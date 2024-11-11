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
            String itemNecessario = novaSala.getItemNecessario();
            if (itemNecessario == null || inventario.possuiItem(itemNecessario)) {
                salaAtual = novaSala;
                System.out.println(salaAtual.getDescricao());
                salaAtual.listarItens();
            } else {
                System.out.println("Você precisa do item '" + itemNecessario + "' para acessar esta sala.");
            }
        } else {
            System.out.println("Não há saída nessa direção.");
        }
    }

    public void pegarItem(String nomeItem) {
        if (nomeItem.equalsIgnoreCase("Livro")) {
            // precisa ter a carteirinha no inventário para pegar livro
            if (inventario.possuiItem("Carteirinha")) {
                Item item = salaAtual.removerItem(nomeItem);
                if (item != null) {
                    inventario.adicionarItem(item);
                    System.out.println("Você alugou: " + item.getNome());
                } else {
                    System.out.println("Item não encontrado na sala.");
                }
            } else {
                System.out.println("Você precisa da Carteirinha para pegar o Livro.");
            }
        }
        if (nomeItem.equalsIgnoreCase("Caderno")) {
            // precisa ter dinheiro no inventário para pegar o caderno
            if (inventario.possuiItem("Dinheiro")) {
                Item item = salaAtual.removerItem(nomeItem);
                if (item != null) {
                    inventario.adicionarItem(item);
                    System.out.println("Você comprou o " + item.getNome());
                } else {
                    System.out.println("Item não encontrado na sala.");
                }
            } else {
                System.out.println("Você precisa da Dinheiro para pegar o caderno.");
            }
        }
        else {
            Item item = salaAtual.removerItem(nomeItem);
            if (item != null) {
                if (inventario.adicionarItem(item)) {
                    System.out.println("Você pegou o item: " + item.getNome());
                } else {
                    System.out.println("Inventário cheio! Não é possível carregar mais itens.");
                    salaAtual.adicionarItem(item);
                }
            } else {
                System.out.println("Item não encontrado na sala.");
            }
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


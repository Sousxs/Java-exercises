class Jogador {
    private Sala salaAtual;
    private Inventario inventario;
    private Mapa mapa;
    private boolean fim;

    public Jogador(Sala salaInicial) {
        this.salaAtual = salaInicial;
        this.inventario = new Inventario();
        this.fim = false;
    }

    public void listar() {
        salaAtual.listarItens();
    }

    public void mover(String direcao) {
        Sala novaSala = salaAtual.getSaida(direcao);
        if (novaSala != null) {
            salaAtual = novaSala;
            System.out.println(salaAtual.getDescricao());
            salaAtual.listarSala();
        } else {
            System.out.println("Não há saída nessa direção.");
        }
    }

    public void ver() {
        System.out.println(salaAtual.getDescricao());
        salaAtual.listarSala();

    }

    public boolean isFim() {
        return fim;
    }


    public void pegarItem(String nomeItem) {
        if (nomeItem.equalsIgnoreCase("TCC")) {
            if (inventario.possuiItem("Hello word") &&
                    inventario.possuiItem("Repeticao 1") &&
                    inventario.possuiItem("Desenvolvimento Web") &&
                    inventario.possuiItem("Interface Grafica")) {

                if (!inventario.estaCheio()) {
                    Item item = salaAtual.removerItem(nomeItem);
                    if (item != null) {
                        inventario.adicionarItem(item);
                        System.out.println("Você pegou o " + item.getNome());

                        inventario.removerItem("Hello word");
                        inventario.removerItem("Repeticao 1");
                        inventario.removerItem("Desenvolvimento Web");
                        inventario.removerItem("Interface Grafica");

                        // Fim do jogo
                        this.fim = true;
                    } else {
                        System.out.println("Item não encontrado na sala.");
                    }
                } else {
                    System.out.println("Seu inventário está cheio! Libere espaço antes de pegar o TCC.");
                }
            } else {
                System.out.println("Você precisa de todas as Atividades para pegar o TCC.");
            }
        } else if (nomeItem.equalsIgnoreCase("Hello word")) {
            if (inventario.possuiItem("Caderno") && inventario.possuiItem("Caneta")) {
                if (!inventario.estaCheio()) {
                    Item item = salaAtual.removerItem(nomeItem);
                    if (item != null) {
                        inventario.adicionarItem(item);
                        inventario.removerItem("Caderno");
                        inventario.removerItem("Caneta");
                        System.out.println("Você pegou a Atividade " + item.getNome());
                    } else {
                        System.out.println("Item não encontrado na sala.");
                    }
                } else {
                    System.out.println("Inventário cheio! Libere espaço antes de pegar o item.");
                }
            } else {
                System.out.println("Você precisa de um CADERNO e uma CANETA para pegar essa atividade.");
            }
        } else if (nomeItem.equalsIgnoreCase("Repeticao 1")) {
            if (inventario.possuiItem("Livro")) {
                if (!inventario.estaCheio()) {
                    Item item = salaAtual.removerItem(nomeItem);
                    if (item != null) {
                        inventario.adicionarItem(item);
                        inventario.removerItem("Livro");
                        System.out.println("Você pegou a Atividade " + item.getNome());
                    } else {
                        System.out.println("Item não encontrado na sala.");
                    }
                } else {
                    System.out.println("Inventário cheio! Libere espaço antes de pegar o item.");
                }
            } else {
                System.out.println("Você precisa de LIVRO para pegar essa atividade.");
            }
        } else if (nomeItem.equalsIgnoreCase("Desenvolvimento Web")) {
            if (inventario.possuiItem("Repeticao 1")) {
                if (!inventario.estaCheio()) {
                    Item item = salaAtual.removerItem(nomeItem);
                    if (item != null) {
                        inventario.adicionarItem(item);
                        System.out.println("Você pegou a Atividade " + item.getNome());
                    } else {
                        System.out.println("Item não encontrado na sala.");
                    }
                } else {
                    System.out.println("Inventário cheio! Libere espaço antes de pegar o item.");
                }
            } else {
                System.out.println("Você precisa de REPETICAO 1 para pegar essa atividade.");
            }
        } else if (nomeItem.equalsIgnoreCase("Interface Grafica")) {
            if (inventario.possuiItem("Cafe")) {
                if (!inventario.estaCheio()) {
                    Item item = salaAtual.removerItem(nomeItem);
                    if (item != null) {
                        inventario.adicionarItem(item);
                        inventario.removerItem("Cafe");
                        System.out.println("Você pegou a Atividade " + item.getNome());
                    } else {
                        System.out.println("Item não encontrado na sala.");
                    }
                } else {
                    System.out.println("Inventário cheio! Libere espaço antes de pegar o item.");
                }
            } else {
                System.out.println("Você precisa de CAFE para pegar essa atividade.");
            }
        } else if (nomeItem.equalsIgnoreCase("Livro")) {
            if (inventario.possuiItem("Carteirinha")) {
                if (!inventario.estaCheio()) {
                    Item item = salaAtual.removerItem(nomeItem);
                    if (item != null) {
                        inventario.adicionarItem(item);
                        System.out.println("Você alugou: " + item.getNome());
                    } else {
                        System.out.println("Item não encontrado na sala.");
                    }
                } else {
                    System.out.println("Inventário cheio! Libere espaço antes de pegar o item.");
                }
            } else {
                System.out.println("Você precisa da CARTEIRINHA para pegar o Livro.");
            }
        } else if (nomeItem.equalsIgnoreCase("Caderno") || nomeItem.equalsIgnoreCase("Caneta")) {
            if (inventario.possuiItem("Dinheiro")) {
                if (!inventario.estaCheio()) {
                    Item item = salaAtual.removerItem(nomeItem);
                    if (item != null) {
                        inventario.adicionarItem(item);
                        inventario.removerItem("Dinheiro");
                        System.out.println("Você comprou o " + item.getNome());
                    } else {
                        System.out.println("Item não encontrado na sala.");
                    }
                } else {
                    System.out.println("Inventário cheio! Libere espaço antes de pegar o item.");
                }
            } else {
                System.out.println("Você precisa de DINHEIRO para comprar o " + nomeItem + ".");
            }
        } else {
            if (!inventario.estaCheio()) {
                Item item = salaAtual.removerItem(nomeItem);
                if (item != null) {
                    inventario.adicionarItem(item);
                    System.out.println("Você pegou o(a) " + item.getNome());
                } else {
                    System.out.println("Item não encontrado na sala.");
                }
            } else {
                System.out.println("Inventário cheio! Libere espaço antes de pegar o item.");
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


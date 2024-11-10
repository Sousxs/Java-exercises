package project;

import java.util.*;

public class Main {
    private static Mapa mapa;
    private static Jogador jogador;
    private static boolean jogoAtivo = true;

    public static void main(String[] args) {
        inicializarJogo();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao The Black Sanctum!");
        System.out.println("Digite 'ajuda' para ver os comandos disponíveis.");

        while (jogoAtivo) {
            System.out.print("> ");
            String comando = scanner.nextLine();
            processarComando(comando.toLowerCase());
        }
        scanner.close();
    }

    private static void inicializarJogo() {
        mapa = new Mapa();
        jogador = new Jogador(mapa.getSalaInicial());
    }

    private static void processarComando(String comando) {
        switch (comando) {
            case "norte": case "sul": case "leste": case "oeste":// case "n": case "s": case "l": case "o":
                jogador.mover(comando);
                break;
            case "pegar":
                System.out.print("Digite o nome do item: ");
                String item = new Scanner(System.in).nextLine();
                jogador.pegarItem(item);
                break;
            case "inventario":
                jogador.mostrarInventario();
                break;
            case "ajuda":
                mostrarAjuda();
                break;
            case "sair":
                jogoAtivo = false;
                System.out.println("Saindo do jogo...");
                break;
            default:
                System.out.println("Comando inválido.");
                break;
        }
    }

    private static void mostrarAjuda() {
        System.out.println("Comandos disponíveis:");
        System.out.println("- norte, sul, leste, oeste: mover-se.");
        System.out.println("- pegar: pegar um item.");
        System.out.println("- usar: usar um item.");
        System.out.println("- inventario: ver itens no inventário.");
        System.out.println("- sair: sair do jogo.");
    }
}

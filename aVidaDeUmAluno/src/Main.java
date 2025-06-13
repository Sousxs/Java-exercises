package src;

import java.util.*;

public class Main {
    private static Mapa mapa;
    private static Jogador jogador;
    private static boolean jogoAtivo = true;

    public static Mapa getMapa() {
        return mapa;
    }

    public static void main(String[] args) {

        inicializarJogo();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo a vida de um Estudante da PUC-GO");
        System.out.println("Os estudantes estão sendo recebidos no Auditório 1, vá até lá e receba suas instruções!");
        System.out.println( "       ┌──────────────────────────────────────────────┐\n" +
                            "       │                    AVENIDA                   │\n" +
                            "       ├──────────────────────────────────────────────┤\n" +
                            "       │   CALÇADAS:                                  │\n" +
                            "       │   [x] Você                                   │\n" +
                            "       │                                              │\n" +
                            "       │                                              │\n" +
                            "       │   ESTRADA:                                   │\n" +
                            "       │   ║██║░░║██║░░║██║░░║██║░░║██║░░║██║░░║██║   │\n" +
                            "       │                                              │\n" +
                            "       │                                              │\n" +
                            "       │   CALÇADAS:                                  │\n" +
                            "       │                                              │\n" +
                            "       │                                              │\n" +
                            "       └──────────────────────────────────────────────┘\n");
        System.out.println("Digite 'ajuda' para ver os comandos disponíveis.");


        while (jogoAtivo) {
            System.out.print("> ");
            String comando = scanner.nextLine();
            processarComando(comando.toLowerCase());
            if(jogador.isFim()){
                System.out.println("Leonardo: Parabéns você foi aprovado no curso de Programação!\n");
                jogoAtivo = false;
            }
        }
        scanner.close();
    }

    private static void inicializarJogo() {
        mapa = new Mapa();
        jogador = new Jogador(mapa.getSalaInicial());
    }

    private static void processarComando(String comando) {
        String[] partesComando = comando.trim().split("\\s+");

        int espacoIndex = comando.indexOf(" ");
        if (espacoIndex != -1) {
            String acao = comando.substring(0, espacoIndex).trim().toLowerCase();
            String nomeItem = comando.substring(espacoIndex + 1).trim();

            switch (partesComando[0].toLowerCase()) {
                case "pegar":
                    jogador.pegarItem(nomeItem);
                    break;
                case "dropar":
                    jogador.droparItem(nomeItem);
                    break;
                default:
                    System.out.println("Comando desconhecido, tente novamente!");
                    break;
            }
        } else {
            switch (comando) {
                case "norte" : case "sul": case "leste": case "oeste": case "n": case "s": case "l": case "o":
                    jogador.mover(comando);
                    break;
                case "pegar":
                    jogador.listar();
                    System.out.println("Qual item você deseja pegar?");
                    String itemPegar = new Scanner(System.in).nextLine();
                    jogador.pegarItem(itemPegar);
                    break;
                case "dropar":
                    jogador.mostrarInventario();
                    System.out.println("Qual item você deseja dropar?");
                    String itemDropar = new Scanner(System.in).nextLine();
                    jogador.droparItem(itemDropar);
                    break;
                case "inventario": case "i":
                    jogador.mostrarInventario();
                    break;
                case "ajuda":
                    mostrarAjuda();
                    break;
                case "sair":
                    jogoAtivo = false;
                    System.out.println("Saindo do jogo...");
                    break;
                case "olhar":
                    jogador.ver();
                    break;
                default:
                    System.out.println("Comando desconhecido, tente novamente!");
                    break;
            }
        }
    }

    private static void mostrarAjuda() {
        System.out.println("Comandos disponíveis:");
        System.out.println("- norte, sul, leste, oeste.");
        System.out.println("- pegar");
        System.out.println("- dropar");
        System.out.println("- inventario");
        System.out.println("- sair");
        System.out.println("- olhar");
    }
}


// JAO E PEDRO ESTIVERAM AQUI

// nego minha existencia com a existencia criada diante dos fatos ocorridos sem saber oq ocorreu - pedro
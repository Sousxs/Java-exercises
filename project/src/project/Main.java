package project;

import java.util.*;

public class Main {
    private static Mapa mapa;
    private static Jogador jogador;
    private static boolean jogoAtivo = true;

    public static void main(String[] args) {
    	
    	Item caneta = new Item("Caneta");
    	Item caderno = new Item("Caderno");
    	Item carteirinha = new Item("Carteirinha");
    	Item livro = new Item("Livro");
    	Item cafe = new Item("Café");
    	Item dinheiro = new Item("Dinheiro");
    	Item atividade1 = new Item("Atividade 1");
    	Item atividade2 = new Item("Atividade 2");
    	Item atividade3 = new Item("Atividade 3");
    	Item atividade4 = new Item("Atividade 4");
    	
        inicializarJogo();
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo a vida de um Estudante da PUC-GO");
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
	        case "norte": case "sul": case "leste": case "oeste":
	            jogador.mover(comando);
	            break;
	        case "pegar":
	            System.out.print("Digite o nome do item para pegar: ");
	            String itemParaPegar = new Scanner(System.in).nextLine();
	            jogador.pegarItem(itemParaPegar);
	            break;
	        case "dropar":
	            System.out.print("Digite o nome do item para dropar: ");
	            String itemParaDropar = new Scanner(System.in).nextLine();
	            jogador.droparItem(itemParaDropar);
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
        System.out.println("- pegar: pegar um item do quarto.");
        System.out.println("- dropar: dropar um item do quarto.");
        System.out.println("- inventario: ver itens no inventário.");
        System.out.println("- sair: sair do jogo.");
    }
}

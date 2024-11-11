import java.util.*;

public class Main {
    private static Mapa mapa;
    private static Jogador jogador;
    private static boolean jogoAtivo = true;

    public static void main(String[] args) {

		inicializarJogo();
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo a vida de um Estudante da PUC-GO");
		System.out.println("Você está na avenida!");
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
	        case "norte": case "sul": case "leste": case "oeste": case "n": case "s": case "l": case "o":
	            jogador.mover(comando);
	            break;
	        case "pegar":
	            System.out.print("Digite o nome do item: ");
	            String itemParaPegar = new Scanner(System.in).nextLine();
	            jogador.pegarItem(itemParaPegar);
	            break;
	        case "dropar":
	            System.out.print("Digite o nome do item: ");
	            String itemParaDropar = new Scanner(System.in).nextLine();
	            jogador.droparItem(itemParaDropar);
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
	        default:
	            System.out.println("Comando inválido.");
	            break;
    	}
    }

    private static void mostrarAjuda() {
        System.out.println("Comandos disponíveis:");
        System.out.println("- norte, sul, leste, oeste.");
        System.out.println("- pegar");
        System.out.println("- dropar");
        System.out.println("- inventario");
        System.out.println("- sair");
    }
}

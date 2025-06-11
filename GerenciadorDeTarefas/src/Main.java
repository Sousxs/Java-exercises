import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tarefas = new ArrayList<>();
        int opcao;
        do{
            menu();
            opcao = sc.nextInt();

            if(opcao == 1)
                cadastrarTarefa(tarefas);

            else if (opcao == 2)
                listarTarefas(tarefas);

            else if (opcao == 3)
                editarTarefa(tarefas);

            else if (opcao == 4)
                excluirTarefa(tarefas);

            else if (opcao == 5) {
                Thread.sleep(2000);
                System.out.println("Encerrando o programa");
            }
            else
                System.out.println("Opção inválida");

        }while(opcao <= 5 && opcao > 0);
    }

    public static void menu(){
        System.out.println("Gerenciador de tarefas:");
        System.out.println("1 - Cadastrar tarefa");
        System.out.println("2 - Listar tarefas");
        System.out.println("3 - Editar tarefa");
        System.out.println("4 - Excluir tarefa");
        System.out.println("5 - Sair");
    }

    public static void cadastrarTarefa(ArrayList<String> s){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome da tarefa:");
        String nome = sc.nextLine();
        s.add(nome);
    }
    public static void listarTarefas(ArrayList<String> s){
        if(s.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada");
            return;
        }
        int i = 1;
        for(String ss : s){
            System.out.print(i++ + " - ");
            System.out.println(ss);
        }
    }
    public static void editarTarefa(ArrayList<String> s){

    }
    public static void excluirTarefa(ArrayList<String> s){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite qual tarefa deseja excluir:");
        String excluido = sc.nextLine();

        boolean existe = s.contains(excluido);
        if(existe) {
            System.out.println("Item excluido com sucesso!");
            s.remove(excluido);
        }
        else
            System.out.println("Não existe essa tarefa");
    }
}
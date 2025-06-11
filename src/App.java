import java.util.*;

public class App  {
    public static void main(String[] args) throws Exception {
        List<String> nomes = Arrays.asList("João", "Maria", "José", "Ana", "Pedro");
    
        nomes.forEach(nome -> System.out.println("Olá, " + nome + "!"));
    }
}

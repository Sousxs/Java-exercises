import java.util.*;

class Mapa {
    private Map<String, Sala> salas;

    public Mapa() {
        salas = new HashMap<>();
        inicializarSalas();
    }

    private void inicializarSalas() {
       
        // construindo cada sala
        Sala sala1 = new Sala("sala1", "Você está em uma Sala de Aula.");
        Sala sala2 = new Sala("sala2", "Você está em uma Sala de Aula.");
        Sala sala3 = new Sala("sala3", "Você está em uma Sala de Aula.");
        Sala sala4 = new Sala("sala4", "Você está em uma Sala de Aula.");
        Sala sala5 = new Sala("sala5", "Você está em uma Sala de Aula.");

        Sala estacionamento = new Sala("estacionamento", "Você está no estacionamento.");
        Sala secretaria = new Sala("secretaria", "Você está na Secretária.");
        Sala Laboratorio1 = new Sala("Laboratorio1", "Você está em um Laboratorio de Programação.");
        Sala cantina = new Sala("cantina", "Você está na Cantina.");
        Sala area2 = new Sala("area2", "Você está na Área 2.");
        Sala igreja = new Sala("igreja", "Você está na Catedral.");
        
        Sala praca = new Sala("praca", "Você está na Praça");
        Sala rua = new Sala("rua", "Você está na rua da Faculdade.");
        Sala avenida = new Sala("avenida", "Você está na Avenida.");
        
        Sala area3 = new Sala("area3", "Você está na Área 3.");
        Sala area4 = new Sala("area4", "Você está na Área 4.");
        Sala Papelaria = new Sala("Papelaria", "Você ver uma Papelaria.");
        Sala Corredor = new Sala("Corredor", "Você está no Corredor da Área 3.");
        Sala Biblioteca = new Sala("Biblioteca", "Você ver uma Biblioteca.");
        Sala Laboratorio2 = new Sala("Laboratorio2", "Você está em um Laboratorio de Programação.");



        //puzzles
        //Puzzle puzzleBiblioteca = new Puzzle("Uma porta trancada que precisa de uma chave especial.", "Chave Dourada");
        //mapa.getSala("Biblioteca").adicionarPuzzle(puzzleBiblioteca);
        //jogador.tentarResolverPuzzle();


        // definindo as saidas de cada sala
        sala1.setSaida("oeste", estacionamento);
        sala1.setSaida("sul", sala2);
        sala1.setSaida("norte", Laboratorio1);

        sala2.setSaida("norte", sala1);
        sala2.setSaida("sul", sala4);
        sala2.setSaida("leste", sala3);
        sala2.setSaida("oeste", sala5);

        sala3.setSaida("oeste", sala2);

        sala4.setSaida("norte", sala2);

        sala5.setSaida("leste", sala2);

        estacionamento.setSaida("leste", sala1);
        estacionamento.setSaida("norte", area2);

        secretaria.setSaida("oeste", Laboratorio1);

        Laboratorio1.setSaida("norte", cantina);
        Laboratorio1.setSaida("sul", sala1);
        Laboratorio1.setSaida("leste", secretaria);
        Laboratorio1.setSaida("oeste", area2);

        cantina.setSaida("sul", Laboratorio1);
        cantina.setSaida("oeste", igreja);

        area2.setSaida("norte", igreja);
        area2.setSaida("sul", estacionamento);
        area2.setSaida("leste", Laboratorio1);
        area2.setSaida("oeste", avenida);

        igreja.setSaida("leste", cantina);
        igreja.setSaida("oeste", praca);
        igreja.setSaida("sul", area2);

        praca.setSaida("sul", avenida);
        praca.setSaida("leste", igreja);
        praca.setSaida("oeste", area4);

        rua.setSaida("norte", avenida);

        avenida.setSaida("leste", area2);
        avenida.setSaida("oeste", area3);
        avenida.setSaida("norte", praca);
        avenida.setSaida("sul", rua);

        area3.setSaida("norte", area4);
        area3.setSaida("leste", avenida);
        area3.setSaida("oeste", Papelaria);

        area4.setSaida("leste", praca);
        area4.setSaida("sul", area3);

        Papelaria.setSaida("sul", Corredor);
        Papelaria.setSaida("leste", area3);

        Corredor.setSaida("norte", Papelaria);
        Corredor.setSaida("sul", Laboratorio2);
        Corredor.setSaida("oeste", area3);

        Biblioteca.setSaida("leste", Corredor);

        Laboratorio2.setSaida("norte", Corredor);


        //comandos monosilabicos
        sala1.setSaida("o", estacionamento);
        sala1.setSaida("s", sala2);
        sala1.setSaida("n", Laboratorio1);

        sala2.setSaida("n", sala1);
        sala2.setSaida("s", sala4);
        sala2.setSaida("l", sala3);
        sala2.setSaida("o", sala5);

        sala3.setSaida("o", sala2);

        sala4.setSaida("n", sala2);

        sala5.setSaida("l", sala2);

        estacionamento.setSaida("l", sala1);
        estacionamento.setSaida("n", area2);

        secretaria.setSaida("o", Laboratorio1);

        Laboratorio1.setSaida("n", cantina);
        Laboratorio1.setSaida("s", sala1);
        Laboratorio1.setSaida("l", secretaria);
        Laboratorio1.setSaida("o", area2);

        cantina.setSaida("s", Laboratorio1);
        cantina.setSaida("o", igreja);

        area2.setSaida("n", igreja);
        area2.setSaida("s", estacionamento);
        area2.setSaida("l", Laboratorio1);
        area2.setSaida("o", avenida);

        igreja.setSaida("l", cantina);
        igreja.setSaida("o", praca);
        igreja.setSaida("s", area2);

        praca.setSaida("s", avenida);
        praca.setSaida("l", igreja);
        praca.setSaida("o", area4);

        rua.setSaida("n", avenida);

        avenida.setSaida("l", area2);
        avenida.setSaida("o", area3);
        avenida.setSaida("n", praca);
        avenida.setSaida("s", rua);

        area3.setSaida("n", area4);
        area3.setSaida("l", avenida);
        area3.setSaida("o", Papelaria);

        area4.setSaida("l", praca);
        area4.setSaida("s", area3);

        Papelaria.setSaida("s", Corredor);
        Papelaria.setSaida("l", area3);

        Corredor.setSaida("n", Papelaria);
        Corredor.setSaida("s", Laboratorio2);
        Corredor.setSaida("o", area3);

        Biblioteca.setSaida("l", Corredor);

        Laboratorio2.setSaida("n", Corredor);


        
        //colocando os itens nas salas
        sala4.adicionarItem(new Item("Caneta"));
        cantina.adicionarItem(new Item("Cafe"));
        igreja.adicionarItem(new Item("Dinheiro"));
        Papelaria.adicionarItem(new Item("Caderno"));
        Biblioteca.adicionarItem(new Item("Livro"));
        secretaria.adicionarItem(new Item("Carteirinha"));
        secretaria.adicionarItem(new Item("Chave"));
        sala3.adicionarItem(new Item("Atividade 4"));
        sala5.adicionarItem(new Item("Atividade 3"));
        Laboratorio1.adicionarItem(new Item("Atividade 2"));
        Laboratorio2.adicionarItem(new Item("Atividade 1"));

        sala2.setItemNecessario("Chave");

        // colocando as salas no mapa
        salas.put("sala1", sala1);
        salas.put("sala2", sala2);
        salas.put("sala3", sala3);
        salas.put("sala4", sala4);
        salas.put("sala5", sala5);
        salas.put("estacionamento", estacionamento);
        salas.put("secretaria", secretaria);
        salas.put("Laboratorio1", Laboratorio1);
        salas.put("cantina", cantina);
        salas.put("area2", area2);
        salas.put("igreja", igreja);
        salas.put("praca", praca);
        salas.put("rua", rua);
        salas.put("avenida", avenida);
        salas.put("area3", area3);
        salas.put("area4", area4);
        salas.put("Papelaria", Papelaria);
        salas.put("Corredor", Corredor);
        salas.put("Biblioteca", Biblioteca);
        salas.put("Laboratorio2", Laboratorio2);

    }

    public Sala getSalaInicial() {
        return salas.get("avenida");
    }
}

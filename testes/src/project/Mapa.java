package project;

import java.util.*;

class Mapa {
    private Map<String, Sala> salas;

    public Mapa() {
        salas = new HashMap<>();
        inicializarSalas();
    }

    private void inicializarSalas() {
        Sala entrada = new Sala("Entrada", "Você está na entrada do mosteiro.");
        Sala sala1 = new Sala("Biblioteca", "Uma sala cheia de livros empoeirados.");
        Sala sala2 = new Sala("Laboratório", "Há frascos e potes quebrados aqui.");

        entrada.setSaida("norte", sala1);
        
        sala1.setSaida("sul", entrada);
        sala1.setSaida("leste", sala2);
        
        sala2.setSaida("oeste", sala1);

        salas.put("Entrada", entrada);
        salas.put("Biblioteca", sala1);
        salas.put("Laboratório", sala2);
    }

    public Sala getSalaInicial() {
        return salas.get("Entrada");
    }
}

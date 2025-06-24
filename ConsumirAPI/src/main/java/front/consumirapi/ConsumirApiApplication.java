package front.consumirapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import java.util.Arrays;

@SpringBootApplication
public class ConsumirApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumirApiApplication.class, args);

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/produtos";

        Produto novoProduto = new Produto();
        novoProduto.setId(1L);
        novoProduto.setNome("Camiseta");
        novoProduto.setPreco(39.90);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Produto> request = new HttpEntity<>(novoProduto, headers);

            Produto produtoCriado = restTemplate.postForObject(url, request, Produto.class);
            System.out.println("Produto criado: " + produtoCriado);

            Produto[] produtos = restTemplate.getForObject(url, Produto[].class);
            Arrays.stream(produtos).forEach(System.out::println);
        } catch (HttpClientErrorException e) {
            System.out.println("Erro ao consumir API: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}

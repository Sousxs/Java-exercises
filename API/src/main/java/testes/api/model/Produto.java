package testes.api.model;

public class Produto {
    private Long id;
    private String nome;
    private double preco;

    public Produto() {} // Construtor padrão necessário para desserialização

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
}
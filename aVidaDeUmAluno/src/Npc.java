package src;

public class Npc {
    private String nome;
    private String conversa;

    public Npc(String nome, String conversa) {
        this.nome = nome;
        this.conversa = conversa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConversa() {
        return conversa;
    }

    public void setConversa(String conversa) {
        this.conversa = conversa;
    }

    public void Conversar() {
        System.out.println(this.nome + ": " + this.conversa);
    }

}

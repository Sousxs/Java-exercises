import java.util.*;

public class livro {
    String nome;
    autor autor;
    editora editora;

    public livro(String nome, autor autor, editora editora) {
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
    }

    // base de dados de livros presentes no .txt
    public List<livro> carregarLivros(String caminho) {
        return null;
    }

    // método para adicionar um livro à base de dados
    void adicionarLivro(livro livro) {}

    // método para remover um livro da base de dados
    void removerLivro(String nome) {}

    // método para pesquisar um livro na base de dados
    public livro pesquisarLivro(String nome) {
        return null;
    }

    // método para listar todos os livros na base de dados
    public List<livro> listarLivros() {
        return new ArrayList<>();
    }


}
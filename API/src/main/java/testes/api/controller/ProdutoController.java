package testes.api.controller;

import org.springframework.web.bind.annotation.*;
import testes.api.model.Produto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>();

    @GetMapping
    public List<Produto> listar() {
        return produtos;
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto) {
        produtos.add(produto);
        return produto;
    }
}
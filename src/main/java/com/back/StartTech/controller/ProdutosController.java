package com.back.StartTech.controller;

import com.back.StartTech.entity.Produtos;
import com.back.StartTech.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    ProdutosService produtosService;

    // CRUD

    @GetMapping
     public List<Produtos> getProdutos() {
        return produtosService.getProdutos();
     }

     @GetMapping("/{id}")
     public Optional<Produtos> getProdutosById(@PathVariable long id) {
        return produtosService.getProdutosByID(id);
     }

     @GetMapping("/nome/{name}")
     public Produtos getProdutosByName(@PathVariable String name) {
        return produtosService.getProdutosByName(name);
     }

     @PostMapping
     public Produtos createProdutos(@RequestBody Produtos produtos) {
        return produtosService.createProdutos(produtos);
     }

     @PutMapping("/{id}")
     public Produtos updateProdutos(@PathVariable long id, @RequestBody Produtos produtos) {
        return produtosService.updateProdutos(id, produtos);
     }

     @DeleteMapping("/{id}")
     public void deleteProdutos(@PathVariable long id) {
        produtosService.deleteProdutosById(id);
     }
}
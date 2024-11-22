package com.back.StartTech.service;

import com.back.StartTech.entity.Produtos;
import com.back.StartTech.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {
    @Autowired
    ProdutosRepository produtosRepository;

    public List<Produtos> getProdutos() {
        return produtosRepository.findAll();
    }

    public Optional<Produtos> getProdutosByID(long id) {
        return produtosRepository.findById(id);
    }

    public Produtos getProdutosByName(String name) {
        return produtosRepository.findByNomeProdutos(name);
    }

    public Produtos createProdutos(Produtos produtos) {
        return produtosRepository.save(produtos);
    }

    public void deleteProdutosById(long id) {
        produtosRepository.deleteById(id);
    }

    public Produtos updateProdutos(long id, Produtos produtos) {
        Optional<Produtos> produtoExistente = produtosRepository.findById(id);
        if (produtoExistente.isEmpty()) throw new RuntimeException("Produto não criado id: " + id);

        Produtos produtoAlterado = produtoExistente.get();
        produtoAlterado.setNomeProdutos(produtos.getNomeProdutos());
        produtoAlterado.setDescricaoProdutos(produtos.getDescricaoProdutos());
        produtoAlterado.setPrecoProduto(produtos.getPrecoProduto());
        produtoAlterado.setQuantidadeProdutos(produtos.getQuantidadeProdutos());
        produtoAlterado.setCategoria(produtos.getCategoria());

        return produtosRepository.save(produtoAlterado);
    }
}

package com.back.StartTech.service;
import com.back.StartTech.entity.Carrinho;
import com.back.StartTech.entity.Produtos;
import com.back.StartTech.repository.CarrinhoRepository;
import com.back.StartTech.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {
    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ProdutosRepository produtosRepository;

    public Carrinho obterCarrinho(Long id) {
        return carrinhoRepository.findById(id).orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
    }

    public Carrinho adicionarItem(Long carrinhoId, Long produtoId, Integer quantidade) {
        Carrinho carrinho = obterCarrinho(carrinhoId);
        Produtos produto = produtosRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (produto.getQuantidadeProdutos() < quantidade) {
            throw new RuntimeException("Estoque insuficiente");
        }

        carrinho.adicionarItem(produto, quantidade);
        produto.setQuantidadeProdutos(produto.getQuantidadeProdutos() - quantidade);
        produtosRepository.save(produto);
        return carrinhoRepository.save(carrinho);
    }

    public Carrinho removerItem(Long carrinhoId, Long produtoId) {
        Carrinho carrinho = obterCarrinho(carrinhoId);
        Produtos produto = produtosRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        carrinho.removerItem(produtoId);
        produto.setQuantidadeProdutos(produto.getQuantidadeProdutos() + 1); // Ajuste o estoque
        produtosRepository.save(produto);
        return carrinhoRepository.save(carrinho);
    }

    public Double obterValorTotal(Long carrinhoId) {
        Carrinho carrinho = obterCarrinho(carrinhoId);
        return carrinho.getValorTotal();
    }

    public Carrinho listarItens(Long carrinhoId) {
        return obterCarrinho(carrinhoId);
    }
}

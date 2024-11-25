package com.back.StartTech.entity;
import com.back.StartTech.entity.Produtos;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemCarrinho> itens = new ArrayList<>();

    public Double getValorTotal() {
        return itens.stream()
                .mapToDouble(ItemCarrinho::getTotal)
                .sum();
    }

    public void adicionarItem(Produtos produto, Integer quantidade) {
        for (ItemCarrinho item : itens) {
            if (item.getProdutos().getId() == (produto.getId())) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                return;
            }
        }
        ItemCarrinho novoItem = new ItemCarrinho();
        novoItem.setProduto(produto);
        novoItem.setQuantidade(quantidade);
        itens.add(novoItem);
    }

    public void removerItem(Long produtoId) {
        itens.removeIf(item -> item.getProdutos().getId() == (produtoId));
    }
}

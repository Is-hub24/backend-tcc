package com.back.StartTech.entity;
import com.back.StartTech.entity.Produtos;
import jakarta.persistence.*;

@Entity
public class ItemCarrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produtos produto;

    private Integer quantidade;

    public Produtos getProdutos() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getTotal() {
        return produto.getPrecoProduto() * quantidade;
    }
}

package com.back.StartTech.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProdutos;

    private String nomeProdutos;
    private String descricaoProdutos ;
    private int quantidadeProdutos;
    private double precoProdutos;
    private String categoriaProdutos;

    public String getNomeProdutos() {
        return nomeProdutos;
    }

    public void setNomeProdutos(String nomeProdutos) {
        this.nomeProdutos = nomeProdutos;
    }

    public long getId() {
        return idProdutos;
    }

    public void setId(long id) {
        this.idProdutos = id;
    }

    public String getDescricaoProdutos() {
        return descricaoProdutos;
    }

    public void setDescricaoProdutos(String descricaoProdutos) {
        this.descricaoProdutos = descricaoProdutos;
    }

    public int getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    public void setQuantidadeProdutos(int quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }

    public double getPrecoProduto() {
        return precoProdutos;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProdutos = precoProduto;
    }

    public String getCategoria() {
        return categoriaProdutos;
    }

    public void setCategoria(String categoria) {
        this.categoriaProdutos = categoria;
    }
}

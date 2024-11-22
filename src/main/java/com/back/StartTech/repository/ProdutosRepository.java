package com.back.StartTech.repository;

import com.back.StartTech.entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
    public Produtos findByNomeProdutos(String name);
}

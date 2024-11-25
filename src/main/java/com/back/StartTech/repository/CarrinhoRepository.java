package com.back.StartTech.repository;

import com.back.StartTech.entity.Carrinho;
import com.back.StartTech.entity.Produtos;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
    public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    }


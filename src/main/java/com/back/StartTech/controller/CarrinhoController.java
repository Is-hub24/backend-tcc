package com.back.StartTech.controller;
import com.back.StartTech.entity.Carrinho;
import com.back.StartTech.service.CarrinhoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @PostMapping("/adicionar")
    public String adicionarItem(@RequestParam Long carrinhoId, @RequestParam Long produtoId, @RequestParam Integer quantidade) {
        carrinhoService.adicionarItem(carrinhoId, produtoId, quantidade);
        return "Item adicionado ao carrinho.";
    }

    @GetMapping("/listar")
    public Carrinho listarItens(@RequestParam Long carrinhoId) {
        return carrinhoService.listarItens(carrinhoId);
    }

    @DeleteMapping("/remover")
    public String removerItem(@RequestParam Long carrinhoId, @RequestParam Long produtoId) {
        carrinhoService.removerItem(carrinhoId, produtoId);
        return "Item removido do carrinho.";
    }

    @GetMapping("/total")
    public Double obterValorTotal(@RequestParam Long carrinhoId) {
        return carrinhoService.obterValorTotal(carrinhoId);
    }
}

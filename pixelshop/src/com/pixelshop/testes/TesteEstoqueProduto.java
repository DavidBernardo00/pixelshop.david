package com.pixelshop.testes;

import com.pixelshop.modelo.Produto;

public class TesteEstoqueProduto {

    public static void main(String[] args) {

        System.out.println("=== TESTE DE OPERAÇÕES DE ESTOQUE ===\n");

        Produto p = new Produto("Headset Gamer", 349.90, 20);

        System.out.println("Produto: " + p.getNome() 
            + " | Preço: R$ " + p.getPreco() 
            + " | Estoque inicial: " + p.getQuantidadeEstoque());

        // Teste: adicionar estoque (sucesso)
        System.out.println("\n--- Adicionar 10 unidades ---");
        p.adicionarEstoque(10);
        System.out.println("Estoque atual: " + p.getQuantidadeEstoque());

        // Teste: adicionar estoque (falha — valor zero ou negativo)
        System.out.println("\n--- Tentar adicionar 0 unidades ---");
        p.adicionarEstoque(0);
        System.out.println("Estoque atual: " + p.getQuantidadeEstoque());

        System.out.println("\n--- Tentar adicionar -5 unidades ---");
        p.adicionarEstoque(-5);
        System.out.println("Estoque atual: " + p.getQuantidadeEstoque());

        // Teste: remover estoque (sucesso)
        System.out.println("\n--- Remover 8 unidades ---");
        p.removerEstoque(8);
        System.out.println("Estoque atual: " + p.getQuantidadeEstoque());

        // Teste: remover estoque (falha — saldo insuficiente)
        System.out.println("\n--- Tentar remover 100 unidades (saldo insuficiente) ---");
        p.removerEstoque(100);
        System.out.println("Estoque atual: " + p.getQuantidadeEstoque());

        // Teste: remover estoque (falha — valor negativo)
        System.out.println("\n--- Tentar remover -3 unidades ---");
        p.removerEstoque(-3);
        System.out.println("Estoque atual: " + p.getQuantidadeEstoque());

        // Teste: setter de preço válido e inválido
        System.out.println("\n--- Alterar preço para R$ 399.90 ---");
        p.setPreco(399.90);
        System.out.println("Preço atual: R$ " + p.getPreco());

        System.out.println("\n--- Tentar alterar preço para R$ 0.00 ---");
        p.setPreco(0.0);
        System.out.println("Preço atual: R$ " + p.getPreco());

        // Teste: setQuantidadeEstoque
        System.out.println("\n--- Alterar estoque diretamente para 50 ---");
        p.setQuantidadeEstoque(50);
        System.out.println("Estoque atual: " + p.getQuantidadeEstoque());

        System.out.println("\n--- Tentar setar estoque para -10 ---");
        p.setQuantidadeEstoque(-10);
        System.out.println("Estoque atual: " + p.getQuantidadeEstoque());

        System.out.println("\n=== FIM DOS TESTES ===");
    }
}

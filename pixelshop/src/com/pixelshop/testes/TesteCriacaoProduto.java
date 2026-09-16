package com.pixelshop.testes;

import com.pixelshop.modelo.Produto;

public class TesteCriacaoProduto {

    public static void main(String[] args) {

        System.out.println("=== TESTE DE CRIAÇÃO DE PRODUTOS ===\n");

        // Instancia dois produtos diferentes
        Produto p1 = new Produto("Controle sem Fio", 249.90, 30);
        Produto p2 = new Produto("Jogo RPG", 199.90, 15);

        // Exibe dados iniciais
        System.out.println("--- Dados Iniciais ---");
        System.out.println("Produto 1: " + p1.getNome() 
            + " | Preço: R$ " + p1.getPreco() 
            + " | Estoque: " + p1.getQuantidadeEstoque());
        System.out.println("Produto 2: " + p2.getNome() 
            + " | Preço: R$ " + p2.getPreco() 
            + " | Estoque: " + p2.getQuantidadeEstoque());

        // Altera preço do primeiro produto usando setter validado
        System.out.println("\n--- Alterando preço do Controle sem Fio ---");
        boolean alterou = p1.setPreco(279.90);
        System.out.println("Preço alterado? " + alterou);

        // Tenta alterar para preço inválido
        System.out.println("\n--- Tentando preço inválido (-50.0) ---");
        alterou = p1.setPreco(-50.0);
        System.out.println("Preço alterado? " + alterou);

        // Exibe dados finais
        System.out.println("\n--- Dados Finais ---");
        System.out.println("Produto 1: " + p1.getNome() 
            + " | Preço: R$ " + p1.getPreco() 
            + " | Estoque: " + p1.getQuantidadeEstoque());
        System.out.println("Produto 2: " + p2.getNome() 
            + " | Preço: R$ " + p2.getPreco() 
            + " | Estoque: " + p2.getQuantidadeEstoque());

        // Teste com valores negativos no construtor
        System.out.println("\n--- Teste: Construtor com valores negativos ---");
        Produto p3 = new Produto("Produto Inválido", -100.0, -5);
        System.out.println("Produto 3: " + p3.getNome() 
            + " | Preço: R$ " + p3.getPreco() 
            + " | Estoque: " + p3.getQuantidadeEstoque());
    }
}

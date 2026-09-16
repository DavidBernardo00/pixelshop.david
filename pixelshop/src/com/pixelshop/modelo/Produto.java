package com.pixelshop.modelo;

public class Produto {

    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;

        if (preco < 0) {
            this.preco = 0.0;
            System.out.println("[AVISO] Preço negativo informado. Atribuído 0.0.");
        } else {
            this.preco = preco;
        }

        if (quantidadeEstoque < 0) {
            this.quantidadeEstoque = 0;
            System.out.println("[AVISO] Estoque negativo informado. Atribuído 0.");
        } else {
            this.quantidadeEstoque = quantidadeEstoque;
        }
    }

    // --- Getters ---

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    // --- Setters com validação ---

    public boolean setPreco(double preco) {
        if (preco > 0) {
            this.preco = preco;
            return true;
        } else {
            System.out.println("[ERRO] Preço deve ser maior que zero. Operação cancelada.");
            return false;
        }
    }

    public boolean setQuantidadeEstoque(int qtd) {
        if (qtd >= 0) {
            this.quantidadeEstoque = qtd;
            return true;
        } else {
            System.out.println("[ERRO] Estoque não pode ser negativo. Operação cancelada.");
            return false;
        }
    }

    // --- Métodos operacionais ---

    public boolean adicionarEstoque(int qtd) {
        if (qtd > 0) {
            this.quantidadeEstoque += qtd;
            System.out.println("[OK] " + qtd + " unidades adicionadas ao estoque de " + nome + ".");
            return true;
        } else {
            System.out.println("[ERRO] Quantidade deve ser maior que zero para adição.");
            return false;
        }
    }

    public boolean removerEstoque(int qtd) {
        if (qtd <= 0) {
            System.out.println("[ERRO] Quantidade deve ser maior que zero para remoção.");
            return false;
        }

        if (qtd <= this.quantidadeEstoque) {
            this.quantidadeEstoque -= qtd;
            System.out.println("[OK] " + qtd + " unidades removidas do estoque de " + nome + ".");
            return true;
        } else {
            System.out.println("[ERRO] Saldo insuficiente. Estoque atual: " 
                + this.quantidadeEstoque + " | Tentativa de remover: " + qtd + ".");
            return false;
        }
    }
}

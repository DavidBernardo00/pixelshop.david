package com.pixelshop;

import com.pixelshop.modelo.Produto;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Produto produto1 = null;
        Produto produto2 = null;

        int opcao;

        do {
            System.out.println("\n========== PixelShop - Menu ==========");
            System.out.println("1 - Cadastrar novo produto");
            System.out.println("2 - Consultar dados e valor total em estoque");
            System.out.println("3 - Realizar entrada (adição) de estoque");
            System.out.println("4 - Realizar saída (remoção) de estoque");
            System.out.println("5 - Alterar preço de um produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpa buffer

            switch (opcao) {

                case 1: // Cadastrar
                    if (produto1 != null && produto2 != null) {
                        System.out.println("[!] Limite de 2 produtos já cadastrados.");
                        break;
                    }

                    System.out.print("Nome do produto: ");
                    String nome = sc.nextLine();
                    System.out.print("Preço: R$ ");
                    double preco = sc.nextDouble();
                    System.out.print("Quantidade em estoque: ");
                    int qtd = sc.nextInt();
                    sc.nextLine();

                    Produto novo = new Produto(nome, preco, qtd);

                    if (produto1 == null) {
                        produto1 = novo;
                        System.out.println("[OK] Produto cadastrado no slot 1.");
                    } else {
                        produto2 = novo;
                        System.out.println("[OK] Produto cadastrado no slot 2.");
                    }
                    break;

                case 2: // Consultar
                    if (produto1 == null && produto2 == null) {
                        System.out.println("[!] Nenhum produto cadastrado.");
                        break;
                    }

                    System.out.println("\n--- Consulta de Produtos ---");
                    consultarProduto(produto1, "Slot 1");
                    consultarProduto(produto2, "Slot 2");
                    break;

                case 3: // Entrada de estoque
                    if (produto1 == null && produto2 == null) {
                        System.out.println("[!] Nenhum produto cadastrado.");
                        break;
                    }

                    Produto alvo = selecionarProduto(sc, produto1, produto2);
                    if (alvo == null) break;

                    System.out.print("Quantidade a adicionar: ");
                    int addQtd = sc.nextInt();
                    sc.nextLine();
                    alvo.adicionarEstoque(addQtd);
                    break;

                case 4: // Saída de estoque
                    if (produto1 == null && produto2 == null) {
                        System.out.println("[!] Nenhum produto cadastrado.");
                        break;
                    }

                    alvo = selecionarProduto(sc, produto1, produto2);
                    if (alvo == null) break;

                    System.out.print("Quantidade a remover: ");
                    int remQtd = sc.nextInt();
                    sc.nextLine();
                    alvo.removerEstoque(remQtd);
                    break;

                case 5: // Alterar preço
                    if (produto1 == null && produto2 == null) {
                        System.out.println("[!] Nenhum produto cadastrado.");
                        break;
                    }

                    alvo = selecionarProduto(sc, produto1, produto2);
                    if (alvo == null) break;

                    System.out.print("Novo preço: R$ ");
                    double novoPreco = sc.nextDouble();
                    sc.nextLine();
                    alvo.setPreco(novoPreco);
                    break;

                case 0:
                    System.out.println("Encerrando PixelShop. Até mais!");
                    break;

                default:
                    System.out.println("[!] Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }

    // --- Métodos auxiliares ---

    private static void consultarProduto(Produto p, String slot) {
        if (p == null) {
            System.out.println(slot + ": [vazio]");
        } else {
            double valorTotal = p.getPreco() * p.getQuantidadeEstoque();
            System.out.println(slot + ": " + p.getNome()
                + " | Preço: R$ " + String.format("%.2f", p.getPreco())
                + " | Estoque: " + p.getQuantidadeEstoque()
                + " | Valor total: R$ " + String.format("%.2f", valorTotal));
        }
    }

    private static Produto selecionarProduto(Scanner sc, Produto p1, Produto p2) {
        System.out.println("\nQual produto?");
        if (p1 != null) {
            System.out.println("1 - " + p1.getNome());
        }
        if (p2 != null) {
            System.out.println("2 - " + p2.getNome());
        }
        System.out.print("Escolha: ");
        int escolha = sc.nextInt();
        sc.nextLine();

        if (escolha == 1 && p1 != null) {
            return p1;
        } else if (escolha == 2 && p2 != null) {
            return p2;
        } else {
            System.out.println("[!] Opção inválida.");
            return null;
        }
    }
}

package domain.services;

import java.util.List;
import java.util.Scanner;

import core.Empresa;
import domain.Produto;
import domain.Usuario;
import domain.Venda;

public class UsuarioService {
    
    public static void opcoesUsuario(){
        System.out.println("1 - Relizar Compras");
        System.out.println("2 - Ver Compras");
        System.out.println("0 - Deslogar");
    }



    public static Integer escolherEmpresa(List<Empresa> empresas, Scanner sc){
        System.out.println("Para realizar uma compra, escolha a empresa onde deseja comprar: ");
        empresas.stream().forEach(x -> {
            System.out.println(x.getId() + " - " + x.getNome());
        });
        Integer escolhaEmpresa = sc.nextInt();
        return escolhaEmpresa;
    }

    public static List<Produto> escolherProdutos(List<Produto> carrinho, List<Produto> produtos , Integer escolhaEmpresa, Scanner sc){
        Integer escolhaProduto = -1;
        Empresa[] empresaAtual = {null};
		do {
			System.out.println("Escolha os seus produtos: ");
			produtos.stream().forEach(x -> {
                if (x.getEmpresa().getId().equals(escolhaEmpresa)) {
                    empresaAtual[0] = x.getEmpresa();
                    System.out.println(x.getId() + " - " + x.getNome());
                }
			});
			System.out.println("0 - Finalizar compra");
			escolhaProduto = sc.nextInt();

			for (Produto produtoSearch : produtos) {
				if (produtoSearch.getId().equals(escolhaProduto) && produtoSearch.getEmpresa().comparador(empresaAtual[0]))
					carrinho.add(produtoSearch);
			}

		} while (escolhaProduto != 0);
        return carrinho;
    }

    public static void resumoCompra(List<Produto> carrinho, Integer escolhaEmpresa){
        System.out.println("************************************************************");
        System.out.println("Resumo da compra: ");
        carrinho.stream().forEach(x -> {
            if (x.getEmpresa().getId().equals(escolhaEmpresa)) {
                System.out.println(x.getId() + " - " + x.getNome() + "    R$" + x.getPreco());
            }
        });

    }

    public static void consultarCompras(List<Venda> vendas, Usuario usuarioLogado){
        System.out.println();
		System.out.println("************************************************************");
		System.out.println("COMPRAS EFETUADAS");
		vendas.stream().forEach(venda -> {
			if (venda.getCliente().getUsername().equals(usuarioLogado.getUsername())) {
				System.out.println("************************************************************");
				System.out.println("Compra de código: " + venda.getCódigo() + " na empresa "+ venda.getEmpresa().getNome() + ": ");
					venda.getItens().stream().forEach(x -> {
					System.out.println(x.getId() + " - " + x.getNome() + "    R$" + x.getPreco());
				});
            System.out.println(venda);
		    System.out.println("************************************************************");
		    }

	    });
    }
}

package domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import core.Empresa;
import domain.Produto;
import domain.Usuario;
import domain.Venda;

public class UsuarioService {
    
    /**
     * Lista as opcoes do usuario
     */
    public static void opcoesUsuario(){
        System.out.println("1 - Relizar Compras");
        System.out.println("2 - Ver Compras");
        System.out.println("0 - Deslogar");
    }


    /**
     * Funcao para escolher o id da empresa
     * @param empresas
     * @param sc
     * @return id da empresa escolhida
     */
    public static Integer escolherEmpresa(List<Empresa> empresas, Scanner sc){
        System.out.println("Para realizar uma compra, escolha a empresa onde deseja comprar: ");
        empresas.stream().forEach(x -> {
            System.out.println(x.getId() + " - " + x.getNome());
        });
        Integer escolhaEmpresa = sc.nextInt();
        return escolhaEmpresa;
    }

    /**
     * Funcao para a escolha de produtos
     * 
     * @param carrinho
     * @param produtos
     * @param escolhaEmpresa
     * @param sc
     * @return Lista com carrinho (indice 0) e produtos (indice 1)
     */
    public static List<List<Produto>> escolherProdutos(List<Produto> carrinho, List<Produto> produtos , Integer escolhaEmpresa, Scanner sc){
        List<List<Produto>> listaFinal = new ArrayList<>();
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
                    if(produtoSearch.getQuantidade() > 0){
                        carrinho.add(produtoSearch);
                        produtoSearch.setQuantidade(produtoSearch.getQuantidade() -1);
                    }
					else{
                        System.out.println("Produto esgotado!");
                    }
			}

		} while (escolhaProduto != 0);
        listaFinal.add(carrinho);
        listaFinal.add(produtos);
        return listaFinal;
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

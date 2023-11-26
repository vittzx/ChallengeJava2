package domain.services;

import java.util.List;

import core.Empresa;
import domain.Produto;
import domain.Usuario;
import domain.Venda;

public class AdminService {
    
    public static void opcoesAdmin(){
        System.out.println("1 - Listar vendas");
        System.out.println("2 - Consultar Saldos das Empresas");
        System.out.println("3 - Ver produtos");
        System.out.println("0 - Deslogar");
    }


    public static void listarVendasAdmin(Usuario usuarioLogado, List<Venda> vendas, List<Empresa> empresas){
        System.out.println();
        System.out.println("************************************************************");
        System.out.println("VENDAS EFETUADAS");
        if(vendas.size() > 0){
            vendas.stream().forEach(venda -> {
            System.out.println("************************************************************");
            System.out.println("Venda realizada na empresa: "+ venda.getEmpresa().getNome());
            System.out.println("Venda de código: " + venda.getCódigo() + " no CPF "+ venda.getCliente().getCpf() + ": ");
            venda.getItens().stream().forEach(x -> {
                System.out.println(x.getId() + " - " + x.getNome() + "    R$" + x.getPreco());
            });
            System.out.println("Total Venda: R$" + venda.getValor());
            System.out.println("Total Taxa a ser paga: R$" + venda.getComissaoSistema());
            System.out.println("************************************************************");
            });
        }
        System.out.println("************************************************************");
    }


    public static void consultarSaldosEmpresas(List<Empresa> empresas) {
        System.out.println("************************************************************");
        System.out.println("SALDOS DAS EMPRESAS");
        empresas.stream().forEach(empresa -> {
            System.out.println("************************************************************");
            System.out.println("Empresa: " + empresa.getNome());
            System.out.println("CNPJ: " + empresa.getCnpj());
            System.out.println("Saldo: " + empresa.getSaldo());
            System.out.println("Taxa sobre o produto: " + empresa.getTaxa() * 100 +  "%");

        });

        System.out.println("************************************************************");
    }


    public static void listarProdutos(List<Produto> produtos) {
        System.out.println("************************************************************");
        System.out.println("Produtos disponiveis");
        produtos.stream().forEach(produto -> {
            System.out.println("************************************************************");
            System.out.println("Empresa responsavel do produto: " + produto.getEmpresa().getNome());
             System.out.println("Produto: " + produto.getNome());
            if(produto.getQuantidade() == 0){
                System.out.println("Produto: " + produto.getNome());
                System.out.println("STATUS: ESGOTADO");
            }else{
                System.out.println("STATUS: DISPONIVEL");
                System.out.println("Quantidade: "+  produto.getQuantidade());
            }
        });

    }


    

}

package core.regrasDeNegocio;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import core.Cliente;
import core.Empresa;
import core.services.EmpresaService;
import domain.Produto;
import domain.Usuario;
import domain.Venda;
import domain.services.AdminService;
import domain.services.UsuarioService;

public class RegraDeNegocio {
    	public static void executar(List<Usuario> usuarios, List<Cliente> clientes, List<Empresa> empresas,
			List<Produto> produtos, List<Produto> carrinho, List<Venda> vendas) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com seu usuário e senha:");
		System.out.print("Usuário: ");
		String username = sc.next();
		System.out.print("Senha: ");
		String senha = sc.next();
		

		List<Usuario> usuariosSearch = usuarios.stream().filter(x -> x.getUsername().equals(username))
				.collect(Collectors.toList());
		if (usuariosSearch.size() > 0) {
			Usuario usuarioLogado = usuariosSearch.get(0);
			if ((usuarioLogado.getSenha().equals(senha))) {

				System.out.println("Escolha uma opção para iniciar");
				if (usuarioLogado.IsEmpresa()) {
                    EmpresaService.opcoesUsuarioEmpresa();

					Integer escolha = sc.nextInt();

					switch (escolha) {
					case 1: {
                        EmpresaService.listarVendas(usuarioLogado, vendas);
						executar(usuarios, clientes, empresas, produtos, carrinho, vendas);
                        break;
					}
					case 2: {
                        EmpresaService.verProdutos(usuarioLogado, produtos);
						executar(usuarios, clientes, empresas, produtos, carrinho, vendas);
                        break;
					}
					case 0: {
						executar(usuarios, clientes, empresas, produtos, carrinho, vendas);
                        break;

					    }
                    default:
                        System.out.println("Opcao invalida");
                        executar(usuarios, clientes, empresas, produtos, carrinho, vendas);
                        break;
					}

				} 
                
                else if(usuarioLogado.IsAdmin()){
                    AdminService.opcoesAdmin();
                    Integer escolha = sc.nextInt();

                    switch ((escolha)) {
                        case 1:
                            AdminService.listarVendasAdmin(usuarioLogado, vendas, empresas);
                            executar(usuarios, clientes, empresas, produtos, carrinho, vendas);
                            break;
                        case 2:
                            AdminService.consultarSaldosEmpresas(empresas);
                            executar(usuarios, clientes, empresas, produtos, carrinho, vendas);
                            break;

                        case 3:
                            AdminService.listarProdutos(produtos);
                            executar(usuarios, clientes, empresas, produtos, carrinho, vendas);
                            break;
                    
                        default:
                            break;
                    }

                }
                else {
                    UsuarioService.opcoesUsuario();

					Integer escolha = sc.nextInt();
					switch (escolha) {
					case 1: {
						Integer escolhaEmpresa = UsuarioService.escolherEmpresa(empresas, sc);
                        List<List<Produto>> listaFinal = UsuarioService.escolherProdutos(carrinho, produtos, escolhaEmpresa, sc);
                        carrinho = listaFinal.get(0);
                        produtos = listaFinal.get(1);

                        UsuarioService.resumoCompra(carrinho, escolhaEmpresa);

						Empresa empresaEscolhida = empresas.stream().filter(x -> x.getId().equals(escolhaEmpresa))
								.collect(Collectors.toList()).get(0);

						Cliente clienteLogado = clientes.stream()
								.filter(x -> x.getUsername().equals(usuarioLogado.getUsername()))
								.collect(Collectors.toList()).get(0);

						Venda venda = criarVenda(carrinho, empresaEscolhida, clienteLogado, vendas);
						System.out.println(venda);
						System.out.println("************************************************************");
						carrinho.clear();
						executar(usuarios, clientes, empresas, produtos, carrinho, vendas);
                        break;
					}
					case 2: {
                        UsuarioService.consultarCompras(vendas, usuarioLogado);
						executar(usuarios, clientes, empresas, produtos, carrinho, vendas);
                        break;
					}
					case 0: {
						executar(usuarios, clientes, empresas, produtos, carrinho, vendas);
                        break;

					}
                    default: 
                        System.out.println("Opcao invalida");
                        executar(usuarios, clientes, empresas, produtos, carrinho, vendas);
                        break;
					

					}
				}

			} else
				System.out.println("Senha incorreta");
                executar(usuarios, clientes, empresas, produtos, carrinho, vendas);
		} else {
			System.out.println("Usuário não encontrado");
            executar(usuarios, clientes, empresas, produtos, carrinho, vendas);
		}
        sc.close();
	}

	public static Venda criarVenda(List<Produto> carrinho, Empresa empresa, Cliente cliente, List<Venda> vendas) {
		Double total = carrinho.stream().mapToDouble(Produto::getPreco).sum();
		Double comissaoSistema = total * empresa.getTaxa();
		int idVenda = vendas.isEmpty() ? 1 : vendas.get(vendas.size() - 1).getCódigo() + 1;
		Venda venda = new Venda(idVenda, carrinho.stream().toList(), total, comissaoSistema, empresa, cliente);
		empresa.setSaldo(empresa.getSaldo() + total* (1- empresa.getTaxa()));
		vendas.add(venda);
		return venda;
	}


}

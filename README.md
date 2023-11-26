# Erros encontrados.

-> Ao iniciar o programa, as regras de negocio estão no programa Main, que isso dificulta caso a manutenibilidade do codigo caso seja necessario


-> Outro erro, ao ver as tag do tipo CASE do executar, estao sem o break; no final
    STATUS: CORRIGIDO

-> Scanner nunca fechado no executar.
    colocar sc.close no final da funcao executar
    STATUS: CORRIGIDO
-> Compras não tem comissão de taxa para as empresas.
    STATUS: CORRIGIDO

OBS: Para todas as regras de negocio, o correto seria a criação de uma interface e criar uma classe para cada regra de negocio, para facilitar a 
    manutenibilidade.

-> Erro na regra de negocio: O saldo da empresa deve ser alterado já refletindo as taxas
   No relatorio de vendas da empresa, o saldo nao vem com a taxa imbutida.
   Corrigido no metodo 'criarVenda' na 'empresa.setSaldo()' linha 182, adicionando taxa da empresa no valor total da venda.
   STATUS: Corrigido

-> Erro na regra de negocio: A empresa deve vender apenas produtos que ela esteja relacionada
                             O codigo estava com um erro de verificacao, para isso a solucao é verificar se a empresa atual é a mesma que está vendendo o produto.
                             STATUS: Corrigido

-> Erro funcionamento estoque: O estoque das empresas nao estava sendo diminuido apos cada compra 
                                O Codigo nao diminuia o estoque, para isso a solucao foi fazer o setQuantidade(getQuantidade -1) ENQUANTO o estoque do produto seja > 0
                                STATUS: Corrigido

-> Tratamento de erro: Opcao Invalida
                        Caso o usuario digite uma opcao invalida, voltara a tela inicial.
                        OBS: Nao é a melhor opcao para tratar o erro de opcao invalida, o correto é redirecionar o usuario para a tela que ele ja estava, 
                        Ex: Se o usuario tivesse na tela de efetuar uma compra e digita o id do produto errado, o correto é lançar a excessão e voltar a para a
                            tela de efetuar compra sem perder seu histórico
                            STATUS:  Não corrigido

-> Implementação Admin: 
                    Foi implementado para o usuario login listar todas as vendas, consultar os saldos das empresas, ver todos os produtos alem de realizar compras
                    STATUS: Implementado

Refatorando Codigo: Criado a pasta services para referir-se a todos os servicoes das entidades presentes no codigo.
                    Cases que estavam com muitas informações agora são funções nas classes Service.
                    Classes Services Presentes| UsuarioService, EmpresaService.
                    

Sugestão: Manter o usuario logado apos realizar a compra, pois se a cada compra ele for obrigado a cadastrar-se novamente pode 
          prejudicar a experiencia do usuario.
          Para a solucao disso, seria ideal guardar o ultimo usuario e colocar uma opcao de 'deseja continuar com o mesmo\n1- sim\2-nao3-sair'
          e assim verifica se ele deseja manter o mesmo, alterar ou ate mesmo sair do sistema.
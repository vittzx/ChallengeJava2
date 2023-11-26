# Erros encontrados.

-> Ao iniciar o programa, as regras de negocio estão no programa Main, que isso dificulta caso a manutenibilidade do codigo caso seja necessario


-> Outro erro, ao ver as tag do tipo CASE do executar, estao sem o break; no final
-> Scanner nunca fechado no executar.
-> Compras não tem comissão de taxa para as empresas.

OBS: Para todas as regras de negocio, o correto seria a criação de uma interface e criar uma classe para cada regra de negocio, para facilitar a 
    manutenibilidade.

-> Erro na regra de negocio: O saldo da empresa deve ser alterado já refletindo as taxas
   No relatorio de vendas da empresa, o saldo nao vem com a taxa imbutida.
   Corrigido no metodo 'criarVenda' na 'empresa.setSaldo()' linha 182, adicionando taxa da empresa no valor total da venda.

-> Tratamento de erro: Opcao Invalida
                        Caso o usuario digite uma opcao invalida, voltara a tela inicial.
                        OBS: Nao é a melhor opcao para tratar o erro de opcao invalida, o correto é redirecionar o usuario para a tela que ele ja estava, 
                        Ex: Se o usuario tivesse na tela de efetuar uma compra e digita o id do produto errado, o correto é lançar a excessão e voltar a para a
                            tela de efetuar compra sem perder seu histórico



Sugestão: Manter o usuario logado apos realizar a compra, pois se a cada compra ele for obrigado a cadastrar-se novamente pode 
          prejudicar a experiencia do usuario.
          Para a solucao disso, seria ideal guardar o ultimo usuario e colocar uma opcao de 'deseja continuar com o mesmo\n1- sim\2-nao3-sair'
          e assim verifica se ele deseja manter o mesmo, alterar ou ate mesmo sair do sistema.
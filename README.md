# Erros encontrados.

-> Erro, ao ver as tag do tipo CASE do executar, estao sem o break; no final
    STATUS: CORRIGIDO

-> Scanner nunca fechado no executar.
    colocar sc.close no final da funcao executar
    STATUS: CORRIGIDO

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

# NOVAS IMPLEMENTAÇÕES


-> Implementação Admin: 
                    Foi implementado para o usuario login listar todas as vendas, consultar os saldos das empresas, ver todos os produtos alem de realizar compras
                    STATUS: Implementado

-> Impletação Ultimo usuario:
                    A Ideia é colocar uma nova feature no login, para que o segundo login no sistemas e seus sucessores, o usuario possa reaproveitar o login antigo para nao precisar logar novamente. 
                    A Logica do login esta quase feita, resta porem esta dando um erro de logica.
                    OBS: O codigo a ser implementado esta comentado no inicio da funcao executar na classe RegraDeNegocio. Linha 26 ate 54.

                    STATUS: A fazer | Não Implementado




# BOAS PRÁTICAS                    


-> Documentacao do  Codigo: As classes Services foram documentadas com o proprio Java Comment para que seja melhor visualização das funcoes caso outros programadores desejem fazer
                              manutencao do codigo
                    
-> Refatorando Pastas: Arquitetura Limpa
                    Foi mudado o sistemas de alocacao de arquivos para um novo estilo de pastas, para que fique melhor a visualização, organização e prevenção de erros.
                    Tambem foi criada as classes Services, que indicam os serviços das entidades e suas funcoes, para reduzir o codigo no metodo executar e faciliar caso exista uma manutanção futura ou uma nova funcionalidade no codigo.

-> Criacao de uma classe Abstrata: Uma boa pratica eh criar uma classe abstrata, para que seja de modelo para as outras classes
                                usuario -> usuarioComum, usuarioEmpresa, usuarioAdmin
                    


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
Sistema Cinema - Venda de ingressos

Devemos construir um sistema para realização de venda de ingressos:
O sistema terá as seguintes funcionalidades:

	• Cadastrar filme
		- id 
		- titulo
		- genero
		- idade mínima
		- tempo
		- valor
		- tecnologia (2D, 3D)
		- poltronas disponiveis

	• Cadastro de usuarios
		- nome
		- role (cliente, funcionario)
		- idade
		- user
		- password
		
- REGRA DE NEGOCIO -

A sala de cinema possui 100 poltronas enumeradas onde existe um ingresso para cada poltrona
Usuários do tipo (funcionário) poderão

	- cadastrar novos filmes no sistema
	- excluir filmes do cartaz
		• um filme só pode ser excluído caso nenhum ingresso tenha sido vendido
	- listas os filmes em cartaz
	- efetuar login e logout

Usuários do tipo (cliente) poderão:

	- comprar ingressos no sistema
	- listas os filmes em cartaz
		• a listagem deve retornar somente os filme de acordo com a classificação indicativa especificada
	- visualizar os ingressos que comprou
	- efetuar login e logout

Deve existir um sistema de login

	- Deve identificar se o usuário é cliente ou funcionario e direciona-lo para o menu correto
Deve existir um cadastro de usuários

	- Podendo criar novos usuários (clientes e funcionarios)

- FLUXO DE TELAS -

MENU INICIAL
ENTRAR -> (TELA DE LOGIN)
CADASTRAR -> (TELA DE CADASTRO)

     
- CADASTRO - 
	informar os campos:

		- nome
		- role (cliente, funcionario)
		- idade
		- user
		- password
		- criptografar senha para salvar
CADASTRAR -> (TELA DE CLIENTE OU TELA DE FUNCIONARIO)

- LOGIN -
  
		Pede user
		Pede password
			O password deve ser criptografado para comparar com o que foi armazenado no cadastro
		ENTRAR -> (TELA DE CLIENTE OU TELA DE FUNCIONARIO)
                VOLTAR -> (TELA MENU INICIAL)

- CLIENTE -
    
		- comprar ingressos no sistema
		- listas os filmes em cartaz
			• a listagem deve retornar somente os filme de acordo com a classificação indicativa especificada
		- visualizar os ingressos que comprou
		- sair -> (TELA DE LOGIN)

- FUNCIONARIO -
  
		- cadastrar novos filmes no sistema
		- excluir filmes do cartaz
			• um filme só pode ser excluído caso nenhum ingresso tenha sido vendido
		- listas os filmes em cartaz
		- sair -> (TELA DE LOGIN)
		
		

#language:pt

@filme
Funcionalidade: CRUD Filme
	
	@cadastroFilmes
	Cenario: Cadastro Filme
		Dado que tenha realizado o login com dados validos
		E que tenha um payload da API de Filme
		Quando realizo uma requisicao do tipo POST de Filme
		Entao valido que recebo status 201 no response
		E valido que no campo "categorias.tipo[1]" possui o valor "Comedia"
		E armazeno o id que recebo do response de Filme
	
	@consultaFilme
	Cenario: Consulta Filme
		Dado que tenha realizado o login com dados validos
		E que tenha um payload da API de Filme
		Quando realizo uma requisicao do tipo Get de Filme atraves do nome
		Entao valido que recebo status 200 no response
		E valido que no campo "categorias[0].tipo[1]" possui o valor "Comedia"
	
	@alteracao
	Cenario: Alteracao Filme
		Dado que tenha realizado o login com dados validos
		E que tenha um payload da API de Filme
		E altero o indice 1 da lista de categorias de filme com os valores
			| tipo | Terror |
		Quando realizo uma requisicao do tipo PUT de Filme
		Entao valido que recebo status 200 no response
		E valido que no campo "categorias.tipo[1]" possui o valor "Terror"
		
		
		
		
		
		
		
		
		
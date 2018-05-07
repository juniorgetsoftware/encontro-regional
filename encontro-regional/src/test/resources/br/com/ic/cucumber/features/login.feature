# language: pt

@EfeturarLogin
Funcionalidade: Fazer login no sistema
	
	Recurso que lida com a funcionalidade de login do sistema
	
	@LoginCorreto
	Cenario: Login com usuario e senha corretos
	
		Dado que eu navego para a pagina de login
		E eu digito o usuario "admin" e a senha "admin"
		E eu clico no botao login
		Entao eu sou redirecionado para a pagina inicial  
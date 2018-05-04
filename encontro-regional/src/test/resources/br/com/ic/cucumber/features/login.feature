# language: pt

Funcionalidade: Fazer login no sistema
	
	Recurso que lida com a funcionalidade de login do sistema

	Cenário: Login com usuario e senha corretos
	
		Dado eu navego para a página de login
		E eu digito o usuário admin e a senha admin
		E eu clico no botão login
		Então eu sou redirecionado para a página inicial  
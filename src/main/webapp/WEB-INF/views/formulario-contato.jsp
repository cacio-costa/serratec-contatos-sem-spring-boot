<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Caelum - Contatos</title>
</head>
<body>

	<h1>Novo contato</h1>
	<hr>

	<form action="cadastrar-contato" method="post">
		<label>Nome: </label>
		<input type="text" name="nome">
		<br>
		
		<label>Email: </label>
		<input type="email" name="email">
		<br>
		
		<label>Telefone: </label>
		<input type="text" name="telefone">
		<br><br>
		
		<button type="submit">Cadastrar</button>
	</form>
</body>
</html>
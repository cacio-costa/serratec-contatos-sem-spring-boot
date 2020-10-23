<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Caelum - Contatos</title>
</head>
<body>

	<h1>Lista de contatos</h1>
	<hr>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>EMAIL</th>
				<th>TELEFONE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="contato" items="${contatos}">
				<tr>
					<td>${contato.id}</td>
					<td>${contato.nome}</td>
					<td>${contato.email}</td>
					<td>${contato.telefone}</td>
				</tr>			
			</c:forEach>
		</tbody>
	</table>

</body>
</html>














<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bater Ponto</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/ponto.css">


</head>
<body>
	<form action="ponto" method="post">
		<table>
			<tr>
				<td><label for="inputUsuario">Usuário:</label></td>
				<td><input type="text" id="inputUsuario" name="inputUsuario"
					required /></td>
			</tr>
			<tr>
				<td colspan="2"><strong>Última Batida:</strong></td>
			</tr>
			<tr>
				<td colspan="2">Horário última Batida: <span>10:30</span></td>
			</tr>
			<tr>
				<td colspan="2">Horário Atual: <%= request.getAttribute("horarioAtual") != null ? request.getAttribute("horarioAtual") : "Horário indisponível" %></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Bater Ponto"></td>
			</tr>
			<tr>
				<td colspan="2">Últimas Batidas: <span>10:00</span></td>
			</tr>
		</table>
	</form>

</body>
</html>

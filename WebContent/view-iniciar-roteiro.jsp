<%@page import="br.com.sistemadevendas.models.Cidade"%>
<%@page import="br.com.sistemadevendas.bd.TransporteMariadb"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,br.com.sistemadevendas.models.Hotel,br.com.sistemadevendas.models.Transporte"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>Início de sessão</title>
<style>
body {background-color: #FFF9F2;margin: 20px;}
</style>
</head>
<body>
	<form action="listar-cidades">
	CPF do usuário:<br>
  	<input type="text" name="cpf">
  	<br><br>
  	Cidade base:<br>
  	<%
		List<Cidade> cidades = ((List<Cidade>)request.getAttribute("cidades"));
		for (Cidade cidade : cidades) {
	%>
	<input type="radio" name="cidade" value="<%=cidade.getId()%>" required> <%=cidade.getNome()%><br>
	<%
		}
	%>
	Número de pessoas:<br>
	<input type="number" name="numero-pessoas" min="1" max="10" required><br>
	Dia:<br>
	<input type="date" name="data-inicial" required><br>
	<input type="submit" value="Submit">
	</form>
</body>
</html>
<body>

</body>
</html>
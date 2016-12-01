<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.sistemadevendas.session.UserSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,br.com.sistemadevendas.models.Cidade"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>Cidades disponíveis</title>
<style>
body {background-color: #FFF9F2;margin: 20px;}
</style>
</head>
<body>
Data atual no roteiro: <%=new SimpleDateFormat("yyyy-MM-dd hh:mm").format(UserSession.getSession().getDataAtual())%>
<h1>Lista de Cidades</h1>
<table style="width: 100%">
	<tr>
		<th>Nome</th>
	</tr>
	<%
		List<Cidade> cidades = ((List<Cidade>)request.getAttribute("cidades"));
		for (Cidade cidade : cidades) {
			if (cidade.getId() != UserSession.getSession().getCidadeAtual()) {
	%>
	<tr>
		<td><a href="detalhes-cidade?id=<%=cidade.getId()%>">
				<%=cidade.getNome()%>
		</a></td>
	</tr>
	<%
			}
		}
	%>
</table>
<br>
<a href="verificar-roteiro">Terminar roteiro</a>
</body>
</html>
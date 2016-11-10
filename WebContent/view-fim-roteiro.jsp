<%@page import="br.com.sistemadevendas.session.UserSession"%>
<%@page import="br.com.sistemadevendas.bd.CidadeMariadb"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,br.com.sistemadevendas.models.Parada,br.com.sistemadevendas.models.RoteiroDeViagem"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resumo do Roteiro</title>
</head>
<body>
	<h1>Paradas</h1>
	<%
		List<Parada> paradas = ((List<Parada>) request.getAttribute("paradas"));
		RoteiroDeViagem roteiro = new RoteiroDeViagem(0, UserSession.getSession().getNumeroPessoas(), paradas);
	%>
	<p>
		Total de paradas:
		<%=paradas.size()%>
	</p>
	<table style="width: 100%">
		<tr>
			<th>Cidade</th>
			<th>Hotel</th>
			<th>Transporte</th>
		</tr>
		<%
			for (Parada parada : paradas) {
		%>
		<tr>
			<td><%=new CidadeMariadb().getCidade(parada.getHotel().getCidade()).getNome()%></td>
			<td><%=parada.getHotel().getNome()%></td>
			<td><%=parada.getTransporte().getTipo()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<p>
		Duração do roteiro:<br><%=roteiro.duracao()%> dias
	</p>
	<p>
		Preco total:<br>R$<%=roteiro.calcularPreco()%>
	</p>
</body>
</html>
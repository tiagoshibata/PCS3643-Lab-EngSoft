<%@page import="br.com.sistemadevendas.bd.TransporteMariadb"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,br.com.sistemadevendas.models.Hotel,br.com.sistemadevendas.models.Transporte"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Informações da cidade</title>
</head>
<body>
	<h1>Configuração de parada</h1>
	<form action="listar-cidades">
		Hotéis:<br>
		<%
		Hotel[] hoteis = (Hotel[])request.getAttribute("hoteis");
		for (Hotel hotel : hoteis) {
		%>
		<input type="radio" name="hotel" value="<%=hotel.getId()%>" checked> <%=hotel.getNome()%> - R$<%=hotel.getPrecoDiaria()%><br>
		<%
		}
		%>
		Transportes:<br>
		<%
		Transporte[] transportes = (Transporte[]) request.getAttribute("transportes");
		for (Transporte transporte : transportes) {
		%>
		<input type="radio" name="transporte" value="<%=transporte.getId()%>"> <%=transporte.getTipo()%> - R$<%=transporte.getPreco()%><br>
		<%
		}
		%>
  		<input type="submit" value="Submit">
	</form>
</body>
</html>
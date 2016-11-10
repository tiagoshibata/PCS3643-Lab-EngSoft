<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,br.com.sistemadevendas.models.Hotel,br.com.sistemadevendas.models.Transporte"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Informações da cidade</title>
</head>
<body>
	<h1>Hotéis</h1>
	<form action="cidade_confirmada">
		Hotéis:<br>
		<%
		List<Hotel> hoteis = ((List<Hotel>)request.getAttribute("hoteis"));
		for (Hotel hotel : hoteis) {
		%>
		<input type="radio" name="hotel" value="<%=hotel.getId()%>" checked> <%=hotel.getNome()%><br>
		<%
		}
		%>
		Transportes:<br>
		<%
		List<Transporte> transportes = ((List<Transporte>)request.getAttribute("transportes"));
		for (Transporte transporte : transportes) {
		%>
		<input type="radio" name="transporte" value="<%=transporte.getId()%>" checked> <%=transporte.getTipo()%><br>
		<%
		}
		%>
  	<input type="submit" value="Submit">
	</form>
</body>
</html>
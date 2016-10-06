<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,br.com.vendapacotes.servlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalhes do hotel</title>
</head>
<body>
	<h1>Informações do Hotel</h1>
	<ul>
		<%
			Hotel hotel = (Hotel) request.getAttribute("hotel");
		%>
		<li><b>Id:</b> <%=hotel.getId()%>
		<li><b>Nome:</b> <%=hotel.getNome()%>
		<li><b>Diária:</b> <%=hotel.getPrecoDiaria()%>
		<li><b>Localização:</b> <%=hotel.getLocalizacao()%>
	</ul>
</body>
</html>
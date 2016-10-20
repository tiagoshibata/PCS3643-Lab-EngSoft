<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,br.com.sistemadevendas.models.Hotel"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hotéis disponíveis</title>
</head>
<body>
<h1>Lista de Hotéis</h1>
<table style="width: 100%">
	<tr>
		<th>Nome</th>
	</tr>
	<%
		List<Hotel> hoteis = ((List<Hotel>)request.getAttribute("hoteis"));
		for (Hotel hotel : hoteis) {
	%>
	<tr>
		<td><a href="detalhes-hotel?id=<%=hotel.getId()%>">
				<%=hotel.getNome()%>
		</a></td>
	</tr>
	<%
		}
	%>
</table>
</body>
</html>
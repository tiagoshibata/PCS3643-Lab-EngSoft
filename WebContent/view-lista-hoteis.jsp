<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,br.com.vendapacotes.servlet.*"%>
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
		String[] hoteis = (String[])request.getAttribute("hoteis");
		for (String hotel : hoteis) {
	%>
	<tr>
		<td><a href="detalhes-hotel?hotel=<%=hotel%>">
				<%=hotel%>
		</a></td>
	</tr>
	<%
		}
	%>
</table>
</body>
</html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.sistemadevendas.session.UserSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,br.com.sistemadevendas.models.Cidade"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cidades disponíveis</title>
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
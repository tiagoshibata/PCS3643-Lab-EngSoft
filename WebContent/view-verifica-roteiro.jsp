<%@page import="br.com.sistemadevendas.session.UserSession"%>
<%@page import="br.com.sistemadevendas.bd.CidadeMariadb"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,br.com.sistemadevendas.models.Parada,br.com.sistemadevendas.models.RoteiroDeViagem"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Verificação de Roteiro</title>
<%if (UserSession.getSession().getCidadeAtual() == UserSession.getSession().getCidadeInicial()) {%>
<meta http-equiv="refresh" content="0; url=fim-roteiro" />
<%}%>
</head>
<body>
	<h1>Cidade final é diferente da destino!</h1>
	<a href="detalhes-cidade?id=<%=UserSession.getSession().getCidadeInicial()%>">Voltar e escolher transporte de volta</a><br>
	<a href="fim-roteiro">Continuar mesmo assim</a>
</body>
</html>
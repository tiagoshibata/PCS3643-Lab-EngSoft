<%@page import="br.com.sistemadevendas.session.UserSession"%>
<%@page import="br.com.sistemadevendas.bd.CidadeMariadb"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,br.com.sistemadevendas.models.Parada,br.com.sistemadevendas.models.RoteiroDeViagem"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>Verificação de Roteiro</title>
<%if (UserSession.getSession().getCidadeAtual() == UserSession.getSession().getCidadeInicial()) {%>
<meta http-equiv="refresh" content="0; url=fim-roteiro" />
<%}%>
<style>
body {background-color: #FFF9F2;margin: 20px;}
</style>
</head>
<body>
	<h1>Cidade final é diferente da destino!</h1>
	<a href="detalhes-cidade?id=<%=UserSession.getSession().getCidadeInicial()%>">Voltar e escolher transporte de volta</a><br>
	<a href="fim-roteiro">Continuar mesmo assim</a>
</body>
</html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.sistemadevendas.models.Transporte"%>
<%@page import="br.com.sistemadevendas.bd.CidadeMariadb"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,br.com.sistemadevendas.models.Hotel"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>Detalhes do transporte</title>
<style>
body {background-color: #FFF9F2;margin: 20px;}
</style>
</head>
<body>
	<h1>Informações do Transporte</h1>
	<ul>
		<%
			Transporte transporte = (Transporte) request.getAttribute("transporte");
		%>
		<li><b>Id:</b> <%=transporte.getId()%>
		<li><b>Transporte:</b> <%=transporte.getTipo()%>
		<li><b>Preço:</b> <%=transporte.getPreco()%>
		<li><b>Origem:</b> <%=transporte.getOrigem().getNome()%>
		<li><b>Destion:</b> <%=transporte.getDestino().getNome()%>
		<li><b>Data:</b> <%=new SimpleDateFormat("yyyy-MM-dd hh:mm").format(transporte.getData())%>
	</ul>
</body>
</html>
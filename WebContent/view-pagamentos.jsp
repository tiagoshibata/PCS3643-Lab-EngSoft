<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,br.com.sistemadevendas.bd.PagamentoMariadb,br.com.sistemadevendas.bd.PagamentoDAO,br.com.sistemadevendas.models.Pagamento,br.com.sistemadevendas.bd.RoteiroDAO, br.com.sistemadevendas.bd.RoteiroMariadb"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>Lista de Pagamentos</title>
<style>
body {background-color: #FFF9F2;margin: 20px;}
</style>
</head>
<body>
	<table style="width: 100%">
		<tr>
			<th style="text-align: left">CPF Cliente</th>
			<th style="text-align: left">Valor</th>
			<th style="text-align: left">Forma de Pagamento</th>
			<th style="text-align: left">Código de cartão</th>
			<th style="text-align: left">Data</th>
		</tr>
		<%
			PagamentoDAO pagamentoDao = new PagamentoMariadb();
			RoteiroDAO roteiroDao = new RoteiroMariadb();
			for (Pagamento pagamento : pagamentoDao.getPagamentos()) {
		%>
		<tr>
			<td><%=roteiroDao.getRoteiro(pagamento.getRoteiro()).getCliente().getCpf()%></td>
			<td><%=roteiroDao.getRoteiro(pagamento.getRoteiro()).calcularPreco()%></td>
			<td><%=pagamento.getForma().toString()%></td>
			<td><%=pagamento.getCodigo()%></td>
			<td><%=new SimpleDateFormat("yyyy-MM-dd hh:mm").format(pagamento.getDate())%></td>
		</tr>
		<%
			}
		%>
	</table>
	<p><a href="index.html">Retornar</a></p>
</body>
</html>
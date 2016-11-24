<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,br.com.sistemadevendas.bd.PagamentoMariadb,br.com.sistemadevendas.bd.PagamentoDAO,br.com.sistemadevendas.models.Pagamento,br.com.sistemadevendas.bd.RoteiroDAO, br.com.sistemadevendas.bd.RoteiroMariadb"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Pagamentos</title>
</head>
<body>
	<table style="width: 100%">
		<tr>
			<th style="text-align: left">CPF Cliente</th>
			<th style="text-align: left">Valor</th>
			<th style="text-align: left">Forma de Pagamento</th>
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
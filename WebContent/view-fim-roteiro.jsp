<%@page import="br.com.sistemadevendas.session.UserSession"%>
<%@page import="br.com.sistemadevendas.bd.CidadeMariadb"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,br.com.sistemadevendas.models.Parada,br.com.sistemadevendas.models.RoteiroDeViagem, br.com.sistemadevendas.bd.ClienteMariadb"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>Resumo do Roteiro</title>
<style>
body {background-color: #FFF9F2;margin: 20px;}
</style>
</head>
<body>
	<h1>Paradas</h1>
	<%
		ClienteMariadb clienteDao = new ClienteMariadb();
		List<Parada> paradas = ((List<Parada>) request.getAttribute("paradas"));
		RoteiroDeViagem roteiro = new RoteiroDeViagem(clienteDao.getCliente(UserSession.getSession().getCpf()),
				UserSession.getSession().getIdRoteiro(), UserSession.getSession().getNumeroPessoas(), paradas);
	%>
	<p>
		Cidade base:
		<%=paradas.get(0).getTransporte().getOrigem().getNome()%></p>
	<h1>Paradas</h1>

	<p>
		Total de paradas:
		<%=paradas.size()%>
	</p>
	<table style="width: 100%">
		<tr>
			<th style="text-align: left">Cidade</th>
			<th style="text-align: left">Hotel</th>
			<th style="text-align: left">Transporte</th>
			<th style="text-align: left">Estadia</th>

		</tr>
		<%
			int paradaID = 0;
			for (Parada parada : paradas) {
		%>
		<tr>
			<td><%=new CidadeMariadb().getCidade(parada.getHotel().getCidade()).getNome()%></td>
			<td><a
				href="view-detalhes-hotel?idHotel=<%=parada.getHotel().getId()%>;idParada=<%=paradaID%>"><%=parada.getHotel().getNome()%></a></td>
			<td><a
				href="view-detalhes-transporte?idTransporte=<%=parada.getTransporte().getId()%>;idParada=<%=paradaID%>"><%=parada.getTransporte().getTipo()%></td>
			<td><%=parada.getDuracao()%> dia(s)</td>
		</tr>
		<%
			paradaID++;
			}
		%>
	</table>
	<h2>Informações gerais</h2>
	<p>
		Número de pessoas:<br><%=roteiro.getNumeroDePessoas()%>
	</p>
	<p>
		Duração do roteiro:<br><%=roteiro.duracao()%>
		dias
	</p>
	<p>
		Preco total:<br>R$<%=roteiro.calcularPreco()%>
	</p>
	Forma de pagamento:<br>
	<form action="pagamento">
	<input type="radio" name="pagamento" value="cartao" onclick="handleClick(this);" required>Cartão<br>
	<input type="radio" name="pagamento" value="dinheiro" onclick="handleClick(this);" required>Dinheiro<br>
	<input type="radio" name="pagamento" value="cheque" onclick="handleClick(this);" required>Cheque<br>
	<div id="spoiler-codigo-cartao" style="display:none">
	Código de identificação da compra por cartão: <input type="text" name="codigo"><br>
	</div>
	<input type="submit" value="Aceitar roteiro e realizar pagamento" />
	</form>
	<script>
	function handleClick(radio) {
		if(radio.value == 'cartao') {
			document.getElementById('spoiler-codigo-cartao').style.display = '';
		} else {
			document.getElementById('spoiler-codigo-cartao').style.display = 'none';
		}
	}
	</script>
	<form action="index.html">
	<input type="submit" value="Cancelar" />
	</form>
</body>
</html>
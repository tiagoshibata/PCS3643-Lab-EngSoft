<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.sistemadevendas.bd.TransporteMariadb"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,br.com.sistemadevendas.models.Hotel,br.com.sistemadevendas.models.Transporte"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Informações da cidade</title>
</head>
<body>
	<h1>Configuração de parada</h1>
	<form action="listar-cidades">
		Hotéis:<br>
		<%
		Hotel[] hoteis = (Hotel[])request.getAttribute("hoteis");
		for (Hotel hotel : hoteis) {
		%>
		<input type="radio" name="hotel" value="<%=hotel.getId()%>" required> <%=hotel.getNome()%> - R$<%=hotel.getPrecoDiaria()%><br>
		<%
		}
		%>
		Transportes:<br>
		<%
		List<Transporte> transportes = (List<Transporte>)request.getAttribute("transportes");
		Transporte prevTransporte = null;
		for (Transporte transporte : transportes) {
			if (transporte != prevTransporte) {
				if (prevTransporte != null) {
					%></div><br><%
				}
				prevTransporte = transporte;
				%><button title="<%=transporte.getTipo()%>" type="button"
				onclick="if(document.getElementById('spoiler-<%=transporte.getId()%>').style.display=='none') {
					document.getElementById('spoiler-<%=transporte.getId()%>').style.display=''
				} else {
					document.getElementById('spoiler-<%=transporte.getId()%>').style.display='none'
				}"><%=transporte.getTipo()%></button><div id="spoiler-<%=transporte.getId()%>" style="display:none"><%
			}
		%>
		<input type="radio" name="transporte" value="<%=transporte.getId()%>" required> <%=transporte.getTipo()%> - <%=new SimpleDateFormat("yyyy-MM-dd hh:mm").format(transporte.getData())%> - R$<%=transporte.getPreco()%><br>
		<%
		}
		%>
		</div><br>Número de diárias:<br>
		<input type="number" name="dias" min="1" max="30" required><br>
  		<input type="submit" value="Submit">
	</form>
</body>
</html>
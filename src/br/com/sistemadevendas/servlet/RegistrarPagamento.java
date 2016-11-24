package br.com.sistemadevendas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemadevendas.bd.HotelDAO;
import br.com.sistemadevendas.bd.HotelMariadb;
import br.com.sistemadevendas.bd.PagamentoDAO;
import br.com.sistemadevendas.bd.PagamentoMariadb;
import br.com.sistemadevendas.models.Pagamento;
import br.com.sistemadevendas.models.Pagamento.Forma;
import br.com.sistemadevendas.session.UserSession;

@WebServlet("/pagamento")
public class RegistrarPagamento extends HttpServlet {
	protected PagamentoDAO pagamentoDao = new PagamentoMariadb();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pagamento.Forma forma;
		switch (request.getParameter("pagamento")) {
		case "cartao":
			forma = Forma.CARTAO;
			break;
			
		case "cheque":
			forma = Forma.CHEQUE;
			break;
			
		default:
			forma = Forma.DINHEIRO;
			break;
		}
		Pagamento pagamento = new Pagamento(forma, null, UserSession.getSession().getIdRoteiro(), request.getParameter("codigo"));
		pagamentoDao.adicionarPagamento(pagamento);
		RequestDispatcher dispatcher = request.getRequestDispatcher("pagamento.html");
		dispatcher.forward(request, response);
	}
}

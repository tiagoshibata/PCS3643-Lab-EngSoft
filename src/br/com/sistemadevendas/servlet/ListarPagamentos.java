package br.com.sistemadevendas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemadevendas.bd.PagamentoDAO;
import br.com.sistemadevendas.bd.PagamentoMariadb;

@WebServlet("/listar-pagamentos")
public class ListarPagamentos extends HttpServlet {
	protected PagamentoDAO pagamentoDao = new PagamentoMariadb();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("view-pagamentos.jsp");
		request.setAttribute("pagamentos", pagamentoDao.getPagamentos());
		dispatcher.forward(request, response);
	}
}

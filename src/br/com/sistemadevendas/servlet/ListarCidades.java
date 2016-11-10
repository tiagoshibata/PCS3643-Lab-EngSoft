package br.com.sistemadevendas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemadevendas.bd.CidadeDAO;
import br.com.sistemadevendas.bd.CidadeMariadb;

@WebServlet("/listar-cidades")
public class ListarCidades extends HttpServlet {
	protected CidadeDAO cidadeDao = new CidadeMariadb();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("view-lista-cidades.jsp");
		request.setAttribute("cidades", cidadeDao.getCidades());
		dispatcher.forward(request, response);
	}
}

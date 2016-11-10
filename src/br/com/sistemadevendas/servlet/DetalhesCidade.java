package br.com.sistemadevendas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemadevendas.bd.CidadeDAO;
import br.com.sistemadevendas.bd.CidadeMariadb;
import br.com.sistemadevendas.models.Cidade;

@WebServlet("/detalhes-cidade")
public class DetalhesCidade extends HttpServlet {
	protected CidadeDAO cidadeDao = new CidadeMariadb();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null)
			throw new ServletException("Missing ID parameter");
		
		Cidade cidade = cidadeDao.getCidade(Integer.parseInt(id));
		if (cidade == null)
			throw new ServletException("Invalid hotel id");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view-detalhes-cidade.jsp");
		request.setAttribute("cidade", cidade);
		dispatcher.forward(request, response);
	}
}

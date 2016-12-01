package br.com.sistemadevendas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemadevendas.bd.TransporteDAO;
import br.com.sistemadevendas.bd.TransporteMariadb;
import br.com.sistemadevendas.models.Transporte;

@WebServlet("/detalhes-transporte")
public class DetalhesTransporte extends HttpServlet {
	protected TransporteDAO dao = new TransporteMariadb();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null)
			throw new ServletException("Missing ID parameter");
		
		Transporte transporte = dao.getTransporte(Integer.parseInt(id));
		if (transporte == null)
			throw new ServletException("Invalid hotel id");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view-detalhes-transporte.jsp");
		request.setAttribute("transporte", transporte);
		dispatcher.forward(request, response);
	}
}

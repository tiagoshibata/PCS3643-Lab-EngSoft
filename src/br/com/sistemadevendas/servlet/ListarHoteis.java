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

@WebServlet("/listar-hoteis")
public class ListarHoteis extends HttpServlet {
	protected HotelDAO hotelDao = new HotelMariadb();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("view-lista-hoteis.jsp");
		request.setAttribute("hoteis", hotelDao.getHoteis());
		dispatcher.forward(request, response);
	}
}

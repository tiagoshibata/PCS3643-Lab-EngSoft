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
import br.com.sistemadevendas.models.Hotel;

@WebServlet("/listar-hoteis")
public class ListarHoteis extends HttpServlet {
	private HotelDAO hotelDao = new HotelMariadb();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("view-lista-hoteis.jsp");
		int contagemHoteis = hotelDao.getContagemHoteis();
		String[] nomesHoteis = new String[contagemHoteis];
		
		for (int i = 0; i < contagemHoteis; i++) {
			Hotel hotel = hotelDao.getHotel(i);
			nomesHoteis[i] = hotel.getNome();
		}
		
		request.setAttribute("hoteis", nomesHoteis);
		dispatcher.forward(request, response);
	}
}

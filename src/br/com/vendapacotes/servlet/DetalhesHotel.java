package br.com.vendapacotes.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detalhes-hotel")
public class DetalhesHotel extends HttpServlet {
	private BDHoteis hoteis;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		hoteis = new BDHoteis();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Hotel hotel = getHotelByName(request.getParameter("hotel"));
		
		if (hotel == null)
			throw new ServletException("Invalid hotel name");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view-detalhes-hotel.jsp");
		request.setAttribute("hotel", hotel);
		dispatcher.forward(request, response);
	}
	
	private Hotel getHotelByName(String name) {
		int contagemHoteis = hoteis.getContagemHoteis();
		for (int i = 0; i < contagemHoteis; i++) {
			Hotel hotel = hoteis.getHotel(i);
			if (hotel.getNome().equals(name))
				return hotel;
		}
		return null;
	}
}

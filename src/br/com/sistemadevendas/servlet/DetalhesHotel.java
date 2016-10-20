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

@WebServlet("/detalhes-hotel")
public class DetalhesHotel extends HttpServlet {
	private HotelDAO hotelDao = new HotelMariadb();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Hotel hotel = hotelDao.getHotel(Integer.parseInt(request.getParameter("id")));
		
		if (hotel == null)
			throw new ServletException("Invalid hotel name");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view-detalhes-hotel.jsp");
		request.setAttribute("hotel", hotel);
		dispatcher.forward(request, response);
	}
}

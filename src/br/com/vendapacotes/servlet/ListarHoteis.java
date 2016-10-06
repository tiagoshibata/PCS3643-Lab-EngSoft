package br.com.vendapacotes.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listar-hoteis")
public class ListarHoteis extends HttpServlet {
	private BDHoteis hoteis;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		hoteis = new BDHoteis();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("view-lista-hoteis.jsp");
		int contagemHoteis = hoteis.getContagemHoteis();
		String[] nomesHoteis = new String[contagemHoteis];
		
		for (int i = 0; i < contagemHoteis; i++) {
			Hotel hotel = hoteis.getHotel(i);
			nomesHoteis[i] = hotel.getNome();
		}
		
		request.setAttribute("hoteis", nomesHoteis);
		dispatcher.forward(request, response);
	}
}

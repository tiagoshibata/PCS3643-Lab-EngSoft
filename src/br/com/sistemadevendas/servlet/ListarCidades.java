package br.com.sistemadevendas.servlet;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemadevendas.bd.CidadeDAO;
import br.com.sistemadevendas.bd.CidadeMariadb;
import br.com.sistemadevendas.bd.HotelMariadb;
import br.com.sistemadevendas.bd.TransporteMariadb;
import br.com.sistemadevendas.models.Hotel;
import br.com.sistemadevendas.models.Parada;
import br.com.sistemadevendas.models.Transporte;
import br.com.sistemadevendas.session.UserSession;

@WebServlet("/listar-cidades")
public class ListarCidades extends HttpServlet {
	protected CidadeDAO cidadeDao = new CidadeMariadb();
	protected UserSession session;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws AccessDeniedException, ServletException, IOException {
		String cpf = request.getParameter("cpf");
		String numero_pessoas = request.getParameter("numero-pessoas");
		String data_inicial = request.getParameter("data-inicial");
		String cidade = request.getParameter("cidade");

		String hotelId = request.getParameter("hotel");
		String transporteId = request.getParameter("transporte");
		String days = request.getParameter("dias");

		if (cpf != null && numero_pessoas != null && data_inicial != null)
			session = UserSession.startSession(cpf, Integer.parseInt(cidade), Integer.parseInt(numero_pessoas), Time.valueOf(data_inicial));
		else
			session = UserSession.getSession();
		if (hotelId != null && transporteId != null && days != null)
			addParada(session, Integer.parseInt(hotelId), Integer.parseInt(transporteId), Integer.parseInt(days));
		RequestDispatcher dispatcher = request.getRequestDispatcher("view-lista-cidades.jsp");
		request.setAttribute("cidades", cidadeDao.getCidades());
		dispatcher.forward(request, response);
	}
	
	private void addParada(UserSession session, int hotelId, int transporteId, int duracao) throws AccessDeniedException {
		Hotel hotel = new HotelMariadb().getHotel(hotelId);
		Transporte transporte = new TransporteMariadb().getTransporte(transporteId);
		session.addParada(new Parada(hotel, transporte, duracao));
	}
}

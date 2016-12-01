package br.com.sistemadevendas.servlet;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		Date data = null;
		if (data_inicial != null)
			try {
				data = new SimpleDateFormat("yyyy-MM-dd").parse(data_inicial);
			} catch (ParseException e) {
				throw new ServletException(e.toString());
			}

		if (cpf != null && numero_pessoas != null && data != null)
			session = UserSession.startSession(cpf, Integer.parseInt(numero_pessoas), Integer.parseInt(cidade), new Time(data.getTime()));
		else
			session = UserSession.getSession();
		if (transporteId == null && days != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			request.setAttribute("message", "Chave transporte inválida");
			dispatcher.forward(request, response);
			return;
		}
		if (transporteId != null && days != null)
			addParada(session, hotelId, Integer.parseInt(transporteId), Integer.parseInt(days));
		RequestDispatcher dispatcher = request.getRequestDispatcher("view-lista-cidades.jsp");
		request.setAttribute("cidades", cidadeDao.getCidades());
		dispatcher.forward(request, response);
	}
	
	private void addParada(UserSession session, String hotelId, int transporteId, int duracao) throws AccessDeniedException {
		Transporte transporte = new TransporteMariadb().getTransporte(transporteId);
		Hotel hotel = null;
		if (!hotelId.equals("null")) {
			hotel = new HotelMariadb().getHotel(Integer.parseInt(hotelId));
			session.addParada(new Parada(hotel, transporte, duracao));
		} else {
			TransporteMariadb transporteDao = new TransporteMariadb();
			session.addParada(new Parada(transporteDao.getTransporte(transporteId).getDestino().getId(), transporte, duracao));
		}
	}
}

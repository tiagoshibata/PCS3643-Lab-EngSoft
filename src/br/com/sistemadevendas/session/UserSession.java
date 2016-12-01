package br.com.sistemadevendas.session;

import java.nio.file.AccessDeniedException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import br.com.sistemadevendas.bd.ClienteDAO;
import br.com.sistemadevendas.bd.ClienteMariadb;
import br.com.sistemadevendas.bd.ParadaDAO;
import br.com.sistemadevendas.bd.ParadaMariadb;
import br.com.sistemadevendas.bd.RoteiroDAO;
import br.com.sistemadevendas.bd.RoteiroMariadb;
import br.com.sistemadevendas.models.Cliente;
import br.com.sistemadevendas.models.Parada;
import br.com.sistemadevendas.models.RoteiroDeViagem;

public class UserSession {
	private static RoteiroDeViagem roteiro;
	private static String cpf = null;
	private static int cidadeInicial = -1;
	private static int cidadeAtual = -1;
	private static int idRoteiro = -1;
	private static Date dataAtual = null;
	private static int numeroPessoas = -1;
	
	public static ClienteDAO clienteDao = new ClienteMariadb();
	public static RoteiroDAO roteiroDao = new RoteiroMariadb();
	public static ParadaDAO paradaDao = new ParadaMariadb();
	
	public static UserSession getSession() throws AccessDeniedException {
		if (cpf == null)
			throw new AccessDeniedException("Nenhuma sessão para cliente iniciada");
		return new UserSession();
	}
	
	public static UserSession startSession(String cpf, int numeroPessoas, int cidadeBase, Date dataInicial) throws AccessDeniedException {
		Cliente cliente = clienteDao.getCliente(cpf);
		if (cliente == null)
			throw new AccessDeniedException("Cliente " + cpf + " não encontrado");
		UserSession.cpf = cpf;
		UserSession.numeroPessoas = numeroPessoas;
		idRoteiro = roteiroDao.adicionarRoteiro(cpf, numeroPessoas);
		cidadeInicial = cidadeAtual = cidadeBase;
		roteiro = new RoteiroDeViagem(cliente, idRoteiro, numeroPessoas, new LinkedList<Parada>());
		dataAtual = dataInicial;
		return new UserSession();
	}
	
	public static void stopSession() {
		cpf = null;
	}
	
	public void addParada(Parada parada) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataAtual);
		calendar.add(Calendar.DATE, parada.getDuracao());

		dataAtual = calendar.getTime();
		roteiro.addParada(parada);
		paradaDao.adicionarParada(parada, idRoteiro);
		cidadeAtual = parada.getHotel().getCidade();
	}
	
	public List<Parada> getParadas() {
		return roteiro.getParadas();
	}
	
	public RoteiroDeViagem getRoteiro() {
		return roteiro;
	}
	
	public int getCidadeAtual() {
		return cidadeAtual;
	}

	public int getCidadeInicial() {
		return cidadeInicial;
	}
	
	public int getNumeroPessoas() {
		return numeroPessoas;
	}
	
	public Date getDataAtual() {
		return dataAtual;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public int getIdRoteiro() {
		return idRoteiro;
	}

}

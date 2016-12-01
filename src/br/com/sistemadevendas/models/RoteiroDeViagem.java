package br.com.sistemadevendas.models;

import java.util.List;

public class RoteiroDeViagem {
	private Cliente cliente;
	private int id;
	private int numeroDePessoas;
	//private Date dataDePartida;
	//private Date dataDeChegada;
	//private String formaDePagamento;
	//private int numeroDeConfirmacao;
	private List<Parada> paradas;

	public RoteiroDeViagem(Cliente cliente, int id, int numeroDePessoas, List<Parada> paradas) {
		this.cliente = cliente;
		this.id = id;
		this.numeroDePessoas = numeroDePessoas;
		//this.dataDePartida = dataDePartida;
		//this.dataDeChegada = dataDeChegada;
		//this.formaDePagamento = formaDePagamento;
		//this.numeroDeConfirmacao = numeroDeConfirmacao;
		this.paradas = paradas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	
	public int getId() {
		return id;
	}

	public int getNumeroDePessoas() {
		return numeroDePessoas;
	}

	public List<Parada> getParadas() {
		return paradas;
	}

	public float calcularPreco() {
		float precoTotal = 0;

		for (Parada parada : paradas) {
			Hotel hotel = parada.getHotel();
			if (hotel != null)
				precoTotal += ((parada.getHotel().getPrecoDiaria() * parada.getDuracao()
						+ parada.getTransporte().getPreco()) * numeroDePessoas);
			else
				precoTotal += parada.getTransporte().getPreco() * numeroDePessoas;
		}
		return precoTotal;
	}
	
	public int duracao() {
		int duracaoTotal = 0;
		for (Parada parada : paradas) {
			duracaoTotal += parada.getDuracao();
		}
		return duracaoTotal;
	}
	
	public void addParada(Parada p) {
		paradas.add(p);
	}
}

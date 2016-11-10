package br.com.sistemadevendas.models;

public class Parada {
	private Cidade cidade;
	private Hotel hotel;
	private Transporte transporte;
	private int duracao;
	
	public Parada(Cidade cidade, Hotel hotel, Transporte transporte) {
		this.cidade = cidade;
		this.hotel = hotel;
		this.transporte = transporte;
	}
	
	public Cidade getCidade() {
		return cidade;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
}

package br.com.sistemadevendas.models;

public class Parada {
	private Hotel hotel;
	private int cidade;
	private Transporte transporte;
	private int duracao;
	
	public Parada(Hotel hotel, Transporte transporte, int duracao) {
		this.hotel = hotel;
		this.cidade = hotel.getCidade();
		this.transporte = transporte;
		this.duracao = duracao;
	}
	
	public Parada(int cidade, Transporte transporte, int duracao) {
		this.hotel = null;
		this.cidade = cidade;
		this.transporte = transporte;
		this.duracao = duracao;
	}
	
	public int getCidade() {
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
}

package br.com.sistemadevendas.models;

public class Parada {
	private Hotel hotel;
	private Transporte transporte;
	private int duracao;
	
	public Parada(Hotel hotel, Transporte transporte, int duracao) {
		this.hotel = hotel;
		this.transporte = transporte;
		this.duracao = duracao;
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

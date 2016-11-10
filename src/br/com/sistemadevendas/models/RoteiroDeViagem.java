package br.com.sistemadevendas.models;

import java.util.List;

public class RoteiroDeViagem {
	private Cliente cliente;
	private int id;
	private int numeroDePessoas;
	private List<Parada> paradas;

	public RoteiroDeViagem(int id, int numeroDePessoas, List<Parada> paradas) {
		this.id = id;
		this.numeroDePessoas = numeroDePessoas;
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
			precoTotal += ((parada.getHotel().getPrecoDiaria() * parada.getDuracao()
					+ parada.getTransporte().getPreco()) * numeroDePessoas);
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
}

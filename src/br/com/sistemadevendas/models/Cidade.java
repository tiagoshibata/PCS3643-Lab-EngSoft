package br.com.sistemadevendas.models;

public class Cidade {
	private int id;
	private String nome;
	private Hotel[] hoteis;
	
	public Cidade(int id, String nome, Hotel[] hoteis) {
		this.id = id;
		this.nome = nome;
		this.hoteis = hoteis;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public Hotel[] getHoteis() {
		return this.hoteis;
	}
}

package br.com.sistemadevendas.models;

public class Hotel {
	private int id;
	private String nome;
	private float diaria;
	private String localizacao;
	
	public Hotel(int id, String nome, float diaria, String localizacao) {
		this.id = id;
		this.nome = nome;
		this.diaria = diaria;
		this.localizacao = localizacao;
	}
	
	public int getId() {
		return id;
	}

	public float getPrecoDiaria() {
		return diaria;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getLocalizacao() {
		return localizacao;
	}
}
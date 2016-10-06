package br.com.vendapacotes.servlet;

public class Hotel {
	private int id;
	private String nome;
	private float diaria;
	private String localizacao;
	
	public Hotel(String nome, float diaria, String localizacao) {
		id = 0;
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
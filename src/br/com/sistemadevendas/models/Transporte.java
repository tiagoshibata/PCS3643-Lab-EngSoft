package br.com.sistemadevendas.models;

public class Transporte {
	private int id;
	private String tipo;
	private float preco;
	private Cidade origem;
	private Cidade destino;

	public Transporte(int id, String tipo, float preco, Cidade origem, Cidade destino) {
		this.id = id;
		this.tipo = tipo;
		this.preco = preco;
		this.origem = origem;
		this.destino = destino;
	}
	
	public int getId() {
		return id;
	}

	public String getTipo() {
		return this.tipo;
	}
	
	public float getPreco() {
		return this.preco;
	}
	
	public Cidade getOrigem() {
		return this.origem;
	}
	
	public Cidade getDestino() {
		return this.destino;
	}
}
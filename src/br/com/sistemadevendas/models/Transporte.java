package br.com.sistemadevendas.models;

import java.util.Date;

public class Transporte {
	private int id;
	private String tipo;
	private float preco;
	private Cidade origem;
	private Cidade destino;
	private Date data;

	public Transporte(int id, String tipo, float preco, Cidade origem, Cidade destino, Date data) {
		this.id = id;
		this.tipo = tipo;
		this.preco = preco;
		this.origem = origem;
		this.destino = destino;
		this.data = data;
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

	public Date getData() {
		return this.data;
	}

}
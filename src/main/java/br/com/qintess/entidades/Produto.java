package br.com.qintess.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private double precoVenda;
	
	@Column(nullable = false)
	private int minEstoque;
	
	@Column(nullable = false)
	private String nome;
	
	private String foto;
	
	public Produto() {
		
	}

	public Produto(double precoVenda, int minEstoque, String nome, String foto) {
		this.precoVenda = precoVenda;
		this.minEstoque = minEstoque;
		this.nome = nome;
		this.foto = foto;
	}
	
	public Produto(double precoVenda, int minEstoque, String nome) {
		this.precoVenda = precoVenda;
		this.minEstoque = minEstoque;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public int getMinEstoque() {
		return minEstoque;
	}

	public void setMinEstoque(int minEstoque) {
		this.minEstoque = minEstoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	

}


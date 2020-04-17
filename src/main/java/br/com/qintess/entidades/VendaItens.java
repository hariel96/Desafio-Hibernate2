package br.com.qintess.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class VendaItens {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produto_id",nullable = false)
	private Produto produto;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "venda_id", nullable = false)
	private Venda venda;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@Column(nullable = false)
	private double PrecoCusto;
	
	@Column(nullable = false)
	private double precoUnit;

	
	public VendaItens() {
		
	}


	public VendaItens(Produto produto, Venda venda, Integer quantidade, double precoCusto, double precoUnit) {
		this.produto = produto;
		this.venda = venda;
		this.quantidade = quantidade;
		PrecoCusto = precoCusto;
		this.precoUnit = precoUnit;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public Venda getVenda() {
		return venda;
	}


	public void setVenda(Venda venda) {
		this.venda = venda;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public double getPrecoCusto() {
		return PrecoCusto;
	}


	public void setPrecoCusto(double precoCusto) {
		PrecoCusto = precoCusto;
	}


	public double getPrecoUnit() {
		return precoUnit;
	}


	public void setPrecoUnit(double precoUnit) {
		this.precoUnit = precoUnit;
	}

	
}

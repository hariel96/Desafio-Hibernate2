package br.com.qintess.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FornecedorHasProduto {

//	@Column(nullable = false)
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "fornecedor_id")
//	private Fornecedor fornecedor;
//	
//	
//	@Column(nullable = false)
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "produto_id")
//	private Produto produto;
	
	@EmbeddedId
	private FornecedorHasProdutoId id;
	
	@Column(nullable = false)
	private Integer estoque;

	@Column(nullable = false)
	private double precoCusto;
	
	public FornecedorHasProduto() {
		
	}

	public FornecedorHasProduto(Fornecedor fornecedor, Produto produto, Integer estoque, double precoCusto) {
		
		this.estoque = estoque;
		this.precoCusto = precoCusto;
	}

	

	public FornecedorHasProdutoId getId() {
		return id;
	}

	public void setId(FornecedorHasProdutoId id) {
		this.id = id;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	
	
	
	
	
	
}

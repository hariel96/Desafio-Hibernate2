package br.com.qintess.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class FornecedorHasProdutoId implements Serializable {

	private static final long serialVersionUID =1L;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Fornecedor fornecedor;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Produto produto;
	
	public FornecedorHasProdutoId() {
		
	}

	public FornecedorHasProdutoId(Fornecedor fornecedor, Produto produto) {
		this.fornecedor = fornecedor;
		this.produto = produto;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}

package br.com.qintess.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String telefone;

	@Column(nullable = false)
	private String contato;

//	@OneToMany (cascade = CascadeType.ALL, mappedBy = "fornecedor")
//	private List<FornecedorHasProduto> FornecedorHasProdutos;

	public Fornecedor() {

	}

	public Fornecedor(String nome, String telefone, String contato) {
		this.nome = nome;
		this.telefone = telefone;
		this.contato = contato;
		// FornecedorHasProdutos = fornecedorHasProdutos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

//	public List<FornecedorHasProduto> getFornecedorHasProdutos() {
//		return FornecedorHasProdutos;
//	}
//
//	public void setFornecedorHasProdutos(List<FornecedorHasProduto> fornecedorHasProdutos) {
//		FornecedorHasProdutos = fornecedorHasProdutos;
//	}

}

package br.com.qintess.entidades;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private Integer idCliente;
	
	@Column(nullable = false)
	private Integer desconto;
	
	@Column(nullable = false)
	private String formaPagamento;
	
	@Column (nullable = false)
	private Timestamp data;
	
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "venda") // OneToMany indica uma venda para muitos itens da venda,
	//e o cascade permite que o hibernate persista todos os objetos que ele precisar
	private List<VendaItens> vendaItens;
	
	public Venda() {
		
	}

	public Venda(Integer idCliente, Integer desconto, String formaPagamento, Timestamp data) {
		this.idCliente = idCliente;
		this.desconto = desconto;
		this.formaPagamento = formaPagamento;
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getDesconto() {
		return desconto;
	}

	public void setDesconto(Integer desconto) {
		this.desconto = desconto;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public List<VendaItens> getVendaItens() {
		return vendaItens;
	}

	public void setVendaItens(List<VendaItens> vendaItens) {
		this.vendaItens = vendaItens;
	}
	
	
	
}

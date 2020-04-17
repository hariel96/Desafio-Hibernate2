package br.com.qintess.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.qintess.connection.ConnectionFactory;
import br.com.qintess.entidades.Fornecedor;
import br.com.qintess.entidades.FornecedorHasProduto;
import br.com.qintess.entidades.Produto;

public class FornecedorHasProdutoDAO {
	public FornecedorHasProduto insert(FornecedorHasProduto fornecedorHasProduto) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			em.persist(fornecedorHasProduto);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return fornecedorHasProduto;
	}
	
	public FornecedorHasProduto update(FornecedorHasProduto fornecedorHasProduto) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			if (fornecedorHasProduto.getId()==null) {
				em.persist(fornecedorHasProduto);
			}else {
				em.merge(fornecedorHasProduto);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return fornecedorHasProduto;
	}
	
	
	public List<FornecedorHasProduto> findAll() {
		EntityManager em = new ConnectionFactory().getConnection();
		List<FornecedorHasProduto> fornecedorHasProdutos = null;

		try {
			fornecedorHasProdutos = em.createQuery("from FornecedorHasProduto").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return fornecedorHasProdutos;
	}
	
	
}

package br.com.qintess.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.qintess.connection.ConnectionFactory;
import br.com.qintess.entidades.Fornecedor;
import br.com.qintess.entidades.Produto;

public class ProdutoDAO {

	public Produto insert(Produto produto) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			em.persist(produto);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return produto;
	}
	
	public Produto update(Produto produto) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			if (produto.getId()==null) {
				em.persist(produto);
			}else {
				em.merge(produto);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return produto;
	}
	
	public Produto findById(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Produto produto = null;

		try {
			produto = em.find(Produto.class, id);
			System.out.println("Nome: " + produto.getNome() +" Preço de venda: "+ produto.getPrecoVenda() + " Estoque: " + produto.getMinEstoque());
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return produto;
	}
	
	public List<Produto> findAll() {
		EntityManager em = new ConnectionFactory().getConnection();
		List<Produto> produtos = null;

		try {
			produtos = em.createQuery("from Produto").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return produtos;
	}
	
	public Produto remove(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Produto produto = em.find(Produto.class, id);
		try {

			em.getTransaction().begin();
			em.remove(produto);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return produto;
	}
}

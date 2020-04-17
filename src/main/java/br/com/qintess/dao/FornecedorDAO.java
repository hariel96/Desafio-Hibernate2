package br.com.qintess.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.qintess.connection.ConnectionFactory;
import br.com.qintess.entidades.Fornecedor;

public class FornecedorDAO {

	public Fornecedor insert(Fornecedor fornecedor) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			em.persist(fornecedor);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return fornecedor;
	}
	
	public Fornecedor update(Fornecedor fornecedor) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			if (fornecedor.getId()==null) {
				em.persist(fornecedor);
			}else {
				em.merge(fornecedor);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return fornecedor;
	}
	
	public Fornecedor findById(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Fornecedor fornecedor = null;

		try {
			fornecedor = em.find(Fornecedor.class, id);
			System.out.println("Nome: " + fornecedor.getNome() +" Contato: "+ fornecedor.getContato() + " Telefone: " + fornecedor.getTelefone());
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return fornecedor;
	}
	
	public List<Fornecedor> findAll() {
		EntityManager em = new ConnectionFactory().getConnection();
		List<Fornecedor> fornecedores = null;

		try {
			fornecedores = em.createQuery("from Fornecedor").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return fornecedores;
	}
	
	public Fornecedor remove(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Fornecedor fornecedor = em.find(Fornecedor.class, id);
		try {

			em.getTransaction().begin();
			em.remove(fornecedor);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return fornecedor;
	}

	
}

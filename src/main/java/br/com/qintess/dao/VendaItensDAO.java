package br.com.qintess.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.qintess.connection.ConnectionFactory;
import br.com.qintess.entidades.Venda;
import br.com.qintess.entidades.VendaItens;

public class VendaItensDAO {
	public VendaItens insert(VendaItens vendaItens) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			em.persist(vendaItens);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return vendaItens;
	}
	
	public VendaItens update(VendaItens vendaItens) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			if (vendaItens.getId()==null) {
				em.persist(vendaItens);
			}else {
				em.merge(vendaItens);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return vendaItens;
	}
	
	public VendaItens findById(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		VendaItens vendaItens = null;

		try {
			vendaItens = em.find(VendaItens.class, id);
			System.out.println("Preco de Custo: "+ vendaItens.getPrecoCusto() + "Preco de Unidade: " + vendaItens.getPrecoUnit() + " Quantidade: " + vendaItens.getQuantidade());
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return vendaItens;
	}
	
	public List<VendaItens> findAll() {
		EntityManager em = new ConnectionFactory().getConnection();
		List<VendaItens> vendasItens = null;

		try {
			vendasItens = em.createQuery("from VendaItens").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return vendasItens;
	}
	
	public VendaItens remove(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		VendaItens vendaItens = em.find(VendaItens.class, id);
		try {

			em.getTransaction().begin();
			em.remove(vendaItens);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return vendaItens;
	}

	
}

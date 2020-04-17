package br.com.qintess.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.qintess.connection.ConnectionFactory;
import br.com.qintess.entidades.Venda;

public class VendaDAO {

	public Venda insert(Venda venda) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			em.persist(venda);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return venda;
	}
	
	public Venda update(Venda venda) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			if (venda.getId()==null) {
				em.persist(venda);
			}else {
				em.merge(venda);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return venda;
	}
	
	public Venda findById(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Venda venda = null;

		try {
			venda = em.find(Venda.class, id);
			System.out.println("Forma de pagamento: "+ venda.getFormaPagamento() + " Data: " + venda.getData() + " Desconto: " + venda.getDesconto() + " ID do cliente: " + venda.getIdCliente());
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return venda;
	}
	
	public List<Venda> findAll() {
		EntityManager em = new ConnectionFactory().getConnection();
		List<Venda> vendas = null;

		try {
			vendas = em.createQuery("from Venda").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return vendas;
	}
	
	public Venda remove(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Venda venda = em.find(Venda.class, id);
		try {

			em.getTransaction().begin();
			em.remove(venda);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return venda;
	}

	
	
}

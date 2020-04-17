package ProjetoHibernate.DesafioHibenate2;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import br.com.qintess.dao.FornecedorDAO;
import br.com.qintess.dao.FornecedorHasProdutoDAO;
import br.com.qintess.dao.ProdutoDAO;
import br.com.qintess.dao.VendaDAO;
import br.com.qintess.dao.VendaItensDAO;
import br.com.qintess.entidades.Fornecedor;
import br.com.qintess.entidades.FornecedorHasProduto;
import br.com.qintess.entidades.FornecedorHasProdutoId;
import br.com.qintess.entidades.Produto;
import br.com.qintess.entidades.Venda;
import br.com.qintess.entidades.VendaItens;

public class App {
	public static void main(String[] args) {

		Venda v = new Venda(8, 500, "Dinheiro", Timestamp.valueOf(LocalDateTime.now()));
		VendaDAO vDAO = new VendaDAO();

		Fornecedor f = new Fornecedor("Jorge", "11 936321254", "jorge@gmail.com");
		FornecedorDAO fDAO = new FornecedorDAO();

		Produto p = new Produto(150, 10, "jaqueta");
		ProdutoDAO pDAO = new ProdutoDAO();

		FornecedorHasProduto fhp = new FornecedorHasProduto(f, p, 100, 15);
		FornecedorHasProdutoDAO fhpDAO = new FornecedorHasProdutoDAO();
		FornecedorHasProdutoId fhpID = new FornecedorHasProdutoId(f, p);
		
		VendaItens vi = new VendaItens(p, v, 200, 3000, 5);
		VendaItensDAO viDAO = new VendaItensDAO();

		// v.setId(1);
		// vDAO.update(v);
		//vDAO.findById(1);
		//for (Venda ve : vDAO.findAll()) {

		//	System.out.println("ID do Cliente: " + ve.getIdCliente() + " Forma de pagamento: " + ve.getFormaPagamento()
		//			+ " Data: " + ve.getData());
		//}

		// f.setId(3);
		// fDAO.update(f);
//		fDAO.findById(2);
//		for (Fornecedor fo : fDAO.findAll()) {
//			System.out.println(
//					"Nome: " + fo.getNome() + " Contato: " + fo.getContato() + " Telefone: " + fo.getTelefone());
//		}

		// pDAO.insert(p);
		// p.setId(2);
		// pDAO.update(p);
		//pDAO.findById(3);
//		for (Produto po : pDAO.findAll()) {
//			System.out.println("Nome: " + po.getNome() + " Preço de Venda: " + po.getPrecoVenda() + " Estoque: "
//					+ po.getMinEstoque());
//		}

		// fhp.setId(fhpID);
		// fhpDAO.insert(fhp);
//		for (FornecedorHasProduto forn : fhpDAO.findAll()) {
//			System.out.println("Estoque: " + forn.getEstoque());
			
		//viDAO.insert(vi);
		//vi.setId(2);
		//viDAO.update(vi);
		
		viDAO.findById(2);
		
		for (VendaItens via: viDAO.findAll()) {
			System.out.println("Preço de Custo: " + via.getPrecoCusto() + " Preço por Unidade: " + via.getPrecoUnit() + " Quantidade: " + via.getQuantidade() );
		}
		
		
		}
	}


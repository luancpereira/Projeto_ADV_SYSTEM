package br.edu.ifsuldeminas.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifsuldeminas.dao.ComandaDao;
import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.dao.ItemComandaDao;
import br.edu.ifsuldeminas.modelo.Comanda;
import br.edu.ifsuldeminas.modelo.ItemComanda;
import br.edu.ifsuldeminas.modelo.Produto;

@ManagedBean
@ViewScoped
public class ComandaController {
	private Comanda comanda = new Comanda();
	private Integer qtde;
	private Integer produtoId;

	public Comanda getComanda() {
		return comanda;
	}

	public Integer getQtde() {
		return qtde;
	}
	
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}
	
	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public List<Produto> getTodosProdutos(){
		return new Dao<Produto>(Produto.class).listaTodos();
	}
	
	public void gravarItem(){
		Produto p = new Dao<Produto>(Produto.class).listaPorId(produtoId);
		
		ItemComanda item = new ItemComanda();
		item.setProduto(p);
		item.setValorUnitario(p.getValor());
		item.setQtde(qtde);
		item.setComanda(comanda);
		
		comanda.add(item);
		
		produtoId = null;
		qtde = 0;
	}
	
	public List<ItemComanda> getItensDaComanda() {
		return comanda.getItens();
	}
	
	public void removerItem(ItemComanda item){
		comanda.getItens().remove(item);
	}
	
	public void gravar(){
		if (this.comanda.getId() == null) {
			new Dao<Comanda>(Comanda.class).adiciona(comanda);
		} else {
			new Dao<Comanda>(Comanda.class).atualiza(comanda);
		}
		
		this.comanda = new Comanda();
	}

	public List<Comanda> getTodasComandas(){
		return new Dao<Comanda>(Comanda.class).listaTodos();
		
	}
	
	public void remover(Comanda c){
		new Dao<Comanda>(Comanda.class).remove(c.getId());
	}
	
	public void carregar(Comanda c){
		comanda = new ComandaDao().listaPorId(c);
		
	}
}

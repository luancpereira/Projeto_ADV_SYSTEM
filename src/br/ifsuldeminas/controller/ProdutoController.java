package br.ifsuldeminas.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifsuldeminas.edu.dao.Dao;
import br.edu.ifsuldeminas.modelo.Produto;
import br.edu.ifsuldeminas.modelo.Tipo;

@ManagedBean
@ViewScoped
public class ProdutoController {
	
	private Produto produto = new Produto();
	private Integer tipoId;
	
	public Integer getTipoId() {
		return tipoId;
	}
	public List<Tipo> getTodosTipos(){
		return new Dao<Tipo>(Tipo.class).listaTodos();
	}
	

	public void setTipoId(Integer tipoId) {
		this.tipoId = tipoId;
	}

	public void gravar(){
		
		Dao<Produto> dao = new Dao<Produto>(Produto.class);
		
		Tipo t = new Dao<Tipo>(Tipo.class).listaPorId(tipoId);
		produto.setTipo(t);
		
		if(produto.getId() == null)
			dao.adiciona(produto);
		else 
			dao.atualiza(produto);
		
		
		produto = new Produto();
		tipoId = null;
	}
	
	public void carregar(Produto p){
		this.produto = p;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getTodosProdutos(){
		return new Dao<Produto>(Produto.class).listaTodos();
	}
	public void remover(Produto p){
		new Dao<Produto>(Produto.class).remove(p.getId());
	}
}

package br.edu.ifsuldeminas.controller;

import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.dao.GrupoDao;
import br.edu.ifsuldeminas.modelo.Funcionalidade;
import br.edu.ifsuldeminas.modelo.Grupo;

@ManagedBean
@ViewScoped
public class GrupoController {
	private Grupo grupo = new Grupo();
	
	private List<String> funcionalidadesSelecionadas = new LinkedList<String>();
	
	public List<String> getFuncionalidadesSelecionadas() {
		return funcionalidadesSelecionadas;
	}
	
	public void setFuncionalidadesSelecionadas(List<String> funcionalidadesSelecionadas) {
		this.funcionalidadesSelecionadas = funcionalidadesSelecionadas;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void gravar() {
		Dao<Funcionalidade> dao = new Dao<Funcionalidade>(Funcionalidade.class);
		
		List<Funcionalidade> lista = new LinkedList<Funcionalidade>();
		
		for(String s : funcionalidadesSelecionadas){
			Funcionalidade f = dao.listaPorId(Integer.parseInt(s));
			lista.add(f);
		}
		
		grupo.setFuncionalidade(lista);
		
		if (grupo.getId() == null) {
			new Dao<Grupo>(Grupo.class).adiciona(grupo);
		} else {
			new Dao<Grupo>(Grupo.class).atualiza(grupo);
		}

		grupo = new Grupo();
		funcionalidadesSelecionadas = new LinkedList<String>();
	}

	public List<Grupo> getTodosGrupos() {
		return new Dao<Grupo>(Grupo.class).listaTodos();
	}

	public List<Funcionalidade> getTodasFuncionalidades() {
		return new Dao<Funcionalidade>(Funcionalidade.class).listaTodos();
	}

	public void carregar(Grupo g) {
		grupo = new GrupoDao().listaPorId(g);
		
		for(Funcionalidade f : grupo.getFuncionalidades()){
			funcionalidadesSelecionadas.add(String.valueOf(f.getId()));
		}
		
	}	

	public void remover(Grupo g) {
		new Dao<Grupo>(Grupo.class).remove(g.getId());
	}

}

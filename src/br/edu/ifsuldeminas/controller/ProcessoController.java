package br.edu.ifsuldeminas.controller;


import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.modelo.TipoProcesso;
import br.edu.ifsuldeminas.modelo.Processos;



@ManagedBean
@ViewScoped

public class ProcessoController {
	
	private Processos processos = new Processos(); 
	
	
	public Processos getProcessos() {
		return processos;
	}

	public void setProcessos(Processos processos) {
		this.processos = processos;
	}

	public void gravar(){
		if (processos.getId() == null){
			new Dao<Processos>(Processos.class).adiciona(processos);
		} else {
			new Dao<Processos>(Processos.class).atualiza(processos);
		}
		this.processos = new Processos();
	}
	
	public void remover(Processos p){
		new Dao<Processos>(Processos.class).remove(p.getId());
	}
	public List<TipoProcesso> getTodosTipos(){
		return Arrays.asList(TipoProcesso.values());
	}
}


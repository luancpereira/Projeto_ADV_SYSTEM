package br.edu.ifsuldeminas.controller;

import java.util.Arrays;
import java.util.List;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.modelo.Pessoa;
import br.edu.ifsuldeminas.modelo.Sexo;

public class PessoaController {
	
	public void gravar(Pessoa p){
		if (p.getId() == null){
			new Dao<Pessoa>(Pessoa.class).adiciona(p);
		} else {
			new Dao<Pessoa>(Pessoa.class).atualiza(p);
		}
	}
	
	public List<Sexo> getTodosSexos(){
		return Arrays.asList(Sexo.values());
	}
	
	public void remover(Pessoa p){
		new Dao<Pessoa>(Pessoa.class).remove(p.getId());
	}
}

package br.edu.ifsuldeminas.controller;



import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.modelo.cargo;

public class CargoController {

	public void gravar(cargo p){
		if (p.getId() == null){
			new Dao<cargo>(cargo.class).adiciona(p);
		} else {
			new Dao<cargo>(cargo.class).atualiza(p);
		}
	}
	
	public void remover(cargo p){
		new Dao<cargo>(cargo.class).remove(p.getId());
	}
}

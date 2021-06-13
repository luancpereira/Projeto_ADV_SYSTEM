package br.edu.ifsuldeminas.utils;

import br.edu.ifsuldeminas.dao.Dao;
import br.edu.ifsuldeminas.modelo.Funcionalidade;

public class InsereFuncionalidades {
	
	public static void main(String[] args) {
		Dao<Funcionalidade> dao = new Dao<Funcionalidade>(Funcionalidade.class);
		
		Funcionalidade f1 = new Funcionalidade();
		f1.setNome("Tipo");
		f1.setPágina("tipo.xhtml");
		
		Funcionalidade f2 = new Funcionalidade();
		f2.setNome("Produto");
		f2.setPágina("produto.xhtml");
		
		Funcionalidade f3 = new Funcionalidade();
		f3.setNome("Cliente");
		f3.setPágina("cliente.xhtml");
		
		Funcionalidade f4 = new Funcionalidade();
		f4.setNome("Funcionario");
		f4.setPágina("funcionario.xhtml");
		
		dao.adiciona(f1);
		dao.adiciona(f2);
		dao.adiciona(f3);
		dao.adiciona(f4);
	}

}

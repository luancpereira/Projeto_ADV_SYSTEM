package br.edu.ifsuldeminas.modelo;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Grupo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@ManyToMany
	private List<Funcionalidade> funcionalidades = new LinkedList<Funcionalidade>();
	
	public List<Funcionalidade> getFuncionalidades() {
		return funcionalidades;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setFuncionalidade(List<Funcionalidade> lista) {
		// TODO Auto-generated method stub
		
	}





}

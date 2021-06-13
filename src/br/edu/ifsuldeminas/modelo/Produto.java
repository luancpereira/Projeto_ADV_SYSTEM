package br.edu.ifsuldeminas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity //tabela
public class Produto {
	@Id //chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto-incremental
	private Integer id;
	private String nome;
	private Integer qtde;
	private Integer qtdeMin;
	private Double valor;
	
	@ManyToOne
	private Tipo tipo = new Tipo();
	
	
	
	
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
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
	public Integer getQtde() {
		return qtde;
	}
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}
	public Integer getQtdeMin() {
		return qtdeMin;
	}
	public void setQtdeMin(Integer qtdeMin) {
		this.qtdeMin = qtdeMin;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}

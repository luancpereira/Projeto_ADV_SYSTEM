package br.edu.ifsuldeminas.modelo;

import java.util.Calendar;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Processos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String numeroProcesso;
	private String vara;
	private String juiz;
	
	private TipoProcesso tipo;
	
	private Calendar dataEntrada = Calendar.getInstance();

	private Calendar dataTermino = Calendar.getInstance();
	
	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumeroProcesso() {
		return numeroProcesso;
	}
	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}
	public String getVara() {
		return vara;
	}
	public void setVara(String vara) {
		this.vara = vara;
	}
	public String getJuiz() {
		return juiz;
	}
	public void setJuiz(String juiz) {
		this.juiz = juiz;
	}

	public TipoProcesso getTipo() {
		return tipo;
	}
	public void setTipo(TipoProcesso tipo) {
		this.tipo = tipo;
	}
	public Calendar getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Calendar getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(Calendar dataTermino) {
		this.dataTermino = dataTermino;
	}
	
	
}

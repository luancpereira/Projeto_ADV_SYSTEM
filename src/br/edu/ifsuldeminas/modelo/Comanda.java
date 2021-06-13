package br.edu.ifsuldeminas.modelo;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comanda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double valor;

	@Temporal(TemporalType.DATE)
	private Calendar dtComanda = Calendar.getInstance();
	
	// cascade all: ao inserir, alterar e remover cascade
	@OneToMany(mappedBy="comanda", cascade= CascadeType.ALL, orphanRemoval = true)
	private List<ItemComanda> itens = new LinkedList<ItemComanda>();

	public void add(ItemComanda item) {
		this.itens.add(item);
	}
	
	public Double getValorTotal() {
		// calcula total
		 valor = 0.0;
		
		for(ItemComanda item : itens){
			valor = valor + item.getValorUnitario() * item.getQtde();
		}
		
		return valor;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Calendar getDtComanda() {
		return dtComanda;
	}

	public void setDtComanda(Calendar dtComanda) {
		this.dtComanda = dtComanda;
	}

	public List<ItemComanda> getItens() {
		return itens;
	}

	public void setItens(List<ItemComanda> itens) {
		this.itens = itens;
	}

}

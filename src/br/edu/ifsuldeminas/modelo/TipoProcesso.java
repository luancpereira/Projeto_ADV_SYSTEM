package br.edu.ifsuldeminas.modelo;

public enum TipoProcesso {
	CIVEL("Civel"), CRIMINAL("Criminal");
	
	private String descricao;

	private TipoProcesso(String desc) {
		this.descricao = desc;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}

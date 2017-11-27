package br.com.lrsantos.pedido.filial.model.bean;

public enum SituacaoCliente {
	
	NOR("Normal"), IND("Inadimplente"), INA("Inatvo"), DEV("Devedor"), NOV("Novo");
	
	private String value;
	
	private SituacaoCliente(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	 

}

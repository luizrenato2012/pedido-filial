package br.com.lrsantos.pedido.filial.model.bean;

public enum UF {
	AC("AC"), AM ("AM"), AP("AP"), MA("MA"),PA("PA"),TO("TO");
	
	private String value;
	
	private UF(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}

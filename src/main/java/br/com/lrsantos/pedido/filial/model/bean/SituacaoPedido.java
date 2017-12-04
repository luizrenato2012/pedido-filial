package br.com.lrsantos.pedido.filial.model.bean;

public enum SituacaoPedido {

	AB("Aberto"), EA("Em Analise"), FC("Fechada"), PD("Pendente");
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	private SituacaoPedido(String descricao) {
		this.descricao = descricao;
	}
	
	
}

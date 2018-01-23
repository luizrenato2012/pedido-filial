package br.com.lrsantos.pedido.filial.model.bean;

import java.io.Serializable;

public class ItemPedidoID implements Serializable{

	private static final long serialVersionUID = 9045566983183750377L;
	
	private Integer numero;
	
	private Long pedido;
	
	public ItemPedidoID() {
		super();
	}
	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Long getPedido() {
		return pedido;
	}

	public void setPedido(Long pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidoID other = (ItemPedidoID) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		return true;
	}
}

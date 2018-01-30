package br.com.lrsantos.pedido.filial.model.bean;

import java.io.Serializable;


public  class PedidoId implements Serializable {
	
	private static final long serialVersionUID = 5286520553385297033L;

	private Long id;
	
	private Filial filial;

	public PedidoId() {
		super();
	}
	
	public PedidoId(Long id, Filial filial) {
		super();
		this.id = id;
		this.filial = filial;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filial == null) ? 0 : filial.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PedidoId other = (PedidoId) obj;
		if (filial == null) {
			if (other.filial != null)
				return false;
		} else if (!filial.equals(other.filial))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}
	
	
	
}
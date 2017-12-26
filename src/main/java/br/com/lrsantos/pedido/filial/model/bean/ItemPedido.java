package br.com.lrsantos.pedido.filial.model.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="db.item_pedido")
public class ItemPedido {
	
	@EmbeddedId
	private ItemPedidoID id;
	
	@Column(precision=6, scale=2)
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name="id_produto")
	private Produto produto;
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	@Embeddable
	public static class ItemPedidoID implements Serializable {
		private static final long serialVersionUID = 9045566983183750377L;

		private Integer numero;
		
		@ManyToOne
		@JoinColumn(name="id_pedido")
		private Pedido pedido;
		
		public ItemPedidoID() {
			super();
		}
		
		public ItemPedidoID(Integer numero, Pedido pedido) {
			super();
			this.numero = numero;
			this.pedido = pedido;
		}

		public Integer getNumero() {
			return numero;
		}

		public void setNumero(Integer numero) {
			this.numero = numero;
		}

		public Pedido getPedido() {
			return pedido;
		}

		public void setPedido(Pedido pedido) {
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
	
	
}

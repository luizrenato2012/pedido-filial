package br.com.lrsantos.pedido.filial.model.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(ItemPedidoID.class)
@Table(name="db.item_pedido")
public class ItemPedido implements Serializable {
	
	private static final long serialVersionUID = -5244754215391977588L;

	@Id
	private Integer numero;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_pedido")
	private br.com.lrsantos.pedido.filial.model.bean.Pedido pedido;
	
	@Column(precision=6, scale=2)
	private BigDecimal valor;
	
	@Column
	private Integer quantidade;
	
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
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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
	
	
	
	
}

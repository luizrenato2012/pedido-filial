package br.com.lrsantos.pedido.filial.model.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="db.pedido")
@SequenceGenerator(name="SEQ_ID_PEDIDO", sequenceName="seq_id_pedido", schema="db", allocationSize=1)
public class Pedido implements Serializable {

	private static final long serialVersionUID = 8568405936214209751L;
	
	@EmbeddedId
	private PedidoId id;
	
	@Column
	private Long numero;
	
	@Column(name="data_hora")
	private LocalDateTime dataHora;
	
	@Column(name="valor_total")
	private BigDecimal valorTotal;
	
	@Column(name="id_situacao")
	@Enumerated(EnumType.STRING)
	private SituacaoPedido situacao;
	
	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE}, mappedBy="pedido")
	private List<ItemPedido> itens;
	
	@ManyToOne
	@JoinColumn(name="id_cliente", insertable=true)
	private Cliente cliente;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
		result = prime * result + ((itens == null) ? 0 : itens.hashCode());
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
		Pedido other = (Pedido) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (dataHora == null) {
			if (other.dataHora != null)
				return false;
		} else if (!dataHora.equals(other.dataHora))
			return false;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		return true;
	}


	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime data) {
		this.dataHora = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public SituacaoPedido getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPedido situacao) {
		this.situacao = situacao;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	public PedidoId getId() {
		return id;
	}

	public void setId(PedidoId id) {
		this.id = id;
	}

	@Embeddable
	public static class PedidoId implements Serializable {
		
		private static final long serialVersionUID = 5286520553385297033L;

		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_PEDIDO")
		private Long id;
		
		@ManyToOne
		@JoinColumn(name="id_filial")
		private Filial filial;

		public PedidoId() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Filial getFilial() {
			return filial;
		}

		public void setFilial(Filial filial) {
			this.filial = filial;
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
		
	}
	
	
}


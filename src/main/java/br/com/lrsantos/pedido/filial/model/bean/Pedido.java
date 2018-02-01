package br.com.lrsantos.pedido.filial.model.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="db.pedido")
@IdClass(PedidoId.class)
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = -5478054316354838402L;
	
	@Id
	@SequenceGenerator(name="SEQ_ID_PEDIDO", schema="db", sequenceName="seq_id_pedido", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_PEDIDO")
	private Long id;
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_filial", insertable=false, updatable=false)
	private Filial filial;

	@Column
	private Long numero;
	
	@Column(name="data_hora")
	private LocalDateTime dataHora;
	
	@Column(name="valor_total")
	private BigDecimal valorTotal;
	
	@Column(name="id_situacao")
	@Enumerated(EnumType.STRING)
	private SituacaoPedido situacao;
	
	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE}, mappedBy="id.pedido")
	private List<ItemPedido> itens;
	
	@ManyToOne
	@JoinColumn(name="id_cliente", insertable=true)
	private Cliente cliente;

	public Pedido() {
		super();
	}
	
	public void addItem(ItemPedido item) {
		if(this.itens==null){
			this.itens = new ArrayList<ItemPedido>();
		}
		this.itens.add(item);
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
	
}


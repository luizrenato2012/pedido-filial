package br.com.lrsantos.pedido.filial.model.bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="db.pedido")
@Entity
@SequenceGenerator(name="SEQ_ID_PEDIDO", sequenceName="seq_id_pedido", schema="db", allocationSize=1)
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_PEDIDO")
	private Long id;
	
	private LocalDate data;
	
	private BigDecimal valorTotal;
	
	@Column(name="id_situacao")
	@Enumerated(EnumType.STRING)
	private SituacaoPedido situacao;
	
	@OneToMany
	private List<ItemPedido> itens;
	
	
}

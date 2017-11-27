package br.com.lrsantos.pedido.filial.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="db.cliente")
@SequenceGenerator(name="SEQ_ID_CLIENTE", sequenceName="seq_id_cliente", schema="db", allocationSize=1)
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_CLIENTE")
	private Long id;

	@OneToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;
	
	@Column(name="situacao")
	@Enumerated(EnumType.STRING)
	private SituacaoCliente situacaoCliente;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public SituacaoCliente getSituacaoCliente() {
		return situacaoCliente;
	}

	public void setSituacaoCliente(SituacaoCliente situacaoCliente) {
		this.situacaoCliente = situacaoCliente;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", pessoa=" + pessoa + ", situacaoCliente=" + situacaoCliente + "]";
	}
	
}

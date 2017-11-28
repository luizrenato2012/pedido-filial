package br.com.lrsantos.pedido.filial.model.bean;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="db.pessoa")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo")
@SequenceGenerator(name="SEQ_ID_PESSOA", sequenceName="seq_id_pessoa", schema="db", allocationSize=1)
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_PESSOA")
	private Long id;
	
	private String nome;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE}) // caso especfico de teste normalmente é lista
	@JoinColumn(name="id_endereco")
	private Endereco endereco;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE}) // caso especfico de teste normalmente é lista
	@JoinColumn(name="id_telefone")
	private Telefone telefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + "]";
	}
	
}

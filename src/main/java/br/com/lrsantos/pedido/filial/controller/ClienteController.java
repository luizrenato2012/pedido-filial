package br.com.lrsantos.pedido.filial.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lrsantos.pedido.filial.model.bean.Cliente;
import br.com.lrsantos.pedido.filial.model.bean.PessoaJuridica;
import br.com.lrsantos.pedido.filial.model.bean.SituacaoCliente;
import br.com.lrsantos.pedido.filial.model.service.ClienteService;

@Named
@RequestScoped
public class ClienteController {

	@EJB
	private ClienteService clienteService;
	
	@Inject
	private Cliente cliente;
	
	@PostConstruct
	private void init() {
		cliente.setPessoa( new PessoaJuridica());
		cliente.setSituacaoCliente(SituacaoCliente.NOV);
	}
	
	public void incluir() {
		System.out.println("incluindo");
		try{
			this.valida(this.cliente);
			this.clienteService.persist(this.cliente);
			this.initCliente();
			FacesMessageUtil.exibeMensagemInfo("Cliente incluido com sucesso!", "Cliente", "msgCliente");
		} catch (Exception e ) {
			FacesMessageUtil.exibeMensagemErro("Erro ao incluir cliente", "Cliente", "msgCliente");
			e.printStackTrace();
		}
	}
	
	private void initCliente() {
		this.cliente= new Cliente();
		this.cliente.setPessoa( new PessoaJuridica());
		this.cliente.setSituacaoCliente(SituacaoCliente.NOV);
	}

	private void valida(Cliente cliente) {
		if(cliente==null){
			throw new RuntimeException("Cliente nulo");
		}
		
		if(cliente.getPessoa()==null ){
			throw new RuntimeException("Pessoa invalida/nula");
		}
	}
	
}

package br.com.lrsantos.pedido.filial.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lrsantos.pedido.filial.model.bean.Endereco;
import br.com.lrsantos.pedido.filial.model.bean.UF;
import br.com.lrsantos.pedido.filial.model.service.EnderecoService;

@Named
@RequestScoped
public class EnderecoController {
	
	@EJB
	private EnderecoService service;
	
	@Inject
	private Endereco endereco;
	
	public void incluir() {
		System.out.println("incluindo");
		try{
			this.valida(this.endereco);
			this.service.persist(endereco);
			this.endereco = new Endereco();
			FacesMessageUtil.exibeMensagemInfo("Endereco incluido com sucesso!", "Endereço", "msgEndereco");
		} catch (Exception e ) {
			FacesMessageUtil.exibeMensagemErro("Erro ao incluir endereco", "Endereço", "msgEndereco");
			e.printStackTrace();
		}
	}
	
	private void valida(Endereco endereco) {
		if(endereco==null){
			throw new RuntimeException("Endereco nulo");
		}
		
		if(endereco.getLogradouro()==null || endereco.getLogradouro().trim().equals("")){
			throw new RuntimeException("Logradouro invalido/nulo");
		}
		
		if(endereco.getCidade()==null || endereco.getCidade().trim().equals("")){
			throw new RuntimeException("Cidade invalida/nula");
		}
	}
	
	public List<SelectItem> getListaUfs() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		for(UF uf : UF.values()){
			items.add(new SelectItem(uf, uf.getValue()));
		}
		return items;
	}
	

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}

package br.com.lrsantos.pedido.filial.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.Logger;

import br.com.lrsantos.pedido.filial.model.bean.Endereco;
import br.com.lrsantos.pedido.filial.model.bean.Filial;
import br.com.lrsantos.pedido.filial.model.bean.PessoaJuridica;
import br.com.lrsantos.pedido.filial.model.service.FilialService;

@Named
@RequestScoped
public class FilialController {

	@EJB
	private FilialService filialService;
	
	private Filial filial;
	
	private PessoaJuridica pessoa;
	
	private Logger logger = Logger.getLogger(FilialController.class);
	private final String msgFilial="msgFilial";
	
	@PostConstruct
	private void init () {
		this.logger.info("Iniciando objetos");
		this.filial = new Filial();
		this.pessoa = new PessoaJuridica();
		this.pessoa.setEndereco(new Endereco());
	}
	
	public void incluir() {
		try {
			this.filial.setPessoaJuridica(this.pessoa);
			valida(this.filial);
			//validaFilialNaMatriz(sigla);
			this.filialService.persist(filial);
			this.init();
			FacesMessageUtil.exibeMensagemInfo("Filial cadastrada com sucesso!", "Filial", msgFilial );
		} catch (Exception e) {
			logger.error(e.getMessage());
			FacesMessageUtil.exibeMensagemErro("Erro ao incluir filial", "Filial", msgFilial);
		}
	}

	private void valida(Filial filial) {
		String sigla = filial.getSigla();
		PessoaJuridica pessoa = filial.getPessoaJuridica();
		
		if( StringUtils.isEmpty(sigla)){
			throw new RuntimeException("Sigla nula/invalida");
		}
		
		if (pessoa==null ){
			throw new RuntimeException("Pessoa nula");
		}
		
		if(StringUtils.isEmpty(pessoa.getNome())){
			throw new RuntimeException("Nome da pessoa nulo/invalido");
		}
	}
	
	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public PessoaJuridica getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaJuridica pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<SelectItem> getListaUfs() {
		return UFSelectItemUtils.getItensUF();
	}
	
	public List<Filial> getFiliais() {
		return this.filialService.listAll(Filial.class);
	}
	
}

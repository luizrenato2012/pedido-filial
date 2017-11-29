package br.com.lrsantos.pedido.filial.controller;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.lrsantos.pedido.filial.model.bean.Produto;
import br.com.lrsantos.pedido.filial.model.service.ProdutoService;

@Named
@RequestScoped
public class ProdutoController {

	@EJB
	private ProdutoService produtoService;
	
	@Inject
	private Produto produto;
	
	private final String MSG_PRODUTO= "msgProduto";
	
	public void incluir(){
		try {
			//existeProdutoNaFilial(this.produto)
			//existeProdutoNaCentral(this.produto)
			valida(this.produto);
			this.produtoService.persist(this.produto);
			this.produto = new Produto();
			FacesMessageUtil.exibeMensagemInfo("Produto cadastrado com sucesso!", "Produto", MSG_PRODUTO);
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessageUtil.exibeMensagemErro("Erro ao cadastrar produto: "+ e.getMessage(), "Produto", MSG_PRODUTO);
		}
	}

	private void valida(Produto produto) {
		if(produto==null) {
			throw new RuntimeException("Produto nulo/invalido");
		}
		
		if (StringUtils.isEmpty(produto.getDescricao())) {
			throw new RuntimeException("Descricao nula/invalida");
		}
		
		if (produto.getPreco()==null || produto.getPreco().equals(BigDecimal.ZERO)){
			throw new RuntimeException("Preco nulo/invalido");
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}

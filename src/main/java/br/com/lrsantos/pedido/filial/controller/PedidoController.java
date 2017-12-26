package br.com.lrsantos.pedido.filial.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import br.com.lrsantos.pedido.filial.model.bean.Pedido;
import br.com.lrsantos.pedido.filial.model.bean.SituacaoPedido;
import br.com.lrsantos.pedido.filial.model.service.PedidoService;

@Named
public class PedidoController {

	@EJB
	private PedidoService pedidoService;
	private Pedido pedido;
	
	@PostConstruct
	private void init() {
		this.pedido = new Pedido();
		this.pedido.setDataHora(LocalDateTime.now());
		this.pedido.setSituacao(SituacaoPedido.CR);
	}
	
	public void incluir() {
		try {
			this.valida(this.pedido);
			this.pedidoService.persist(pedido);
			FacesMessageUtil.exibeMensagemInfo("Pedido criado com sucesso", "Pedido", "msgPedido");
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessageUtil.exibeMensagemErro("Erro ao criar pedido", "Pedido", "msgPedido");
		}
	}
	
	private void valida(Pedido pedido) {
		if(pedido==null){
			throw new RuntimeException("Pedido nulo/invalido");
		}
		
		if(pedido.getDataHora()==null){
			throw new RuntimeException("Data do pedido nula/invalida");
		}
		
		if (pedido.getValorTotal()==null || pedido.getValorTotal().equals(BigDecimal.ZERO)) {
			throw new RuntimeException("Valor total do pedido nulo/invalido");
		}
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}

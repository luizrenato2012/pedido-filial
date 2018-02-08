package br.com.lrsantos.pedido.filial.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.jboss.logging.Logger;

import br.com.lrsantos.pedido.filial.model.bean.Cliente;
import br.com.lrsantos.pedido.filial.model.bean.ItemPedido;
import br.com.lrsantos.pedido.filial.model.bean.Pedido;
import br.com.lrsantos.pedido.filial.model.bean.Produto;
import br.com.lrsantos.pedido.filial.model.bean.SituacaoPedido;
import br.com.lrsantos.pedido.filial.model.service.PedidoService;

@Named
@ViewScoped
public class PedidoController implements Serializable {

	private static final long serialVersionUID = -5217087875367844834L;

	@EJB
	private PedidoService pedidoService;
	
	private Pedido pedido;
	private Cliente cliente;
	private List<ItemPedido> itens;
	private ItemPedido itemEdicao;
	private static Logger log = Logger.getLogger(PedidoController.class);
	
	@PostConstruct
	private void init() {
		this.pedido = new Pedido();
		this.pedido.setDataHora(LocalDateTime.now());
		this.pedido.setSituacao(SituacaoPedido.CR);
		this.itemEdicao = new ItemPedido();
		this.itemEdicao.setProduto(new Produto());
	}
	
	public void testePedido() {
		this.pedidoService.teste();
	}
	
	public void incluir() {
		log.info("Incluindo pedido");
		try {
			this.valida(this.pedido);
			this.pedidoService.persist(pedido);
			FacesMessageUtil.exibeMensagemInfo("Pedido criado com sucesso", "Pedido", "msgPedido");
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessageUtil.exibeMensagemErro("Erro ao criar pedido", "Pedido", "msgPedido");
		}
	}
	
	public void incluiItem() {
		log.info("Incluindo item pedido");
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

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public ItemPedido getItem() {
		return itemEdicao;
	}

	public void setItem(ItemPedido item) {
		this.itemEdicao = item;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ItemPedido getItemEdicao() {
		return itemEdicao;
	}

	public void setItemEdicao(ItemPedido itemEdicao) {
		this.itemEdicao = itemEdicao;
	}
	
}

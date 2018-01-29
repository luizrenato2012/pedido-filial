package br.com.lrsantos.pedido.filial.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import br.com.lrsantos.pedido.filial.model.bean.Cliente;
import br.com.lrsantos.pedido.filial.model.bean.Filial;
import br.com.lrsantos.pedido.filial.model.bean.ItemPedido;
import br.com.lrsantos.pedido.filial.model.bean.Pedido;
import br.com.lrsantos.pedido.filial.model.bean.Produto;
import br.com.lrsantos.pedido.filial.model.bean.SituacaoPedido;
import br.com.lrsantos.pedido.filial.model.bean.Pedido.PedidoId;
import br.com.lrsantos.pedido.filial.model.service.ClienteService;
import br.com.lrsantos.pedido.filial.model.service.FilialService;
import br.com.lrsantos.pedido.filial.model.service.PedidoService;
import br.com.lrsantos.pedido.filial.model.service.ProdutoService;

@Named
public class PedidoController {

	@EJB
	private PedidoService pedidoService;
	
	@EJB
	private ClienteService clienteService;
	
	@EJB
	private ProdutoService produtoService;
	
	@EJB
	private FilialService filialservice;
	
	private Pedido pedido;
	
	private List<ItemPedido> itens;
	private ItemPedido item;
	
	@PostConstruct
	private void init() {
		this.pedido = new Pedido();
		this.pedido.setDataHora(LocalDateTime.now());
		this.pedido.setSituacao(SituacaoPedido.CR);
		this.item = new ItemPedido();
		this.item.setProduto(new Produto());
	}
	
	public void testePedido() {
		Pedido pedido = new Pedido();
		PedidoId pedidoId = new PedidoId();
		//Filial filial = this.filialservice.find(11l, Filial.class);
//		/pedidoId.setFilial(filial);
		pedido.setId(pedidoId);
		pedido.setDataHora(LocalDateTime.now());
		pedido.setSituacao(SituacaoPedido.AB);
		
//		pedido.set
		ItemPedido item = new ItemPedido();
//		ItemPedidoID itemId = new ItemPedidoID();
//		itemId.setNumero(1);
//		itemId.setPedido(pedido.getId());
		item.setNumero(1);
		item.setPedido(pedido);
		Produto produto = this.produtoService.find(14l, Produto.class);
		item.setProduto(produto);
		
		pedido.setItens(new ArrayList<>());
		pedido.getItens().add(item);
		
		Cliente cliente = this.clienteService.find(1l, Cliente.class);
		pedido.setCliente(cliente);
		this.pedidoService.persist(pedido);
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

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public ItemPedido getItem() {
		return item;
	}

	public void setItem(ItemPedido item) {
		this.item = item;
	}
	
}

package br.com.lrsantos.pedido.filial.model.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.lrsantos.pedido.filial.model.bean.Cliente;
import br.com.lrsantos.pedido.filial.model.bean.Filial;
import br.com.lrsantos.pedido.filial.model.bean.ItemPedido;
import br.com.lrsantos.pedido.filial.model.bean.Pedido;
import br.com.lrsantos.pedido.filial.model.bean.Produto;
import br.com.lrsantos.pedido.filial.model.bean.SituacaoPedido;

@Stateless
public class PedidoService extends ServiceImpl<Pedido, Long> {

	@EJB
	private ClienteService clienteService;
	
	@EJB
	private ProdutoService produtoService;
	
	@EJB
	private FilialService filialservice;
	
	@EJB
	private ItemPedidoService itemPedidoService;
	
	public void teste() {
		Pedido pedido = new Pedido();
		Filial filial = this.filialservice.find(12l, Filial.class);
		pedido.setFilial(filial);
		pedido.setDataHora(LocalDateTime.now());
		pedido.setSituacao(SituacaoPedido.AB);
		pedido.setNumero(1002l);
		pedido.setValorTotal(new BigDecimal(9.3));
		this.persist(pedido);
		
		ItemPedido item = new ItemPedido();
		item.setId(new ItemPedido.ItemPedidoID(new Integer(3 ), pedido));
		Produto produto = this.produtoService.find(14l, Produto.class);
		item.setProduto(produto);
		item.setQuantidade(2);
		item.setValor(new BigDecimal(9.3));
		this.itemPedidoService.persist(item);
		
		pedido.addItem(item);
		
		Cliente cliente = this.clienteService.find(1l, Cliente.class);
		pedido.setCliente(cliente);
		this.update(pedido);
	}
}

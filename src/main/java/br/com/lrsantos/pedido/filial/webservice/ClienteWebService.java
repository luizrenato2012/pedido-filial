package br.com.lrsantos.pedido.filial.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.lrsantos.pedido.filial.model.bean.Cliente;

@WebService(name="ServiceCliente")
public interface ClienteWebService {
	
	@WebMethod(operationName="inclui", action="incluiCliente")
	public void inclui( Cliente cliente) ;

}

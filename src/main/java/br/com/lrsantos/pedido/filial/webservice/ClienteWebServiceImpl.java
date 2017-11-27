package br.com.lrsantos.pedido.filial.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.lrsantos.pedido.filial.model.bean.Cliente;

@WebService(serviceName="ServiceCliente")
public class ClienteWebServiceImpl implements ClienteWebService{

	@Override
	@WebMethod(operationName="inclui", action="incluiCliente")
	public void inclui(@WebParam(name="cliente", partName="cliente")Cliente cliente) {
		System.out.println(cliente);
	}

}

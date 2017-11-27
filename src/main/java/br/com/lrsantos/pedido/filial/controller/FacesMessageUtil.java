package br.com.lrsantos.pedido.filial.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesMessageUtil {
	
	public static void exibeMensagemInfo (String mensagem, String titulo, String msgComponente ) {
		FacesContext.getCurrentInstance().addMessage(msgComponente, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, titulo , mensagem)  );
	}
	
	public static void exibeMensagemErro(String mensagem, String titulo, String msgComponente ) {
		FacesContext.getCurrentInstance().addMessage(msgComponente, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo , mensagem)  );
	}

}

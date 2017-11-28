package br.com.lrsantos.pedido.filial.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.lrsantos.pedido.filial.model.bean.UF;

public class UFSelectItemUtils {
	
	private static List<SelectItem> itensUF;
	
	static {
		itensUF = new ArrayList<SelectItem>();
		for(UF uf : UF.values()){
			itensUF.add(new SelectItem(uf, uf.getValue()));
		}
	}

	public static List<SelectItem> getItensUF() {
		return itensUF;
	}
}

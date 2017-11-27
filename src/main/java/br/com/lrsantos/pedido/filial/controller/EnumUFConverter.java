package br.com.lrsantos.pedido.filial.controller;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.EnumConverter;
import javax.faces.convert.FacesConverter;

import br.com.lrsantos.pedido.filial.model.bean.UF;

@FacesConverter(forClass=UF.class)
public class EnumUFConverter extends EnumConverter {
	
	private Map<String,UF> map;
	
	public EnumUFConverter () {
		map = new HashMap<>();
		for(UF uf : UF.values()){
			map.put(uf.getValue(), uf);
		}
	}

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent comp, String value) {
		return this.map.get(value);
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent comp, Object obj) {
		return ((UF)obj).getValue();
	}
	
	

}

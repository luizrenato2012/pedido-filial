package br.com.lrsantos.pedido.filial.controller.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=LocalDateTime.class)
public class LocalDateTimeJSFConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return (value!=null) ?  LocalDateTime.parse(value,DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) : null;
//		return (value!=null) ?     DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").parse(value). : null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return value != null ? ((LocalDateTime)value).format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) : null;
	}

}

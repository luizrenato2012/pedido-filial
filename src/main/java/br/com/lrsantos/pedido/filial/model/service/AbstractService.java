package br.com.lrsantos.pedido.filial.model.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;

@Local
public interface AbstractService <T, PK extends Serializable> {

	public void persist(T t);
	
	public void update(T t);
	
	public void delete ( T t);
	
	public T find (PK pk, Class <T> classe);
	
	public List<T> listAll(Class <T> classe);
	
	public List<T> list(String query, Map<String,Object> map);
}

package br.com.lrsantos.pedido.filial.model.service;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ServiceImpl <T,PK> implements AbstractService<T, Long> {

	@PersistenceContext(name="pedido-filialPU")
	private EntityManager entityManager;
	
	@Override
	public void persist(T t) {
		this.entityManager.persist(t);
	}

	@Override
	public void update(T t) {
		this.entityManager.merge(t);
	}

	@Override
	public void delete(T t) {
		this.entityManager.remove(t);
	}

	@Override
	public T find(Long pk, Class <T> classe) {
		return this.entityManager.find(classe, pk);
	}

	@Override
	public List<T> listAll(Class classe) {
		Query query = this.entityManager.createQuery("select t from " + classe.getName()+ " t ");
		return query.getResultList();
	}

	@Override
	public List<T> list(String queryStr, Map<String, Object> params) {
		Query query = this.entityManager.createQuery(queryStr);
		for(String nome : params.keySet()){
			query.setParameter(nome, params.get(nome));
		}
		return query.getResultList();
	}

}

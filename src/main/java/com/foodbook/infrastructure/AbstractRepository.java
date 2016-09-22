package com.foodbook.infrastructure;


import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public abstract class AbstractRepository<E> implements Repository<E>{

	protected Class<E> entityType;
	
	@PersistenceContext(unitName="DataSourceBLX", type = PersistenceContextType.EXTENDED)
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public AbstractRepository() {
		ParameterizedType  parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityType = ( Class<E> ) parameterizedType.getActualTypeArguments()[0];
	}

	@Override
	public boolean register(Entity entity) {
		if (entity != null)
		{
			this.entityManager.persist(entity);
			return true;
		}	
		return false;
	}

	@Override
	public boolean update(Entity entity) {
		if (entity != null)
		{
			this.entityManager.merge(entity);
			return true;
		}	
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> listAll(String className) {
		
		return this.entityManager.createQuery("FROM " + className).getResultList();
	}

	@Override
	public E foundById(long id) {
		return this.entityManager.find(this.entityType, id);
	}

		
}
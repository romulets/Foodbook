package com.foodbook.infrastructure;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractRepository<E> implements Repository<E>{

	@PersistenceContext(unitName="foodbookPU")
	protected EntityManager entityManager;

	@Transactional
	@Override
	public boolean save(E entity) {
		try {
			this.entityManager.persist(entity);
		}
		catch (PersistenceException error) {
			error.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> list(String className) {
		try {
			return this.entityManager.createQuery("FROM " + className).getResultList();
		}
		catch(IllegalArgumentException error) {
			error.printStackTrace();
		}
		catch(PersistenceException error) {
			error.printStackTrace();
		}
		return null;
	}

	@Override
	public E findById(E entity, Integer id) {
		try {
			this.entityManager.find(entity.getClass(), id);
		}
		catch(IllegalArgumentException error) {
			error.printStackTrace();
		}
		catch(PersistenceException error) {
			error.printStackTrace();
		}
		return null;
	}
}
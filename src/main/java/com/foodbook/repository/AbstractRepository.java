package com.foodbook.repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractRepository<E> implements Repository<E> {

	final Class<E> typeParameterClass;

	public AbstractRepository(Class<E> typeParameterClass) {
		this.typeParameterClass = typeParameterClass;
	}

	@PersistenceContext(unitName = "foodbookPU")
	protected EntityManager entityManager;

	@Transactional
	@Override
	public boolean save(E entity) {
		try {
			this.entityManager.persist(entity);
		} catch (PersistenceException error) {
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
		} catch (IllegalArgumentException error) {
			error.printStackTrace();
		} catch (PersistenceException error) {
			error.printStackTrace();
		}
		return null;
	}

	// Alterei o método, retirei Entity para String. Att. Matheus Johan Mulder.
	@Override
	@Deprecated
	public E findById(String className, Integer id) {
		try {
			this.entityManager.find(className.getClass(), id);
		} catch (IllegalArgumentException error) {
			error.printStackTrace();
		} catch (PersistenceException error) {
			error.printStackTrace();
		}
		return null;
	}

	public E findById(Integer id) {
		try {
			this.entityManager.find(typeParameterClass, id);
		} catch (IllegalArgumentException error) {
			error.printStackTrace();
		} catch (PersistenceException error) {
			error.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(E entity) {
		try {
			this.entityManager.merge(entity);
		} catch (PersistenceException error) {
			error.printStackTrace();
			return false;
		}
		return true;
	}

}
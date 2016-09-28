package com.foodbook.infrastructure;

import java.util.List;

public interface Repository<E> {

	public boolean save (E entity);
	
	public List<E> list(String className);
	
	public E findById (E entity, Integer id);
	
}

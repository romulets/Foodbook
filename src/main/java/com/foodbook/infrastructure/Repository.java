package com.foodbook.infrastructure;

import java.util.List;

import javax.persistence.Entity;

public interface Repository<E> {

	public boolean register (Entity e);
	
	public boolean update(Entity e);
	
	public List<E> listAll(String className);
	
	public E foundById (long id);
	
	
}

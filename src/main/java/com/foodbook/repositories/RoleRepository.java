package com.foodbook.repositories;

import org.springframework.stereotype.Repository;

import com.foodbook.models.Role;

@Repository
public class RoleRepository extends AbstractRepository<Role> {

	public RoleRepository() {
		super(Role.class);
	}

	public Role findRole(String name) {
		String sql = "FROM Role WHERE name = :name";
		return this.entityManager.createQuery(sql, Role.class)
											.setParameter("name", name)
											.getSingleResult();
	}
	
}

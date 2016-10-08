package com.foodbook.repository;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.foodbook.model.User;

@Repository
public class UserRepository extends AbstractRepository<User> {

	public User loadUserByUsername(String login) {
		User user;
		String sql;
		
		sql = "SELECT u FROM User u WHERE u.login = :login";
		
		try {
			user = entityManager.createQuery(sql, User.class)
									.setParameter("login", login)
									.getSingleResult();
		} catch (NoResultException error) {
			return null;
		}
		return user;
	}
	
}

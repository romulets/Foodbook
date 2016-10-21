package com.foodbook.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.foodbook.model.Recipe;
import com.foodbook.model.User;

@Repository
public class UserRepository extends AbstractRepository<User> {

	public UserRepository(){
		super(User.class);
	}
	
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
	
	@SuppressWarnings("unchecked")
	public Set<User> getUsersWhoLiked(Recipe recipe) {
		String hql = "SELECT users FROM Recipe r JOIN r.likedBy users WHERE r.idRecipe = :idRecipe";
		Query query = entityManager.createQuery(hql);
		query.setParameter("idRecipe", recipe.getIdRecipe());
		Set<User> users = new HashSet<>(query.getResultList());
		
		return users;
	}
	
}

package com.foodbook.repositories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.foodbook.models.Recipe;
import com.foodbook.models.User;

@Repository
public class RecipeRepository extends AbstractRepository<Recipe> {
	
	public RecipeRepository() {
		super(Recipe.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Recipe> getRecipes(User user) {
		String hql = "SELECT recipe FROM Recipe as recipe WHERE recipe.publishedBy = :user";
		Query query = entityManager.createQuery(hql);
		query.setParameter("user", user);
		query.setMaxResults(10);
		List<Recipe> recipes = (List<Recipe>) query.getResultList();
		return recipes;
	}
	
	@SuppressWarnings("unchecked")
	public List<Recipe> getPublishedRecipes(User user) {
		String hql = "SELECT recipe FROM Recipe as recipe WHERE recipe.publishedBy = :user AND recipe.status = TRUE";
		Query query = entityManager.createQuery(hql);
		query.setParameter("user", user);
		query.setMaxResults(10);
		List<Recipe> recipes = (List<Recipe>) query.getResultList();
		return recipes;
	}
	
	@SuppressWarnings("unchecked")
	public List<Recipe> getRecipesForTimeline(User user) {
		String sql = "SELECT r.* "
				+ "FROM recipe AS r "
				+ "WHERE r.recipe_publishedBy_fk = :mainUser OR "
				+ "      (r.recipe_publishedBy_fk IN ( "
				+ "        SELECT f.idUser "
				+ "        FROM user f "
				+ "          INNER JOIN user_follow uf ON f.idUser = uf.idUser_followed AND (uf.idUser_follower = :followerUser) "
				+ "      ) AND r.status = TRUE) OR "
				+ "      (r.idRecipe IN ( "
				+ "        SELECT url.idRecipe "
				+ "        FROM user f "
				+ "          INNER JOIN user_follow uf ON f.idUser = uf.idUser_followed AND "
				+ "                                       (uf.idUser_follower = :followerUser OR f.idUser = uf.idUser_follower = :mainUser) "
				+ "          INNER JOIN user_recipe_like url ON f.idUser = url.idUser "
				+ "      ) AND r.status = TRUE) "
				+ "ORDER BY r.publicationDate DESC "
				+ "LIMIT 20; ";
		
		Query query = entityManager.createNativeQuery(sql, Recipe.class);
		query.setParameter("mainUser", user.getIdUser());
		query.setParameter("followerUser", user.getIdUser());
		List<Recipe> recipes = (List<Recipe>) query.getResultList();
		return recipes;
	}
	
	@SuppressWarnings("unchecked")
	public Set<Recipe> getRecipesLikedBy(User user) {
		String hql = "SELECT recipes FROM User u JOIN u.likedRecipes recipes WHERE u.idUser = :idUser";
		Query query = entityManager.createQuery(hql);
		query.setParameter("idUser", user.getIdUser());
		Set<Recipe> recipes = new HashSet<Recipe>(query.getResultList());
		return recipes;
	}
	
	@SuppressWarnings("unchecked")
	public List<Recipe> getPublishedRecipesByNameOrDescription(String query) {
		String hql = "FROM Recipe r WHERE r.status = TRUE AND (r.name LIKE :name or r.description LIKE :description)";
		query = "%" + query + "%";
		
		List<Recipe> recipes = this.entityManager.createQuery(hql)
						  .setParameter("name", query)
						  .setParameter("description", query)
						  .getResultList();
		return recipes;
	}
	
	public long getNumberOfPublishedRecipesByNameOrDescription(String query) {
		String hql = "SELECT count(*) FROM Recipe r WHERE r.status = TRUE AND (r.name LIKE :name or r.description LIKE :description)";
		query = "%" + query + "%";
		
		return (long) this.entityManager.createQuery(hql)
						  .setParameter("name", query)
						  .setParameter("description", query)
						  .getSingleResult();
	}
	
}


/*
--CONSULTA DA TIMELINE

 SELECT r.*
FROM recipe AS r
WHERE r.recipe_publishedBy_fk = :mainUser OR
      (r.recipe_publishedBy_fk IN (
        SELECT f.idUser
        FROM user f
          INNER JOIN user_follow ASuf ON f.idUser = uf.idUser_followed AND (uf.idUser_follower = :followerUser)
      ) AND r.status = TRUE) OR
      (r.idRecipe IN (
        SELECT url.idRecipe
        FROM user f
          INNER JOIN user_follow uf ON f.idUser = uf.idUser_followed AND
                                       (uf.idUser_follower = :followerUser OR f.idUser = uf.idUser_follower = :mainUser)
          INNER JOIN user_recipe_like url ON f.idUser = url.idUser
      ) AND r.status = TRUE)
ORDER BY r.publicationDate DESC
LIMIT 20;
 */

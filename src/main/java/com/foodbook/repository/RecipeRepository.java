package com.foodbook.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.foodbook.model.Recipe;
import com.foodbook.model.User;

@Repository
public class RecipeRepository extends AbstractRepository<Recipe> {
	
	public RecipeRepository() {
		super(Recipe.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Recipe> getPublishedRecipes(User user) {
		String hql = "SELECT recipe FROM Recipe as recipe WHERE recipe.publishedBy = :user";
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

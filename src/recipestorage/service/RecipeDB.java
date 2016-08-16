package recipestorage.service;

import java.util.List;

import javax.jws.WebService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Ingredient;
import model.Recipe;
import dao.Dao;

@WebService(endpointInterface="recipestorage.service.RecipeDBInterface")
public class RecipeDB implements RecipeDBInterface{
	
	private static final Logger logger = LogManager.getFormatterLogger("RecipeStorageService");
	
	@Override
	public Recipe storeRecipe(Recipe recipe) {
		if (recipe.getId() == null)
			recipe = Dao.getDao().saveRecipe(recipe, false);
		else
			recipe = Dao.getDao().saveRecipe(recipe, true);
		return recipe;
	}

	@Override
	public List<Recipe> getRecipes(String searchterm, String author) {
		List<Recipe> ret = Dao.getDao().searchRecipe(searchterm, author);
		return ret;
	}

	@Override
	public Recipe getRecipeById(int recipe_id) {
		Recipe ret = Dao.getDao().getById(new Integer(recipe_id));
		return ret;
	}

	@Override
	public Recipe addIngredient(Recipe rec, Ingredient ingr) {
		rec = Dao.getDao().getById(new Integer(rec.getId()));
		rec.addProduct(ingr);
		rec = Dao.getDao().saveRecipe(rec, true);
		logger.info("Added %s to recipe %s.", ingr, rec);
		return rec;
	}

	@Override
	public Recipe removeIngredient(Recipe rec, Ingredient ingr) {
		rec = Dao.getDao().getById(new Integer(rec.getId()));
		rec.removeProduct(ingr);
		rec = Dao.getDao().saveRecipe(rec, true);
		logger.info("Removing %s from recipe %s.", ingr, rec);
		return rec;
	}
}

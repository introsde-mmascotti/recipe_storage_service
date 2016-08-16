package recipestorage.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import model.Ingredient;
import model.Recipe;

@WebService
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL)
public interface RecipeDBInterface {
	
	@WebMethod(operationName="storeRecipe")
	public Recipe storeRecipe(@WebParam(name="recipe") Recipe recipe);
	
	@WebMethod
	@WebResult(name="recipelist")
	public List<Recipe> getRecipes(@WebParam(name="searchitem") String searchterm, @WebParam(name="author") String author);
	
	@WebMethod
	@WebResult(name="recipe")
	public Recipe getRecipeById(@WebParam(name="recipe_id") int recipe_id);
	
	@WebMethod
	public Recipe addIngredient(@WebParam(name="recipe") Recipe rec,@WebParam(name="ingredient") Ingredient ingr);
	
	@WebMethod
	public Recipe removeIngredient(@WebParam(name="recipe") Recipe rec,@WebParam(name="ingredient") Ingredient ingr);
}

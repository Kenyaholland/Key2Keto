package application.Key2Keto.Recipes;

import java.util.ArrayList;

public class RecipeList {
	private ArrayList<Recipe> recipeList;
	
	public RecipeList() {
		this.recipeList = new ArrayList<Recipe>();
	}
	public void addRecipe(Recipe recipe) {
		this.recipeList.add(recipe);
	}
	
	public ArrayList<Recipe> getRecipeList() {
		return this.recipeList;
	}
	public void setRecipeList(ArrayList<Recipe> recipeList) {
		this.recipeList = recipeList;
	}
	//get a single recipe
	public Recipe singleRecipe() {
		return this.recipeList.get(0);
	}
	//list of entrees
	//list of breakfast
	//list of snacks
}

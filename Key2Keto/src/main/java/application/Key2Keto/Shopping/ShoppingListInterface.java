package application.Key2Keto.Shopping;

import java.util.ArrayList;

import application.Key2Keto.Recipes.Recipe;

public interface ShoppingListInterface
{
	public abstract ArrayList<Recipe> getRecipes();
	
	public abstract void generateStrings();
	public abstract void generateShoppingList();
	
}

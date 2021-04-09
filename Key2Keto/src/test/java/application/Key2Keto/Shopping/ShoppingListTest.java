package application.Key2Keto.Shopping;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import application.Key2Keto.Recipes.*;

public class ShoppingListTest
{
	@Test
	public void macrosCalculateCorrectlyTest()
	{
		ShoppingList sut = new ShoppingList();
		
		for(Recipe recipe : sut.getRecipes())
		{
			int recipeCalories = recipe.getTotalCalories();
			double recipeFat = recipe.getTotalFat();
			double recipeCarbs = recipe.getTotalCarb();
			double recipeProtein = recipe.getTotalProtein();
			
			int totalIngredientCalories = 0;
			double totalIngredientFat = 0.0;
			double totalIngredientCarbs = 0.0;
			double totalIngredientProtein = 0.0;
			
			for(Ingredient ingredient : recipe.getIngredient())
			{
				
			}
		}
	}
}

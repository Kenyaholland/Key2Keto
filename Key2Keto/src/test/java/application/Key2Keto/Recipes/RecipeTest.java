package application.Key2Keto.Recipes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecipeTest {	
	Recipe recipe;
	Ingredient ingredient;
	
	@Test
	void test() {
		recipe = new Recipe("Breakfast", "Chocolate Chip Cookies", 200, 20.5, 15.5, 10.5, 4);
		ingredient = new Ingredient("Chocolate Chips", "1/4 cup");
		recipe.addIngredient(ingredient);
		recipe.addInstruction("Eat the cookie");
		assertEquals("Eat the cookie", recipe.getInstruction().get(0));
		assertEquals("1/4 cup Chocolate Chips", recipe.getIngredient().get(0).toString());
	}

}

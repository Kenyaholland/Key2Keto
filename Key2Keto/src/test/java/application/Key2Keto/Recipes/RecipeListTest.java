package application.Key2Keto.Recipes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecipeListTest {
	RecipeList list = new RecipeList();
	@Test
	void test() {
		RecipeFileReader reader = new RecipeFileReader("./src/main/java/application/Key2Keto/Recipes/ModifiedKeto.txt");
		list = reader.getRecipeList();
		assertEquals("Breakfast", list.getRecipeList().get(0).getType());
	
	}

}

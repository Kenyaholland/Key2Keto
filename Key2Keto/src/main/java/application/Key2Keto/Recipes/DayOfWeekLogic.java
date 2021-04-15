package application.Key2Keto.Recipes;

import java.util.ArrayList;

public class DayOfWeekLogic {
	private static RecipeList recipeList = new RecipeList();
	private static ArrayList<Recipe> daysRecipes = new ArrayList<Recipe>();

	public static void addRecipeListToClass(RecipeList recipeList) {
		DayOfWeekLogic.recipeList = recipeList;
	}
	
	public static RecipeList getRecipeList() {
		return recipeList;
	}
	
	public static ArrayList<String> getBreakfastRecipes(){
		ArrayList<String> temp = new ArrayList<String>();
		for(int i = 0; i < recipeList.breakfastRecipes().size();i++) {
			temp.add(recipeList.breakfastRecipes().get(i).getName());
		}
		
		return temp;
	}
	
	public static ArrayList<String> getEntreeRecipes(){
		ArrayList<String> temp = new ArrayList<String>();
		for(int i = 0; i < recipeList.entreeRecipes().size();i++) {
			temp.add(recipeList.entreeRecipes().get(i).getName());
		}
		
		return temp;
	}
	
	public static ArrayList<String> getSnackRecipes(){
		ArrayList<String> temp = new ArrayList<String>();
		for(int i = 0; i < recipeList.snackRecipes().size();i++) {
			temp.add(recipeList.snackRecipes().get(i).getName());
		}
		
		return temp;
	}
	public static void addRecipe(String recipe) {
		
	}
	
	public static String clearRecipe(String nameFromLabel) {
		
		return "";
	}
}

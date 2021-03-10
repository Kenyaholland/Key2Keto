package application.Key2Keto.Recipes;

import java.util.ArrayList;

public class Recipe {
	private String name = "";
	private ArrayList<Ingredient> ingredients;
	private int totalCarb = 0;
	private int totalProtein = 0;
	private int totalFat = 0;
	private int ratio = 0;
	private ArrayList<String> instructions;
	
	public Recipe(String name, int carb, int protein, int fat, int ratio) {
		this.ingredients = new ArrayList<Ingredient>();
		this.instructions = new ArrayList<String>();
		this.name = name;
		this.ratio = ratio;
		this.totalCarb = carb;
		this.totalFat = fat;
		this.totalProtein = protein;
	}
	public void addIngredient(Ingredient ing) {
		this.ingredients.add(ing);
	}
	public void addInstruction(String string) {
		this.instructions.add(string);
	}
}

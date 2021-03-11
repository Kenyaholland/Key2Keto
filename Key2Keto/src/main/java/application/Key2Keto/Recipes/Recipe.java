package application.Key2Keto.Recipes;

import java.util.ArrayList;

public class Recipe {
	private String name = "";
	private ArrayList<Ingredient> ingredients;
	private double totalCarb = 0;
	private double totalProtein = 0;
	private double totalFat = 0;
	private double dietRatio = 0;
	private ArrayList<String> instructions;
	private int totalCalories = 0;

	public Recipe(String name, int calories, double carb, double protein, double fat, double ratio) {
		this.ingredients = new ArrayList<Ingredient>();
		this.instructions = new ArrayList<String>();
		this.name = name;
		this.dietRatio = ratio;
		this.totalCarb = carb;
		this.totalFat = fat;
		this.totalProtein = protein;
		this.totalCalories = calories;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTotalCarb(double totalCarb) {
		this.totalCarb = totalCarb;
	}

	public double getTotalCarb() {
		return this.totalCarb;
	}

	public void setTotalFat(double totalFat) {
		this.totalFat = totalFat;
	}

	public double getTotalFat() {
		return this.totalFat;
	}

	public void setTotalProtein(double totalProtein) {
		this.totalProtein = totalProtein;
	}

	public double getTotalProtein() {
		return this.totalProtein;
	}

	public void addIngredient(Ingredient ing) {
		this.ingredients.add(ing);
	}

	public void addInstruction(String string) {
		this.instructions.add(string);
	}

	public ArrayList<Ingredient> getIngredient() {
		return this.ingredients;
	}

	public ArrayList<String> getInstruction() {
		return this.instructions;
	}

	public void setDietRatio(double dietRatio) {
		this.dietRatio = dietRatio;
	}

	public double getDietRatio() {
		return this.dietRatio;
	}
	
	public String listedIngredients() {
		String listOfIngredients="";
		for(int i = 0; i<this.ingredients.size();i++) {
			if(i == this.ingredients.size()-1) {
				listOfIngredients.concat((i+1)+". "+this.ingredients.get(i));
			}else {
				listOfIngredients.concat((i+1)+". "+this.ingredients.get(i)+"/n");
			}
		}
		return listOfIngredients;
	}
	
	public String listedInstructions() {
		String listOfInstructions="";
		for(int i = 0; i<this.instructions.size();i++) {
			if(i == this.instructions.size()-1) {
				listOfInstructions.concat((i+1)+". "+this.instructions.get(i));
			}else {
				listOfInstructions.concat((i+1)+". "+this.instructions.get(i)+"/n");
			}
		}
		
		return listOfInstructions;
	}
	public String toString() {

		return this.name+"/n"+"Total Calories: " +this.totalCalories+"/nTotal Carbs: "+ this.totalCarb+"/n"
				+ "Total Protein: "+this.totalProtein+"/nTotal Fats: "+this.totalFat+"/n"
				+ "Ingredients: "+ this.listedIngredients()+"/nInstructions: "+this.listedInstructions()+"/n"
				+ "Diet Ratio: "+ this.dietRatio;
	}
}

package application.Key2Keto.Shopping;

import java.util.ArrayList;

import application.Key2Keto.Account.Account;
import application.Key2Keto.Recipes.Recipe;

public class ShoppingViewLogic {
	private static ArrayList<RestaurantMeals> restaurantMeals = new ArrayList<RestaurantMeals>();
	private static Account account;
	private static ArrayList<ArrayList<Recipe>> usersChosenRecipes = new ArrayList<ArrayList<Recipe>>();
	private static String dietType;
	private static RestaurantFileReader restFileReader;
	
	public static void setUserAccount(Account acct) {
		ShoppingViewLogic.account = acct;
	}

	public static Account getUserAccount() {
		return ShoppingViewLogic.account;
	}
	
	public static void setFileReader(String file) {
		ShoppingViewLogic.restFileReader = new RestaurantFileReader(file);
	}

	public static RestaurantFileReader getFileReader() {
		return ShoppingViewLogic.restFileReader;
	}
	
	public static void setUsersChosenRecipes(ArrayList<ArrayList<Recipe>> usersChosen) {
		ShoppingViewLogic.usersChosenRecipes = usersChosen;
	}
	
	public static void setDietType(String type) {
		ShoppingViewLogic.dietType = type;
	}
	
	public static ArrayList<ArrayList<Recipe>> getChosenRecipes(){
		return ShoppingViewLogic.usersChosenRecipes;
	}
	
	public static ArrayList<RestaurantMeals> getRestMeals(){
		return ShoppingViewLogic.restaurantMeals;
	}

	public static ArrayList<String> getRestMealsNames(ArrayList<RestaurantMeals> meals, String diet){
		ArrayList<String> temp = new ArrayList<String>();
		
		for(int i = 0;i<meals.size(); i++) {
			if(meals.get(i).getDietType().contentEquals(diet)) {
				temp.add(meals.get(i).getRestaurantName());
			}
		}
		return temp;
	}
}

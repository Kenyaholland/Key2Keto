package application.Key2Keto.Dashboard;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

import application.Key2Keto.Account.Account;
import application.Key2Keto.Recipes.Recipe;

public class Dashboard {
	private Account userAccount;
	private ArrayList<ArrayList<Recipe>> weeksRecipes;
	private String currentDayOfWeek;
	
	public Dashboard(Account userAccount) {
		DayOfWeek day = LocalDateTime.now().getDayOfWeek();
		this.userAccount = userAccount;
		this.currentDayOfWeek = day.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	}
	
	public Account getUserAccount() {
		return this.userAccount;
	}
	
	public String getCurrentDay() {
		return this.currentDayOfWeek;
	}

	public int getCurrentDayInt() {
		int day = 0;
		switch(this.currentDayOfWeek) {
			case "Sunday":
				day = 0;
				break;
			case "Monday":
				day = 1;
			case "Tuesday":
				day = 2;
				break;
			case "Wednesday":
				day = 3;
				break;
			case "Thursday":
				day = 4;
				break;
			case "Friday":
				day = 5;
				break;
			case "Saturday":
				day = 5;
				break;
			default:
				System.out.println("This does not exist.");
		}
		return day;
	}
	
	public Recipe getBreakfastRecipe(){
		Recipe recipe = null;
		if(this.userAccount.getChosenRecipes().get(this.getCurrentDayInt()).size()>0) {
			for(int i = 0; i<this.userAccount.getChosenRecipes().get(this.getCurrentDayInt()).size(); i++) {
				if(this.userAccount.getChosenRecipes().get(this.getCurrentDayInt()).get(i).getName().contentEquals("Breakfast")) {
					recipe = this.userAccount.getChosenRecipes().get(this.getCurrentDayInt()).get(i);
				}
			}
		}
		return recipe;
	}
	public Recipe getLunchRecipe(){
		Recipe recipe = null;
		if(this.userAccount.getChosenRecipes().get(this.getCurrentDayInt()).size()>0) {
			for(int i = 0; i<this.userAccount.getChosenRecipes().get(this.getCurrentDayInt()).size(); i++) {
				if(this.userAccount.getChosenRecipes().get(this.getCurrentDayInt()).get(i).getName().contentEquals("Entree")) {
					recipe = this.userAccount.getChosenRecipes().get(this.getCurrentDayInt()).get(i);
				}
			}
		}
		return recipe;
	}
	public Recipe getDinnerRecipe(){
		Recipe recipe = null;
		if(this.userAccount.getChosenRecipes().get(this.getCurrentDayInt()).size()>0) {
			for(int i = 0; i<this.userAccount.getChosenRecipes().get(this.getCurrentDayInt()).size(); i++) {
				if(this.userAccount.getChosenRecipes().get(this.getCurrentDayInt()).get(i).getName().contentEquals("Entree")) {
					recipe = this.userAccount.getChosenRecipes().get(this.getCurrentDayInt()).get(i+1);
				}
			}
		}
		return recipe;
	}
	public Recipe getSnackRecipe(){
		Recipe recipe = null;
		if(this.userAccount.getChosenRecipes().get(this.getCurrentDayInt()).size()>0) {
			for(int i = 0; i<this.userAccount.getChosenRecipes().get(this.getCurrentDayInt()).size(); i++) {
				if(this.userAccount.getChosenRecipes().get(this.getCurrentDayInt()).get(i).getName().contentEquals("Snacks")) {
					recipe = this.userAccount.getChosenRecipes().get(this.getCurrentDayInt()).get(i);
				}
			}
		}
		return recipe;
	}
}

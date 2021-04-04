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
		populateWeeksRecipes();
		this.currentDayOfWeek = day.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	}
	
	public Account getUserAccount() {
		return this.userAccount;
	}
	
	public String getCurrentDay() {
		return this.currentDayOfWeek;
	}

	//NEEDS ACCOUNTS METHODS TO POPULATE THE RECIPES FOR THE DAY.
	private void populateWeeksRecipes() {
		for(int i = 0; i<7;i++) {
			//this.userAccount.add(this.recipe.getdays()[i].getSelectedRecipes());
		}
	}
	
	public ArrayList<Recipe> getCurrentDaysRecipes(){
		ArrayList<Recipe> temp = new ArrayList<>();
		for(int i =0;i<this.weeksRecipes.size();i++) {
		//	if(this.currentDayOfWeek.contentEquals(this.recipe.getdays()[i].getName())) {
			//	for(int j =0 ;j < this.recipe.getdays()[i].getSelectedRecipes().size();j++) {
				//	temp.add(this.recipe.getdays()[i].getSelectedRecipes().get(j));
				//}
			//}
		}
		return temp;
	}
	
	public double getDaysSleep() {
		double total = 0.0;
		/*for(int i = 0; i < this.userAccount.TRACKERINFORMATION.size();i++){
			if(this.currentDayOfWeek.contentEquals(this.userAccount.TRACKERINFORMATION.get(i).getDayOfWeek()){
				total+=this.userAccount.TRACKERINFORMATION.get(i).getHoursOfSleep();
			}
		}*/
		
		return total;
	}
	
	public double getDaysWater() {
		double water = 0.0;
		/*for(int i = 0; i < this.userAccount.TRACKERINFORMATION.size();i++){	
			if(this.currentDayOfWeek.contentEquals(this.userAccount.TRACKERINFORMATION.get(i).getDayOfWeek()){
				water+=this.userAccount.TRACKERINFORMATION.get(i).getWaterIntake();
			}
		}*/
		
		return water;
	}
	
}

package application.Key2Keto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import application.Key2Keto.Account.Account;
import application.Key2Keto.Recipes.Recipe;
import application.Key2Keto.Tracker.Tracker;

public class AccountSaver
{
	public static void saveAccount(Account account)
	{
		FileWriter saver = null;
		
		try
		{
			saver = new FileWriter(account.getUsername() + ".txt");
			
			saver.write(account.getUsername() + "," + account.getPassword() + "\n");
			saver.write(account.getFirstName() + "," + account.getLastName() + "\n");
			saver.write(account.getSex() + "," + account.getHeight() + "," + account.getWeight() + "," + account.getAge() + "\n");
			saver.write(account.getDietType() + "\n");
			
			for(Tracker tracker : account.getTrackers())
			{
				saver.write(tracker.getDayOfWeek() + "\n");
				
				for(String goal : tracker.getGoals())
				{
					saver.write(goal + "\n");
				}
				
				saver.write(tracker.getHoursOfSleep() + "," + tracker.getWaterIntake() + "\n");
			}
			
			for(ArrayList<Recipe> chosenRecipesForDay : account.getChosenRecipes())
			{
				saver.write(account.getChosenRecipes().indexOf(chosenRecipesForDay) + "\n");
				
				for(Recipe chosenRecipe : chosenRecipesForDay)
				{
					saver.write(chosenRecipe.getName() + "\n");
				}
			}
			
			saver.close();
		}
		
		catch(IOException io)
		{
			io.printStackTrace();
		}
	}
}

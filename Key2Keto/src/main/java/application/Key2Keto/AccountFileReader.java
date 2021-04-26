package application.Key2Keto;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import application.Key2Keto.Account.Account;
import application.Key2Keto.Interfaces.FileReaderInterface;
import application.Key2Keto.Recipes.Recipe;
import application.Key2Keto.Recipes.RecipeFileReader;
import application.Key2Keto.Recipes.RecipeViewLogic;
import application.Key2Keto.Tracker.Tracker;

public class AccountFileReader implements FileReaderInterface
{
	private Account loadedAccount;
	
	public AccountFileReader(String fileName)
	{
		loadedAccount = new Account();
		readFile(fileName);
	}
	
	public void readFile(String fileName)
	{
		File accountFile = new File(fileName);
		Scanner fileScanner = null;
		
		try
		{
			fileScanner = new Scanner(accountFile);
			fileScanner.useDelimiter(",|\n");
			
			loadedAccount.setUsername(fileScanner.next());
			System.out.println("username: " + loadedAccount.getUsername());
			loadedAccount.setPassword(fileScanner.next());
			System.out.println("password: " + loadedAccount.getPassword());
			
			loadedAccount.setFirstName(fileScanner.next());
			System.out.println("first name: " + loadedAccount.getFirstName());
			loadedAccount.setLastName(fileScanner.next());
			System.out.println("last name: " + loadedAccount.getLastName());
			
			loadedAccount.setSex(fileScanner.next());
			System.out.println("sex: " + loadedAccount.getSex());
			loadedAccount.setHeight(fileScanner.next());
			System.out.println("height: " + loadedAccount.getHeight());
			loadedAccount.setWeight(Integer.parseInt(fileScanner.next()));
			System.out.println("weight: " + loadedAccount.getWeight());
			loadedAccount.setAge(Integer.parseInt(fileScanner.next()));
			System.out.println("age: " + loadedAccount.getAge());
			
			loadedAccount.setDietType(fileScanner.next());
			System.out.println("diet type: " + loadedAccount.getDietType());
			
			if(fileScanner.next().equals("Trackers"))
			{
				for(int i = 0; i < 7; i++)
				{
					fileScanner.next();
					fileScanner.nextLine();
					String goalsLine = fileScanner.nextLine();
					System.out.println("goalsLine: " + goalsLine);
					
					if(goalsLine.equals("no goals"))
					{
						//do nothing
					}
					
					else
					{
						String[] splitGoals = goalsLine.split(",");
						
						for(String goal : splitGoals)
						{
							System.out.println("goal: " + goal);
							loadedAccount.getTrackers().get(i).addGoal(goal);
						}
					}
					
					loadedAccount.getTrackers().get(i).setHoursOfSleep(Double.parseDouble(fileScanner.next()));
					System.out.println("hours of sleep: " + loadedAccount.getTrackers().get(i).getHoursOfSleep());
					loadedAccount.getTrackers().get(i).setWaterIntake(Double.parseDouble(fileScanner.next()));
					System.out.println("water intake: " + loadedAccount.getTrackers().get(i).getWaterIntake());
				}
			}
			
			String[] dietString = loadedAccount.getDietType().split(" ");
			String recipeFileName = "./src/main/java/application/Key2Keto/Recipes/" + dietString[0] + "Keto.txt";
			RecipeFileReader fileReader = new RecipeFileReader(recipeFileName);
			
			if(fileScanner.next().equals("Recipes"))
			{
				for(int i = 0; i < 7; i++)
				{
					fileScanner.next();
					fileScanner.nextLine();
					String recipesLine = fileScanner.nextLine();
					
					if(recipesLine.equals("no recipes"))
					{
						loadedAccount.addRecipe(null, i);
						loadedAccount.addRecipe(null, i);
						loadedAccount.addRecipe(null, i);
						loadedAccount.addRecipe(null, i);
					}
					
					else
					{
						String[] splitRecipes = recipesLine.split(",");
						
						for(String recipeString : splitRecipes)
						{
							if(recipeString.equals("nothing chosen"))
							{
								loadedAccount.addRecipe(null, i);
							}
							
							else
							{
								for(Recipe recipe : fileReader.getRecipeList().getRecipeList())
								{
									if(recipeString.equals(recipe.getName()))
									{
										loadedAccount.addRecipe(recipe, i);
										break;
									}
								}
							}
						}
					}
				}
			}
		}
		
		catch(IOException io)
		{
			System.out.println("Error reading account file");
		}
		
		finally
		{
			fileScanner.close();
		}
		
		
	}
	
	public Account getLoadedAccount()
	{
		return loadedAccount;
	}
}

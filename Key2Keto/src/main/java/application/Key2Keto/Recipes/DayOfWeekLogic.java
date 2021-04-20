package application.Key2Keto.Recipes;

import java.util.ArrayList;

import application.Key2Keto.Account.Account;

public class DayOfWeekLogic {
	private static RecipeList recipeList = new RecipeList();
	private static ArrayList<Recipe> daysRecipes = new ArrayList<Recipe>();
	private static int[] numEntree = new int[7];
	private static boolean lunchFlag = false;
	private static boolean dinnerFlag = false;
	private static Account account;

	// USER ACCOUNT ITEMS
	public static void setUserAccount(Account acct) {
		DayOfWeekLogic.account = acct;
	}

	public static Account getUserAccount() {
		return DayOfWeekLogic.account;
	}

	public static void addToUsersChosenRecipes(ArrayList<String> recipes, int day) {
		ArrayList<Recipe> temp = new ArrayList<Recipe>();
		for (int i = 0; i < 4; i++) {
			temp.add(i, null);
		}

		account.getChosenRecipes().get(day).clear();
		for (int i = 0; i < recipeList.getRecipeList().size(); i++) {
			if (recipeList.getRecipeList().get(i).getName().contentEquals(recipes.get(0))) {
				temp.add(0, recipeList.getRecipeList().get(i));
			}
			if (recipeList.getRecipeList().get(i).getName().contentEquals(recipes.get(1))) {
				temp.add(1, recipeList.getRecipeList().get(i));
			}
			if (recipeList.getRecipeList().get(i).getName().contentEquals(recipes.get(2))) {
				temp.add(2, recipeList.getRecipeList().get(i));
			}
			if (recipeList.getRecipeList().get(i).getName().contentEquals(recipes.get(3))) {
				temp.add(3, recipeList.getRecipeList().get(i));
			}
		}

		for (int i = 0; i < 4; i++) {
			account.getChosenRecipes().get(day).add(temp.get(i));
		}
	}

	public static void addRecipeListToClass(RecipeList recipeList) {
		DayOfWeekLogic.recipeList = recipeList;
	}

	public static RecipeList getRecipeList() {
		return recipeList;
	}

	public static ArrayList<Recipe> getDaysRecipes(int day) {
		return account.getChosenRecipes().get(day);
	}

	public static ArrayList<String> getBreakfastRecipes() {
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < recipeList.breakfastRecipes().size(); i++) {
			temp.add(recipeList.breakfastRecipes().get(i).getName());
		}

		return temp;
	}

	public static ArrayList<String> getEntreeRecipes() {
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < recipeList.entreeRecipes().size(); i++) {
			temp.add(recipeList.entreeRecipes().get(i).getName());
		}

		return temp;
	}

	public static ArrayList<String> getSnackRecipes() {
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < recipeList.snackRecipes().size(); i++) {
			temp.add(recipeList.snackRecipes().get(i).getName());
		}

		return temp;
	}

	public static void addRecipe(String recipe, int day) {
		Recipe temp;
		int recflag = 0;
		for (int i = 0; i < DayOfWeekLogic.getRecipeList().getRecipeList().size(); i++) {
			if (recipe.contentEquals(DayOfWeekLogic.getRecipeList().getRecipeList().get(i).getName())) {
				temp = DayOfWeekLogic.getRecipeList().getRecipeList().get(i);
				for (int j = 0; j < DayOfWeekLogic.getDaysRecipes(day).size(); j++) {
					System.out.println("J: "+ j);
					if(DayOfWeekLogic.getDaysRecipes(day).get(j) != null) {
					if (DayOfWeekLogic.getDaysRecipes(day).get(j).getType().contentEquals(temp.getType())
							&& !temp.getType().contentEquals("Entrees")) {
						recflag = 1;
						break;
					} else if (DayOfWeekLogic.getDaysRecipes(day).get(j).getType().contentEquals(temp.getType())
							&& temp.getType().contentEquals("Entrees")) {
						if (numEntree[day] > 1) {
							recflag = 1;
							break;
						}
					}
				}
				}
				if (recflag == 0 && !temp.getType().contentEquals("Entrees")) {
					DayOfWeekLogic.getDaysRecipes(day).add(temp);
				}
				if (temp.getType().contentEquals("Entrees") && numEntree[day] < 2) {
					DayOfWeekLogic.getDaysRecipes(day).add(temp);
					numEntree[day]++;
				}
			}
		}
	}

	public static String clearRecipe(String nameFromLabel, int num) {
		String str = "";
		switch (num) {
		case 0:
			for (int i = 0; i < account.getChosenRecipes().get(num).size(); i++) {
				if (nameFromLabel.contentEquals(account.getChosenRecipes().get(num).get(i).getName())) {
					account.getChosenRecipes().get(num).remove(i);
				}
			}
			str = "No Breakfast Chosen";
			break;

		case 1: {
			for (int i = 0; i < account.getChosenRecipes().get(num).size(); i++) {
				if (nameFromLabel.contentEquals(account.getChosenRecipes().get(num).get(i).getName())) {
					account.getChosenRecipes().get(num).remove(i);
					lunchFlag = false;
				}
			}
			str = "No Lunch Chosen";
			break;
		}
		case 2:
			for (int i = 0; i < account.getChosenRecipes().get(num).size(); i++) {
				if (nameFromLabel.contentEquals(account.getChosenRecipes().get(num).get(i).getName())) {
					account.getChosenRecipes().get(num).remove(i);
					dinnerFlag = false;
				}
			}
			str = "No Dinner Chosen";
			break;
		case 3:
			for (int i = 0; i < account.getChosenRecipes().get(num).size(); i++) {
				if (nameFromLabel.contentEquals(account.getChosenRecipes().get(num).get(i).getName())) {
					account.getChosenRecipes().get(num).remove(i);
				}
			}
			str = "No Snack Chosen";
			break;
		default:
			System.out.println("Something is wrong here");
		}

		return str;
	}
}

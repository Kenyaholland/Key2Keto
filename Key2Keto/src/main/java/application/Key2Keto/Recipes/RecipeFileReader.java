package application.Key2Keto.Recipes;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class RecipeFileReader {	
	private RecipeList recipeList;
	Scanner sc;
	Scanner strScan;
	public RecipeFileReader(String fileName) {
		recipeList = new RecipeList();
		try {
			File file = new File(fileName);
			sc = new Scanner(file);
			String recName = "";
			String carb = "";
			String fat = "";
			String pro = "";
			String ins = "";
			String ing = "";
			String cal = "";
			String ratio = "";
			String type = "";
			String meas = "";
			String token = "";
			//sc.useDelimiter(",");
			while(sc.hasNextLine()) {
				//System.out.println(sc.nextLine());
				strScan = new Scanner(sc.nextLine());
				//System.out.println(strScan.nextLine());
				strScan.useDelimiter(",");
				type = strScan.next();
				recName = strScan.next();
				cal = strScan.next();
				ratio= strScan.next();
				fat= strScan.next();
				pro= strScan.next();
				carb= strScan.next();
				Recipe recipe = new Recipe(type,recName, Integer.parseInt(cal), Double.parseDouble(carb), 
						Double.parseDouble(pro), Double.parseDouble(fat), Double.parseDouble(ratio));
				//System.out.println(recipe.toString());
				
				while(!(token=strScan.next()).equals("Directions")) {
					//System.out.println("In first "+ token+ " "+ ing);
					ing = strScan.next();
					System.out.println("In first "+ token+ " "+ ing);
					Ingredient ingredient = new Ingredient(ing, token);
					recipe.addIngredient(ingredient);
				}
				System.out.println(recipe.getIngredient().toString());
				while(strScan.hasNext()) {
					ins = strScan.next();
					System.out.println(ins);
					recipe.addInstruction(ins);
				}
				recipeList.addRecipe(recipe);
			//	System.out.println(recipeList.getRecipeList().get(0).toString());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			strScan.close();
			sc.close();
		}
	}
	
	public RecipeList getRecipeList() {
		return this.recipeList;
	}
}

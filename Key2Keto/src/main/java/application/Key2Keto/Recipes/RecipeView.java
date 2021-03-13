package application.Key2Keto.Recipes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class RecipeView extends Pane{
	private RecipeFileReader recipeFileReader;
	private VBox view = new VBox();
	private HBox categoryTabs = new HBox();
	private Button breakfast = new Button("BREAKFAST");
	private Button entrees = new Button("ENTREES");
	private Button snacks = new Button("SNACKS");
	private ComboBox recipeSelection = new ComboBox();
	private int recipeListLength = 0;
	public RecipeView(String file){
		this.setWidth(500);
		this.setHeight(500);
		breakfast.setPrefSize(100, 20);
		entrees.setPrefSize(100, 20);
		snacks.setPrefSize(100, 20);
		view.setPrefHeight(500);
		view.setPrefWidth(500);
		categoryTabs.setPrefWidth(400);
		categoryTabs.setPrefHeight(200);
		this.recipeFileReader = new RecipeFileReader(file);
		categoryTabs.getChildren().addAll(breakfast,entrees,snacks);
		view.getChildren().addAll(categoryTabs,recipeSelection);
		recipeSelection.setVisible(false);

		breakfast.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	populateComboBox(0);
		        System.out.println("Accepted Breakfast");
		    }
		});
		entrees.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	populateComboBox(1);
		        System.out.println("Accepted Entrees");
		    }
		});
		snacks.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	populateComboBox(2);
		        System.out.println("Accepted Snacks");
		    }
		});
		
		this.getChildren().add(view);
	}
	protected void populateComboBox(int num) {
		recipeSelection.getItems().clear();
		switch(num) {
			case 0:
			for(int i=0;i<this.recipeFileReader.getRecipeList().breakfastRecipes().size();i++) {
				recipeSelection.getItems().add(this.recipeFileReader.getRecipeList().breakfastRecipes().get(i).getName());
				recipeSelection.setVisible(true);
			}
			break;
			case 1:
				for(int i=0;i<this.recipeFileReader.getRecipeList().entreeRecipes().size();i++) {
					recipeSelection.getItems().add(this.recipeFileReader.getRecipeList().entreeRecipes().get(i).getName());
					recipeSelection.setVisible(true);
				}
				break;
			case 2:
				for(int i=0;i<this.recipeFileReader.getRecipeList().snackRecipes().size();i++) {
					recipeSelection.getItems().add(this.recipeFileReader.getRecipeList().snackRecipes().get(i).getName());
					recipeSelection.setVisible(true);
				}
				break;
			default:
				System.out.println("Something is wrong here");
		}
	}
	
	
	//tab for breakfast 
	//  -use Combo Box 
	//tab for entrees
	//tab snacks
	//VBOX
	// - HBOX - 
	//  -  - BREAKFAST , ENTREES, SNACKS
	//  -  - COMBO BOX WHICH POPULATES BASED ON B. E. S. TABS
	//  -  - VBOX DISPLAYING THE RECIPE NAMES
	
}

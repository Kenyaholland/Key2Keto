package application.Key2Keto.Recipes;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class DayOfWeekView extends Pane { //intanstate method, stylize method, add children method. need to be private.
	private String name;
	private RecipeList recipeList;
	private ArrayList<Recipe> daysRecipes;
	private boolean flag = false;
	private boolean lunchFlag = false;
	private boolean dinnerFlag = false;
	private VBox wholeView;
	private VBox selectedRecipes;
	
	private HBox categorySelection;
	private HBox breakfastInfo;
	private HBox lunchInfo;
	private HBox dinnerInfo;
	private HBox snackInfo;
	private HBox addRecipeDropdown;
	
	//selected recipe names
	private Label breakfastRecipeName;
	private Label lunchRecipeName;
	private Label dinnerRecipeName;
	private Label snackRecipeName;
	
	//ComboBox variables
	private ComboBox comboBox;
	private Button viewSelectedRecipe;
	private Button addRecipeButton;
	
	//category Buttons
	private Button overViewButton;
	private Button breakfastButton;
	private Button entreesButton;
	private Button snacksButton;
	
	//delete recipe Buttons
	private Button deleteBreakfastButton;
	private Button deleteLunchButton;
	private Button deleteDinnerButton;
	private Button deleteSnackButton;

	
	public DayOfWeekView(RecipeList recipeList, String name) {
		this.name = name;
		this.recipeList = recipeList;
		this.daysRecipes = new ArrayList<Recipe>();
		initializeVariables();
		styleVariables();
		populateChildren();
		setDefaultVisibilities();

		overViewButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	disPlayViewsRecipes();
		        System.out.println("Accepted Overview");
		    }
		});
		breakfastButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	populateComboBox(0);
		        System.out.println("Accepted Breakfast");
		    }
		});
		entreesButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	populateComboBox(1);
		        System.out.println("Accepted Entrees");
		    }
		});
		snacksButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	populateComboBox(2);
		        System.out.println("Accepted Snacks");
		    }
		});
		
		deleteBreakfastButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	int num = 0;
		    	clearRecipe(0);
		        System.out.println("Accepted Delete Breakfast");
		    }
		});
		deleteLunchButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	clearRecipe(1);
		        System.out.println("Accepted Delete Lunch");
		    }
		});
		deleteDinnerButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	clearRecipe(2);
		        System.out.println("Accepted Delete Dinner");
		    }
		});
		deleteSnackButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	clearRecipe(3);
		        System.out.println("Accepted Delete Snacks");
		    }
		});
		
		addRecipeButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		  //  	addRecipe();
		        System.out.println("Added Recipe");
		    }
		});		
	}
	
	private void addRecipe() {
		boolean contentMatch = false;
		for(int i =0; i<this.recipeList.getRecipeList().size();i++) {
			if(comboBox.getValue().toString().contentEquals(this.recipeList.getRecipeList().get(i).getName())) {
				if(this.daysRecipes.get(i).getType().contentEquals(this.recipeList.getRecipeList().get(i).getType()) && !this.daysRecipes.get(i).getType().contentEquals("Entrees")) {
					contentMatch = true;
				}else {
					if(lunchFlag = false) {
						lunchFlag = true;
						this.daysRecipes.add(this.recipeList.getRecipeList().get(i));
					}else {
						dinnerFlag = true;
						this.daysRecipes.add(this.recipeList.getRecipeList().get(i));
					}
				}
			}else {
				this.daysRecipes.add(this.recipeList.getRecipeList().get(i));
			}
		}
		disPlayViewsRecipes();
	}
	
	private void disPlayViewsRecipes() {

		for(int i = 0; i < this.daysRecipes.size();i++) {
			if(this.daysRecipes.get(i).getType().contentEquals("Breakfast")) {
				this.breakfastRecipeName.setText(this.daysRecipes.get(i).getName());
			}else if(this.daysRecipes.get(i).getType().contentEquals("Snacks")) {
				this.snackRecipeName.setText(this.daysRecipes.get(i).getName());
			}else if(this.daysRecipes.get(i).getType().contentEquals("Entrees") && lunchFlag == true) {
				this.lunchRecipeName.setText(this.daysRecipes.get(i).getName());
			}else {
				this.dinnerRecipeName.setText(this.daysRecipes.get(i).getName());
			}
		}
		this.breakfastRecipeName.setVisible(true);
		this.lunchRecipeName.setVisible(true);
		this.dinnerRecipeName.setVisible(true);
		this.snackRecipeName.setVisible(true);

	}

	private void populateChildren() {
		//adding catgoryButtons tabs
				this.categorySelection.getChildren().addAll(this.overViewButton,this.breakfastButton,this.entreesButton,this.snacksButton);
		//adding recipe names and delete buttons to selectedRecipes section
				this.breakfastInfo.getChildren().addAll(this.breakfastRecipeName, this.deleteBreakfastButton);
				this.lunchInfo.getChildren().addAll(this.lunchRecipeName, this.deleteLunchButton);
				this.dinnerInfo.getChildren().addAll(this.dinnerRecipeName, this.deleteDinnerButton);
				this.snackInfo.getChildren().addAll(this.snackRecipeName, this.deleteSnackButton);
				this.selectedRecipes.getChildren().addAll(this.breakfastInfo,this.lunchInfo, this.dinnerInfo, this.snackInfo);
		//adding ComboBox and Add button to addRecipeDropDown section
				this.addRecipeDropdown.getChildren().addAll(this.comboBox,this.addRecipeButton);
		//add all components to the view		
				this.wholeView.getChildren().addAll(this.categorySelection, this.addRecipeDropdown,this.selectedRecipes);
		//add the view to the class
				this.getChildren().add(wholeView);
		
	}

	private void styleVariables() {
		this.wholeView.setBackground(new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
		this.wholeView.setPrefSize(550, 440);
	}
	
	private void setDefaultVisibilities() {
		if(this.daysRecipes.size()>0) {
			this.breakfastRecipeName.setVisible(true);
			this.lunchRecipeName.setVisible(true);
			this.dinnerRecipeName.setVisible(true);
			this.snackRecipeName.setVisible(true);
		}else {
			this.breakfastRecipeName.setVisible(false);
			this.lunchRecipeName.setVisible(false);
			this.dinnerRecipeName.setVisible(false);
			this.snackRecipeName.setVisible(false);
		}
		this.comboBox.setVisible(false);
		this.addRecipeButton.setVisible(false);
		flag = true;
	}

	private void initializeVariables() {
		this.wholeView = new VBox();
		this.selectedRecipes = new VBox();
		this.categorySelection = new HBox();
		this.breakfastInfo = new HBox();
		this.lunchInfo = new HBox();
		this.dinnerInfo = new HBox();
		this.snackInfo = new HBox();
		this.addRecipeDropdown = new HBox();
		this.breakfastRecipeName = new Label("DEFAULT FOR BREAKFAST");
		this.lunchRecipeName= new Label("DEFAULT FOR LUNCH");
		this.dinnerRecipeName= new Label("DEFAULT FOR DINNER");
		this.snackRecipeName= new Label("DEFAULT FOR SNACK");
		this.comboBox = new ComboBox();
		this.overViewButton = new Button("OVERVIEW");
		this.breakfastButton = new Button("BREAKFAST");
		this.entreesButton = new Button("ENTREES");
		this.snacksButton = new Button("SNACKS");
		this.addRecipeButton = new Button("ADD");
		this.deleteBreakfastButton = new Button("DELETE");
		this.deleteLunchButton = new Button("DELETE");	
		this.deleteDinnerButton = new Button("DELETE");
		this.deleteSnackButton = new Button("DELETE");
		this.viewSelectedRecipe = new Button("VIEW RECIPE");
	}

	protected void populateComboBox(int num) {
		if(flag) {
			this.comboBox.setVisible(true);
			this.addRecipeButton.setVisible(true);
		}else {
			flag = false;
		}

		comboBox.getItems().clear();
		switch(num) {
			case 0:
			for(int i=0;i<this.recipeList.breakfastRecipes().size();i++) {
				comboBox.getItems().add(this.recipeList.breakfastRecipes().get(i).getName());
				comboBox.setVisible(true);
			}
			break;
			case 1:
				for(int i=0;i<this.recipeList.entreeRecipes().size();i++) {
					comboBox.getItems().add(this.recipeList.entreeRecipes().get(i).getName());
					comboBox.setVisible(true);
				}
				break;
			case 2:
				for(int i=0;i<this.recipeList.snackRecipes().size();i++) {
					comboBox.getItems().add(this.recipeList.snackRecipes().get(i).getName());
					comboBox.setVisible(true);
				}
				break;
			default:
				System.out.println("Something is wrong here");
		}
	}
	
	private void clearRecipe(int num) {
		switch(num) {
		case 0:
			for(int i=0; i< this.daysRecipes.size();i++) {
				if(this.breakfastRecipeName.getText().contentEquals(this.daysRecipes.get(i).getName())) {
					this.daysRecipes.remove(i);
				}
			}
			break;
			
		case 1:{
			for(int i=0; i< this.daysRecipes.size();i++) {
				if(this.lunchRecipeName.getText().contentEquals(this.daysRecipes.get(i).getName())) {
					this.daysRecipes.remove(i);
					lunchFlag = false;
				}
			}
			break;
		}
		case 2:
			for(int i=0; i< this.daysRecipes.size();i++) {
				if(this.dinnerRecipeName.getText().contentEquals(this.daysRecipes.get(i).getName())) {
					this.daysRecipes.remove(i);
					dinnerFlag = false;
				}
			}
			break;
		case 3:
			for(int i=0; i< this.daysRecipes.size();i++) {
				if(this.snackRecipeName.getText().contentEquals(this.daysRecipes.get(i).getName())) {
					this.daysRecipes.remove(i);
				}
			}
			break;
		default:
			System.out.println("Something is wrong here");
		}
	}
}


package application.Key2Keto.Recipes;

import java.util.ArrayList;
import java.util.Arrays;

import application.Key2Keto.Account.Account;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DayOfWeekView extends Pane {
	private String name;
	private Account user;
	private RecipeList recipeList;
	private ArrayList<Recipe> daysRecipes;
	private RecipeDetailView recipeDetailView;
	private int day = 0;
	private boolean flag = false;
	private boolean lunchFlag = false;
	private boolean dinnerFlag = false;
	private int numEntree = 0;
	private VBox wholeView;
	private VBox selectedRecipes;
	private VBox recipeDetails;
	private HBox bottomRecipeInfo;
	private HBox categorySelection;
	private HBox breakfastInfo;
	private HBox lunchInfo;
	private HBox dinnerInfo;
	private HBox snackInfo;
	private HBox addRecipeDropdown;
	private VBox confirmationBox;
	
	//selected recipe names
	private Label breakfastRecipeName;
	private Label lunchRecipeName;
	private Label dinnerRecipeName;
	private Label snackRecipeName;
	private Label daysRecipesLabel;
	//ComboBox variables
	private ComboBox<String> comboBox;
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

	//confirm Recipes Button
	private Button confirmRecipeSelection;
	private Label confirmLabel;
	private StackPane confirm;
	
	public DayOfWeekView(RecipeList recipeList, String name, Account user) {
		this.name = name;
		this.recipeList = recipeList;
		this.user = user;
		this.day = getIntFormOfDay(this.name);
		this.daysRecipes = new ArrayList<Recipe>();
		initializeVariables();
		styleVariables();
		populateChildren();
		setDefaultVisibilities();

		overViewButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	disPlayViewsRecipes();
		    	DayOfWeekView.this.comboBox.setVisible(false);
		    	DayOfWeekView.this.addRecipeButton.setVisible(false);
		    	DayOfWeekView.this.recipeDetails.setViewOrder(0);
		    	DayOfWeekView.this.confirmationBox.setViewOrder(-1);
		    	DayOfWeekView.this.confirmationBox.setVisible(true);
		    	DayOfWeekView.this.recipeDetails.setVisible(false);
		    	setButtonCLickedColor(0);
		    }
		});
		breakfastButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	populateComboBox(0);
		    	DayOfWeekView.this.comboBox.setPromptText("--- Select a Recipe ---");
		    	DayOfWeekView.this.recipeDetails.setViewOrder(-1);
		    	DayOfWeekView.this.confirmationBox.setViewOrder(0);
		    	DayOfWeekView.this.confirmationBox.setVisible(false);
		    	DayOfWeekView.this.recipeDetails.setVisible(true);
		    	setButtonCLickedColor(1);
		    }
		});
		entreesButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	populateComboBox(1);
		    	DayOfWeekView.this.comboBox.setPromptText("--- Select a Recipe ---");
		    	DayOfWeekView.this.recipeDetails.setViewOrder(-1);
		    	DayOfWeekView.this.confirmationBox.setViewOrder(0);
		    	DayOfWeekView.this.confirmationBox.setVisible(false);
		    	DayOfWeekView.this.recipeDetails.setVisible(true);
		    	setButtonCLickedColor(2);
		    }
		});
		snacksButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	populateComboBox(2);
		    	DayOfWeekView.this.comboBox.setPromptText("--- Select a Recipe ---");
		    	DayOfWeekView.this.recipeDetails.setViewOrder(-1);
		    	DayOfWeekView.this.confirmationBox.setViewOrder(0);
		    	DayOfWeekView.this.confirmationBox.setVisible(false);
		    	DayOfWeekView.this.recipeDetails.setVisible(true);
		    	setButtonCLickedColor(3);
		    }
		});
		
		deleteBreakfastButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	clearRecipe(0);
		    }
		});
		
		deleteLunchButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	clearRecipe(1);
		    }
		});
		
		deleteDinnerButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	clearRecipe(2);
		    }
		});
		
		deleteSnackButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	clearRecipe(3);
		    }
		});
		
		addRecipeButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	String selected = "";
		    	if(DayOfWeekView.this.comboBox.getValue() == null) {
		    		System.out.println("No String Entered");
		    	}else {
		    		selected = DayOfWeekView.this.comboBox.getValue().toString();
		    	}
		    	addRecipe(selected);
		    }
		});
		
		confirmRecipeSelection.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	ArrayList<Recipe> temp = new ArrayList<Recipe>();
		    	for(int i = 0; i<4;i++) {
		    		temp.add(i,null);
		    	}
		    	
		    	
		    	DayOfWeekView.this.user.getChosenRecipes().get(day).clear();
		    	
		    	for(int i = 0; i<DayOfWeekView.this.daysRecipes.size(); i++) {
		    		if(DayOfWeekView.this.daysRecipes.get(i).getName().contentEquals(DayOfWeekView.this.breakfastRecipeName.getText())) {
		    			temp.add(0,DayOfWeekView.this.daysRecipes.get(i));
		    		}
		    		if(DayOfWeekView.this.daysRecipes.get(i).getName().contentEquals(DayOfWeekView.this.lunchRecipeName.getText())) {
		    			temp.add(1,DayOfWeekView.this.daysRecipes.get(i));
		    		}
		    		if(DayOfWeekView.this.daysRecipes.get(i).getName().contentEquals(DayOfWeekView.this.dinnerRecipeName.getText())) {
		    			temp.add(2,DayOfWeekView.this.daysRecipes.get(i));
		    		}
		    		if(DayOfWeekView.this.daysRecipes.get(i).getName().contentEquals(DayOfWeekView.this.snackRecipeName.getText())) {
		    			temp.add(3,DayOfWeekView.this.daysRecipes.get(i));
		    		}
		    	}
		    	DayOfWeekView.this.user.getChosenRecipes().get(day).add(temp.get(0));
		    	DayOfWeekView.this.user.getChosenRecipes().get(day).add(temp.get(1));
		    	DayOfWeekView.this.user.getChosenRecipes().get(day).add(temp.get(2));
		    	DayOfWeekView.this.user.getChosenRecipes().get(day).add(temp.get(3));
		    }
		});
		
		this.comboBox.setOnAction(e-> {
			DayOfWeekView.this.recipeDetails.getChildren().clear();
			String recipe = "";
			if(this.comboBox.getValue() != null) {
				recipe = this.comboBox.getValue().toString();
				for(int i =0; i<DayOfWeekView.this.recipeList.getRecipeList().size();i++ ) {
					if(recipe.contentEquals(DayOfWeekView.this.recipeList.getRecipeList().get(i).getName())) {
						ScrollPane scrollPane = new ScrollPane();
						scrollPane.setPrefWidth(500);
						scrollPane.setMaxHeight(375);
						DayOfWeekView.this.recipeDetailView = new RecipeDetailView(DayOfWeekView.this.recipeList.getRecipeList().get(i));
						scrollPane.setContent(DayOfWeekView.this.recipeDetailView);
						DayOfWeekView.this.recipeDetails.getChildren().add(scrollPane);
						DayOfWeekView.this.recipeDetails.setViewOrder(-1);
						DayOfWeekView.this.confirmationBox.setViewOrder(0);
						VBox.setMargin(scrollPane, new Insets(10,0,0,10));
					}
				}
				
			}
		});
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getIntFormOfDay(String dayName) {
		int day = 0;
		switch(dayName) {
			case "Sunday":
				day = 0;
				break;
			case "Monday":
				day = 1;
				break;
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
	
	public RecipeDetailView getDetailView() {
		return this.recipeDetailView;
	}
		
	private void setButtonColor() {
		Button temp[] = new Button[4];
		temp[0] = this.overViewButton;
		temp[1] = this.breakfastButton;
		temp[2] = this.entreesButton;
		temp[3] = this.snacksButton;

		
		for(int i = 0; i < 4; i++) {
			temp[i].setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
	}
	
	private void setButtonCLickedColor(int num) {
		Button temp[] = new Button[4];
		temp[0] = this.overViewButton;
		temp[1] = this.breakfastButton;
		temp[2] = this.entreesButton;
		temp[3] = this.snacksButton;
		
		for(int i = 0; i < 4; i++) {
			if(num == i) {
				temp[i].setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
			}else {
				temp[i].setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		}
	}

	private void addRecipe(String selected) {
		Recipe temp;
		int recflag = 0;
		for (int i = 0; i < this.recipeList.getRecipeList().size(); i++) {
			if (selected.contentEquals(this.recipeList.getRecipeList().get(i).getName())) {
				temp = this.recipeList.getRecipeList().get(i);
				for(int j =0; j<this.daysRecipes.size();j++) {
					if(this.daysRecipes.get(j).getType().contentEquals(temp.getType()) && !temp.getType().contentEquals("Entrees") ) {
							recflag = 1;
							break;	
					}
					else if(this.daysRecipes.get(j).getType().contentEquals(temp.getType()) && temp.getType().contentEquals("Entrees") ) {
						if(numEntree > 1) {
							recflag = 1;
							break;
						}
					}
				}
				if(recflag == 0 && !temp.getType().contentEquals("Entrees")) {
					this.daysRecipes.add(temp);
				}
				if(temp.getType().contentEquals("Entrees") && numEntree < 2 ) {
					this.daysRecipes.add(temp);
					numEntree++;
				}
			}
		}
		disPlayViewsRecipes();
	}

	private void disPlayViewsRecipes() {
		int count = 0;
		
		for(int i = 0; i < this.daysRecipes.size();i++) {
			if(this.daysRecipes.get(i).getType().contentEquals("Breakfast")) {
				this.breakfastRecipeName.setText(this.daysRecipes.get(i).getName());
			}else if(this.daysRecipes.get(i).getType().contentEquals("Snacks")) {
				this.snackRecipeName.setText(this.daysRecipes.get(i).getName());
			}else if(this.daysRecipes.get(i).getType().contentEquals("Entrees") && count == 0) {
				this.lunchRecipeName.setText(this.daysRecipes.get(i).getName());
				count = 1;
			}else if(this.daysRecipes.get(i).getType().contentEquals("Entrees")) {
				this.dinnerRecipeName.setText(this.daysRecipes.get(i).getName());
				count = 0;
			}
		}
		this.breakfastRecipeName.setVisible(true);
		this.lunchRecipeName.setVisible(true);
		this.dinnerRecipeName.setVisible(true);
		this.snackRecipeName.setVisible(true);
		this.deleteBreakfastButton.setVisible(true);
		this.deleteLunchButton.setVisible(true);
		this.deleteDinnerButton.setVisible(true);
		this.deleteSnackButton.setVisible(true);
	}

	private void populateChildren() {
		this.confirmationBox.getChildren().addAll(this.confirmLabel, this.confirmRecipeSelection);
		this.confirm.getChildren().addAll(this.confirmationBox, this.recipeDetails);
		//adding catgoryButtons tabs
				this.categorySelection.getChildren().addAll(this.overViewButton,this.breakfastButton,this.entreesButton,this.snacksButton);
		//adding recipe names and delete buttons to selectedRecipes section
				this.breakfastInfo.getChildren().addAll(this.breakfastRecipeName, this.deleteBreakfastButton);
				this.lunchInfo.getChildren().addAll(this.lunchRecipeName, this.deleteLunchButton);
				this.dinnerInfo.getChildren().addAll(this.dinnerRecipeName, this.deleteDinnerButton);
				this.snackInfo.getChildren().addAll(this.snackRecipeName, this.deleteSnackButton);
				this.selectedRecipes.getChildren().addAll(this.daysRecipesLabel, this.breakfastInfo,this.lunchInfo, this.dinnerInfo, this.snackInfo);
		//adding selected recipes and recipe details
				this.bottomRecipeInfo.getChildren().addAll(this.selectedRecipes, this.confirm);
		//adding ComboBox and Add button to addRecipeDropDown section
				this.addRecipeDropdown.getChildren().addAll(this.comboBox,this.addRecipeButton);
		//add all components to the view		
				this.wholeView.getChildren().addAll(this.categorySelection, this.addRecipeDropdown,this.bottomRecipeInfo);
		//add the view to the class
				this.getChildren().add(wholeView);
	}

	private void styleVariables() {
		//wholeView styling
		this.wholeView.setBackground(new Background(new BackgroundFill(Color.LIGHTSLATEGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		this.wholeView.setPrefSize(980, 500);
		//this.wholeView.setMargin(categorySelection, new Insets(0, 0, 0, 0));
		//this.wholeView.setMargin(addRecipeDropdown, new Insets(0, 0, 0, 0));
		VBox.setMargin(selectedRecipes, new Insets(0, 10, 0, 10));
		
		//this.categorySelection
		this.categorySelection.setPrefSize(980, 75);
		this.categorySelection.setAlignment(Pos.CENTER);
		this.categorySelection.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		HBox.setMargin(overViewButton, new Insets(10, 5, 10, 0));
		HBox.setMargin(breakfastButton, new Insets(10, 5, 10, 5));
		HBox.setMargin(entreesButton, new Insets(10, 5, 10, 5));
		HBox.setMargin(snacksButton, new Insets(10, 5, 10, 5));
		
		this.overViewButton.setPrefSize(125, 50);
		this.overViewButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		this.breakfastButton.setPrefSize(125, 50);
		this.breakfastButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		this.entreesButton.setPrefSize(125, 50);
		this.entreesButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		this.snacksButton.setPrefSize(125, 50);
		this.snacksButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		
		this.selectedRecipes.setPrefSize(480, 385);
		this.selectedRecipes.setBackground(new Background(new BackgroundFill(Color.LIGHTSLATEGREY, CornerRadii.EMPTY, Insets.EMPTY)));
		this.selectedRecipes.setAlignment(Pos.CENTER);
		
		this.daysRecipesLabel.setPrefSize(500, 75);
		this.daysRecipesLabel.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.daysRecipesLabel.setAlignment(Pos.CENTER);
		this.daysRecipesLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		
		this.breakfastInfo.setPrefSize(500, 75);
		HBox.setMargin(this.breakfastRecipeName, new Insets(10, 5, 10, 5));
		HBox.setMargin(this.deleteBreakfastButton, new Insets(15, 5, 10, 5));
		this.breakfastInfo.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		this.lunchInfo.setPrefSize(500, 75);
		this.lunchInfo.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		HBox.setMargin(this.lunchRecipeName, new Insets(10, 5, 10, 5));
		HBox.setMargin(this.deleteLunchButton, new Insets(15, 5, 10, 5));
		
		this.dinnerInfo.setPrefSize(500, 75);
		this.dinnerInfo.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		HBox.setMargin(this.dinnerRecipeName, new Insets(10, 5, 10, 5));
		HBox.setMargin(this.deleteDinnerButton, new Insets(15, 5, 10, 5));
		
		this.snackInfo.setPrefSize(500, 75);
		this.snackInfo.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		HBox.setMargin(this.snackRecipeName, new Insets(10, 5, 10, 5));
		HBox.setMargin(this.deleteSnackButton, new Insets(15, 5, 10, 5));
		
		this.breakfastRecipeName.setPrefSize(350, 65);
		this.breakfastRecipeName.setFont(Font.font(16));
		this.deleteBreakfastButton.setPrefSize(75, 40);
		this.deleteBreakfastButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		
		this.lunchRecipeName.setPrefSize(350, 65);
		this.lunchRecipeName.setFont(Font.font(16));
		this.deleteLunchButton.setPrefSize(75, 40);
		this.deleteLunchButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		
		this.dinnerRecipeName.setPrefSize(350, 65);
		this.dinnerRecipeName.setFont(Font.font(16));
		this.deleteDinnerButton.setPrefSize(75, 40);
		this.deleteDinnerButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		
		this.snackRecipeName.setPrefSize(350, 65);
		this.snackRecipeName.setFont(Font.font(16));
		this.deleteSnackButton.setPrefSize(75, 40);
		this.deleteSnackButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		
		this.addRecipeDropdown.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.addRecipeDropdown.setPrefSize(980, 35);
		this.addRecipeDropdown.setAlignment(Pos.CENTER);
		HBox.setMargin(this.comboBox, new Insets(5, 5, 5, 5));
		HBox.setMargin(this.addRecipeButton, new Insets(5, 5, 5, 5));
		
		this.comboBox.setPrefSize(420, 35);
		this.comboBox.setPromptText("--- Select a Recipe ---");
		this.comboBox.setEditable(true);
		this.comboBox.getEditor().setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
		this.addRecipeButton.setPrefSize(75, 35);
		this.addRecipeButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		
		this.bottomRecipeInfo.setPrefSize(490, 400);
		this.confirm.setPrefSize(490, 400);
		this.confirm.setMargin(this.confirmationBox, new Insets(10, 10, 10, 10));
		this.confirm.setAlignment(Pos.CENTER);
		this.confirmLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
		this.confirmLabel.setPrefSize(480, 100);
		this.confirmLabel.setWrapText(true);
		this.confirmLabel.setAlignment(Pos.CENTER);
		this.confirmationBox.setAlignment(Pos.CENTER);
		this.confirmRecipeSelection.setPrefSize(100, 50);
		this.confirmRecipeSelection.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
		this.confirmRecipeSelection.setAlignment(Pos.CENTER);
		
	}
	
	private void setDefaultVisibilities() {
		if(this.daysRecipes.size()>0) {
		//if(this.user.getChosenRecipes().get(day).size() > 0) {
			this.breakfastRecipeName.setVisible(true);
			this.lunchRecipeName.setVisible(true);
			this.dinnerRecipeName.setVisible(true);
			this.snackRecipeName.setVisible(true);
		}else {
			this.breakfastRecipeName.setVisible(false);
			this.deleteBreakfastButton.setVisible(false);
			this.lunchRecipeName.setVisible(false);
			this.deleteLunchButton.setVisible(false);
			this.dinnerRecipeName.setVisible(false);
			this.deleteDinnerButton.setVisible(false);
			this.snackRecipeName.setVisible(false);
			this.deleteSnackButton.setVisible(false);
		}
		this.comboBox.setVisible(false);
		this.addRecipeButton.setVisible(false);
		flag = true;
	}

	private void initializeVariables() {
		this.wholeView = new VBox();
		this.selectedRecipes = new VBox();
		this.recipeDetails = new VBox();
		this.confirm = new StackPane();
		this.confirmationBox = new VBox();
		this.confirmLabel = new Label("Click Confirm to add the "
				+ "Chosen Recipes to your Dashboard");
		this.confirmRecipeSelection = new Button("CONFIRM");
		this.bottomRecipeInfo = new HBox();
		this.categorySelection = new HBox();
		this.breakfastInfo = new HBox();
		this.lunchInfo = new HBox();
		this.dinnerInfo = new HBox();
		this.snackInfo = new HBox();
		this.addRecipeDropdown = new HBox();
		this.breakfastRecipeName = new Label("No Breakfast Chosen");
		this.lunchRecipeName= new Label("No Lunch Chosen");
		this.dinnerRecipeName= new Label("No Dinner Chosen");
		this.snackRecipeName= new Label("No Snack Chosen");
		this.daysRecipesLabel = new Label("CHOSEN RECIPES");
		this.comboBox = new ComboBox<String>();
		this.overViewButton = new Button("OVERVIEW");
		this.breakfastButton = new Button("BREAKFAST");
		this.entreesButton = new Button("ENTREES");
		this.snacksButton = new Button("SNACKS");
		this.addRecipeButton = new Button("ADD");
		this.deleteBreakfastButton = new Button("DELETE");
		this.deleteLunchButton = new Button("DELETE");	
		this.deleteDinnerButton = new Button("DELETE");
		this.deleteSnackButton = new Button("DELETE");
		setButtonColor();
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
			this.breakfastRecipeName.setText("No Breakfast Chosen");
			break;
			
		case 1:{
			for(int i=0; i< this.daysRecipes.size();i++) {
				if(this.lunchRecipeName.getText().contentEquals(this.daysRecipes.get(i).getName())) {
					this.daysRecipes.remove(i);
					lunchFlag = false;
				}
			}
			this.lunchRecipeName.setText("No Lunch Chosen");
			break;
		}
		case 2:
			for(int i=0; i< this.daysRecipes.size();i++) {
				if(this.dinnerRecipeName.getText().contentEquals(this.daysRecipes.get(i).getName())) {
					this.daysRecipes.remove(i);
					dinnerFlag = false;
				}
			}
			this.dinnerRecipeName.setText("No Dinner Chosen");
			break;
		case 3:
			for(int i=0; i< this.daysRecipes.size();i++) {
				if(this.snackRecipeName.getText().contentEquals(this.daysRecipes.get(i).getName())) {
					this.daysRecipes.remove(i);
				}
			}
			this.snackRecipeName.setText("No Snack Chosen");
			break;
		default:
			System.out.println("Something is wrong here");
		}
	}
	
	public ArrayList<Recipe> getSelectedRecipes(){
		return this.daysRecipes;
	}

// Methods needed for testing purposes
	protected ComboBox<String> getComboBoxForTest() {
		return this.comboBox;
	}
	
	protected ArrayList<Button> getButtonsToTest(){
		ArrayList<Button> buttonsToTest = new ArrayList<Button>();
		buttonsToTest.addAll(new ArrayList<Button>(Arrays.asList(this.breakfastButton, this.entreesButton, this.snacksButton, this.deleteBreakfastButton,
				this.deleteLunchButton, this.deleteDinnerButton,this.deleteSnackButton, this.addRecipeButton)));
		
		return buttonsToTest;
	}
	
	protected ArrayList<Label> getLabels(){
		ArrayList<Label> labelsToTest = new ArrayList<Label>();
		labelsToTest.addAll(new ArrayList<Label>(Arrays.asList(this.breakfastRecipeName, this.lunchRecipeName, this.dinnerRecipeName,
				this.snackRecipeName)));
		
		return labelsToTest;
	}
}
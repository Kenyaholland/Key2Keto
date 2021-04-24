package application.Key2Keto.Shopping;

import java.util.ArrayList;

import application.Key2Keto.Account.Account;
import application.Key2Keto.Interfaces.ViewInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ShoppingView extends Pane implements ViewInterface {
	private HBox view;
	
	private VBox sundayRecipes;
	private VBox mondayRecipes;
	private VBox tuesdayRecipes;
	private VBox wednesdayRecipes;
	private VBox thursdayRecipes;
	private VBox fridayRecipes;
	private VBox saturdayRecipes;
	
	private VBox leftside;
	private VBox rightside;
	private VBox rightInner;
	private VBox leftInner;
	private VBox restInfoBox;
	private VBox macroInfoBox;
	private Button print;
	private ComboBox<String> restaurantBox;
	
	private Label restMeal;
	private Label restOption;
	private Label totalMacrosTitle;
	private Label weekLabel;
	private Label sundayMac;
	private Label mondayMac;
	private Label tuesdayMac;
	private Label wednesdayMac;
	private Label thursdayMac;
	private Label fridayMac;
	private Label saturdayMac;
	
	private Label sundayRecTitle;
	private Label mondayRecTitle;
	private Label tuesdayRecTitle;
	private Label wednesdayRecTitle;
	private Label thursdayRecTitle;
	private Label fridayRecTitle;
	private Label saturdayRecTitle;
	
	public ShoppingView(Account account) {
		ShoppingViewLogic.setUserAccount(account);
		String file = "./src/main/java/application/Key2Keto/Shopping/RestaurantMeals.txt";
		ShoppingViewLogic.setFileReader(file);
		ShoppingViewLogic.setRestaurantMeals(ShoppingViewLogic.getFileReader().getMeals());
		ShoppingViewLogic.setUsersChosenRecipes(account.getChosenRecipes());
		ShoppingViewLogic.setDietType(account.getDietType());
		initializeVariables();
		populateChildren();
		stylizeElements();
		populateCombo();
		assignSetOnActions();
	}

	@Override
	public void populateChildren() {
		this.sundayRecipes.getChildren().add(this.sundayRecTitle);
		populateRecipeIngredients(this.sundayRecipes, 0);
		
		this.mondayRecipes.getChildren().add(this.mondayRecTitle);
		populateRecipeIngredients(this.mondayRecipes, 1);
		
		this.tuesdayRecipes.getChildren().add(this.tuesdayRecTitle);
		populateRecipeIngredients(this.tuesdayRecipes, 2);
		
		this.wednesdayRecipes.getChildren().add(this.wednesdayRecTitle);
		populateRecipeIngredients(this.wednesdayRecipes, 3);
		
		this.thursdayRecipes.getChildren().add(this.thursdayRecTitle);
		populateRecipeIngredients(this.thursdayRecipes, 4);
		
		this.fridayRecipes.getChildren().add(this.fridayRecTitle);
		populateRecipeIngredients(this.fridayRecipes, 5);
		
		this.saturdayRecipes.getChildren().add(this.saturdayRecTitle);
		populateRecipeIngredients(this.saturdayRecipes, 6);
		
		this.leftInner.getChildren().addAll(this.weekLabel,this.sundayRecipes,this.mondayRecipes,this.tuesdayRecipes,
				this.wednesdayRecipes,this.thursdayRecipes,this.fridayRecipes,this.saturdayRecipes, this.print);
		
		this.macroInfoBox.getChildren().addAll(this.totalMacrosTitle,this.sundayMac,this.mondayMac,this.tuesdayMac,
				this.wednesdayMac,this.thursdayMac,this.fridayMac,this.saturdayMac);
		
		this.restInfoBox.getChildren().addAll(this.restOption,this.restaurantBox,this.restMeal);
		this.rightInner.getChildren().addAll(this.macroInfoBox,this.restInfoBox);
		
		this.rightside.getChildren().add(this.rightInner);
		this.leftside.getChildren().add(this.leftInner);
		this.view.getChildren().addAll(this.leftside, this.rightside);
		this.getChildren().add(view);
	}

	@Override
	public void initializeVariables() {
		this.view = new HBox();
		this.leftside = new VBox();
		this.leftInner = new VBox();
		this.sundayRecipes = new VBox();
		this.mondayRecipes = new VBox();
		this.tuesdayRecipes = new VBox();
		this.wednesdayRecipes = new VBox();
		this.thursdayRecipes = new VBox();
		this.fridayRecipes = new VBox();
		this.saturdayRecipes = new VBox();
		
		this.print = new Button("Print Shopping List");
		
		this.totalMacrosTitle= new Label("TOTAL MACROS FOR THE WEEK");
		this.sundayMac= new Label("Sunday: Fat: Xg  Carbs: Xg  Protein: Xg");
		this.mondayMac = new Label("Monday Fat: Xg  Carbs: Xg  Protein: Xg");
		this.tuesdayMac= new Label("Tuesday Fat: Xg  Carbs: Xg  Protein: Xg");
		this.wednesdayMac= new Label("Wednesday Fat: Xg  Carbs: Xg  Protein: Xg");
		this.thursdayMac= new Label("Thursday Fat: Xg  Carbs: Xg  Protein: Xg");
		this.fridayMac= new Label("Friday Fat: Xg  Carbs: Xg  Protein: Xg");
		this.saturdayMac= new Label("Saturday Fat: Xg  Carbs: Xg  Protein: Xg");
		
		this.weekLabel = new Label("INGREDIENTS NEEDED FOR THE WEEK");
		this.sundayRecTitle = new Label("SUNDAY");
		this.mondayRecTitle = new Label("MONDAY");
		this.tuesdayRecTitle = new Label("TUESDAY");
		this.wednesdayRecTitle = new Label("WEDNESDAY");
		this.thursdayRecTitle = new Label("THURSDAY");
		this.fridayRecTitle = new Label("FRIDAY");
		this.saturdayRecTitle = new Label("SATURDDAY");
		
		this.rightside = new VBox();
		this.rightInner = new VBox();
		this.restInfoBox = new VBox();
		this.macroInfoBox = new VBox();
		
		this.restOption = new Label("Need a restaurant meal option?\nClick the dropdown to select "
				+ "a restaruant with a meal based off your selected diet type");
		this.restMeal = new Label("Restaurant Meal Label");
		this.restaurantBox = new ComboBox<String>();
	}

	@Override
	public void stylizeElements() {
		this.view.setPrefSize(980, 500);
		this.leftside.setPrefSize(490, 500);
		this.leftside.setId("ShoppingPane");
		this.leftInner.setPrefSize(490, 500);
		VBox.setMargin(this.leftInner, new Insets(5,5,5,5));
		this.weekLabel.setPrefWidth(500);
		this.weekLabel.setId("ShoppingViewTitles");
		
		this.rightside.setPrefSize(490,500);
		this.rightside.setId("ShoppingPane");
		VBox.setMargin(this.rightInner, new Insets(5,5,5,5));
		this.rightInner.setPrefSize(490, 500);
		
		this.macroInfoBox.setPrefSize(490, 250);
		this.restInfoBox.setAlignment(Pos.CENTER);
		VBox.setMargin(this.restaurantBox, new Insets(5,5,5,5));
		VBox.setMargin(this.restMeal, new Insets(5,5,5,5));
		VBox.setMargin(this.restOption, new Insets(5,5,5,5));
		this.totalMacrosTitle.setId("ShoppingViewTitles");
		this.totalMacrosTitle.setPrefWidth(500);
		this.restInfoBox.setPrefSize(490, 250);
		this.restOption.setWrapText(true);
		this.restMeal.setWrapText(true);
		this.print.setId("ShoppingViewButton");
		this.leftInner.setMargin(this.print, new Insets(15,5,5,5));		
		//this.view.setId(value);
		
		
	}

	@Override
	public void assignSetOnActions() {
		this.restaurantBox.setOnAction(e -> {
			String restaurantName = "";
			if (this.restaurantBox.getValue() != null) {
				restaurantName = this.restaurantBox.getValue().toString();
				this.restMeal.setText(ShoppingViewLogic.findRestaurantMeal(restaurantName));
			}
		});
		
		this.print.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {				
				ShoppingList shopList = new ShoppingList(ShoppingViewLogic.getChosenRecipes().get(5));
				shopList.generateShoppingList();
			}
		});
		
	}
	
	private void populateCombo(){
		this.restaurantBox.getItems().clear();
		this.restaurantBox.getItems().addAll(ShoppingViewLogic.getRestaurantNames(ShoppingViewLogic.getFileReader().getMeals()
				,ShoppingViewLogic.getUserAccount().getDietType()));
		this.restaurantBox.setVisible(true);
	}
	
	public void updateUI() {
		this.sundayMac.setText("Sunday: Fat: XXg  Carbs: Xg  Protein: Xg");
		this.mondayMac.setText("Monday Fat: XXg  Carbs: Xg  Protein: Xg");
		this.tuesdayMac.setText("Tuesday Fat: XXg  Carbs: Xg  Protein: Xg");
		this.wednesdayMac.setText("Wednesday Fat: XXg  Carbs: Xg  Protein: Xg");
		this.thursdayMac.setText("Thursday Fat: XXg  Carbs: Xg  Protein: Xg");
		this.fridayMac.setText("Friday Fat: XXg  Carbs: Xg  Protein: Xg");
		this.saturdayMac.setText("Saturday Fat: Xg  Carbs: Xg  Protein: Xg");
		populateRecipeIngredients(this.sundayRecipes, 0);
		populateRecipeIngredients(this.mondayRecipes, 1);
		populateRecipeIngredients(this.tuesdayRecipes, 2);
		populateRecipeIngredients(this.wednesdayRecipes, 3);
		populateRecipeIngredients(this.thursdayRecipes, 4);
		populateRecipeIngredients(this.fridayRecipes, 5);
		populateRecipeIngredients(this.saturdayRecipes, 6);
	}
	
	private void populateRecipeIngredients(VBox vbox, int num){
		Label day = (Label) vbox.getChildren().get(0);
		ArrayList<String> temp;
		vbox.getChildren().clear();
		vbox.getChildren().addAll(this.weekLabel, day);
		temp = ShoppingViewLogic.populateIngredientsForDay(ShoppingViewLogic.getUserAccount().getChosenRecipes().get(num));
		if(temp.size()<1) {
			temp.add("No Recipes Chosen");
		}
		for(int i = 0; i<temp.size(); i ++) {
			Label label = new Label(temp.get(i));
			vbox.getChildren().add(label);
		}
	}

}

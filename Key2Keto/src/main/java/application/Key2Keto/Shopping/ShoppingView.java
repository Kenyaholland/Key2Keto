package application.Key2Keto.Shopping;

import java.util.ArrayList;

import application.Key2Keto.Account.Account;
import application.Key2Keto.Interfaces.ViewInterface;
import application.Key2Keto.Recipes.DayOfWeekLogic;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
		this.mondayRecipes.getChildren().add(this.mondayRecTitle);
		this.tuesdayRecipes.getChildren().add(this.tuesdayRecTitle);
		this.wednesdayRecipes.getChildren().add(this.wednesdayRecTitle);
		this.thursdayRecipes.getChildren().add(this.thursdayRecTitle);
		this.fridayRecipes.getChildren().add(this.fridayRecTitle);
		this.saturdayRecipes.getChildren().add(this.saturdayRecTitle);
		
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
		this.mondayMac= new Label("Monday Fat: Xg  Carbs: Xg  Protein: Xg");
		this.tuesdayMac= new Label("Tuesday Fat: Xg  Carbs: Xg  Protein: Xg");
		this.wednesdayMac= new Label("Wednesday Fat: Xg  Carbs: Xg  Protein: Xg");
		this.thursdayMac= new Label("Thursday Fat: Xg  Carbs: Xg  Protein: Xg");
		this.fridayMac= new Label("Friday Fat: Xg  Carbs: Xg  Protein: Xg");
		this.saturdayMac= new Label("Saturday Fat: Xg  Carbs: Xg  Protein: Xg");
		
		this.weekLabel = new Label("Ingredients needed for each day of week");
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
		
		this.restOption = new Label("Restaurant meal option?");
		this.restMeal = new Label("Restaurant Meal Label");
		this.restaurantBox = new ComboBox<String>();
	}

	@Override
	public void stylizeElements() {
		this.view.setPrefSize(980, 500);
		this.leftside.setPrefSize(490, 500);
		this.rightside.setPrefSize(490,500);
		this.leftInner.setPrefSize(490, 500);
		this.rightInner.setPrefSize(490, 500);
		this.macroInfoBox.setPrefSize(490, 250);
		this.restInfoBox.setPrefSize(490, 250);
		this.print.setId("ShoppingViewButton");
		//this.view.setId(value);
		
		
	}

	@Override
	public void assignSetOnActions() {
		this.restaurantBox.setOnAction(e -> {
			String restaurantName = "";
			if (this.restaurantBox.getValue() != null) {
				restaurantName = this.restaurantBox.getValue().toString();
				for (int i = 0; i < ShoppingViewLogic.getRestMeals().size(); i++) {
					if (restaurantName.contentEquals(ShoppingViewLogic.getFileReader().getMeals().get(i).getRestaurantName())) {
						System.out.println(ShoppingViewLogic.getFileReader().getMeals().get(i).getMealName());
					}
				}

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
		this.restaurantBox.getItems().addAll(ShoppingViewLogic.getRestMealsNames(ShoppingViewLogic.getFileReader().getMeals()
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
	}

}

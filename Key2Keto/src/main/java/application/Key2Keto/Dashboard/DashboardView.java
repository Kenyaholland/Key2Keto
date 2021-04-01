package application.Key2Keto.Dashboard;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import application.Key2Keto.Account.Account;
import javafx.geometry.Pos;
//import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DashboardView extends Pane {
	private Dashboard dashboard;
	private VBox view;
	private VBox recipeInformationBox;
	private VBox goalInformationBox;
	private HBox upperHalf;
	private HBox lowerHalf;
	
	Label userName;
	Label dietType;
	Label breakfastRecipe;
	Label lunchRecipe;
	Label dinnerRecipe;
	Label snackRecipe;
	Label weeklyGoalsLabel;
	
	public DashboardView() {
		this.dashboard = new Dashboard(new Account("username123", "password123", "John", "McLastname", "Male", "5'9\"", 190, 24, "Classic"));
		populateSleepChart();
		populateWaterChart();
		initializeVariables();
		populateChildren();
		stylizeVariables();
		this.getChildren().add(view);		
	}
	
	private void initializeVariables() {
		
	}
	
	private void populateChildren() {
		
	}
	
	private void populateSleepChart() {
		
	}
	
	private void populateWaterChart() {
		
	}
	
	private void stylizeVariables() {
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
		this.view.setPrefSize(980, 500);
	}
}
/*
	UserAccount Tracker day. getwater or getsleep for each chart.
*/
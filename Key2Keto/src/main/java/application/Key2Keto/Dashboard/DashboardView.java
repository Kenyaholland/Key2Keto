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
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
//import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DashboardView extends Pane {
	private Dashboard dashboard;
	private VBox view;
	private VBox recipeInformationBox;
	private VBox goalInformationBox;
	private HBox upperHalf;
	private HBox lowerHalf;
	
	private Label userName;
	private Label dietType;
	private Label breakfastRecipe;
	private Label lunchRecipe;
	private Label dinnerRecipe;
	private Label snackRecipe;
	private Label weeklyGoalsLabel;
	private Label goals;
	private Label todaysRecipeTitle;
	private LineChart waterChart;
	private LineChart sleepChart;
	
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
		this.view = new VBox();
		this.recipeInformationBox= new VBox();
		this.goalInformationBox= new VBox();
		this.upperHalf = new HBox();
		this.lowerHalf = new HBox();
		
		this.userName = new Label(this.dashboard.getUserAccount().getFirstName()+" "+this.dashboard.getUserAccount().getLastName());
		this.dietType= new Label("Diet Type: "+this.dashboard.getUserAccount().getDietType());
		this.todaysRecipeTitle = new Label("TODAY'S RECIPES");
		this.breakfastRecipe= new Label("Chosen Breakfast: XXXXXXXXXXXXXXXXXXXXXXXXX");
		this.lunchRecipe= new Label("Chosen Lunch: XXXXXXXXXXXXXXXXXXXXXXXXX");
		this.dinnerRecipe= new Label("Chosen Dinner: XXXXXXXXXXXXXXXXXXXXXXXXX");
		this.snackRecipe= new Label("Chosen Snack: XXXXXXXXXXXXXXXXXXXXXXXXX");
		this.weeklyGoalsLabel= new Label("GOALS FOR THE WEEK");
		this.goals = new Label("THIS WILL BE POPULATED WITH THE USER'S GOALS FROM THE TRACKER CLASS");
	}
	
	private void populateChildren() {
		this.recipeInformationBox.getChildren().addAll(this.dietType,this.todaysRecipeTitle,
				this.breakfastRecipe,this.lunchRecipe,this.dinnerRecipe,this.snackRecipe);
		this.goalInformationBox.getChildren().addAll(this.weeklyGoalsLabel, this.goals);
		this.upperHalf.getChildren().addAll(this.recipeInformationBox, this.goalInformationBox);
		this.lowerHalf.getChildren().addAll(this.waterChart, this.sleepChart);
		this.view.getChildren().addAll(this.userName, this.upperHalf, this.lowerHalf);
	}
	
	private void populateSleepChart() {
		NumberAxis xaxis = new NumberAxis(1,7,1);  
        NumberAxis yaxis = new NumberAxis(1,24,1);  
        xaxis.setLabel("Day of Week");  
        yaxis.setLabel("Hours of Sleep");  
            
        this.sleepChart = new LineChart(xaxis,yaxis);  
        sleepChart.setTitle("Sleep Overview");  
             
        XYChart.Series series = new XYChart.Series();   
        series.getData().add(new XYChart.Data(1,6));  
        series.getData().add(new XYChart.Data(2,10));  
        series.getData().add(new XYChart.Data(3,7));  
        series.getData().add(new XYChart.Data(4,8));  
        series.getData().add(new XYChart.Data(5,8));  
        series.getData().add(new XYChart.Data(6,8));  
        series.getData().add(new XYChart.Data(7,6));  
 
        sleepChart.getData().add(series);
	}
	
	private void populateWaterChart() {
		NumberAxis xaxis = new NumberAxis(1,7,1);  
        NumberAxis yaxis = new NumberAxis(1,24,1);  
        xaxis.setLabel("Day of Week");  
        yaxis.setLabel("Ounces of Water");  
            
        this.waterChart = new LineChart(xaxis,yaxis);  
        sleepChart.setTitle("Water Consumption");  
             
        XYChart.Series series = new XYChart.Series();   
        series.getData().add(new XYChart.Data(1,6));  
        series.getData().add(new XYChart.Data(2,10));  
        series.getData().add(new XYChart.Data(3,7));  
        series.getData().add(new XYChart.Data(4,8));  
        series.getData().add(new XYChart.Data(5,8));  
        series.getData().add(new XYChart.Data(6,8));  
        series.getData().add(new XYChart.Data(7,6));  
 
        sleepChart.getData().add(series);
		
	}
	
	private void stylizeVariables() {
		this.view.setPrefSize(980, 500);
		this.view.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
		this.userName.setFont(Font.font(18));
		this.waterChart.setPrefHeight(315);
		this.sleepChart.setPrefHeight(315);
		this.upperHalf.setPrefSize(980, 155);
		this.upperHalf.setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, null, null)));
		this.lowerHalf.setPrefSize(980, 315);
		this.upperHalf.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
	}
}
/*
	UserAccount Tracker day. getwater or getsleep for each chart.
*/
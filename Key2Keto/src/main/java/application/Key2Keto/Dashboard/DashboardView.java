package application.Key2Keto.Dashboard;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import application.Key2Keto.Account.Account;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.CheckBox;
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
	private Label goalOne;
	private Label goalTwo;
	private Label goalThree;
	private Label todaysRecipeTitle;
	private LineChart<String, Number> waterChart;
	private LineChart<String, Number> sleepChart;
	private CheckBox firstGoal;
	private CheckBox secondGoal;
	private CheckBox thirdGoal;
	
	public DashboardView() {
	//public DashboardView(Account user) {
		//this.dashboard = new Dashboard(user);
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
		
		this.userName = new Label(this.dashboard.getUserAccount().getFirstName()+" "+this.dashboard.getUserAccount().getLastName()+"'s Key2Keto Overview");
		this.dietType = new Label("Selected Diet Type: "+this.dashboard.getUserAccount().getDietType());
		this.todaysRecipeTitle = new Label("TODAY'S RECIPES");
		this.breakfastRecipe= new Label("Chosen Breakfast: XXXXX XXXXXX XXXXX XXX XX XXXX"); //need the Account for the days
		this.lunchRecipe= new Label("Chosen Lunch: XX XXXX XXXXXXX XXXX XXXXXXXX");
		this.dinnerRecipe= new Label("Chosen Dinner: XX XXXXXX XXX XXXX XXXX XXXXXX");
		this.snackRecipe= new Label("Chosen Snack: XXX XXXXXXX XXX XXXXXXXXXXXX");
		this.weeklyGoalsLabel= new Label("GOALS FOR THE WEEK");
		this.firstGoal = new CheckBox("Have an average of 8 hours of sleep a day for the week.");
		this.secondGoal = new CheckBox("Drink 100 ounces of water each day for the week.");
		this.thirdGoal = new CheckBox("Drink 128 ounces of water on Tuesday");
	}
	
	private void populateChildren() {
		this.recipeInformationBox.getChildren().addAll(this.todaysRecipeTitle,this.dietType,
				this.breakfastRecipe,this.lunchRecipe,this.dinnerRecipe,this.snackRecipe);
		this.goalInformationBox.getChildren().addAll(this.weeklyGoalsLabel, this.firstGoal, this.secondGoal, this.thirdGoal);
		this.upperHalf.getChildren().addAll(this.recipeInformationBox, this.goalInformationBox);
		this.lowerHalf.getChildren().addAll(this.waterChart, this.sleepChart);
		this.view.getChildren().addAll(this.userName, this.upperHalf, this.lowerHalf);
	}
	
	private void populateSleepChart() {
		CategoryAxis xaxis = new CategoryAxis();  
        NumberAxis yaxis = new NumberAxis(0,14,2);  
        xaxis.setLabel("Day of Week");  
        yaxis.setLabel("Hours of Sleep");  
            
        this.sleepChart = new LineChart<String,Number>(xaxis,yaxis);  
        this.sleepChart.setTitle("Sleep Overview");  
             
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        series.setName("Weekly Hours of Sleep");
        series.getData().add(new Data<String, Number>("Sunday",6));  
        series.getData().add(new Data<String, Number>("Monday",10));  
        series.getData().add(new Data<String, Number>("Tuesday",7));  
        series.getData().add(new Data<String, Number>("Wednesday",8));  
        series.getData().add(new Data<String, Number>("Thursday",8));  
        series.getData().add(new Data<String, Number>("Friday",8));  
        series.getData().add(new Data<String, Number>("Saturday",6));
 
        this.sleepChart.getData().add(series);
        this.sleepChart.setLegendVisible(false);
        this.sleepChart.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
	}
	
	private void populateWaterChart() {
		CategoryAxis xaxis = new CategoryAxis();  
        NumberAxis yaxis = new NumberAxis(0,128,8);  
        xaxis.setLabel("Day of Week");  
        yaxis.setLabel("Ounces of Water");  
            
        this.waterChart = new LineChart<String,Number>(xaxis,yaxis);  
        this.waterChart.setTitle("Water Consumption");  
             
        XYChart.Series<String, Number> series = new Series<String, Number>();
        series.setName("Daily Ounces of Water Consumed");
        series.getData().add(new Data<String, Number>("Sunday",46));  
        series.getData().add(new Data<String, Number>("Monday",100));  
        series.getData().add(new Data<String, Number>("Tuesday",97));  
        series.getData().add(new Data<String, Number>("Wedday",78));  
        series.getData().add(new Data<String, Number>("Thursday",58));  
        series.getData().add(new Data<String, Number>("Friday",48));  
        series.getData().add(new Data<String, Number>("Saturday",96));  
 
        this.waterChart.getData().add(series);
        this.waterChart.setLegendVisible(false);
        this.waterChart.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
	}
	
	private void stylizeVariables() {
		this.view.setPrefSize(980, 500);
		this.view.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
		
		this.userName.setPrefWidth(980);
		this.setPrefHeight(40);
		this.userName.setAlignment(Pos.CENTER);
		this.userName.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 18));
		this.userName.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		//VBox.setMargin(this.userName, new Insets(5, 0, 5, 0));
		this.userName.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            null, null, null, BorderStrokeStyle.NONE, BorderStrokeStyle.NONE,BorderStrokeStyle.SOLID,
	            BorderStrokeStyle.NONE, CornerRadii.EMPTY, new BorderWidths(3), null)));
		
		this.dietType.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
		
		this.todaysRecipeTitle.setPrefWidth(490);
		this.todaysRecipeTitle.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 16));
		this.todaysRecipeTitle.setAlignment(Pos.CENTER);
		
		this.weeklyGoalsLabel.setPrefWidth(490);
		this.weeklyGoalsLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 16));
		this.weeklyGoalsLabel.setAlignment(Pos.CENTER);
		
		this.waterChart.setPrefHeight(315);
		this.sleepChart.setPrefHeight(315);
		this.waterChart.setPrefWidth(489);
		this.sleepChart.setPrefWidth(490);
		
		this.recipeInformationBox.setPrefWidth(490);
		VBox.setMargin(this.todaysRecipeTitle, new Insets(5, 0, 5, 0));
		VBox.setMargin(this.breakfastRecipe, new Insets(0, 0, 0, 5));
		VBox.setMargin(this.lunchRecipe, new Insets(0, 0, 0, 5));
		VBox.setMargin(this.dinnerRecipe, new Insets(0, 0, 0, 5));
		VBox.setMargin(this.snackRecipe, new Insets(0, 0, 0, 5));
		VBox.setMargin(this.dietType, new Insets(0, 0, 0, 5));
		
		this.breakfastRecipe.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
		this.lunchRecipe.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
		this.dinnerRecipe.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
		this.snackRecipe.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
		
		this.goalInformationBox.setPrefWidth(490);
		VBox.setMargin(this.weeklyGoalsLabel, new Insets(5, 0, 5, 0));
		VBox.setMargin(this.firstGoal, new Insets(0, 0, 0, 10));
		VBox.setMargin(this.secondGoal, new Insets(0, 0, 0, 10));
		VBox.setMargin(this.thirdGoal, new Insets(0, 0, 0, 10));
		
		this.upperHalf.setPrefSize(980, 155);
		this.upperHalf.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, null, null)));
		this.lowerHalf.setPrefSize(980, 315);
		
		this.firstGoal.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
		this.secondGoal.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
		this.thirdGoal.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
	}
}
/*
	UserAccount Tracker day. getwater or getsleep for each chart.
*/
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
import application.Key2Keto.Tracker.TrackerView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class DashboardView extends Pane {
	private Dashboard dashboard;
	private TrackerView trackerView;
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
	
	public DashboardView(Account user) {
		this.dashboard = new Dashboard(user);
		this.trackerView = new TrackerView(user);
		populateSleepChart();
		populateWaterChart();
		initializeVariables();
		populateChildren();
		stylizeVariables();
		this.getChildren().add(view);
		populateDaysRecipes();
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
		this.breakfastRecipe= new Label("Chosen Breakfast: Nothing Chosen");
		this.lunchRecipe= new Label("Chosen Lunch: Nothing Chosen");
		this.dinnerRecipe= new Label("Chosen Dinner: Nothing Chosen");
		this.snackRecipe= new Label("Chosen Snack: Nothing Chosen");
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
	
	private void populateDaysRecipes(){
		System.out.println("this got read");
		if(this.dashboard.getUserAccount().getChosenRecipes().get(this.dashboard.getCurrentDayInt()).size()>0) {
			System.out.println("Size is greater than one.");
			this.breakfastRecipe.setText("Chosen Breakfast: "+ this.dashboard.getUserAccount().getChosenRecipes()
					.get(this.dashboard.getCurrentDayInt()).get(0))/*getBreakfastRecipe().getName())*/;
		//	this.lunchRecipe.setText("Chosen Lunch: "+ this.dashboard.getLunchRecipe().getName());
		//	this.dinnerRecipe.setText("Chosen Dinner: "+ this.dashboard.getDinnerRecipe().getName());
		//	this.snackRecipe.setText("Chosen Snack: "+ this.dashboard.getSnackRecipe().getName());
		}
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
        series.getData().add(new Data<String, Number>("Sunday",this.dashboard.getUserAccount().getTrackers().get(0).getHoursOfSleep()));  
        series.getData().add(new Data<String, Number>("Monday",this.dashboard.getUserAccount().getTrackers().get(1).getHoursOfSleep()));  
        series.getData().add(new Data<String, Number>("Tuesday",this.dashboard.getUserAccount().getTrackers().get(2).getHoursOfSleep()));  
        series.getData().add(new Data<String, Number>("Wednesday",this.dashboard.getUserAccount().getTrackers().get(3).getHoursOfSleep()));  
        series.getData().add(new Data<String, Number>("Thursday",this.dashboard.getUserAccount().getTrackers().get(4).getHoursOfSleep()));  
        series.getData().add(new Data<String, Number>("Friday",this.dashboard.getUserAccount().getTrackers().get(5).getHoursOfSleep()));  
        series.getData().add(new Data<String, Number>("Saturday",this.dashboard.getUserAccount().getTrackers().get(6).getHoursOfSleep()));
 
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
        series.getData().add(new Data<String, Number>("Sunday",this.dashboard.getUserAccount().getTrackers().get(0).getWaterIntake()));  
        series.getData().add(new Data<String, Number>("Monday",this.dashboard.getUserAccount().getTrackers().get(1).getWaterIntake()));  
        series.getData().add(new Data<String, Number>("Tuesday",this.dashboard.getUserAccount().getTrackers().get(2).getWaterIntake()));  
        series.getData().add(new Data<String, Number>("Wedday",this.dashboard.getUserAccount().getTrackers().get(3).getWaterIntake()));  
        series.getData().add(new Data<String, Number>("Thursday",this.dashboard.getUserAccount().getTrackers().get(4).getWaterIntake()));  
        series.getData().add(new Data<String, Number>("Friday",this.dashboard.getUserAccount().getTrackers().get(5).getWaterIntake()));  
        series.getData().add(new Data<String, Number>("Saturday",this.dashboard.getUserAccount().getTrackers().get(6).getWaterIntake()));  

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
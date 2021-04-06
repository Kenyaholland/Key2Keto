package application.Key2Keto;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import javafx.stage.Stage;
import application.Key2Keto.Account.Account;
import application.Key2Keto.Account.AccountView;
import application.Key2Keto.Dashboard.*;
import application.Key2Keto.Recipes.RecipeView;
import application.Key2Keto.Tracker.TrackerView;

public class MainView extends Pane{

	Stage stage;
	SceneSwitcher switcher;
	Account user;
    VBox view;
	HBox labels;
	private Button dash;
	private Button account;
	private Button tracker;
	Button shopping;
	private Button recipes;
	Button logout;
	private StackPane mainContent;
	private RecipeView recipeView;
	private AccountView accountView;
	private TrackerView trackerView;
	private DashboardView dashboardView;
	private Pane other;
	private Label label;
	Label title;
	
	
	public MainView(Stage stage, Account user) {
		this.stage = stage;
		this.user = user;
		this.switcher = new SceneSwitcher(stage);
		
		InitializeVariables();
		StylizeElements();
		AddAllElementsToChildren();
		
	
		this.recipes.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	stackOrder(0);
		    }
		});
		
		this.dash.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	//MainView.this.dashboardView = new DashboardView(MainView.this.user);
		    	stackOrder(1);
		    	
		    }
		});
		
		this.account.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	stackOrder(2);
		    }
		});
		
		this.tracker.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	stackOrder(3);
		    }
		});
}
	
	private void InitializeVariables(){
	    view = new VBox();
		labels = new HBox();
		dash = new Button("DASHBOARD");
		account = new Button("MY ACCOUNT");
		tracker = new Button("TRACKER");
		shopping = new Button("SHOPPING");
		recipes = new Button("RECIPES");
		logout = new Button("LOG OUT");
		mainContent = new StackPane();
		recipeView = new RecipeView(this.user);
		accountView = new AccountView(this.user);  /*TODO NEEDS ADJUSTED */
		trackerView = new TrackerView();
		dashboardView = new DashboardView(this.user);
		other = new Pane();
		label = new Label("IM IN FRONT");
		title = new Label("KEY2KETO");
	}

	private void StylizeElements(){
		title.setFont(new Font(75));
		view.setPrefSize(1000, 750);
		VBox.setMargin(labels, new Insets(0, 10, 0, 10));
		VBox.setMargin(this.mainContent, new Insets(5, 10, 5, 10));
		VBox.setMargin(title, new Insets(5, 10, 5, 10));
		view.setBackground(new Background(new BackgroundFill(Color.LIGHTSLATEGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		labels.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		labels.setPrefSize(1000, 75);
		labels.setSpacing(12);
		labels.setAlignment(Pos.CENTER);
		dash.setPrefSize(129, 45);
		dash.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		dash.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		account.setPrefSize(129, 45);
		account.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		account.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		tracker.setPrefSize(129, 45);
		tracker.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		tracker.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		shopping.setPrefSize(129, 45);
		shopping.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		shopping.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		recipes.setPrefSize(129, 45);
		recipes.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		recipes.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		logout.setPrefSize(129, 45);
		logout.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		logout.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		view.setAlignment(Pos.CENTER);
	}
	
	private void AddAllElementsToChildren(){
		labels.getChildren().addAll(dash,account,tracker,shopping,recipes,logout);
		view.getChildren().addAll(title,labels, mainContent);
		other.getChildren().add(label);
		this.mainContent.getChildren().addAll(recipeView,accountView, dashboardView, trackerView);
		this.mainContent.setVisible(false);
	}

	public void stackOrder(int num){
		switch(num) {
			case 0: //Switch to Recipe tab
				this.mainContent.setVisible(true);
				this.recipeView.setViewOrder(-1);
				this.dashboardView.setViewOrder(0);
				this.accountView.setViewOrder(0);
				this.trackerView.setViewOrder(0);
			
				this.dashboardView.setVisible(false);
				this.accountView.setVisible(false);
				this.recipeView.setVisible(true);
				this.trackerView.setVisible(false);
				break;
			case 1: //Switch to Dashboard tab
				this.mainContent.setVisible(true);
				this.recipeView.setViewOrder(0);
				this.dashboardView.setViewOrder(-1);
				this.accountView.setViewOrder(0);
				this.trackerView.setViewOrder(0);
			
				this.dashboardView.setVisible(true);
				this.accountView.setVisible(false);
				this.recipeView.setVisible(false);
				this.trackerView.setVisible(false);
				break;
			case 2: //Switch to Account tab
				this.mainContent.setVisible(true);
				this.recipeView.setViewOrder(0);
				this.dashboardView.setViewOrder(0);
				this.accountView.setViewOrder(-1);
				this.trackerView.setViewOrder(0);
			
				this.dashboardView.setVisible(false);
				this.accountView.setVisible(true);
				this.recipeView.setVisible(false);
				this.trackerView.setVisible(false);
				break;
			case 3: //Switch to tracker tab
				this.mainContent.setVisible(true);
				this.recipeView.setViewOrder(0);
				this.dashboardView.setViewOrder(0);
				this.accountView.setViewOrder(0);
				this.trackerView.setViewOrder(-1);
			
				this.dashboardView.setVisible(false);
				this.accountView.setVisible(false);
				this.recipeView.setVisible(false);
				this.trackerView.setVisible(true);
			case 4:
				/*TODO add panes as they are developed*/
			default:
				System.out.println("You should not get here");
		}
		
		//this.mainContent.setVisible(true);
		//this.recipeView.setViewOrder(-1);
		//this.other.setViewOrder(0);
		//this.other.setVisible(false);
		//this.recipeView.setVisible(true);
		
	}
	
	public void stackOrder2(){
		this.mainContent.setVisible(true);
		this.recipeView.setViewOrder(0);
		this.other.setViewOrder(-1);
		this.recipeView.setVisible(false);
		this.other.setVisible(true);
		
	}
	
	public VBox getView() {
		return this.view;
	}
}

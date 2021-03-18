package application.Key2Keto;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
import javafx.stage.Stage;
import application.Key2Keto.Dashboard.*;
import application.Key2Keto.Recipes.RecipeView;

public class MainView extends Pane{

	Stage stage;
	SceneSwitcher switcher;
	
    VBox view;
	HBox labels;
	private Button dash;
	Button account;
	Button shopping;
	private Button recipes;
	Button logout;
	private StackPane mainContent;
	private RecipeView recipeView;
	private Pane other;
	private Label label;
	Label title;
	
	
	public MainView(Stage stage) {
		this.stage = stage;
		this.switcher = new SceneSwitcher(stage);
		
		InitializeVariables();
		StylizeElements();
		AddAllElementsToChildren();
		
	
		this.recipes.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	stackOrder();
		    }
		});
		
		this.dash.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	stackOrder2();
		    }
		});
}
	
	private void InitializeVariables(){
	    view = new VBox();
		labels = new HBox();
		dash = new Button("DASHBOARD");
		account = new Button("MY ACCOUNT");
		shopping = new Button("SHOPPING");
		recipes = new Button("RECIPES");
		logout = new Button("LOG OUT");
		mainContent = new StackPane();
		recipeView = new RecipeView("./src/main/java/application/Key2Keto/Recipes/ModifiedKeto.txt");
		other = new Pane();
		label = new Label("IM IN FRONT");
		title = new Label("KEY2KETO");
	}

	private void StylizeElements(){
		title.setFont(new Font(75));
		view.setPrefSize(1000, 750);
		view.setMargin(labels, new Insets(0, 15, 0, 15));
		view.setMargin(this.mainContent, new Insets(5, 15, 5, 15));
		view.setMargin(title, new Insets(5, 15, 5, 15));
		view.setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, CornerRadii.EMPTY, Insets.EMPTY)));
		labels.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		labels.setPrefSize(1000, 75);
	}
	
	private void AddAllElementsToChildren(){
		labels.getChildren().addAll(dash,account,shopping,recipes,logout);
		view.getChildren().addAll(title,labels, mainContent);
		other.getChildren().add(label);
		this.mainContent.getChildren().addAll(recipeView, other);
		this.mainContent.setVisible(false);
	}

	public void stackOrder(){
		this.mainContent.setVisible(true);
		this.recipeView.setViewOrder(-1);
		this.other.setViewOrder(0);
		this.other.setVisible(false);
		this.recipeView.setVisible(true);
		
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

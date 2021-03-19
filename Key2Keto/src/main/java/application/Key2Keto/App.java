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
import application.Key2Keto.Account.*;
import application.Key2Keto.Recipes.*;
import application.Key2Keto.Recipes.RecipeView;

public class App extends Application {
	    VBox view = new VBox();
    	HBox labels = new HBox();
    	private Button dash = new Button("DASHBOARD");
    	Button account = new Button("MY CCOUNT");
    	Button shopping = new Button("SHOPPING");
    	private Button recipes = new Button("RECIPES");
    	Button logout = new Button("LOG OUT");
    	private StackPane mainContent = new StackPane();
    	private RecipeView recipeView = new RecipeView("./src/main/java/application/Key2Keto/Recipes/ModifiedKeto.txt");
    	private Pane other = new Pane();
    	private Label label = new Label("IM IN FRONT");
    @Override
    public void start(Stage stage) {
    	SceneSwitcher switcher = new SceneSwitcher(stage);
    
    	stage.setScene(switcher.LoginScene());
    	Label title = new Label("KEY2KETO");
    	title.setFont(new Font(75));
    	
    	labels.getChildren().addAll(dash,account,shopping,recipes,logout);
    	view.setPrefSize(1000, 750);
    	view.setMargin(labels, new Insets(0, 15, 0, 15));
    	view.setMargin(this.mainContent, new Insets(5, 15, 5, 15));
    	view.setMargin(title, new Insets(5, 15, 5, 15));
    	view.setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, CornerRadii.EMPTY, Insets.EMPTY)));
    	labels.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
    	labels.setPrefSize(1000, 75);
    	view.getChildren().addAll(title,labels, mainContent);
    	other.getChildren().add(label);
    	this.mainContent.getChildren().addAll(recipeView, other);
    	this.mainContent.setVisible(false);

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
    	
    	Scene scene = new Scene(view, 1000, 750);
        stage.setScene(scene);
        stage.show();
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

    public static void main(String[] args) {
        launch();
    }

}
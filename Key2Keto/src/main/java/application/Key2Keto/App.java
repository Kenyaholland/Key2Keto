package application.Key2Keto;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import application.Key2Keto.Dashboard.*;
import application.Key2Keto.Recipes.RecipeView;

public class App extends Application {
	
    @Override
    public void start(Stage stage) {
    	StackPane mainContent = new StackPane();
    	RecipeView recipeView = new RecipeView("./src/main/java/application/Key2Keto/Recipes/ModifiedKeto.txt");
    	
    	mainContent.getChildren().add(recipeView);
        Scene scene = new Scene(mainContent, 750, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
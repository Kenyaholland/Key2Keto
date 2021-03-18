package application.Key2Keto;

import application.Key2Keto.Account.AccountCreationView;
import application.Key2Keto.Account.LoginView;
import application.Key2Keto.Recipes.RecipeView;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SceneSwitcher extends Pane{
	
	Stage stage;
	
	public SceneSwitcher(Stage stage) {
		this.stage = stage;
	}
	
	public Scene LoginScene() {
		StackPane loginPane = new StackPane();
    	LoginView loginView = new LoginView(this.stage);
    	
    	loginPane.getChildren().add(loginView);
        Scene loginScene = new Scene(loginPane, 750, 600);

        return loginScene;
	}
	
	public Scene AccountCreationScene() {
		StackPane creationPane = new StackPane();
    	AccountCreationView creationView = new AccountCreationView(this.stage);
    	
    	creationPane.getChildren().add(creationView);
        Scene creationScene = new Scene(creationPane, 750, 600);
        
        return creationScene;
	}
	
	public Scene RecipeViewScene() {
		StackPane recipeViewPane = new StackPane();
		RecipeView recipeView = new RecipeView("./src/main/java/application/Key2Keto/Recipes/ModifiedKeto.txt");
    	
    	recipeViewPane.getChildren().add(recipeView);
        Scene creationScene = new Scene(recipeViewPane, 750, 600);
        
        return creationScene;
	}
}

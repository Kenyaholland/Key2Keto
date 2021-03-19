package application.Key2Keto;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
	
    @Override
    public void start(Stage stage) {
    	SceneSwitcher switcher = new SceneSwitcher(stage);
    
    	stage.setScene(switcher.LoginScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
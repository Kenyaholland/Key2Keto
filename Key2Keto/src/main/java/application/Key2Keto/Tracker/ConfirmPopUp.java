package application.Key2Keto.Tracker;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmPopUp {
	
	
	public void display() {
		Stage popUp = new Stage();
		popUp.initModality(Modality.APPLICATION_MODAL);
		popUp.setTitle("Confirmation");
		
		Label confirmationLabel = new Label("The information you entered was saved!");
		Button closeButton = new Button("Close");
		closeButton.setOnAction(e -> popUp.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(confirmationLabel, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, 300, 100);
		popUp.setScene(scene);
		popUp.showAndWait();
		
	}
}

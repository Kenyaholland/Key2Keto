package application.Key2Keto.Account;

import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class LoginView extends Pane
{
	//two text boxes and labels for username and password
	Label usernameLabel = new Label("Username:");
	Label passwordLabel = new Label("Password:");
	
	TextField usernameTextField = new TextField();
	TextField passwordTextField = new TextField();
	
	//one button for signing in, one button for creating account
	Button signInButton = new Button("Sign in");
	Button createAccountButton = new Button("Create Account");
	
	//need a label for creating account button
	Label noAccountLabel = new Label("Don't have an account? Create one here:");
	
	//now some HBoxes
	HBox usernameRow = new HBox();
	HBox passwordRow = new HBox();
	HBox createAccountRow = new HBox();
	
	//and a VBox to contain them all
	VBox loginRows = new VBox();
	
	public LoginView()
	{
		usernameRow.getChildren().addAll(usernameLabel, usernameTextField);
		passwordRow.getChildren().addAll(passwordLabel, passwordTextField);
		
		createAccountRow.getChildren().addAll(noAccountLabel, createAccountButton);
		
		loginRows.getChildren().addAll(usernameRow, passwordRow, signInButton, createAccountRow);
		
		this.getChildren().add(loginRows);
	}
}

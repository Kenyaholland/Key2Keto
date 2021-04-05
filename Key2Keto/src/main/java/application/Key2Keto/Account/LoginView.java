package application.Key2Keto.Account;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import application.Key2Keto.SceneSwitcher;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class LoginView extends Pane
{
	//For switching scenes
	Stage stage;
	SceneSwitcher switcher;

	//Section for the app title/logo
	Label titleOrLogo;
	
	//two text boxes and labels for username and password
	Label usernameLabel;
	Label passwordLabel;
	
	TextField usernameTextField;
	TextField passwordTextField;
	
	//one button for signing in, one button for creating account
	Button signInButton;
	Button createAccountButton;
	
	//need a label for creating account button
	Label noAccountLabel;
	
	//now some HBoxes
	HBox titleOrLogoRow;
	HBox usernameRow;
	HBox passwordRow;
	HBox signInButtonRow;
	HBox createAccountRow;
	
	//and a VBox to contain them all
	VBox loginRows;
	
	public LoginView(Stage stage)
	{
		this.stage = stage;
		this.switcher = new SceneSwitcher(stage);

		instantiateVariables();
		stylizeElements();
		
		addAllElementsToChildren();
	}
	
	private void instantiateVariables()
	{
		titleOrLogo = new Label("Key2Keto");
		
		usernameLabel = new Label("Username:");
		passwordLabel = new Label("Password:");
		
		usernameTextField = new TextField();
		passwordTextField = new TextField();
		
		signInButton = new Button("Sign in");
		signInButton.setOnAction(e -> 
		{
			if(checkFormProperlyFilled())
			{
				stage.setScene(switcher.MainViewScene());
			}
			
		});
		
		createAccountButton = new Button("Create Account");
		createAccountButton.setOnAction(e -> stage.setScene(switcher.AccountCreationScene()));

		noAccountLabel = new Label("Don't have an account? Create one here:");
		
		usernameRow = new HBox();
		titleOrLogoRow = new HBox();
		passwordRow = new HBox();
		signInButtonRow = new HBox();
		createAccountRow = new HBox();
		
		loginRows = new VBox();
	}
	
	private void stylizeElements()
	{
		titleOrLogoRow.setAlignment(Pos.CENTER);
		titleOrLogoRow.setMinWidth(500);
		titleOrLogoRow.setMargin(titleOrLogo, new Insets(40, 0, 40, 0));
		
		usernameRow.setMargin(usernameLabel, new Insets(10, 20, 10, 20));
		usernameRow.setMargin(usernameTextField, new Insets(10, 20, 10, 20));
		passwordRow.setMargin(passwordLabel, new Insets(10, 20, 10, 20));
		passwordRow.setMargin(passwordTextField, new Insets(10, 20, 10, 20));
		
		signInButtonRow.setAlignment(Pos.CENTER);
		signInButtonRow.setMargin(signInButton, new Insets(10, 0, 10, 0));
		
		createAccountRow.setAlignment(Pos.CENTER);
		createAccountRow.setMargin(createAccountButton, new Insets(30, 20, 30, 20));
	}
	
	private void addAllElementsToChildren() //helper function for readability
	{
		titleOrLogoRow.getChildren().add(titleOrLogo);
		usernameRow.getChildren().addAll(usernameLabel, usernameTextField);
		passwordRow.getChildren().addAll(passwordLabel, passwordTextField);
		signInButtonRow.getChildren().add(signInButton);
		
		createAccountRow.getChildren().addAll(noAccountLabel, createAccountButton);
		
		loginRows.getChildren().addAll(titleOrLogoRow, usernameRow, passwordRow, signInButtonRow, createAccountRow);
		
		this.getChildren().add(loginRows);
	}
	
	private boolean checkFormProperlyFilled()
	{
		if(usernameTextField.getText().equals(""))
		{
			return false;
		}
		
		else if(passwordTextField.getText().equals(""))
		{
			return false;
		}
		
		else
		{
			return true;
		}
	}
	
	public Button getSignInButton()
	{
		return signInButton;
	}
	
	public Button getCreateAccountButton()
	{
		return createAccountButton;
	}
	
	//these are for junit
	protected TextField getUsernameTextField()
	{
		return usernameTextField;
	}
	
	protected TextField getPasswordTextField()
	{
		return passwordTextField;
	}
}

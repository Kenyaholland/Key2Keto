package application.Key2Keto.Account;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
	PasswordField passwordTextField;
	
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
	
	//for showing errors upon invalid input
	HBox errorRow;
	String errorMessage;
	Label errorLabel;
	
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
		passwordTextField = new PasswordField();
		
		signInButton = new Button("Sign in");
		signInButton.setOnAction(e -> 
		{
			if(checkFormProperlyFilled())
			{
			//	stage.setScene(switcher.MainViewScene());
			}
			
			else
			{
				errorLabel.setText(errorMessage);
				errorLabel.setVisible(true);
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
		
		errorLabel = new Label();
		errorRow = new HBox();
		
		loginRows = new VBox();
	}
	
	private void stylizeElements()
	{
		stage.setTitle("Key2Keto - Sign In");
		
		titleOrLogoRow.setAlignment(Pos.CENTER);
		titleOrLogoRow.setMinWidth(500);
		titleOrLogoRow.setMargin(titleOrLogo, new Insets(40, 0, 40, 0));
		titleOrLogo.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 18));
		
		usernameRow.setMargin(usernameLabel, new Insets(10, 20, 10, 20));
		usernameRow.setMargin(usernameTextField, new Insets(10, 20, 10, 20));
		usernameLabel.setMinWidth(113);
		usernameLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		usernameTextField.setFont(Font.font("Verdana", 12));
		
		passwordRow.setMargin(passwordLabel, new Insets(10, 20, 10, 20));
		passwordRow.setMargin(passwordTextField, new Insets(10, 20, 10, 20));
		passwordLabel.setMinWidth(113);
		passwordLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		passwordTextField.setFont(Font.font("Verdana", 12));
		
		signInButtonRow.setAlignment(Pos.CENTER);
		signInButtonRow.setMargin(signInButton, new Insets(10, 0, 10, 0));
		signInButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		
		errorLabel.setTextFill(Color.RED);
		errorLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		errorLabel.setVisible(false);
		errorRow.setAlignment(Pos.CENTER);
		
		createAccountRow.setAlignment(Pos.CENTER);
		createAccountRow.setMargin(createAccountButton, new Insets(30, 20, 30, 20));
		noAccountLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		createAccountButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
	}
	
	private void addAllElementsToChildren() //helper function for readability
	{
		titleOrLogoRow.getChildren().add(titleOrLogo);
		usernameRow.getChildren().addAll(usernameLabel, usernameTextField);
		passwordRow.getChildren().addAll(passwordLabel, passwordTextField);
		signInButtonRow.getChildren().add(signInButton);
		
		createAccountRow.getChildren().addAll(noAccountLabel, createAccountButton);
		
		errorRow.getChildren().add(errorLabel);
		
		loginRows.getChildren().addAll(titleOrLogoRow, usernameRow, passwordRow, errorRow, signInButtonRow, createAccountRow);
		
		this.getChildren().add(loginRows);
	}
	
	private boolean checkFormProperlyFilled()
	{
		if(usernameTextField.getText().equals(""))
		{
			errorMessage = "Username field must not be empty";
			return false;
		}
		
		else if(passwordTextField.getText().equals(""))
		{
			errorMessage = "Password field must not be empty";
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

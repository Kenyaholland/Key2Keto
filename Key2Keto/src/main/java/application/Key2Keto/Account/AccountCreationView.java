package application.Key2Keto.Account;

import javafx.scene.layout.Pane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.Arrays;

import application.Key2Keto.SceneSwitcher;
import javafx.collections.FXCollections;

public class AccountCreationView extends Pane
{
	//For switching scenes
	Stage stage;
	SceneSwitcher switcher;
  
	Account newlyCreatedAccount;
	
	Label createAccountLabel;
	
	//a label sectioning off the "Create New Account" text from the text fields
	Label accountDetailsDivider;
	
	Label newUsernameLabel;
	TextField newUsernameTextField;
	
	Label newPasswordLabel;
	PasswordField newPasswordTextField;
	
	//typically on many account creation forms
	Label confirmPasswordLabel;
	PasswordField confirmPasswordTextField;
	
	//now for personal details
	Label personalDetailsDivider;

	Label firstNameLabel;
	TextField firstNameTextField;
	
	Label lastNameLabel;
	TextField lastNameTextField;
	
	//haha
	Label sexLabel;
	ComboBox sexChooser;
	
	Label heightLabel;
	TextField heightTextField;
	
	Label weightLabel;
	TextField weightTextField;
	
	Label ageLabel;
	TextField ageTextField;
	
	Label dietTypeLabel;
	ComboBox dietTypeChooser;
	
	Button cancelAccountCreationButton;
	Button createAccountButton;
	
	HBox titleRow;
	HBox accountDetailsDividerRow;
	HBox newUsernameRow;
	HBox newPasswordRow;
	HBox confirmPasswordRow;
	HBox personalDetailsDividerRow;

	HBox firstNameRow;
	HBox lastNameRow;

	HBox sexRow;
	HBox heightRow;
	HBox weightRow;
	HBox ageRow;
	HBox dietTypeRow;
	HBox createAccountButtonRow;
	
	HBox errorRow;
	String errorMessage;
	Label errorLabel;
	
	VBox accountCreationRows;
	
	public AccountCreationView(Stage stage)
	{
		this.stage = stage;
		this.switcher = new SceneSwitcher(stage);

		instantiateVariables();
		stylizeElements();
		
		addAllElementsToChildren();
	}
	
	private void instantiateVariables()
	{
		createAccountLabel = new Label("Create New Account");
		
		accountDetailsDivider = new Label("Account Details");
		
		newUsernameLabel = new Label("Username:");
		newUsernameTextField = new TextField();
		
		newPasswordLabel = new Label("Password:");
		newPasswordTextField = new PasswordField();
		
		confirmPasswordLabel = new Label("Confirm Password:");
		confirmPasswordTextField = new PasswordField();
		
		personalDetailsDivider = new Label("Personal Details");
		
		firstNameLabel = new Label("First Name:");
		firstNameTextField = new TextField();
		
		lastNameLabel = new Label("Last Name:");
		lastNameTextField = new TextField();
		
		sexLabel = new Label("Sex:");
		String sexes[] = {"Male", "Female"};
		sexChooser = new ComboBox(FXCollections.observableArrayList(sexes));
		
		heightLabel = new Label("Height:");
		heightTextField = new TextField();
		
		weightLabel = new Label("Weight:");
		weightTextField = new TextField();
		
		ageLabel = new Label("Age:");
		ageTextField = new TextField();
		
		dietTypeLabel = new Label("Diet Type:");
		String diets[] = {"Classic Keto", "Light Keto", "Modified Keto"};
		dietTypeChooser = new ComboBox(FXCollections.observableArrayList(diets));
		
		cancelAccountCreationButton = new Button("Cancel");
		createAccountButton = new Button("Create Account");
		
		cancelAccountCreationButton.setOnAction(e ->
		{
			stage.setScene(switcher.LoginScene());
		});
		
		createAccountButton.setOnAction(e -> 
		{
			if(checkFormProperlyFilled())
			{
				newlyCreatedAccount = new Account(newUsernameTextField.getText(), newPasswordTextField.getText(), firstNameTextField.getText(),
												  lastNameTextField.getText(), sexChooser.getValue().toString(), heightTextField.getText(),
												  Integer.parseInt(weightTextField.getText()), Integer.parseInt(ageTextField.getText()), 
												  dietTypeChooser.getValue().toString());
				
				stage.setScene(switcher.MainViewScene(newlyCreatedAccount));
				System.out.println("Recipe Type: "+ newlyCreatedAccount.getDietType());
			}
			
			else
			{
				errorLabel.setText(errorMessage);
				errorLabel.setVisible(true);
			}
		});
		
		titleRow = new HBox();
		accountDetailsDividerRow = new HBox();
		newUsernameRow = new HBox();
		newPasswordRow = new HBox();
		confirmPasswordRow = new HBox();
		personalDetailsDividerRow = new HBox();
    
		firstNameRow = new HBox();
		lastNameRow = new HBox();
		sexRow = new HBox();
		heightRow = new HBox();
		weightRow = new HBox();
		ageRow = new HBox();
		dietTypeRow = new HBox();
		createAccountButtonRow = new HBox();
		
		accountCreationRows = new VBox();
		
		errorLabel = new Label();
		errorRow = new HBox();
	}
	
	private void stylizeElements()
	{
		stage.setTitle("Key2Keto - Create New Account");
		
		titleRow.setAlignment(Pos.CENTER);
		titleRow.setMinWidth(500);
		titleRow.setMargin(createAccountLabel, new Insets(40, 0, 40, 0));
		createAccountLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 18));
		
		accountDetailsDividerRow.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
													   				   BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE, 
													   				   CornerRadii.EMPTY, new BorderWidths(2), Insets.EMPTY)));
		accountDetailsDividerRow.setAlignment(Pos.CENTER);
		accountDetailsDividerRow.setMargin(accountDetailsDivider, new Insets(10, 0, 10, 0));
		accountDetailsDivider.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		
		newUsernameRow.setMargin(newUsernameLabel, new Insets(20, 10, 10, 10));
		newUsernameRow.setMargin(newUsernameTextField, new Insets(20, 10, 10, 10));
		newUsernameLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		newUsernameLabel.setMinWidth(144);
		newUsernameTextField.setFont(Font.font("Verdana", 12));
		
		newPasswordRow.setMargin(newPasswordLabel, new Insets(10, 10, 10, 10));
		newPasswordRow.setMargin(newPasswordTextField, new Insets(10, 10, 10, 10));
		newPasswordLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		newPasswordLabel.setMinWidth(144);
		newPasswordTextField.setFont(Font.font("Verdana", 12));
		
		confirmPasswordRow.setMargin(confirmPasswordLabel, new Insets(10, 10, 20, 10));
		confirmPasswordRow.setMargin(confirmPasswordTextField, new Insets(10, 10, 10, 10));
		confirmPasswordLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		confirmPasswordLabel.setMinWidth(144);
		confirmPasswordTextField.setFont(Font.font("Verdana", 12));
		
		createAccountButtonRow.setAlignment(Pos.CENTER);
		createAccountButtonRow.setMargin(createAccountButton, new Insets(20, 5, 20, 5));
		createAccountButtonRow.setMargin(cancelAccountCreationButton, new Insets(20, 5, 20, 5));
		cancelAccountCreationButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		createAccountButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		
		personalDetailsDividerRow.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
				   														BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE, 
				   														CornerRadii.EMPTY, new BorderWidths(2), Insets.EMPTY)));
		personalDetailsDividerRow.setAlignment(Pos.CENTER);
		personalDetailsDividerRow.setMargin(personalDetailsDivider, new Insets(10, 0, 10, 0));
		personalDetailsDivider.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		
		firstNameRow.setMargin(firstNameLabel, new Insets(20, 10, 10, 10));
		firstNameRow.setMargin(firstNameTextField, new Insets(20, 10, 10,10));
		firstNameLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		firstNameLabel.setMinWidth(144);
		firstNameTextField.setFont(Font.font("Verdana", 12));
		
		lastNameRow.setMargin(lastNameLabel, new Insets(10, 10, 10, 10));
		lastNameRow.setMargin(lastNameTextField, new Insets(10, 10, 10, 10));
		lastNameLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		lastNameLabel.setMinWidth(144);
		lastNameTextField.setFont(Font.font("Verdana", 12));
		
		sexRow.setMargin(sexLabel, new Insets(10, 10, 10, 10));
		sexRow.setMargin(sexChooser, new Insets(10, 10, 10, 10));
		sexLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		sexLabel.setMinWidth(144);
		sexChooser.setMinWidth(157);
		
		heightRow.setMargin(heightLabel, new Insets(10, 10, 10, 10));
		heightRow.setMargin(heightTextField, new Insets(10, 10, 10, 10));
		heightLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		heightLabel.setMinWidth(144);
		heightTextField.setFont(Font.font("Verdana", 12));
		
		heightTextField.setPromptText("e.g. 5'11\"");
		
		weightRow.setMargin(weightLabel, new Insets(10, 10, 10, 10));
		weightRow.setMargin(weightTextField, new Insets(10, 10, 10, 10));
		weightLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		weightLabel.setMinWidth(144);
		weightTextField.setFont(Font.font("Verdana", 12));
		weightTextField.setPromptText("in pounds");
		
		ageRow.setMargin(ageLabel, new Insets(10, 10, 10, 10));
		ageRow.setMargin(ageTextField, new Insets(10, 10, 10, 10));
		ageLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		ageLabel.setMinWidth(144);
		ageTextField.setFont(Font.font("Verdana", 12));
		ageTextField.setPromptText("in years");
		
		dietTypeRow.setMargin(dietTypeLabel, new Insets(10, 10, 10, 10));
		dietTypeRow.setMargin(dietTypeChooser, new Insets(10, 10, 10, 10));
		dietTypeLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		dietTypeLabel.setMinWidth(144);
		dietTypeChooser.setMinWidth(157);
		
		errorLabel.setTextFill(Color.RED);
		errorLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		errorLabel.setVisible(false);
		errorRow.setAlignment(Pos.CENTER);
	}
	
	private void addAllElementsToChildren()
	{
		titleRow.getChildren().add(createAccountLabel);
		
		accountDetailsDividerRow.getChildren().add(accountDetailsDivider);
		
		newUsernameRow.getChildren().addAll(newUsernameLabel, newUsernameTextField);
		newPasswordRow.getChildren().addAll(newPasswordLabel, newPasswordTextField);
		
		confirmPasswordRow.getChildren().addAll(confirmPasswordLabel, confirmPasswordTextField);
		
		personalDetailsDividerRow.getChildren().add(personalDetailsDivider);
		
		firstNameRow.getChildren().addAll(firstNameLabel, firstNameTextField);
		lastNameRow.getChildren().addAll(lastNameLabel, lastNameTextField);
		
		sexRow.getChildren().addAll(sexLabel, sexChooser);
		heightRow.getChildren().addAll(heightLabel, heightTextField);
		weightRow.getChildren().addAll(weightLabel, weightTextField);
		ageRow.getChildren().addAll(ageLabel, ageTextField);
		dietTypeRow.getChildren().addAll(dietTypeLabel, dietTypeChooser);
		
		createAccountButtonRow.getChildren().addAll(cancelAccountCreationButton, createAccountButton);
		
		errorRow.getChildren().add(errorLabel);
		
		accountCreationRows.getChildren().addAll(titleRow, accountDetailsDividerRow, newUsernameRow, newPasswordRow, confirmPasswordRow, 
												 personalDetailsDividerRow, firstNameRow, lastNameRow, sexRow, heightRow, weightRow, ageRow, dietTypeRow, 
												 errorRow, createAccountButtonRow);
		
		this.getChildren().add(accountCreationRows);
	}
	
	private boolean checkFormProperlyFilled()
	{
		//testing if text fields are empty
		if(newUsernameTextField.getText().equals(""))
		{
			errorMessage = "Username field must not be empty";
			return false;
		}
		
		else if(newPasswordTextField.getText().equals(""))
		{
			errorMessage = "Password field must not be empty";
			return false;
		}
		
		else if(confirmPasswordTextField.getText().equals(""))
		{
			errorMessage = "Confirm password field must not be empty";
			return false;
		}
		
		//then confirm password
		else if(!confirmPasswordTextField.getText().equals(newPasswordTextField.getText())) //not equal to each other
		{
			errorMessage = "Confirm password does not match password";
			return false;
		}
		
		else if(firstNameTextField.getText().equals(""))
		{
			errorMessage = "First name field must not be empty";
			return false;
		}
		
		else if(lastNameTextField.getText().equals(""))
		{
			errorMessage = "Last name field must not be empty";
			return false;
		}
		
		//now personal details
		else if(sexChooser.getSelectionModel().isEmpty())
		{
			errorMessage = "A sex must be chosen";
			return false;
		}
		
		else if(heightTextField.getText().equals(""))
		{
			errorMessage = "Height field must not be empty";
			return false;
		}
		
		else if(!heightTextField.getText().matches("^([0-9]*'([0-9]\"|(1[0-1])\"))|([0-9]*')$"))
		{
			errorMessage = "Height must be expressed in the form ft'in\" or ft'";
			return false;
		}
		
		else if(weightTextField.getText().equals(""))
		{
			errorMessage = "Weight field must not be empty";
			return false;
		}
		
		else if(!weightTextField.getText().matches("^[0-9]*$"))
		{
			errorMessage = "Weight must contain only digits";
			return false;
		}
		
		else if(ageTextField.getText().equals(""))
		{
			errorMessage = "Age field must not be empty";
			return false;
		}
		
		else if(!ageTextField.getText().matches("^[0-9]*$"))
		{
			errorMessage = "Age must contain only digits";
			return false;
		}
		
		else if(dietTypeChooser.getSelectionModel().isEmpty())
		{
			errorMessage = "A diet type must be chosen";
			return false;
		}
		
		//if none of the above are true, form is filled correctly
		else
		{
			return true;
		}
	}
	
	//for setting on action in pane containing this pane
	public Button getCreateAccountButton()
	{
		return createAccountButton;
	}
	
	public Account getNewlyCreatedAccount()
	{
		return newlyCreatedAccount;
	}
	
	//these two are for junit
	protected ArrayList<TextField> getAccountDetailTextFields()
	{
		ArrayList<TextField> textFieldsToReturn = new ArrayList<TextField>
		(
			Arrays.asList(newUsernameTextField, newPasswordTextField, confirmPasswordTextField, firstNameTextField, lastNameTextField,
						  heightTextField, weightTextField, ageTextField)
		);
		
		return textFieldsToReturn;
	}
	
	protected ArrayList<ComboBox> getAccountDetailComboBoxes()
	{
		ArrayList<ComboBox> comboBoxesToReturn = new ArrayList<ComboBox>
		(
			Arrays.asList(sexChooser, dietTypeChooser)
		);
		
		return comboBoxesToReturn;
	}
}
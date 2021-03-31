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
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
		
		createAccountButton = new Button("Create Account");
		createAccountButton.setOnAction(e -> 
		{
			if(checkFormProperlyFilled())
			{
				newlyCreatedAccount = new Account(newUsernameTextField.getText(), newPasswordTextField.getText(), firstNameTextField.getText(),
												  lastNameTextField.getText(), sexChooser.getValue().toString(), heightTextField.getText(),
												  Integer.parseInt(weightTextField.getText()), Integer.parseInt(ageTextField.getText()), 
												  dietTypeChooser.getValue().toString());
				
				stage.setScene(switcher.MainViewScene());
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
	}
	
	private void stylizeElements()
	{
		titleRow.setAlignment(Pos.CENTER);
		titleRow.setMinWidth(500);
		titleRow.setMargin(createAccountLabel, new Insets(40, 0, 40, 0));
		
		accountDetailsDividerRow.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
													   				   BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE, 
													   				   CornerRadii.EMPTY, new BorderWidths(2), Insets.EMPTY)));
		accountDetailsDividerRow.setAlignment(Pos.CENTER);
		accountDetailsDividerRow.setMargin(accountDetailsDivider, new Insets(10, 0, 10, 0));
		
		newUsernameRow.setMargin(newUsernameLabel, new Insets(20, 10, 10, 10));
		newUsernameRow.setMargin(newUsernameTextField, new Insets(20, 10, 10, 10));
		
		newPasswordRow.setMargin(newPasswordLabel, new Insets(10, 10, 10, 10));
		newPasswordRow.setMargin(newPasswordTextField, new Insets(10, 10, 10, 10));
		
		confirmPasswordRow.setMargin(confirmPasswordLabel, new Insets(10, 10, 20, 10));
		confirmPasswordRow.setMargin(confirmPasswordTextField, new Insets(10, 10, 10, 10));
		
		createAccountButtonRow.setAlignment(Pos.CENTER);
		createAccountButtonRow.setMargin(createAccountButton, new Insets(20, 0, 20, 0));
		
		personalDetailsDividerRow.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
				   														BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE, 
				   														CornerRadii.EMPTY, new BorderWidths(2), Insets.EMPTY)));
		personalDetailsDividerRow.setAlignment(Pos.CENTER);
		personalDetailsDividerRow.setMargin(personalDetailsDivider, new Insets(10, 0, 10, 0));
		
		firstNameRow.setMargin(firstNameLabel, new Insets(20, 10, 10, 10));
		firstNameRow.setMargin(firstNameTextField, new Insets(20, 10, 10,10));
		
		lastNameRow.setMargin(lastNameLabel, new Insets(10, 10, 10, 10));
		lastNameRow.setMargin(lastNameTextField, new Insets(10, 10, 10, 10));
		
		sexRow.setMargin(sexLabel, new Insets(10, 10, 10, 10));
		sexRow.setMargin(sexChooser, new Insets(10, 10, 10, 10));
		
		heightRow.setMargin(heightLabel, new Insets(10, 10, 10, 10));
		heightRow.setMargin(heightTextField, new Insets(10, 10, 10, 10));
		
		heightTextField.setPromptText("e.g. 5'11\"");
		
		weightRow.setMargin(weightLabel, new Insets(10, 10, 10, 10));
		weightRow.setMargin(weightTextField, new Insets(10, 10, 10, 10));
		
		ageRow.setMargin(ageLabel, new Insets(10, 10, 10, 10));
		ageRow.setMargin(ageTextField, new Insets(10, 10, 10, 10));
		
		dietTypeRow.setMargin(dietTypeLabel, new Insets(10, 10, 10, 10));
		dietTypeRow.setMargin(dietTypeChooser, new Insets(10, 10, 10, 10));
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
		
		createAccountButtonRow.getChildren().add(createAccountButton);
		
		accountCreationRows.getChildren().addAll(titleRow, accountDetailsDividerRow, newUsernameRow, newPasswordRow, confirmPasswordRow, 
												 personalDetailsDividerRow, firstNameRow, lastNameRow, sexRow, heightRow, weightRow, ageRow, dietTypeRow, 
												 createAccountButtonRow);
		
		this.getChildren().add(accountCreationRows);
	}
	
	private boolean checkFormProperlyFilled()
	{
		//testing if text fields are empty
		if(newUsernameTextField.getText().equals(""))
		{
			return false;
		}
		
		else if(newPasswordTextField.getText().equals(""))
		{
			return false;
		}
		
		else if(confirmPasswordTextField.getText().equals(""))
		{
			return false;
		}
		
		//then confirm password
		else if(!confirmPasswordTextField.getText().equals(newPasswordTextField.getText())) //not equal to each other
		{
			return false;
		}
		
		else if(firstNameTextField.getText().equals(""))
		{
			return false;
		}
		
		else if(lastNameTextField.getText().equals(""))
		{
			return false;
		}
		
		//now personal details
		else if(sexChooser.getSelectionModel().isEmpty())
		{
			return false;
		}
		
		else if(heightTextField.getText().equals(""))
		{
			return false;
		}
		
		else if(!heightTextField.getText().matches("^([0-9]*'([0-9]\"|(1[0-1])\"))|([0-9]*')$"))
		{
			return false;
		}
		
		else if(weightTextField.getText().equals(""))
		{
			return false;
		}
		
		else if(!weightTextField.getText().matches("^[0-9]*$"))
		{
			return false;
		}
		
		else if(ageTextField.getText().equals(""))
		{
			return false;
		}
		
		else if(!ageTextField.getText().matches("^[0-9]*$"))
		{
			return false;
		}
		
		else if(dietTypeChooser.getSelectionModel().isEmpty())
		{
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
}
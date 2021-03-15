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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;

public class AccountCreationView extends Pane
{
	Label createAccountLabel;
	
	//a label sectioning off the "Create New Account" text from the text fields
	Label accountDetailsDivider;
	
	Label newUsernameLabel;
	TextField newUsernameTextField;
	
	Label newPasswordLabel;
	TextField newPasswordTextField;
	
	//typically on many account creation forms
	Label confirmPasswordLabel;
	TextField confirmPasswordTextField;
	
	//now for personal details
	Label personalDetailsDivider;
	
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
	HBox sexRow;
	HBox heightRow;
	HBox weightRow;
	HBox ageRow;
	HBox dietTypeRow;
	HBox createAccountButtonRow;
	
	VBox accountCreationRows;
	
	public AccountCreationView()
	{
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
		newPasswordTextField = new TextField();
		
		confirmPasswordLabel = new Label("Confirm Password:");
		confirmPasswordTextField = new TextField();
		
		personalDetailsDivider = new Label("Personal Details");
		
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
		
		titleRow = new HBox();
		accountDetailsDividerRow = new HBox();
		newUsernameRow = new HBox();
		newPasswordRow = new HBox();
		confirmPasswordRow = new HBox();
		personalDetailsDividerRow = new HBox();
		sexRow = new HBox();
		heightRow = new HBox();
		weightRow = new HBox();
		ageRow = new HBox();
		dietTypeRow = new HBox();
		createAccountButtonRow = new HBox();
		
		accountCreationRows = new VBox();
	}
	
	public void stylizeElements()
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
		
		sexRow.setMargin(sexLabel, new Insets(10, 10, 10, 10));
		sexRow.setMargin(sexChooser, new Insets(10, 10, 10, 10));
		
		heightRow.setMargin(heightLabel, new Insets(10, 10, 10, 10));
		heightRow.setMargin(heightTextField, new Insets(10, 10, 10, 10));
		
		weightRow.setMargin(weightLabel, new Insets(10, 10, 10, 10));
		weightRow.setMargin(weightTextField, new Insets(10, 10, 10, 10));
		
		ageRow.setMargin(ageLabel, new Insets(10, 10, 10, 10));
		ageRow.setMargin(ageTextField, new Insets(10, 10, 10, 10));
		
		dietTypeRow.setMargin(dietTypeLabel, new Insets(10, 10, 10, 10));
		dietTypeRow.setMargin(dietTypeChooser, new Insets(10, 10, 10, 10));
	}
	
	public void addAllElementsToChildren()
	{
		titleRow.getChildren().add(createAccountLabel);
		
		accountDetailsDividerRow.getChildren().add(accountDetailsDivider);
		
		newUsernameRow.getChildren().addAll(newUsernameLabel, newUsernameTextField);
		newPasswordRow.getChildren().addAll(newPasswordLabel, newPasswordTextField);
		
		confirmPasswordRow.getChildren().addAll(confirmPasswordLabel, confirmPasswordTextField);
		
		personalDetailsDividerRow.getChildren().add(personalDetailsDivider);
		
		sexRow.getChildren().addAll(sexLabel, sexChooser);
		heightRow.getChildren().addAll(heightLabel, heightTextField);
		weightRow.getChildren().addAll(weightLabel, weightTextField);
		ageRow.getChildren().addAll(ageLabel, ageTextField);
		dietTypeRow.getChildren().addAll(dietTypeLabel, dietTypeChooser);
		
		createAccountButtonRow.getChildren().add(createAccountButton);
		
		accountCreationRows.getChildren().addAll(titleRow, accountDetailsDividerRow, newUsernameRow, newPasswordRow, confirmPasswordRow, 
												 personalDetailsDividerRow, sexRow, heightRow, weightRow, ageRow, dietTypeRow, createAccountButtonRow);
		
		this.getChildren().add(accountCreationRows);
	}
}

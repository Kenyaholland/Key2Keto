package application.Key2Keto.Account;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class AccountView extends Pane
{
	Account currentAccount;
	
	Label myAccountLabel;
	HBox viewTitleRow;
	
	Label usernameDisplayLabel;
	Label currentUsernameLabel;
	Button changeUsernameButton;
	HBox usernameRow;
	
	Label passwordDisplayLabel;
	Label currentPasswordLabel;
	Button changePasswordButton;
	HBox passwordRow;
	
	Label nameDisplayLabel;
	Label currentNameLabel;
	Button changeNameButton;
	HBox nameRow;
	
	Label sexDisplayLabel;
	Label currentSexLabel;
	Button changeSexButton;
	HBox sexRow;
	
	Label heightDisplayLabel;
	Label currentHeightLabel;
	Button changeHeightButton;
	HBox heightRow;
	
	Label weightDisplayLabel;
	Label currentWeightLabel;
	Button changeWeightButton;
	HBox weightRow;
	
	Label ageDisplayLabel;
	Label currentAgeLabel;
	Button changeAgeButton;
	HBox ageRow;
	
	Label dietTypeDisplayLabel;
	Label currentDietTypeLabel;
	Button changeDietTypeButton;
	HBox dietTypeRow;
	
	VBox myAccountRows;
	
	public AccountView(Account currentAccount)
	{
		this.currentAccount = currentAccount;
		
		instantiateVariables();
		stylizeElements();
		
		addAllElementsToChildren();
	}
	
	private void instantiateVariables()
	{
		myAccountLabel = new Label("My Account");
		viewTitleRow = new HBox();
		
		usernameDisplayLabel = new Label("Username:");
		currentUsernameLabel = new Label(currentAccount.getUsername());
		changeUsernameButton = new Button("Edit");
		usernameRow = new HBox();
		
		passwordDisplayLabel = new Label("Password:");
		currentPasswordLabel = new Label(currentAccount.getPassword());
		changePasswordButton = new Button("Edit");
		passwordRow = new HBox();
		
		nameDisplayLabel = new Label("Name:");
		currentNameLabel = new Label(currentAccount.getFirstName() + " " + currentAccount.getLastName());
		changeNameButton = new Button("Edit");
		nameRow = new HBox();
		
		sexDisplayLabel = new Label("Sex:");
		currentSexLabel = new Label(currentAccount.getSex());
		changeSexButton = new Button("Edit");
		sexRow = new HBox();
		
		heightDisplayLabel = new Label("Height:");
		currentHeightLabel = new Label(currentAccount.getHeight());
		changeHeightButton = new Button("Edit");
		heightRow = new HBox();
		
		weightDisplayLabel = new Label("Weight:");
		currentWeightLabel = new Label(String.valueOf(currentAccount.getWeight()));
		changeWeightButton = new Button("Edit");
		weightRow = new HBox();
		
		ageDisplayLabel = new Label("Age:");
		currentAgeLabel = new Label(String.valueOf(currentAccount.getAge()));
		changeAgeButton = new Button("Edit");
		ageRow = new HBox();
		
		dietTypeDisplayLabel = new Label("Diet Type:");
		currentDietTypeLabel = new Label(currentAccount.getDietType() + " Keto");
		changeDietTypeButton = new Button("Edit");
		dietTypeRow = new HBox();
		
		myAccountRows = new VBox();
	}
	
	private void stylizeElements()
	{
		
	}
	
	private void addAllElementsToChildren()
	{
		viewTitleRow.getChildren().add(myAccountLabel);
		
		usernameRow.getChildren().addAll(usernameDisplayLabel, currentUsernameLabel, changeUsernameButton);
		passwordRow.getChildren().addAll(passwordDisplayLabel, currentPasswordLabel, changePasswordButton);
		
		nameRow.getChildren().addAll(nameDisplayLabel, currentNameLabel, changeNameButton);
		
		sexRow.getChildren().addAll(sexDisplayLabel, currentSexLabel, changeSexButton);
		heightRow.getChildren().addAll(heightDisplayLabel, currentHeightLabel, changeHeightButton);
		weightRow.getChildren().addAll(weightDisplayLabel, currentWeightLabel, changeWeightButton);
		ageRow.getChildren().addAll(ageDisplayLabel, currentAgeLabel, changeAgeButton);
		dietTypeRow.getChildren().addAll(dietTypeDisplayLabel, currentDietTypeLabel, changeDietTypeButton);
		
		myAccountRows.getChildren().addAll(viewTitleRow, usernameRow, passwordRow, nameRow, sexRow, heightRow, weightRow, ageRow, dietTypeRow);
		
		this.getChildren().add(myAccountRows);
	}
}

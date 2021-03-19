package application.Key2Keto.Account;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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
		currentWeightLabel = new Label(String.valueOf(currentAccount.getWeight()) + " lbs");
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
		myAccountLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 18));
		
		viewTitleRow.setAlignment(Pos.CENTER);
		viewTitleRow.setMinWidth(500);
		viewTitleRow.setMargin(myAccountLabel, new Insets(40, 0, 40, 0));
		
		viewTitleRow.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
				   										   BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE, 
				   										   CornerRadii.EMPTY, new BorderWidths(2), Insets.EMPTY)));
		
		usernameRow.setMargin(usernameDisplayLabel, new Insets(20, 10, 10, 10));
		usernameDisplayLabel.setMinWidth(75);
		usernameDisplayLabel.setFont(Font.font("Verdana", 12));
		usernameRow.setMargin(currentUsernameLabel, new Insets(20, 10, 10, 10));
		currentUsernameLabel.setMinWidth(102);
		currentUsernameLabel.setFont(Font.font("Verdana", 12));
		usernameRow.setMargin(changeUsernameButton, new Insets(20, 10, 10, 10));
		changeUsernameButton.setFont(Font.font("Verdana", 12));
		
		passwordRow.setMargin(passwordDisplayLabel, new Insets(20, 10, 10, 10));
		passwordDisplayLabel.setMinWidth(75);
		passwordDisplayLabel.setFont(Font.font("Verdana", 12));
		passwordRow.setMargin(currentPasswordLabel, new Insets(20, 10, 10, 10));
		currentPasswordLabel.setMinWidth(102);
		currentPasswordLabel.setFont(Font.font("Verdana", 12));
		passwordRow.setMargin(changePasswordButton, new Insets(20, 10, 10, 10));
		changePasswordButton.setFont(Font.font("Verdana", 12));
		
		nameRow.setMargin(nameDisplayLabel, new Insets(20, 10, 10, 10));
		nameDisplayLabel.setMinWidth(75);
		nameDisplayLabel.setFont(Font.font("Verdana", 12));
		nameRow.setMargin(currentNameLabel, new Insets(20, 10, 10, 10));
		currentNameLabel.setMinWidth(102);
		currentNameLabel.setFont(Font.font("Verdana", 12));
		nameRow.setMargin(changeNameButton, new Insets(20, 10, 10, 10));
		changeNameButton.setFont(Font.font("Verdana", 12));
		
		sexRow.setMargin(sexDisplayLabel, new Insets(20, 10, 10, 10));
		sexDisplayLabel.setMinWidth(75);
		sexDisplayLabel.setFont(Font.font("Verdana", 12));
		sexRow.setMargin(currentSexLabel, new Insets(20, 10, 10, 10));
		currentSexLabel.setMinWidth(102);
		currentSexLabel.setFont(Font.font("Verdana", 12));
		sexRow.setMargin(changeSexButton, new Insets(20, 10, 10, 10));
		changeSexButton.setFont(Font.font("Verdana", 12));
		
		heightRow.setMargin(heightDisplayLabel, new Insets(20, 10, 10, 10));
		heightDisplayLabel.setMinWidth(75);
		heightDisplayLabel.setFont(Font.font("Verdana", 12));
		heightRow.setMargin(currentHeightLabel, new Insets(20, 10, 10, 10));
		currentHeightLabel.setMinWidth(102);
		currentHeightLabel.setFont(Font.font("Verdana", 12));
		heightRow.setMargin(changeHeightButton, new Insets(20, 10, 10, 10));
		changeHeightButton.setFont(Font.font("Verdana", 12));
		
		weightRow.setMargin(weightDisplayLabel, new Insets(20, 10, 10, 10));
		weightDisplayLabel.setMinWidth(75);
		weightDisplayLabel.setFont(Font.font("Verdana", 12));
		weightRow.setMargin(currentWeightLabel, new Insets(20, 10, 10, 10));
		currentWeightLabel.setMinWidth(102);
		currentWeightLabel.setFont(Font.font("Verdana", 12));
		weightRow.setMargin(changeWeightButton, new Insets(20, 10, 10, 10));
		changeWeightButton.setFont(Font.font("Verdana", 12));
		
		ageRow.setMargin(ageDisplayLabel, new Insets(20, 10, 10, 10));
		ageDisplayLabel.setMinWidth(75);
		ageDisplayLabel.setFont(Font.font("Verdana", 12));
		ageRow.setMargin(currentAgeLabel, new Insets(20, 10, 10, 10));
		currentAgeLabel.setMinWidth(102);
		currentAgeLabel.setFont(Font.font("Verdana", 12));
		ageRow.setMargin(changeAgeButton, new Insets(20, 10, 10, 10));
		changeAgeButton.setFont(Font.font("Verdana", 12));
		
		dietTypeRow.setMargin(dietTypeDisplayLabel, new Insets(20, 10, 20, 10));
		dietTypeDisplayLabel.setMinWidth(75);
		dietTypeDisplayLabel.setFont(Font.font("Verdana", 12));
		dietTypeRow.setMargin(currentDietTypeLabel, new Insets(20, 10, 20, 10));
		currentDietTypeLabel.setMinWidth(102);
		currentDietTypeLabel.setFont(Font.font("Verdana", 12));
		dietTypeRow.setMargin(changeDietTypeButton, new Insets(20, 10, 20, 10));
		changeDietTypeButton.setFont(Font.font("Verdana", 12));
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

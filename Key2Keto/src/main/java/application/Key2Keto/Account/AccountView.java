package application.Key2Keto.Account;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

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
	
	Stage variableChangerWindow;
	Pane changerPane;
	Scene changerScene;
	Label newVariableLabel;
	TextField newVariableTextField;
	ComboBox newVariableComboBox;
	Button confirmVariableChangeButton;
	HBox newVariableRow;
	HBox confirmButtonRow;
	VBox changerRows;
	
	public AccountView(Account currentAccount)
	{
		this.currentAccount = currentAccount;
		
		instantiateVariables();
		stylizeElements();
		
		addAllElementsToChildren();
		setOnActionForAllButtons();
	}
	
	private void instantiateVariables()
	{	
		myAccountLabel = new Label("ACCOUNT DETAILS");
		viewTitleRow = new HBox();
		
		usernameDisplayLabel = new Label("Username:");
		currentUsernameLabel = new Label(currentAccount.getUsername());
		changeUsernameButton = new Button("EDIT");
		usernameRow = new HBox();
		
		passwordDisplayLabel = new Label("Password:");
		currentPasswordLabel = new Label(currentAccount.getPassword());
		changePasswordButton = new Button("EDIT");
		passwordRow = new HBox();
		
		nameDisplayLabel = new Label("Name:");
		currentNameLabel = new Label(currentAccount.getFirstName() + " " + currentAccount.getLastName());
		changeNameButton = new Button("EDIT");
		nameRow = new HBox();
		
		sexDisplayLabel = new Label("Sex:");
		currentSexLabel = new Label(currentAccount.getSex());
		changeSexButton = new Button("EDIT");
		sexRow = new HBox();
		
		heightDisplayLabel = new Label("Height:");
		currentHeightLabel = new Label(currentAccount.getHeight());
		changeHeightButton = new Button("EDIT");
		heightRow = new HBox();
		
		weightDisplayLabel = new Label("Weight:");
		currentWeightLabel = new Label(String.valueOf(currentAccount.getWeight()) + " lbs");
		changeWeightButton = new Button("EDIT");
		weightRow = new HBox();
		
		ageDisplayLabel = new Label("Age:");
		currentAgeLabel = new Label(String.valueOf(currentAccount.getAge()));
		changeAgeButton = new Button("EDIT");
		ageRow = new HBox();
		
		dietTypeDisplayLabel = new Label("Diet Type:");
		currentDietTypeLabel = new Label(currentAccount.getDietType() + " Keto");
		changeDietTypeButton = new Button("EDIT");
		dietTypeRow = new HBox();
		
		myAccountRows = new VBox();
		
		variableChangerWindow = new Stage();
		changerPane = new Pane();
		changerScene = new Scene(changerPane);
		newVariableLabel = new Label(); //the text of this will be set by each individual edit button
		newVariableTextField = new TextField();
		newVariableComboBox = new ComboBox();
		confirmVariableChangeButton = new Button("Confirm");
		newVariableRow = new HBox();
		confirmButtonRow = new HBox();
		changerRows = new VBox();
	}
	
	private void stylizeElements()
	{	
		myAccountLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 18));
		
		viewTitleRow.setAlignment(Pos.CENTER);
		viewTitleRow.setMinWidth(980);
		viewTitleRow.setMargin(myAccountLabel, new Insets(40, 0, 40, 0));
		
		viewTitleRow.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
				   										   BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE, 
				   										   CornerRadii.EMPTY, new BorderWidths(2), Insets.EMPTY)));
		viewTitleRow.setBackground(new Background(new BackgroundFill(Color.LIGHTSLATEGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		
		usernameRow.setMargin(usernameDisplayLabel, new Insets(20, 10, 10, 10));
		usernameDisplayLabel.setMinWidth(100);
		usernameDisplayLabel.setFont(Font.font("Verdana", 14));
		usernameRow.setMargin(currentUsernameLabel, new Insets(20, 10, 10, 10));
		currentUsernameLabel.setMinWidth(127);
		currentUsernameLabel.setFont(Font.font("Verdana", 14));
		usernameRow.setMargin(changeUsernameButton, new Insets(20, 10, 10, 10));
		changeUsernameButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		usernameRow.setAlignment(Pos.CENTER);
		usernameRow.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		passwordRow.setMargin(passwordDisplayLabel, new Insets(20, 10, 10, 10));
		passwordDisplayLabel.setMinWidth(100);
		passwordDisplayLabel.setFont(Font.font("Verdana", 14));
		passwordRow.setMargin(currentPasswordLabel, new Insets(20, 10, 10, 10));
		currentPasswordLabel.setMinWidth(127);
		currentPasswordLabel.setFont(Font.font("Verdana", 14));
		passwordRow.setMargin(changePasswordButton, new Insets(20, 10, 10, 10));
		changePasswordButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		passwordRow.setAlignment(Pos.CENTER);
		passwordRow.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		nameRow.setMargin(nameDisplayLabel, new Insets(20, 10, 10, 10));
		nameDisplayLabel.setMinWidth(100);
		nameDisplayLabel.setFont(Font.font("Verdana", 14));
		nameRow.setMargin(currentNameLabel, new Insets(20, 10, 10, 10));
		currentNameLabel.setMinWidth(127);
		currentNameLabel.setFont(Font.font("Verdana", 14));
		nameRow.setMargin(changeNameButton, new Insets(20, 10, 10, 10));
		changeNameButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		nameRow.setAlignment(Pos.CENTER);
		nameRow.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		sexRow.setMargin(sexDisplayLabel, new Insets(20, 10, 10, 10));
		sexDisplayLabel.setMinWidth(100);
		sexDisplayLabel.setFont(Font.font("Verdana", 14));
		sexRow.setMargin(currentSexLabel, new Insets(20, 10, 10, 10));
		currentSexLabel.setMinWidth(127);
		currentSexLabel.setFont(Font.font("Verdana", 14));
		sexRow.setMargin(changeSexButton, new Insets(20, 10, 10, 10));
		changeSexButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		sexRow.setAlignment(Pos.CENTER);
		sexRow.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		heightRow.setMargin(heightDisplayLabel, new Insets(20, 10, 10, 10));
		heightDisplayLabel.setMinWidth(100);
		heightDisplayLabel.setFont(Font.font("Verdana", 14));
		heightRow.setMargin(currentHeightLabel, new Insets(20, 10, 10, 10));
		currentHeightLabel.setMinWidth(127);
		currentHeightLabel.setFont(Font.font("Verdana", 14));
		heightRow.setMargin(changeHeightButton, new Insets(20, 10, 10, 10));
		changeHeightButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		heightRow.setAlignment(Pos.CENTER);
		heightRow.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		weightRow.setMargin(weightDisplayLabel, new Insets(20, 10, 10, 10));
		weightDisplayLabel.setMinWidth(100);
		weightDisplayLabel.setFont(Font.font("Verdana", 14));
		weightRow.setMargin(currentWeightLabel, new Insets(20, 10, 10, 10));
		currentWeightLabel.setMinWidth(127);
		currentWeightLabel.setFont(Font.font("Verdana", 14));
		weightRow.setMargin(changeWeightButton, new Insets(20, 10, 10, 10));
		changeWeightButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		weightRow.setAlignment(Pos.CENTER);
		weightRow.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		ageRow.setMargin(ageDisplayLabel, new Insets(20, 10, 10, 10));
		ageDisplayLabel.setMinWidth(100);
		ageDisplayLabel.setFont(Font.font("Verdana", 14));
		ageRow.setMargin(currentAgeLabel, new Insets(20, 10, 10, 10));
		currentAgeLabel.setMinWidth(127);
		currentAgeLabel.setFont(Font.font("Verdana", 14));
		ageRow.setMargin(changeAgeButton, new Insets(20, 10, 10, 10));
		changeAgeButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		ageRow.setAlignment(Pos.CENTER);
		ageRow.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		dietTypeRow.setMargin(dietTypeDisplayLabel, new Insets(20, 10, 20, 10));
		dietTypeDisplayLabel.setMinWidth(100);
		dietTypeDisplayLabel.setFont(Font.font("Verdana", 14));
		dietTypeRow.setMargin(currentDietTypeLabel, new Insets(20, 10, 20, 10));
		currentDietTypeLabel.setMinWidth(127);
		currentDietTypeLabel.setFont(Font.font("Verdana", 14));
		dietTypeRow.setMargin(changeDietTypeButton, new Insets(20, 10, 20, 10));
		changeDietTypeButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		dietTypeRow.setAlignment(Pos.CENTER);
		dietTypeRow.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		myAccountRows.setMargin(myAccountRows, new Insets(0, 0, 0, 250));
		
		//now to stylize the popup window for changing variables
		newVariableLabel.setMinWidth(90);
		newVariableRow.setMargin(newVariableLabel, new Insets(20, 10, 10, 10));
		newVariableRow.setMargin(newVariableTextField, new Insets(20, 10, 10, 10));
		newVariableRow.setMargin(newVariableComboBox, new Insets(20, 10, 10, 10));
		newVariableRow.setAlignment(Pos.CENTER);
		
		newVariableTextField.setMinWidth(150);
		newVariableComboBox.setMinWidth(150);
		
		confirmButtonRow.setMargin(confirmVariableChangeButton, new Insets(10, 10, 20, 10));
		confirmButtonRow.setAlignment(Pos.CENTER);
		
		changerRows.setAlignment(Pos.CENTER);
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
		
		newVariableRow.getChildren().addAll(newVariableLabel, newVariableTextField);
		confirmButtonRow.getChildren().add(confirmVariableChangeButton);
		
		changerRows.getChildren().addAll(newVariableRow, confirmButtonRow);
		
		changerPane.getChildren().add(changerRows);
	}
	
	private void setOnActionForAllButtons()
	{
		changeUsernameButton.setOnAction(e -> 
		{
			variableChangerWindow.setTitle("Change Username");
			
			newVariableRow.getChildren().clear();
			changerRows.getChildren().clear();
			newVariableLabel.setText("New Username:");
			newVariableTextField.setText("");
			newVariableTextField.setPromptText("");
			
			newVariableRow.getChildren().addAll(newVariableLabel, newVariableTextField);
			changerRows.getChildren().addAll(newVariableRow, confirmButtonRow);
			
			variableChangerWindow.setScene(changerScene);
			
			variableChangerWindow.show();
			
			setConfirmButtonAction("Username");
		});
		
		changePasswordButton.setOnAction(e -> 
		{
			variableChangerWindow.setTitle("Change Password");
			
			newVariableRow.getChildren().clear();
			changerRows.getChildren().clear();
			newVariableLabel.setText("New Password:");
			newVariableTextField.setText("");
			newVariableTextField.setPromptText("");
			
			newVariableRow.getChildren().addAll(newVariableLabel, newVariableTextField);
			changerRows.getChildren().addAll(newVariableRow, confirmButtonRow);
			
			variableChangerWindow.setScene(changerScene);
			
			variableChangerWindow.show();
			
			setConfirmButtonAction("Password");
		});
		
		changeNameButton.setOnAction(e -> 
		{
			variableChangerWindow.setTitle("Change Name");
			
			newVariableRow.getChildren().clear();
			changerRows.getChildren().clear();
			newVariableLabel.setText("New Name:");
			newVariableTextField.setText("");
			newVariableTextField.setPromptText("e.g. John Smith");
			
			newVariableRow.getChildren().addAll(newVariableLabel, newVariableTextField);
			changerRows.getChildren().addAll(newVariableRow, confirmButtonRow);
			
			confirmVariableChangeButton.requestFocus();
			
			variableChangerWindow.setScene(changerScene);
			
			variableChangerWindow.show();
			
			setConfirmButtonAction("Name");
		});
		
		changeSexButton.setOnAction(e -> 
		{
			variableChangerWindow.setTitle("Change Sex");
			
			newVariableRow.getChildren().clear();
			changerRows.getChildren().clear();
			newVariableLabel.setText("New Sex:");
			
			String[] sexes = {"Male", "Female"};	
			newVariableComboBox.setItems(FXCollections.observableArrayList(sexes));
			
			newVariableRow.getChildren().addAll(newVariableLabel, newVariableComboBox);
			changerRows.getChildren().addAll(newVariableRow, confirmButtonRow);
			
			variableChangerWindow.setScene(changerScene);
			
			variableChangerWindow.show();
			
			setConfirmButtonAction("Sex");
		});
		
		changeHeightButton.setOnAction(e -> 
		{
			variableChangerWindow.setTitle("Change Height");
			
			newVariableRow.getChildren().clear();
			changerRows.getChildren().clear();
			newVariableLabel.setText("New Height:");
			newVariableTextField.setText("");
			newVariableTextField.setPromptText("e.g. 5'11\"");
			
			newVariableRow.getChildren().addAll(newVariableLabel, newVariableTextField);
			changerRows.getChildren().addAll(newVariableRow, confirmButtonRow);
			
			confirmVariableChangeButton.requestFocus();
			
			variableChangerWindow.setScene(changerScene);
			
			variableChangerWindow.show();
			
			setConfirmButtonAction("Height");
		});
		
		changeWeightButton.setOnAction(e -> 
		{
			variableChangerWindow.setTitle("Change Weight");
			
			newVariableRow.getChildren().clear();
			changerRows.getChildren().clear();
			newVariableLabel.setText("New Weight:");
			newVariableTextField.setText("");
			newVariableTextField.setPromptText("in pounds");
			
			newVariableRow.getChildren().addAll(newVariableLabel, newVariableTextField);
			changerRows.getChildren().addAll(newVariableRow, confirmButtonRow);
			
			confirmVariableChangeButton.requestFocus();
			
			variableChangerWindow.setScene(changerScene);
			
			variableChangerWindow.show();
			
			setConfirmButtonAction("Weight");
		});
		
		changeAgeButton.setOnAction(e -> 
		{
			variableChangerWindow.setTitle("Change Age");
			
			newVariableRow.getChildren().clear();
			changerRows.getChildren().clear();
			newVariableLabel.setText("New Age:");
			newVariableTextField.setText("");
			newVariableTextField.setPromptText("in years");
			
			newVariableRow.getChildren().addAll(newVariableLabel, newVariableTextField);
			changerRows.getChildren().addAll(newVariableRow, confirmButtonRow);
			
			confirmVariableChangeButton.requestFocus();
			
			variableChangerWindow.setScene(changerScene);
			
			variableChangerWindow.show();
			
			setConfirmButtonAction("Age");
		});
		
		changeDietTypeButton.setOnAction(e -> 
		{
			variableChangerWindow.setTitle("Change Diet Type");
			
			newVariableRow.getChildren().clear();
			changerRows.getChildren().clear();
			newVariableLabel.setText("New Diet Type:");
			
			String diets[] = {"Classic Keto", "Light Keto", "Modified Keto"};
			newVariableComboBox.setItems(FXCollections.observableArrayList(diets));
			
			newVariableRow.getChildren().addAll(newVariableLabel, newVariableComboBox);
			changerRows.getChildren().addAll(newVariableRow, confirmButtonRow);
			
			variableChangerWindow.setScene(changerScene);
			
			variableChangerWindow.show();
			
			setConfirmButtonAction("DietType");
		});
	}
	
	private void setConfirmButtonAction(String variableToBeChanged)
	{
		switch(variableToBeChanged)
		{
			case "Username":
				confirmVariableChangeButton.setOnAction(e ->
				{
					if(checkNewVariableIsValid(variableToBeChanged))
					{
						currentAccount.setUsername(newVariableTextField.getText());
						currentUsernameLabel.setText(newVariableTextField.getText());
					}
				});
				
				break;
			case "Password":
				confirmVariableChangeButton.setOnAction(e ->
				{
					if(checkNewVariableIsValid(variableToBeChanged))
					{
						currentAccount.setPassword(newVariableTextField.getText());
						currentPasswordLabel.setText(newVariableTextField.getText());
					}
				});
				
				break;
			case "Name":
				confirmVariableChangeButton.setOnAction(e ->
				{
					if(checkNewVariableIsValid(variableToBeChanged))
					{
						String[] nameSplit = newVariableTextField.getText().split("\\s+");
						
						currentAccount.setFirstName(nameSplit[0]);
						currentAccount.setLastName(nameSplit[1]);
						currentNameLabel.setText(nameSplit[0] + " " + nameSplit[1]);
					}
				});
				
				break;
			case "Sex":
				confirmVariableChangeButton.setOnAction(e ->
				{
					if(checkNewVariableIsValid(variableToBeChanged))
					{
						currentAccount.setSex(newVariableComboBox.getSelectionModel().getSelectedItem().toString());
						currentSexLabel.setText(newVariableComboBox.getSelectionModel().getSelectedItem().toString());
					}
				});
				
				break;
			case "Height":
				confirmVariableChangeButton.setOnAction(e ->
				{
					if(checkNewVariableIsValid(variableToBeChanged))
					{
						currentAccount.setHeight(newVariableTextField.getText());
						currentHeightLabel.setText(newVariableTextField.getText());
					}
				});
				
				break;
			case "Weight":
				confirmVariableChangeButton.setOnAction(e ->
				{
					if(checkNewVariableIsValid(variableToBeChanged))
					{
						currentAccount.setWeight(Integer.parseInt(newVariableTextField.getText()));
						currentWeightLabel.setText(newVariableTextField.getText() + " lbs");
					}
				});
				
				break;
			case "Age":
				confirmVariableChangeButton.setOnAction(e ->
				{
					if(checkNewVariableIsValid(variableToBeChanged))
					{
						currentAccount.setAge(Integer.parseInt(newVariableTextField.getText()));
						currentAgeLabel.setText(newVariableTextField.getText());
					}
				});
				
				break;
			case "DietType":
				confirmVariableChangeButton.setOnAction(e ->
				{
					if(checkNewVariableIsValid(variableToBeChanged))
					{
						currentAccount.setSex(newVariableComboBox.getSelectionModel().getSelectedItem().toString());
						currentDietTypeLabel.setText(newVariableComboBox.getSelectionModel().getSelectedItem().toString());
					}
				});
				
				break;
			default:
				break;
		}
	}
	
	private boolean checkNewVariableIsValid(String variableToBeChanged)
	{
		switch(variableToBeChanged)
		{
			case "Username":
				if(newVariableTextField.getText().equals(""))
				{
					return false;
				}
				
				else
				{
					return true;
				}
				
			case "Password":
				if(newVariableTextField.getText().equals(""))
				{
					return false;
				}
				
				else
				{
					return true;
				}

			case "Name":
				if(!newVariableTextField.getText().matches("^[A-Za-z]+\\s[A-Za-z]+$"))
				{
					return false;
				}
				
				else
				{
					return true;
				}

			case "Sex":
				if(newVariableComboBox.getSelectionModel().isEmpty())
				{
					return false;
				}
				
				else
				{
					return true;
				}

			case "Height":
				if(newVariableTextField.getText().equals(""))
				{
					return false;
				}
				
				else if(!newVariableTextField.getText().matches("^([0-9]*'([0-9]\"|(1[0-1])\"))|([0-9]*')$"))
				{
					return false;
				}
				
				else
				{
					return true;
				}
				
			case "Weight":
				if(newVariableTextField.getText().equals(""))
				{
					return false;
				}
				
				else if(!newVariableTextField.getText().matches("^[0-9]*$"))
				{
					return false;
				}
				
				else
				{
					return true;
				}

			case "Age":
				if(newVariableTextField.getText().equals(""))
				{
					return false;
				}
				
				else if(!newVariableTextField.getText().matches("^[0-9]*$"))
				{
					return false;
				}
				
				else
				{
					return true;
				}

			case "DietType":
				if(newVariableComboBox.getSelectionModel().isEmpty())
				{
					return false;
				}
				
				else
				{
					return true;
				}

			default:
				return false;
		}
	}
}

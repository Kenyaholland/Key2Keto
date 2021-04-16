package application.Key2Keto.Account;

import java.util.ArrayList;
import java.util.Arrays;

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
	Button cancelVariableChangeButton;
	Button confirmVariableChangeButton;
	HBox newVariableRow;
	HBox confirmButtonRow;
	VBox changerRows;
	
	HBox errorRow;
	String errorMessage;
	Label errorLabel;
	
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
		cancelVariableChangeButton = new Button("Cancel");
		confirmVariableChangeButton = new Button("Confirm");
		newVariableRow = new HBox();
		confirmButtonRow = new HBox();
		changerRows = new VBox();
		
		errorRow = new HBox();
		errorLabel = new Label();
	}
	
	private void stylizeElements()
	{	
		myAccountLabel.setId("AccountTitleLabel");
		
		viewTitleRow.setAlignment(Pos.CENTER);
		viewTitleRow.setMinWidth(980);
		viewTitleRow.setMargin(myAccountLabel, new Insets(40, 0, 40, 0));
		
		viewTitleRow.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
				   										   BorderStrokeStyle.NONE, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE, 
				   										   CornerRadii.EMPTY, new BorderWidths(2), Insets.EMPTY)));
		viewTitleRow.setId("AccountTitleBox");
		
		usernameRow.setMargin(usernameDisplayLabel, new Insets(20, 10, 10, 10));
		usernameDisplayLabel.setMinWidth(100);
		usernameRow.setMargin(currentUsernameLabel, new Insets(20, 10, 10, 10));
		currentUsernameLabel.setMinWidth(127);
		usernameRow.setMargin(changeUsernameButton, new Insets(20, 10, 10, 10));
		usernameRow.setAlignment(Pos.CENTER);
		usernameRow.setId("DarkRows");
		
		passwordRow.setMargin(passwordDisplayLabel, new Insets(20, 10, 10, 10));
		passwordDisplayLabel.setMinWidth(100);
		passwordRow.setMargin(currentPasswordLabel, new Insets(20, 10, 10, 10));
		currentPasswordLabel.setMinWidth(127);
		passwordRow.setMargin(changePasswordButton, new Insets(20, 10, 10, 10));
		passwordRow.setAlignment(Pos.CENTER);
		passwordRow.setId("LightRows");
		
		nameRow.setMargin(nameDisplayLabel, new Insets(20, 10, 10, 10));
		nameDisplayLabel.setMinWidth(100);
		nameRow.setMargin(currentNameLabel, new Insets(20, 10, 10, 10));
		currentNameLabel.setMinWidth(127);
		nameRow.setMargin(changeNameButton, new Insets(20, 10, 10, 10));
		nameRow.setAlignment(Pos.CENTER);
		nameRow.setId("DarkRows");
		
		sexRow.setMargin(sexDisplayLabel, new Insets(20, 10, 10, 10));
		sexDisplayLabel.setMinWidth(100);
		sexRow.setMargin(currentSexLabel, new Insets(20, 10, 10, 10));
		currentSexLabel.setMinWidth(127);
		sexRow.setMargin(changeSexButton, new Insets(20, 10, 10, 10));
		sexRow.setAlignment(Pos.CENTER);
		sexRow.setId("LightRows");
		
		heightRow.setMargin(heightDisplayLabel, new Insets(20, 10, 10, 10));
		heightDisplayLabel.setMinWidth(100);
		heightRow.setMargin(currentHeightLabel, new Insets(20, 10, 10, 10));
		currentHeightLabel.setMinWidth(127);
		heightRow.setMargin(changeHeightButton, new Insets(20, 10, 10, 10));
		heightRow.setAlignment(Pos.CENTER);
		heightRow.setId("DarkRows");
		
		weightRow.setMargin(weightDisplayLabel, new Insets(20, 10, 10, 10));
		weightDisplayLabel.setMinWidth(100);
		weightRow.setMargin(currentWeightLabel, new Insets(20, 10, 10, 10));
		currentWeightLabel.setMinWidth(127);
		weightRow.setMargin(changeWeightButton, new Insets(20, 10, 10, 10));
		weightRow.setAlignment(Pos.CENTER);
		weightRow.setId("LightRows");
		
		ageRow.setMargin(ageDisplayLabel, new Insets(20, 10, 10, 10));
		ageDisplayLabel.setMinWidth(100);
		ageRow.setMargin(currentAgeLabel, new Insets(20, 10, 10, 10));
		currentAgeLabel.setMinWidth(127);
		ageRow.setMargin(changeAgeButton, new Insets(20, 10, 10, 10));
		ageRow.setAlignment(Pos.CENTER);
		ageRow.setId("DarkRows");
		
		dietTypeRow.setMargin(dietTypeDisplayLabel, new Insets(20, 10, 20, 10));
		dietTypeDisplayLabel.setMinWidth(100);
		dietTypeRow.setMargin(currentDietTypeLabel, new Insets(20, 10, 20, 10));
		currentDietTypeLabel.setMinWidth(127);
		dietTypeRow.setMargin(changeDietTypeButton, new Insets(20, 10, 20, 10));
		dietTypeRow.setAlignment(Pos.CENTER);
		dietTypeRow.setId("LightRows");
		
		myAccountRows.setMargin(myAccountRows, new Insets(0, 0, 0, 250));
		
		//now to stylize the popup window for changing variables
		newVariableLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		newVariableLabel.setMinWidth(125);
		newVariableTextField.setFont(Font.font("Verdana", 12));
		newVariableRow.setMargin(newVariableLabel, new Insets(20, 10, 10, 10));
		newVariableRow.setMargin(newVariableTextField, new Insets(20, 10, 10, 10));
		newVariableRow.setMargin(newVariableComboBox, new Insets(20, 10, 10, 10));
		newVariableRow.setAlignment(Pos.CENTER);
		
		errorLabel.setTextFill(Color.RED);
		errorRow.setMargin(errorLabel, new Insets(0, 10, 0, 10));
		errorLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		errorRow.setMinWidth(360);
		errorLabel.setVisible(false);
		errorRow.setAlignment(Pos.CENTER);
		
		newVariableTextField.setMinWidth(150);
		newVariableComboBox.setMinWidth(150);
		
		confirmButtonRow.setMargin(confirmVariableChangeButton, new Insets(10, 5, 20, 5));
		confirmButtonRow.setMargin(cancelVariableChangeButton, new Insets(10, 5, 20, 5));
		cancelVariableChangeButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		confirmVariableChangeButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
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
		confirmButtonRow.getChildren().addAll(cancelVariableChangeButton, confirmVariableChangeButton);
		
		errorRow.getChildren().add(errorLabel);
		
		changerRows.getChildren().addAll(newVariableRow, errorRow, confirmButtonRow);
		
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
			changerRows.getChildren().addAll(newVariableRow, errorRow, confirmButtonRow);
			
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
			changerRows.getChildren().addAll(newVariableRow, errorRow, confirmButtonRow);
			
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
			changerRows.getChildren().addAll(newVariableRow, errorRow, confirmButtonRow);
			
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
			changerRows.getChildren().addAll(newVariableRow, errorRow, confirmButtonRow);
			
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
			changerRows.getChildren().addAll(newVariableRow, errorRow, confirmButtonRow);
			
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
			changerRows.getChildren().addAll(newVariableRow, errorRow, confirmButtonRow);
			
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
			changerRows.getChildren().addAll(newVariableRow, errorRow, confirmButtonRow);
			
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
			changerRows.getChildren().addAll(newVariableRow, errorRow, confirmButtonRow);
			
			variableChangerWindow.setScene(changerScene);
			
			variableChangerWindow.show();
			
			setConfirmButtonAction("DietType");
		});
		
		cancelVariableChangeButton.setOnAction(e ->
		{
			errorLabel.setVisible(false);
			variableChangerWindow.close();
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
						errorLabel.setVisible(false);
						variableChangerWindow.close();
					}
					
					else
					{
						errorLabel.setText(errorMessage);
						errorLabel.setVisible(true);
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
						errorLabel.setVisible(false);
						variableChangerWindow.close();
					}
					
					else
					{
						errorLabel.setText(errorMessage);
						errorLabel.setVisible(true);
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
						errorLabel.setVisible(false);
						variableChangerWindow.close();
					}
					
					else
					{
						errorLabel.setText(errorMessage);
						errorLabel.setVisible(true);
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
						errorLabel.setVisible(false);
						variableChangerWindow.close();
					}
					
					else
					{
						errorLabel.setText(errorMessage);
						errorLabel.setVisible(true);
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
						errorLabel.setVisible(false);
						variableChangerWindow.close();
					}
					
					else
					{
						errorLabel.setText(errorMessage);
						errorLabel.setVisible(true);
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
						errorLabel.setVisible(false);
						variableChangerWindow.close();
					}
					
					else
					{
						errorLabel.setText(errorMessage);
						errorLabel.setVisible(true);
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
						errorLabel.setVisible(false);
						variableChangerWindow.close();
					}
					
					else
					{
						errorLabel.setText(errorMessage);
						errorLabel.setVisible(true);
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
						errorLabel.setVisible(false);
						variableChangerWindow.close();
					}
					
					else
					{
						errorLabel.setText(errorMessage);
						errorLabel.setVisible(true);
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
					errorMessage = "Username field must not be empty";
					return false;
				}
				
				else
				{
					return true;
				}
				
			case "Password":
				if(newVariableTextField.getText().equals(""))
				{
					errorMessage = "Password field must not be empty";
					return false;
				}
				
				else
				{
					return true;
				}

			case "Name":
				if(newVariableTextField.getText().equals(""))
				{
					errorMessage = "Name field must not be empty";
					return false;
				}
				
				else if(!newVariableTextField.getText().matches("^[A-Za-z]+\\s[A-Za-z]+$"))
				{
					errorMessage = "Name must be two words containing only letters";
					return false;
				}
				
				else
				{
					return true;
				}

			case "Sex":
				if(newVariableComboBox.getSelectionModel().isEmpty())
				{
					errorMessage = "A sex must be chosen";
					return false;
				}
				
				else
				{
					return true;
				}

			case "Height":
				if(newVariableTextField.getText().equals(""))
				{
					errorMessage = "Height field must not be empty";
					return false;
				}
				
				else if(!newVariableTextField.getText().matches("^([0-9]*'([0-9]\"|(1[0-1])\"))|([0-9]*')$"))
				{
					errorMessage = "Height must be expressed in the form ft'in\" or ft'";
					return false;
				}
				
				else
				{
					return true;
				}
				
			case "Weight":
				if(newVariableTextField.getText().equals(""))
				{
					errorMessage = "Weight field must not be empty";
					return false;
				}
				
				else if(!newVariableTextField.getText().matches("^[0-9]*$"))
				{
					errorMessage = "Weight must only contain digits";
					return false;
				}
				
				else
				{
					return true;
				}

			case "Age":
				if(newVariableTextField.getText().equals(""))
				{
					errorMessage = "Age field must not be empty";
					return false;
				}
				
				else if(!newVariableTextField.getText().matches("^[0-9]*$"))
				{
					errorMessage = "Age must only contain digits";
					return false;
				}
				
				else
				{
					return true;
				}

			case "DietType":
				if(newVariableComboBox.getSelectionModel().isEmpty())
				{
					errorMessage = "A diet type must be chosen";
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
	
	//methods after this point are only for unit tests
	protected ArrayList<Button> getButtonsForTests()
	{
		ArrayList<Button> buttonsToReturn = new ArrayList<Button>();
		
		buttonsToReturn.addAll(new ArrayList<Button>
		(
			Arrays.asList(changeUsernameButton, changePasswordButton, changeNameButton, changeSexButton,
							   changeHeightButton, changeWeightButton, changeAgeButton, changeDietTypeButton)
		));
		
		return buttonsToReturn;
	}
	
	protected TextField getNewVariableTextFieldForTests()
	{
		return newVariableTextField;
	}
	
	protected ComboBox getNewVariableComboBoxForTests()
	{
		return newVariableComboBox;
	}
	
	protected Button getConfirmVariableChangeButtonForTests()
	{
		return confirmVariableChangeButton;
	}
	
	protected ArrayList<Label> getCurrentVariableLabelsForTests()
	{
		ArrayList<Label> labelsToReturn = new ArrayList<Label>();
		
		labelsToReturn.addAll(new ArrayList<Label>
		(
			Arrays.asList(currentUsernameLabel, currentPasswordLabel, currentNameLabel, currentSexLabel,
						  currentHeightLabel, currentWeightLabel, currentAgeLabel, currentDietTypeLabel)
		));
		
		return labelsToReturn;
	}
}

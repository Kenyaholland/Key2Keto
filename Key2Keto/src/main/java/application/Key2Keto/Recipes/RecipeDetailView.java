package application.Key2Keto.Recipes;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class RecipeDetailView extends Pane {
	private Recipe recipe;
	private Label nameLabel;
	private Label carbLabel;
	private Label proteinLabel;
	private Label fatLabel;
	private Label ratioLabel;
	private Label ingredientsLabel;
	private Label totalCaloriesLabel;
	private Label instructionsLabel;
	private Label insTitle;
	private Label ingTitle;
	private VBox vbox;
	private HBox hbox;
	private VBox upper;
	private VBox lower;
	private Button imageButton;
	
	public RecipeDetailView(Recipe recipe) {
		this.recipe = recipe;
		initializeVariables();
		stylingOfVariables();
		populateChildren();
		this.getChildren().add(vbox);
	}
	
	public void initializeVariables(){
		this.vbox = new VBox();
		this.lower = new VBox();
		this.upper = new VBox();
		this.hbox = new HBox();
		this.imageButton = new Button("IMAGE");
		this.nameLabel = new Label(this.recipe.getName());
		this.carbLabel = new Label(String.valueOf("Total Carbohydrates: " +this.recipe.getTotalCarb()));
		this.proteinLabel = new Label("Total Protein: " + String.valueOf(this.recipe.getTotalProtein()));
		this.fatLabel = new Label("Total Fat: " + String.valueOf(this.recipe.getTotalFat()));
		this.ratioLabel = new Label(String.valueOf("Recipe Ratio: "+ this.recipe.getDietRatio()+"/1"));
		this.totalCaloriesLabel = new Label("Total Calories: "+String.valueOf(this.recipe.getTotalCalories()));
		this.ingTitle = new Label("Ingredients");
		this.ingredientsLabel = new Label(this.recipe.listedIngredients());
		this.ingredientsLabel.setWrapText(true);
		this.insTitle = new Label("Instructions");
		this.instructionsLabel = new Label(this.recipe.listedInstructions());
		this.instructionsLabel.setWrapText(true);
		this.instructionsLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
	}
	
	
	public void stylingOfVariables() {
		this.setPrefWidth(480);
		this.vbox.setPrefSize(480, 500);
		this.vbox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.hbox.setPrefSize(480, 125);
		this.hbox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		this.nameLabel.setPrefWidth(350);
		this.nameLabel.setWrapText(true);
		this.nameLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		this.nameLabel.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		this.carbLabel.setPrefWidth(400);
		this.carbLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
		
		this.totalCaloriesLabel.setPrefWidth(400);
		this.totalCaloriesLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
		
		this.proteinLabel.setPrefWidth(400);
		this.proteinLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
		
		this.ratioLabel.setPrefWidth(400);
		this.ratioLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
		
		this.fatLabel.setPrefWidth(400);
		this.fatLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
		
		this.ingTitle.setPrefWidth(400);
		this.ingTitle.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		this.insTitle.setPrefWidth(400);
		this.insTitle.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		
		this.imageButton.setPrefSize(130,130);
		this.imageButton.setAlignment(Pos.CENTER);
		this.imageButton.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		this.upper.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.upper.setPrefWidth(350);
		VBox.setMargin(nameLabel, new Insets(0, 0, 0, 0));
		VBox.setMargin(carbLabel, new Insets(0, 0, 0, 20));
		VBox.setMargin(proteinLabel, new Insets(0, 0, 0, 20));
		VBox.setMargin(fatLabel, new Insets(0, 0, 0, 20));
		VBox.setMargin(ratioLabel, new Insets(0, 0, 0, 20));
		VBox.setMargin(totalCaloriesLabel, new Insets(0, 0, 0, 20));
		VBox.setMargin(ingredientsLabel, new Insets(0, 0, 0, 20));
		VBox.setMargin(instructionsLabel, new Insets(0, 0, 0, 20));
	}
	
	public void populateChildren() {
		this.upper.getChildren().addAll(nameLabel,ratioLabel,totalCaloriesLabel,carbLabel,proteinLabel,fatLabel);
		this.hbox.getChildren().addAll(this.upper,this.imageButton);
		this.lower.getChildren().addAll(ingTitle,ingredientsLabel,insTitle,instructionsLabel);
		this.vbox.getChildren().addAll(this.hbox,lower);
	}
	
	protected ArrayList<Label> getDetailLabels(){
		ArrayList<Label> labelsToTest = new ArrayList<Label>();
		labelsToTest.addAll(new ArrayList<Label>(Arrays.asList(this.nameLabel, this.ratioLabel, this.totalCaloriesLabel,
				this.carbLabel, this.proteinLabel, this.fatLabel)));
		
		return labelsToTest;
	}
}

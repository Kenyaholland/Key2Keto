package application.Key2Keto.Recipes;

import javafx.geometry.Insets;
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
		this.ingredientsLabel = new Label("Ingredinets\n" +this.recipe.listedIngredients());
		this.ingredientsLabel.setWrapText(true);
		this.instructionsLabel = new Label("Instructions\n" +this.recipe.listedInstructions());
		this.instructionsLabel.setWrapText(true);
	}
	
	
	public void stylingOfVariables() {
		this.vbox.setPrefSize(490, 500);
		this.vbox.setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));
		this.hbox.setPrefSize(485, 250);
		this.hbox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		this.nameLabel.setPrefWidth(375);
		this.nameLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		this.nameLabel.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		this.carbLabel.setPrefWidth(250);
		this.totalCaloriesLabel.setPrefWidth(250);
		this.proteinLabel.setPrefWidth(250);
		this.ratioLabel.setPrefWidth(250);
		this.fatLabel.setPrefWidth(250);
		//this.imageButton.setPrefSize(100, 100);
		this.imageButton.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.upper.setMargin(nameLabel, new Insets(0, 5, 0, 5));
		this.upper.setMargin(carbLabel, new Insets(0, 5, 0, 5));
		this.upper.setMargin(proteinLabel, new Insets(0, 5, 0, 5));
		this.upper.setMargin(fatLabel, new Insets(0, 5, 0, 5));
		this.upper.setMargin(ratioLabel, new Insets(0, 5, 0, 5));
		this.upper.setMargin(totalCaloriesLabel, new Insets(0, 5, 0, 5));
		this.lower.setMargin(ingredientsLabel, new Insets(0, 5, 0, 5));
		this.lower.setMargin(instructionsLabel, new Insets(0, 5, 0, 5));
	}
	
	public void populateChildren() {
		this.upper.getChildren().addAll(nameLabel,ratioLabel,totalCaloriesLabel,carbLabel,proteinLabel,fatLabel);
		this.hbox.getChildren().addAll(this.upper,this.imageButton);
		this.lower.getChildren().addAll(ingredientsLabel,instructionsLabel);
		this.vbox.getChildren().addAll(upper,lower);
	}
}

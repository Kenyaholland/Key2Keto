package application.Key2Keto.Recipes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class RecipeView extends Pane {
	private RecipeFileReader recipeFileReader;
	private VBox view = new VBox();
	private HBox categoryTabs = new HBox();
	private Button sundayButton = new Button("SUNDAY");
	private Button mondayButton = new Button("MONDAY");
	private Button tuesdayButton = new Button("TUESDAY");
	private Button wednesdayButton = new Button("WEDNESDAY");
	private Button thursdayButton = new Button("THURSDAY");
	private Button fridayButton = new Button("FRIDAY");
	private Button saturdayButton = new Button("SATURDAY");
	private StackPane daysOfWeek = new StackPane();
	private DayOfWeekView days[] = new DayOfWeekView[7];
	
	public RecipeView(String file){
		this.recipeFileReader = new RecipeFileReader(file);
		populateDaysOfWeek();
		populateChildren();
		setStyles();

		this.getChildren().add(view);
		sundayButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	setButtonCLickedColor(0);
		    	daysOfWeek.setVisible(true);
		    	setDayStack(0);
		        System.out.println("Sunday Selected");
		    }
		});
		mondayButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	setButtonCLickedColor(1);
		    	daysOfWeek.setVisible(true);
		    	setDayStack(1);
		        System.out.println("Monday Selected");
		    }
		});
		tuesdayButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	setButtonCLickedColor(2);
		    	daysOfWeek.setVisible(true);
		    	setDayStack(2);
		        System.out.println("Tuesday Selected");
		    }
		});
		wednesdayButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	setButtonCLickedColor(3);
		    	daysOfWeek.setVisible(true);
		    	setDayStack(3);
		        System.out.println("Wednesday Selected");
		    }
		});
		thursdayButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	setButtonCLickedColor(4);
		    	daysOfWeek.setVisible(true);
		    	setDayStack(4);
		        System.out.println("Thursday Selected");
		    }
		});
		fridayButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	setButtonCLickedColor(5);
		    	daysOfWeek.setVisible(true);
		    	setDayStack(5);
		        System.out.println("Friday Selected");
		    }
		});
		saturdayButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	setButtonCLickedColor(6);
		    	daysOfWeek.setVisible(true);
		    	setDayStack(6);
		        System.out.println("Saturday Selected");
		    }
		});
	}
	
	private void populateChildren() {
		categoryTabs.getChildren().addAll(sundayButton, mondayButton, tuesdayButton, wednesdayButton, thursdayButton, fridayButton, saturdayButton);
		daysOfWeek.getChildren().addAll(days[0],days[1],days[2],days[3],days[4],days[5],days[6]);
		view.getChildren().addAll(categoryTabs,daysOfWeek);
	}
	
	private void setStyles() {
		this.setWidth(980);
		this.setHeight(500);
		view.setPrefHeight(500);
		view.setPrefWidth(980);
		this.categoryTabs.setPrefSize(600, 50);
		this.categoryTabs.setSpacing(12);
		this.sundayButton.setPrefSize(129, 45);
		this.sundayButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		this.mondayButton.setPrefSize(129, 45);
		this.mondayButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		this.tuesdayButton.setPrefSize(129, 45);
		this.tuesdayButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		this.wednesdayButton.setPrefSize(129, 45);
		this.wednesdayButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		this.thursdayButton.setPrefSize(129, 45);
		this.thursdayButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		this.fridayButton.setPrefSize(129, 45);
		this.fridayButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		this.saturdayButton.setPrefSize(129, 45);
		this.saturdayButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 14));
		this.daysOfWeek.setPrefSize(600, 440);
		setButtonColor();
		daysOfWeek.setVisible(false);
	}
	
	private void setButtonCLickedColor(int num) {
		Button temp[] = new Button[7];
		temp[0] = this.sundayButton;
		temp[1] = this.mondayButton;
		temp[2] = this.tuesdayButton;
		temp[3] = this.wednesdayButton;
		temp[4] = this.thursdayButton;
		temp[5] = this.fridayButton;
		temp[6] = this.saturdayButton;
		
		for(int i = 0; i < 7; i++) {
			if(num == i) {
				temp[i].setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
			}else {
				temp[i].setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		}
	}
	
	private void setButtonColor() {
		Button temp[] = new Button[7];
		temp[0] = this.sundayButton;
		temp[1] = this.mondayButton;
		temp[2] = this.tuesdayButton;
		temp[3] = this.wednesdayButton;
		temp[4] = this.thursdayButton;
		temp[5] = this.fridayButton;
		temp[6] = this.saturdayButton;
		
		for(int i = 0; i < 7; i++) {
			temp[i].setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
	}
	
	private void populateDaysOfWeek() {
		days[0] = new DayOfWeekView(this.recipeFileReader.getRecipeList(),"Sunday");
		days[1] = new DayOfWeekView(this.recipeFileReader.getRecipeList(),"Monday");
		days[2] = new DayOfWeekView(this.recipeFileReader.getRecipeList(),"Tuesday");
		days[3] = new DayOfWeekView(this.recipeFileReader.getRecipeList(),"Wednesday");
		days[4] = new DayOfWeekView(this.recipeFileReader.getRecipeList(),"Thursday");
		days[5] = new DayOfWeekView(this.recipeFileReader.getRecipeList(),"Friday");
		days[6] = new DayOfWeekView(this.recipeFileReader.getRecipeList(),"Saturday");
	}
	
	protected void setDayStack(int num) {
		for(int i = 0; i < 7; i++) {
			if(num == i) {
				days[i].setViewOrder(-1);
			}else {
				days[i].setViewOrder(0);
			}
		}
	}
}

package application.Key2Keto.Tracker;

import application.Key2Keto.Recipes.DayOfWeekView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DayView extends Pane{
	
	Tracker tracker;
	ConfirmPopUp popUp;
	String dayOfWeek;
	
	Spinner<Double> sleepField;
	Button sleepButton;
	Label sleepLabel;
	
	Spinner<Double> waterField;
	Button waterButton;
	Label waterLabel;
	
	TextField goalsTextField;
	Label goalsLabel;
	Button addGoalsButton;
	
	VBox sleepContent;
	VBox waterContent;
	VBox goalsContent;
	VBox wholeView;
	
	String[] styleClasses;

	public DayView(String day){
		
		this.dayOfWeek = day;
		
		initializeVariables();
		StylizeComponents();
		
		this.sleepField.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
		this.waterField.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
		
		this.sleepContent.getChildren().addAll(this.sleepLabel, this.sleepField, this.sleepButton);
		this.waterContent.getChildren().addAll(this.waterLabel, this.waterField, this.waterButton);
		this.goalsContent.getChildren().addAll(this.goalsLabel, this.goalsTextField, this.addGoalsButton);
		this.wholeView.getChildren().addAll(this.sleepContent, this.waterContent, this.goalsContent);
		this.getChildren().add(wholeView);
	}
	
	private void initializeVariables() {
		this.tracker = new Tracker(this.dayOfWeek);
		this.popUp = new ConfirmPopUp();
		
		this.wholeView = new VBox();
		this.sleepContent = new VBox();
		this.waterContent = new VBox();
		this.goalsContent = new VBox();
		
		this.sleepLabel = new Label("How many hours of sleep did you have today?");
		this.sleepField = new Spinner<Double>(0, 24, 0, 0.5);
		this.sleepField.setEditable(true);
		this.sleepButton = new Button("Save");
		this.sleepButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	if(sleepField.getValue() != null) {
		    		tracker.setHoursOfSleep(Double.valueOf(sleepField.getValue()));
		    		popUp.display();
		    		System.out.println(tracker.getHoursOfSleep());
		    	}
		    }
		});
		
		this.waterLabel = new Label("How many ounces of water did you drink today?");
		this.waterField = new Spinner<Double>(0, 128, 0, 1.0);
		this.waterField.setEditable(true);
		this.waterButton = new Button("Save");
		this.waterButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	if(waterField.getValue() != null) {
		    		tracker.setWaterIntake(Double.valueOf(waterField.getValue()));	
		    		popUp.display();
		    		System.out.println(tracker.getWaterIntake());
		    	}
		    }
		});
		
		this.goalsTextField = new TextField();
		this.goalsLabel = new Label("Add your own personalized goals here:");
		this.addGoalsButton = new Button("Add");
		this.addGoalsButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	if(!goalsTextField.getText().isEmpty()) {
		    		tracker.addGoal(goalsTextField.getText());
		    		System.out.println(tracker.getGoals());
		    		goalsTextField.clear();
		    		popUp.display();
		    	}
		    }
		});
	}
	
	private void StylizeComponents() {
		
		this.sleepContent.setSpacing(10);
		this.waterContent.setSpacing(10);
		this.goalsContent.setSpacing(10);
		
		this.sleepContent.setPadding(new Insets(15,20, 10,10));
		this.waterContent.setPadding(new Insets(15,20, 10,10));
		this.goalsContent.setPadding(new Insets(15,20, 10,10));
		
		this.sleepLabel.setPrefSize(400, 30);
		this.sleepLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		this.waterLabel.setPrefSize(400, 30);
		this.waterLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		this.goalsLabel.setPrefSize(400, 30);
		this.goalsLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		
		this.sleepButton.setPrefSize(125, 30);
		this.sleepButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		
		this.waterButton.setPrefSize(125, 30);
		this.waterButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
		
		this.addGoalsButton.setPrefSize(125, 30);
		this.addGoalsButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 12));
	}
}
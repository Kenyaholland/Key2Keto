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
		
        sleepField.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
        waterField.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
		
		sleepContent.getChildren().addAll(sleepLabel, sleepField, sleepButton);
		waterContent.getChildren().addAll(waterLabel, waterField, waterButton);
		goalsContent.getChildren().addAll(goalsLabel, goalsTextField, addGoalsButton);
		wholeView.getChildren().addAll(sleepContent, waterContent, goalsContent);
		this.getChildren().add(wholeView);
	}
	
	private void initializeVariables() {
		tracker = new Tracker(this.dayOfWeek);
		popUp = new ConfirmPopUp();
		
		wholeView = new VBox();
		sleepContent = new VBox();
		waterContent = new VBox();
		goalsContent = new VBox();
		
		sleepLabel = new Label("How many hours of sleep did you have today?");
		sleepField = new Spinner<Double>(0, 24, 0, 0.5);
		sleepButton = new Button("Save");
		sleepButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	if(sleepField.getValue() != null) {
		    		tracker.setHoursOfSleep(Double.valueOf(sleepField.getValue()));
		    		popUp.display();
		    		System.out.println(tracker.getHoursOfSleep());
		    	}
		    }
		});
		
		waterLabel = new Label("How many ounces of water did you drink today?");
		waterField = new Spinner<Double>(0, 128, 0, 1.0);
		waterButton = new Button("Save");
		waterButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	if(waterField.getValue() != null) {
		    		tracker.setWaterIntake(Double.valueOf(waterField.getValue()));	
		    		popUp.display();
		    		System.out.println(tracker.getWaterIntake());
		    	}
		    }
		});
		
		goalsTextField = new TextField();
		goalsLabel = new Label("Add your own personalized goals here");
		addGoalsButton = new Button("Add");
		addGoalsButton.setOnAction(new EventHandler<ActionEvent>() {
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
}
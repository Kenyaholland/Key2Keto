package application.Key2Keto.Tracker;

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
	
	TextField sleepTextField;
	Button sleepButton;
	Label sleepLabel;
	
	TextField waterTextField;
	Button waterButton;
	Label waterLabel;
	
	VBox sleepContent;
	VBox waterContent;
	VBox wholeView;

	public DayView(String day){
		initializeVariables();
		
		NumberAxis xaxis = new NumberAxis(1,7,1);  
        NumberAxis yaxis = new NumberAxis(1,24,1);  
        xaxis.setLabel("Day of Week");  
        yaxis.setLabel("Hours of Sleep");  
            
        LineChart sleepChart = new LineChart(xaxis,yaxis);  
        sleepChart.setTitle("Sleep Overview");  
             
        XYChart.Series series = new XYChart.Series();   
        series.getData().add(new XYChart.Data(1,6));  
        series.getData().add(new XYChart.Data(2,10));  
        series.getData().add(new XYChart.Data(3,7));  
        series.getData().add(new XYChart.Data(4,8));  
        series.getData().add(new XYChart.Data(5,8));  
        series.getData().add(new XYChart.Data(6,8));  
        series.getData().add(new XYChart.Data(7,6));  
 
        sleepChart.getData().add(series);  
		
		sleepContent.getChildren().addAll(sleepLabel, sleepTextField, sleepButton);
		waterContent.getChildren().addAll(waterLabel, waterTextField, waterButton);
		wholeView.getChildren().addAll(sleepContent, waterContent, sleepChart);
		this.getChildren().add(wholeView);
	}
	
	private void initializeVariables() {
		wholeView = new VBox();
		sleepContent = new VBox();
		waterContent = new VBox();
		
		sleepLabel = new Label("How many hours of sleep did you have today?");
		sleepTextField = new TextField();
		sleepButton = new Button("Save");
		
		waterLabel = new Label("How many 8 oz glasses of water did you have today?");
		waterTextField = new TextField();
		waterButton = new Button("Save");
	}
}
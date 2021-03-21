package application.Key2Keto.Dashboard;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;
//import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DashboardView extends Pane
{
	private VBox view = new VBox();
	Label description = new Label("The Dashboard will be the home for the user's information such as: \n\t"
			+ " - Their basic information like Name and chosen diet type.\n\t"
			+ " - Total Water Consumption.\n\t"
			+ " - Calculations of the marcos for the day and week based off of the selected recipes.\n\t"
			+ " - The daily and weekly goals the user has set up");
	
	public DashboardView()
	{
		this.view.getChildren().add(description);
		this.getChildren().add(view);
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
		description.setWrapText(true);
		description.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		view.setPrefSize(980, 490);
		view.setAlignment(Pos.CENTER);
		description.setPrefSize(900, 200);
		
	}
}

package application.Key2Keto.Dashboard;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;

public class DashboardView extends Pane
{
	private Button testButton = new Button("button");
	
	public DashboardView()
	{
		this.getChildren().add(testButton);
		this.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
	}
}

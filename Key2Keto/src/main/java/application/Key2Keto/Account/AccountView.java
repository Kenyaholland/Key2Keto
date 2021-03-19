package application.Key2Keto.Account;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class AccountView extends Pane
{
	private Button testButton = new Button("button");
	
	public AccountView()
	{
		this.getChildren().add(testButton);
		this.setBackground(new Background(new BackgroundFill(Color.PINK, null, null)));
		this.setWidth(980);
		this.setHeight(500);
	}
}

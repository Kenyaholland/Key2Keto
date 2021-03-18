package application.Key2Keto;

import application.Key2Keto.Dashboard.DashboardView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * JavaFX App
 */
public class Main extends Application
{

    @Override
    public void start(Stage stage)
    {
        VBox tabsAndContent = new VBox();
        
        HBox tabsContainer = new HBox();
        StackPane contentLayers = new StackPane();
        
        Button tabs[] = new Button[5];
        for(int i = 0; i < tabs.length; i++)
        {
        	tabs[i] = new Button();
        }
        
        Pane contents[] = new Pane[5];
        for(int i = 0; i < contents.length; i++)
        {
        	contents[i] = new Pane();
        	contents[i].setPrefWidth(500);
        	contents[i].setPrefHeight(500);
        	
        	switch(i)
        	{
        		case 0:
        			contents[i].setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
        			break;
        		case 1:
        			contents[i].setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
        			break;
        		case 2:
        			contents[i].setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
        			break;
        	}
        }
        
        contents[0] = new DashboardView();
        //contents[0].getChildren().add(new Button("button"));
        
        tabs[0].setText("Dashboard");
        tabs[0].setOnAction(e ->
        {        	
        	for(int i = 0; i < contents.length; i++)
        	{
        		contents[i].setViewOrder(0.0);
        	}
        	
        	contents[0].setViewOrder(-1.0);
        });
        
        tabs[1].setText("Account");
        tabs[1].setOnAction(e ->
        {
        	for(int i = 0; i < contents.length; i++)
        	{
        		contents[i].setViewOrder(0.0);
        	}
        	
        	contents[1].setViewOrder(-1.0);
        });
        
        tabs[2].setText("Recipes");
        tabs[2].setOnAction(e ->
        {
        	for(int i = 0; i < contents.length; i++)
        	{
        		contents[i].setViewOrder(0.0);
        	}
        	
        	contents[2].setViewOrder(-1.0);
        });
        
        tabs[3].setText("Tab");
        tabs[4].setText("Tab");
        
        for(int i = 0; i < 5; i++) //Adding tabs to tabsContainer, and adding content panes to stack pane
        {
        	tabsContainer.getChildren().add(tabs[i]);
        	contentLayers.getChildren().add(contents[i]);
        }
        
        tabsAndContent.getChildren().addAll(tabsContainer, contentLayers);
        
        Scene keto = new Scene(tabsAndContent);
        stage.setScene(keto);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
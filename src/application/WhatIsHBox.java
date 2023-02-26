package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// Click each button to make it disappear!
public class WhatIsHBox extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// StackPane extends Pane
		// A HBox will put each of the children in horizontal rows
		HBox pane = new HBox();
		pane.getChildren().add(makeButton("One", pane));
		pane.getChildren().add(makeButton("Two", pane));
		pane.getChildren().add(makeButton("Three", pane));
		pane.getChildren().add(makeButton("Four", pane));
		
		// Add the layout to the scene
		Scene scene = new Scene(pane, 300, 250);
		
		// Add the scene to the primary stage
		primaryStage.setTitle("What's in VBox?");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private Button makeButton(String msg, Pane pane) {
		Button button = new Button();
		button.setText(msg);
		button.setOnAction(e -> buttonClick(pane, button));
		return button;
	}
	
	private void buttonClick(Pane pane, Button button) {	
		pane.getChildren().remove(button);
	}

}

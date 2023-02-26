package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ClickMe extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Create a button and give it an action
		Button button = new Button();
		button.setText("Click Me!");
		button.setOnAction(e -> buttonClick(button));
		
		// Put the button in some kind of layout pane
		// The layout determines where elements are positioned.
		Pane pane = new Pane();
		pane.getChildren().add(button);
		
		// Add the layout to the scene
		// The scene holds the user interface elements
		Scene scene = new Scene(pane, 300, 250);
		
		// Add the scene to the primary stage
		// A stage is the top-level container in JavaFX
		primaryStage.setTitle("Click Button App");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void buttonClick(Button button) {
		if (button.getText().equals("Click Me!")) {
			button.setText("Click me again!!");
		} else {
			button.setText("Click Me!"); // set it back
		}
	}

}

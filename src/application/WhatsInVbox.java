package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Click each button to make it disappear!
public class WhatsInVbox extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// StackPane extends Pane
		// A VBox will put each of the children in vertical columns
		VBox pane = new VBox();
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

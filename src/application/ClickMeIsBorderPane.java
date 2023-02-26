package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// Click each button to make it disappear!
public class ClickMeIsBorderPane extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// BorderPane extends Pane
		// A BorderPane can put items in top, bottom, left, right, center on the pane.
		// From there, you align each item.
		BorderPane pane = new BorderPane();
		
		Button b1 = makeButton("One", pane);
		pane.setTop(b1);
		BorderPane.setAlignment(b1, Pos.CENTER);

		Button b2 = makeButton("Two", pane);
		pane.setLeft(b2);
		BorderPane.setAlignment(b2, Pos.CENTER);

		Button b3 = makeButton("Three", pane);
		pane.setRight(b3);
		BorderPane.setAlignment(b3, Pos.CENTER);
		
		Button b4 = makeButton("Four", pane);
		pane.setBottom(b4);
		BorderPane.setAlignment(b4, Pos.CENTER);
		
		// Add the layout to the scene
		Scene scene = new Scene(pane, 300, 250);
		
		// Add the scene to the primary stage
		primaryStage.setTitle("Click Me Is Border Pane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private Button makeButton(String msg, Pane pane) {
		Button button = new Button();
		button.setText(msg);
		button.setOnAction(e -> buttonClick(pane, button));
		return button;
	}
	
	private void buttonClick(Pane pane, Button thisButton) {
		pane.getChildren().remove(thisButton);
	}

}

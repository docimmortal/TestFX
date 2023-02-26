package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// Click each button to make it disappear!
public class ClickMeIsAPane extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// StackPane extends Pane
		// A StackPage will put each of the children on to of each other
		StackPane pane = new StackPane();
		pane.getChildren().add(makeButton("Four ", pane));
		pane.getChildren().add(makeButton("Three", pane));
		pane.getChildren().add(makeButton(" Two ", pane));
		pane.getChildren().add(makeButton(" One ", pane));
		
		// Add the layout to the scene
		Scene scene = new Scene(pane, 300, 250);
		
		// Add the scene to the primary stage
		primaryStage.setTitle("Click Me Is A Pane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private Button makeButton(String msg, Pane pane) {
		Button button = new Button();
		button.setText(msg);
		button.setOnAction(e -> buttonClick(pane));
		return button;
	}
	
	private void buttonClick(Pane pane) {	
		// We can get away with this approach since each button is on top each other
		int index = pane.getChildren().size()-1;
		pane.getChildren().remove(index);
	}

}

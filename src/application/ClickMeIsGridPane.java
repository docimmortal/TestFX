package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

// Click each button to make it disappear!
public class ClickMeIsGridPane extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// GridPane extends Pane
		// A GridPane has an (x,y) grid to place items
		// From there, you align each item.
		GridPane pane = new GridPane();
		
		/* Grid is (buttons indicated by x):
		 * 
		       0 1 2
		     0   x
		     1 x   x
		     2   x
		 */
		Button b1 = makeButton("One", pane);
		// GridPane.setConstraints(b1, 1, 0) same as:
		//    GridPane.setColumnIndex(b1, 1);
		//    GridPane.setRowIndex(b1, 0); 
		GridPane.setConstraints(b1, 1, 0);  // top center (element, x,y)
		GridPane.setHalignment(b1, HPos.CENTER);
		GridPane.setValignment(b1, VPos.CENTER);
		
		Button b2 = makeButton("Two", pane);
		GridPane.setConstraints(b2, 0, 1); // left center
		GridPane.setHalignment(b2, HPos.CENTER);
		GridPane.setValignment(b2, VPos.CENTER);

		Button b3 = makeButton("Three", pane);
		GridPane.setConstraints(b3, 2, 1); // right center
		GridPane.setHalignment(b3, HPos.CENTER);
		GridPane.setValignment(b3, VPos.CENTER);
		
		Button b4 = makeButton("Four", pane);
		GridPane.setConstraints(b4, 1, 2); // bottom center
		GridPane.setHalignment(b4, HPos.CENTER);
		GridPane.setValignment(b4, VPos.CENTER);
	
		// Add all of the buttons to the pane
		pane.getChildren().addAll(b1, b2, b3, b4);
		
		// We can change how big each column is (how many pixels)
		// The scene is 300x300, making each row/column grid 100x100
		pane.getColumnConstraints().add(new ColumnConstraints(100));
	    pane.getColumnConstraints().add(new ColumnConstraints(100));
	    pane.getColumnConstraints().add(new ColumnConstraints(100));
		pane.getRowConstraints().add(new RowConstraints(100));
		pane.getRowConstraints().add(new RowConstraints(100));
		pane.getRowConstraints().add(new RowConstraints(100));
		
		// Add the layout to the scene
		Scene scene = new Scene(pane, 300, 300);
		
		// Add the scene to the primary stage
		primaryStage.setTitle("Click Me Is Grid Pane");
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

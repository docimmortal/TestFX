package application.labels;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LabelExample extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {
        // Create a label
        Label label = new Label("This is a label");
 
        // Create a Stack pane, add label
        StackPane pane = new StackPane();
        pane.getChildren().add(label);
 
        Scene scene = new Scene(pane, 200, 200);
        stage.setScene(scene);
        stage.setTitle("Creating label");

        stage.show();

	}


}

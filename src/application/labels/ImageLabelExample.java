package application.labels;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ImageLabelExample extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) throws FileNotFoundException {
		FileInputStream input = new FileInputStream("images/check.png");
		 
        // create a image
        Image img = new Image(input);
 
        // create a image View
        ImageView imageView = new ImageView(img);
        Label label = new Label("", imageView);
        
        StackPane pane = new StackPane();
        pane.getChildren().add(label);
 
        Scene scene = new Scene(pane, 200, 200);
        stage.setScene(scene);
        stage.setTitle("Creating image label");

        stage.show();

	}

}

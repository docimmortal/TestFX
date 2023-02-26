package application.labels;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class LabelTextFieldExample extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		
		TextField fName = new TextField("First Name");
        Label fnLabel = new Label("_1 First Name");
        fnLabel.setLabelFor(fName);
 
        TextField lName = new TextField("Last Name");
        Label lnLabel = new Label("_2 Last Name");
        lnLabel.setLabelFor(lName);
 
        // create a Tile pane
        TilePane pane = new TilePane();
 
        // setMnemonicParsing - this creates a keyboard shortcut
        // Hitting Alt+1 goes to this field
        // That is because the label starts with _1
        fnLabel.setMnemonicParsing(true);
        
        // Hitting Alt+2 goes to this field
        // That is because the label starts with _1
        lnLabel.setMnemonicParsing(true); 
 
        // add everything
        pane.getChildren().add(fnLabel);
        pane.getChildren().add(fName);
        pane.getChildren().add(lnLabel);
        pane.getChildren().add(lName);
 
        Scene scene = new Scene(pane, 200, 200);
        stage.setScene(scene);
        stage.setTitle("Creating TextField with label");
        stage.show();
	}

}

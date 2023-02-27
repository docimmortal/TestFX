package application.events;

import java.io.FileNotFoundException;
import java.util.HashMap;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonEventDemo extends Application implements EventHandler<ActionEvent>{

	private HashMap<String, Button> buttonMap;
	private TextField text;
	
	public static void main(String[] args) throws FileNotFoundException {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		buttonMap = new HashMap<>();
		VBox grid = layoutSetup();
		Scene scene = new Scene(grid, 200, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private VBox layoutSetup() {
		VBox vBox = new VBox();
		GridPane pane = new GridPane();
		buttonMap.put("1",makeButton("1"));
		buttonMap.put("2",makeButton("2"));
		buttonMap.put("3",makeButton("3"));
		text = new TextField();
		
		vBox.getChildren().add(text);
		pane.add(buttonMap.get("1"), 0, 1);
		pane.add(buttonMap.get("2"), 1, 1);
		pane.add(buttonMap.get("3"), 2, 1);
		vBox.getChildren().add(pane);
		return vBox;
	}
	
	private Button makeButton(String buttonText) {
		Button button = new Button();
		button.setText(buttonText);
		button.setOnAction(this);
		return button;
	}

	@Override
	public void handle(ActionEvent event) {
		Button button = (Button)event.getSource();
		text.setText(text.getText()+button.getText());
	}

}

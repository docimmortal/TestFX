package application.textfield;

import java.util.HashMap;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExampleA extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Label lblCharacter = makeLabel("Character's Name:");
		Label lblActor = makeLabel("Actor's Name:");
		TextField txtCharacter = makeTextField("Enter the name of the character here.","Character");
		TextField txtActor = makeTextField("Enter the name of the actor here.","Actor");

		Button okButton = new Button("OK");
		okButton.setMinWidth(75);
		okButton.setOnAction(e -> buttonOkClick(txtCharacter, txtActor));
		
		HBox paneCharacter = makeHBox(lblCharacter, txtCharacter);
		HBox paneActor = makeHBox(lblActor, txtActor);
		HBox paneButton = makeHBox(okButton);
		paneButton.setAlignment(Pos.BOTTOM_RIGHT);

		VBox pane = new VBox(10, paneCharacter, paneActor, paneButton);
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Movie Role");
		primaryStage.show();
	}

	private HBox makeHBox(Node... controls) {
		HBox box = new HBox(20, controls);
		box.setPadding(new Insets(10));
		return box;
	}

	private void buttonOkClick(TextField... textFields) {
		String errorMessage="";
		Dialog<String> dialog  = null;
		HashMap<String, String> map = new HashMap<>();
		for (TextField textField: textFields) {
			if (textField.getText().length()==0) {
				errorMessage = errorMessage + textField.getId()+" is a required field. ";
			} else {
				map.put(textField.getId(), textField.getText());
			}
		}
		if (errorMessage.length()==0) {
			String message = "The role of "+map.get("Character")+" is played by "+map.get("Actor")+".";
			dialog = makeDialog("Cast",message);
		} else {
			dialog = makeDialog("Error",errorMessage);
		}
		dialog.showAndWait();
	}
	
	private Dialog<String> makeDialog(String title, String message) {
		Dialog<String> dialog = new Dialog<String>();
		dialog.setHeaderText(title);
		dialog.setContentText(message);
		ButtonType done = new ButtonType("Ok", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(done);
		return dialog;
	}

	private Label makeLabel(String name) {
		Label label = new Label(name);
		label.setMinWidth(100);
		label.setAlignment(Pos.BOTTOM_RIGHT);
		return label;
	}

	private TextField makeTextField(String prompt, String id) {
		TextField tf = new TextField();
		tf.setMinWidth(200);
		tf.setMaxWidth(200);
		tf.setPromptText(prompt);
		tf.setId(id);
		return tf;
	}

}

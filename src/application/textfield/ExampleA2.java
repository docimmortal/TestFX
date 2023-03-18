package application.textfield;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExampleA2 extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		List<HBox> panes = new ArrayList<>();
		panes.add(LabelWithTextField.getHBox("Movie Name:", "Enter movie name here.","Movie"));
		panes.add(LabelWithTextField.getHBox("Character's Name:", "Enter character name here.","Character"));
		panes.add(LabelWithTextField.getHBox("Actor's Name:","Enter actor name here.","Actor"));
		
		Button okButton = new Button("OK");
		okButton.setMinWidth(75);
		okButton.setOnAction(e -> buttonOkClick(panes));
		HBox paneButton = makeHBox(okButton);
		paneButton.setAlignment(Pos.BOTTOM_RIGHT);
		panes.add(paneButton);

		VBox pane = new VBox(2, panes.toArray(new HBox[0])) ;
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

	private void buttonOkClick(List<HBox> hboxes) {
		String errorMessage="";
		Dialog<String> dialog  = null;
		HashMap<String, String> map = new HashMap<>();
		for (HBox hbox:hboxes) {
			for (Node child: hbox.getChildren()) {
				if (child.getClass() == TextField.class) {
					TextField tf = (TextField)child;
					if (tf.getText().length()==0) {
						errorMessage = errorMessage + tf.getId()+" is a required field. ";
					} else {
						map.put(tf.getId(), tf.getText());
					}
				}
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

}

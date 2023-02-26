package application.menu;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FileNewMenuExample extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		Menu fileMenu = new Menu("_File");
        MenuItem newFileMenuItem = new MenuItem("_New...");
        
        // For Mac and PC support, use setAccelerator instead of setMnemonicParsing
        newFileMenuItem.setAccelerator(
            KeyCombination.keyCombination("SHORTCUT+N")
        );
        newFileMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("New file!");
            }
        });
        fileMenu.getItems().add(
                newFileMenuItem
        );

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().setAll(
                fileMenu
        );

        VBox layout = new VBox(menuBar);
        layout.setPrefSize(200, 100);

        stage.setScene(new Scene(layout));
        stage.show();
	}



}

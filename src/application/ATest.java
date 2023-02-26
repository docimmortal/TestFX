package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ATest extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();

		//  Put some text in the center
		pane.setCenter(new Text("It works!"));

		Scene scene = new Scene(pane,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}	
}

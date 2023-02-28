package application.images;

import application.card.entity.Card;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ForegroundBackground extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Pane pane = new Pane();
		ImageView bg = ImageUtilities.createImageView("Table.png",1281,814);
		pane.getChildren().add(bg);
		
		int j=0;
		for (int i=1; i<6; i++) {
			Card card = new Card("Music.png",1, 100*i+j, 100);
			j+=30;
			pane.getChildren().add(card.getCardDisplay());
		}
		Scene scene = new Scene(pane, 1290, 820);
		primaryStage.setScene(scene);
		primaryStage.show();
	}



}

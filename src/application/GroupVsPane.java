package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class GroupVsPane extends Application  {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();
        Group group = new Group();

        VBox.setVgrow(group, Priority.NEVER);
        VBox.setVgrow(pane, Priority.NEVER);

        VBox vbox = new VBox(group, pane);

        Text text1 = new Text("Group");
        text1.setStyle("-fx-font: 24 arial;");
        text1.setFill(Color.BROWN);
        text1.setWrappingWidth(800);
        text1.setTextAlignment(TextAlignment.CENTER);
        
        
        Text text2 = new Text("Pane");
        text2.setStyle("-fx-font: 24 arial;");
        text2.setFill(Color.BROWN);
        text2.setWrappingWidth(800);
        text2.setTextAlignment(TextAlignment.CENTER);
        
        Rectangle rect1 = new Rectangle(100, 100, 100, 100);
        Rectangle rect2 = new Rectangle(100, 100, 100, 100);
        Rectangle rect3 = new Rectangle(200, 200, 100, 100);
        Rectangle rect4 = new Rectangle(200, 200, 100, 100);
        rect1.setFill(Color.BLUE);
        rect2.setFill(Color.BLUE);
        rect3.setFill(Color.GREEN);
        rect4.setFill(Color.GREEN);

        group.getChildren().addAll(text1, rect1, rect3);
        pane.getChildren().addAll(text2, rect2, rect4);

        Scene scene = new Scene(vbox, 800, 800, Color.ALICEBLUE);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            double deltaX ;
            switch(e.getCode()) {
                case LEFT:
                    deltaX = -10 ;
                    break ;
                case RIGHT:
                    deltaX = 10 ;
                    break ;
                default:
                    deltaX = 0 ;
            }
            rect3.setX(rect3.getX() + deltaX);
            rect4.setX(rect4.getX() + deltaX);
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Use LEFT and RIGHT arrow keys.");
        primaryStage.show();
	}

}

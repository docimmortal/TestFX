package application.card;

import java.io.IOException;

import application.card.entity.Card;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Match extends Application {

	private static long correct;
	private static Card[][] cards;
	
	private static int locations[];
	private static int oldLocations[];

	public static void main(String[] args) throws Exception {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		setupNewGame();
		correct=0;
		locations = new int[4]; // stores new match pair x,y coordinates
		oldLocations = new int[4]; // stores old match pair x,y coordinates
		resetLocations();
		resetOldLocations();
		
		GridPane grid = layoutSetup();
		
		// Add the layout to the scene
		Scene scene = new Scene(grid, 900, 700);
		primaryStage.setScene(scene);
		
		scene.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		    	if (twoCardsFlipped()) {
		    		checkMatch();
		    	}	
		    }
		});

		primaryStage.show();
	}
	
	private  static void resetLocations() {
		locations[0]=-1; locations[1]=-1; locations[2]=-1; locations[3]=-1;
	}
	
	private  static void resetOldLocations() {
		oldLocations[0]=-1; oldLocations[1]=-1; oldLocations[2]=-1; oldLocations[3]=-1;
	}
	
	private static void setOldLocations() {
		oldLocations[0]=locations[0];
		oldLocations[1]=locations[1];
		oldLocations[2]=locations[2];
		oldLocations[3]=locations[3];
	}
	
	private static void checkMatch() { 
		int x1=locations[0]; int y1=locations[1];
		int x2=locations[2]; int y2=locations[3];

		int value1 = cards[x1][y1].getId();
		int value2 = cards[x2][y2].getId();
		if (value1 == value2) {
			cards[x1][y1].matchFound();
			cards[x2][y2].matchFound();
			correct++;
		}
		if (correct == 4) {
			System.out.println("We are done.");
		}
		resetLocations();
	}
	
	private static void setupNewGame() throws IOException {
		cards = new Card[4][2];
		cards[0][0] = new Card("Music.png",1);
		cards[0][1] = new Card("Music.png",1);
		cards[1][0] = new Card("Heart.png",2);
		cards[1][1] = new Card("Heart.png",2);
		cards[2][0] = new Card("Wifi.png",3);
		cards[2][1] = new Card("Wifi.png",3);
		cards[3][0] = new Card("Controller.png",4);
		cards[3][1] = new Card("Controller.png",4);
		shuffleCards();
	}
	
	private static boolean twoCardsFlipped() {
		if (oldLocations[0]!=-1 && oldLocations[2]!=-1) {
			int x=oldLocations[0];
			int y=oldLocations[1];
			if (! cards[x][y].isMatchFound()) {
				cards[x][y].flipToHide();
				x=oldLocations[2];
				y=oldLocations[3];
				cards[x][y].flipToHide();
			}
			resetOldLocations();
		}
		resetLocations();
		int cardsFlipped=0;
		boolean twoFlipped=false;
		for (int i=0; i<4; i++) {
			for (int j=0; j<2; j++) {
				if (cards[i][j].wasJustFlipped()) {
					cardsFlipped++;
					if (locations[0]==-1) {
						locations[0]=i; locations[1]=j;
					} else {
						locations[2]=i; locations[3]=j;
					}
				}
			}
		}
		if (cardsFlipped==2) {
			twoFlipped=true;
			setOldLocations();
		}
		return twoFlipped;
	}
	
	private static GridPane layoutSetup() {
		GridPane pane = new GridPane();
		for (int i=0; i<4; i++) {
			for (int j=0; j<2; j++) {
				Button button = cards[i][j].getCardDisplay();
				pane.add(button, i, j); 
			}
		}
		return pane;
	}
	
	private static void shuffleCards() {
		
		int fromX = (int)(Math.random() * 4);
		int fromY = (int)(Math.random() * 2);
		int toX =  (int)(Math.random() * 4);
		int toY =  (int)(Math.random() * 2);
		
		for (int i=1; i< 20; i++) {
			Card temp = cards[toX][toY];
			cards[toX][toY]=cards[fromX][fromY];
			cards[fromX][fromY]=temp;
		}
	}

}

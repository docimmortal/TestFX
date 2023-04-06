package application.card.entity;

import java.io.IOException;

import application.images.ImageUtilities;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Card {

	private Button cardFaceUp;
	private ImageView cardFace;
	private ImageView cardBack;
	private int id;
	private boolean faceUp;
	private boolean matchFound;
	private boolean justFlipped;

	public Card(String filename, int id) throws IOException {
		cardFace = ImageUtilities.createImageView(filename, 100, 140);
		cardBack = ImageUtilities.createImageView("CardBack.png", 100, 140);
		
		cardFaceUp = new Button();
		cardFaceUp.setOnAction(e -> flipToShow());
		cardFaceUp.setPrefSize(100,140);
		cardFaceUp.setGraphic(cardBack);
		
		this.id=id;
		faceUp=false;
		matchFound=false;
		justFlipped=false;
	}
	
	public Card(String filename, int id, int xLoc, int yLoc) throws IOException {
		this(filename, id);	
		cardFaceUp.setLayoutX(xLoc);
		cardFaceUp.setLayoutY(yLoc);
	}
	
	public Button getCardDisplay() {
		return cardFaceUp;
	}
	
	public void flipToShow() {
		cardFaceUp.setGraphic(cardFace);
		faceUp=true;
		justFlipped=true;
	}

	public void flipToHide() {
		cardFaceUp.setGraphic(cardBack);
		justFlipped=false;
		faceUp=false;
	}
	
	public boolean wasJustFlipped() {
		return justFlipped;
	}
	
	public void matchFound() {
		matchFound=true;
		justFlipped=false; // we don't want to flip it back
	}
	
	public boolean isMatchFound() {
		return matchFound;
	}
	
	public boolean isFaceUp() {
		return faceUp;
	}
	
	public int getId() {
		return id;
	}
}

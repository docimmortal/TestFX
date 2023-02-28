package application.card.entity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card {

	private Button cardFaceUp;
	private ImageView cardFace;
	private ImageView cardBack;
	private int id;
	private boolean faceUp;
	private boolean matchFound;
	private boolean justFlipped;

	public Card(String filename, int id) throws FileNotFoundException {
		FileInputStream input = new FileInputStream("images/"+filename);
		Image image1 = new Image(input, 100, 140, false, false);
		cardFace = new ImageView(image1);
		
		// Initially the card backs are shown.
		FileInputStream input2 = new FileInputStream("images/CardBack.png");
		Image image2 = new Image(input2, 100, 140, false, false);
		cardBack = new ImageView(image2);
		cardFaceUp = new Button();
		cardFaceUp.setGraphic(cardBack);
		cardFaceUp.setOnAction(e -> flipToShow());
		this.id=id;
		faceUp=false;
		matchFound=false;
		justFlipped=false;
	}
	
	public Button getCardDisplay() {
		return cardFaceUp;
	}
	
	public void flipToShow() {
		System.out.println("Showing "+id);
		cardFaceUp.setGraphic(cardFace);
		faceUp=true;
		justFlipped=true;
	}

	public void flipToHide() {
		System.out.println("Hiding "+id);
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

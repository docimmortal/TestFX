package application.images;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageUtilities {

	public static ImageView createImageView(String filename, int xPixels, int yPixels) throws FileNotFoundException {
		FileInputStream input = new FileInputStream("images/"+filename);
		Image image = new Image(input, xPixels, yPixels, false, false);
		return new ImageView(image);
	}
}

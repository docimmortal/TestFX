package application.images;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageUtilities {

	public static ImageView createImageView(String filename, int xPixels, int yPixels) throws IOException {
		Image image = null;
		try (FileInputStream input = new FileInputStream("images/"+filename)) {
			image = new Image(input, xPixels, yPixels, false, false);
		}
		return new ImageView(image);
	}
}

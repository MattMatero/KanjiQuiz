import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Matt Matero
 *
 *ImageHandler will handle the loading of images
 */

public class ImageHandler {
	private Image kanji;
	private ImageView kanjiView;
	
	public ImageHandler(){
		kanji = null;
		kanjiView = null;
	}
	
	public ImageHandler(String fileName){
		kanji = new Image(fileName);
		kanjiView = new ImageView(kanji);
	}
	
	public ImageView getImageView(){
		return kanjiView;
	}
	
	public void setImage(String fileName){
		kanji = new Image(fileName);
		kanjiView = new ImageView(kanji);
	}
}

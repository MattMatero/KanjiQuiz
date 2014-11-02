import javafx.scene.image.ImageView;
import java.util.ArrayList;

/**
 * @author Matt Matero
 * 
 * Card class represents a "flash card" object containing a picture of the kanji and what it translates to.
 *
 */
public class Card {
	private ArrayList<String> onReading;
	private ArrayList<String> kunReading;
	private ArrayList<String> meaning;
	private ImageHandler picture;
	private CardHandler cardInfo;
	
	public Card(String fileName){
		cardInfo = new CardHandler(fileName);
		picture = new ImageHandler();
		picture.setImage(cardInfo.readCard());
		meaning = cardInfo.getMeaning();
		onReading = cardInfo.getOn();
		kunReading = cardInfo.getKun();
	}
	
	
	public ImageView getImageView(){
		return picture.getImageView();
	}
}

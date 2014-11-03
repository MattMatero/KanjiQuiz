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
	private int cardNum; //Eventually want to keep stats of cards to do comparison
	
	public Card(String fileName){
		cardInfo = new CardHandler(fileName);
		picture = new ImageHandler();
		picture.setImage(cardInfo.readCard());
		meaning = cardInfo.getMeaning();
		onReading = cardInfo.getOn();
		kunReading = cardInfo.getKun();
		cardNum = cardInfo.getNum();
	}
	
	
	public ArrayList<String> getOnReading() {
		return onReading;
	}


	public ArrayList<String> getKunReading() {
		return kunReading;
	}


	public ArrayList<String> getMeaning() {
		return meaning;
	}


	public ImageHandler getPicture() {
		return picture;
	}


	public CardHandler getCardInfo() {
		return cardInfo;
	}


	public ImageView getImageView(){
		return picture.getImageView();
	}
	
	
	public int getCardNum(){
		return cardNum;
	}
	
	/**
	 * compares two cards to check if they are <,>, or =
	 * @param other The card being compared 
	 * @return -1 if calling object < other
	 * 			0 if calling object = other
	 * 			1 if calling object > other
	 */
	public int compare(Card other){
		if(this == other){
			return 0;
		}
		
		if(this.getCardNum() < other.getCardNum()){
			return -1;
		}
		
		if(this.getCardNum() > other.getCardNum()){
			return 1;
		}
		
		if(this.getCardNum() == other.getCardNum()){
			return 0;
		}
		
		return 1;
	}
}

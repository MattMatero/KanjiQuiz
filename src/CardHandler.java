import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;
import java.util.ArrayList;

public class CardHandler {
	private Scanner input;
	private ArrayList<String> meanings = new ArrayList<String>(1);
	private ArrayList<String> on = new ArrayList<String>(1);
	private ArrayList<String> kun = new ArrayList<String>(1);
	private int num;
	
	public CardHandler(String fileName){
		File f = new File(fileName);
		
		try{
		input = new Scanner(f);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private String readImageLoc(){
		return input.nextLine();
	}
	
	private void readOnReading(){
		int i = 0;
		String line = input.nextLine();
		Scanner lineReader = new Scanner(line);
		while(lineReader.hasNext()){
			 on.add(i, lineReader.next());
			i++;
		} 
		lineReader.close();
	}
	
	private void readMeanings(){
		int i = 0;
		String line = input.nextLine();
		Scanner lineReader = new Scanner(line);
		while(lineReader.hasNext()){
			meanings.add(i, lineReader.next());
			i++;
		}
		lineReader.close();
	}
	
	private void readKunReading(){
		int i = 0;
		String line = input.nextLine();
		Scanner lineReader = new Scanner(line);
		while(lineReader.hasNext()){
			kun.add(i, lineReader.next());
			i++;
		}
		lineReader.close();
	}
	
	private int readNum(){
		return input.nextInt();
	}
	
	/**
	 * Reads all information of the card and returns the location of the image. 
	 * The on and kun readings are saved locally and can be accessed via getter methods.
	 * @return
	 */
	public String readCard(){
		String fileLoc = this.readImageLoc();
		this.readMeanings();
		this.readOnReading();
		this.readKunReading();
		num = this.readNum();
		return fileLoc;
	}

	public int getNum(){
		return num;
	}
	public ArrayList<String> getOn() {
		return on;
	}

	public ArrayList<String> getKun() {
		return kun;
	}
	
	public ArrayList<String> getMeaning(){
		return meanings;
	}
	
}

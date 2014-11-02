import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javafx.event.*;

import javafx.geometry.*;

import javafx.beans.binding.*;
import javafx.beans.property.*;
import javafx.beans.value.*;
import javafx.collections.*;

import javafx.scene.media.*;
import javafx.util.*;

import java.net.*;
import java.io.*;
import java.util.*;

public class Kanji extends Application {
	public static void main(String[] args){
		launch(args);
	}
	
	@SuppressWarnings("deprecation")
	public void start(Stage theStage){
		Group root = new Group();
		Scene theScene = new Scene(root);
		theStage.setTitle("Kanji Quiz!");
	
		//main Screen
		VBox mainBox = VBoxBuilder.create().alignment(Pos.CENTER).build();

		//Horizontal row for picture
		Card first = new Card("E:\\Git\\KanjiQuiz\\src\\cards\\card2.txt");
		HBox picture = HBoxBuilder.create().alignment(Pos.CENTER).build();
		picture.getChildren().add(first.getImageView());
		
		HBox buttonRow = HBoxBuilder.create().alignment(Pos.CENTER).build();
		Button next = ButtonBuilder.create().text("next").build();
		buttonRow.getChildren().add(next);
		
		//Horizontal row to have all input related to meaning
		HBox meaningRow = HBoxBuilder.create().alignment(Pos.CENTER).build();
		Text meaningLabel = TextBuilder.create().text("Meaning: ").build();
		TextField meaningInput = TextFieldBuilder.create().build();
		
		//Horizontal row to have all input related to onReading
		HBox onReading = HBoxBuilder.create().alignment(Pos.CENTER).build();
		Text onLabel = TextBuilder.create().text("On Reading: ").build();
		TextField onInput = TextFieldBuilder.create().build();
		
		//Horizontal row to have all input related to kunReading
		HBox kunReading = HBoxBuilder.create().alignment(Pos.CENTER).build();
		Text kunLabel = TextBuilder.create().text("Kun Reading: ").build();
		TextField kunInput = TextFieldBuilder.create().build();
		
		//adding row components to row
		meaningRow.getChildren().addAll(meaningLabel,meaningInput); 
		
		//adding row components to row
		onReading.getChildren().addAll(onLabel,onInput);
		
		//adding row components to row
		kunReading.getChildren().addAll(kunLabel,kunInput);
		
		//adding to main screen
		mainBox.getChildren().addAll(picture,buttonRow,meaningRow,onReading,kunReading);
		root.getChildren().add(mainBox);
		
		theStage.setScene(theScene);
		theStage.show();
	}
}

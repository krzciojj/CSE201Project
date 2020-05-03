package application;
	
import javafx.application.Application;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import application.Controller;
import javafx.stage.Stage;
import steakstore.Restaurant;
import steakstore.User;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class Main extends Application implements Serializable{
	
	Button button;
	static ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
	public static void main(String[] args) throws ClassNotFoundException, IOException 
	{
		createRestaurantData();
		readRestaurantData();
		launch(args);
	}
	
	public static void readRestaurantData() throws IOException, ClassNotFoundException
	{
		ObjectInputStream objectData = new ObjectInputStream(new FileInputStream("restaurants.dat"));
		while(objectData.available() != 0)
		{
			restaurants.add((Restaurant) objectData.readObject());
		}
		objectData.close();
		System.out.println("test");
	}
	
	public static void createRestaurantData()
	{
		try (FileOutputStream fileOut = new FileOutputStream("restaurants.dat");
	             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
				User testuser = new User("name", "pass", "email");
	            Restaurant test = new Restaurant("asfda", "asfda", "asfda", "asfda", "asfda", testuser);
	            Restaurant test2 = new Restaurant("aa", "aaa", "aasdfsa", "a1423423a", "a23423a", testuser);
	            
	            objectOut.writeObject(test);
	            objectOut.writeObject(test2);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("steakstore.fxml"));
		primaryStage.setTitle("Steak Store");
		primaryStage.setScene(new Scene(root, 600, 400));
		primaryStage.show();
	}

	
}

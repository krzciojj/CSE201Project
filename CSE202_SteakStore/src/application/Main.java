package application;
	
import javafx.application.Application;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

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

@SuppressWarnings("serial")
public class Main extends Application implements Serializable{
	
	Button button;
	private static final long serialVersionUID = 0;
	public static ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
	public static ArrayList<User> users = new ArrayList<User>();
	public static void main(String[] args) throws ClassNotFoundException, IOException 
	{
		File temp = new File("restaurants.dat");
		File temp2 = new File("users.dat");
		if(!temp.exists())
			createRestaurantData();
		if(!temp2.exists())
			createUserData();
		
		readRestaurantData();
		readUserData();
		launch(args);
	}
	
	public static void readRestaurantData() throws IOException, ClassNotFoundException
	{
		ObjectInputStream objectData = new ObjectInputStream(new FileInputStream("restaurants.dat"));
		while(true)
		{
			try {
			restaurants.add((Restaurant) objectData.readObject());
			} catch(EOFException e) {
				return;
				//objectData.close();
			}
		}
		
	}
	
	public static void readUserData() throws IOException, ClassNotFoundException
	{
		ObjectInputStream objectData = new ObjectInputStream(new FileInputStream("users.dat"));
		while(true)
		{
			try {
			users.add((User) objectData.readObject());
			} catch(EOFException e) {
				return;
				//objectData.close();
			}
		}
		
	}
	
	public static void createRestaurantData()
	{
		try (FileOutputStream fileOut = new FileOutputStream("restaurants.dat");
	             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
				User testuser = new User("name", "pass", "email");
	            Restaurant test = new Restaurant("asfda", "asfda", "asfda", "asfda", "asfda", testuser);
	            Restaurant test2 = new Restaurant("aa", "aaa", "aasdfsa", "a1423423a", "a23423a", testuser);
	            Restaurant test3 = new Restaurant("bb", "aaa", "aasdfsa", "a1523423a", "a23423a", testuser);
	            
	            objectOut.writeObject(test);
	            objectOut.writeObject(test2);
	            objectOut.writeObject(test3);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	public static void createUserData()
	{
		try (FileOutputStream fileOut = new FileOutputStream("users.dat");
	             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
				User testuser = new User("name", "pass", "email");
				User testuser2 = new User("name2", "pass2", "emai2l");
				User testuser3 = new User("name3", "pass3", "email3");
	            
	            objectOut.writeObject(testuser);
	            objectOut.writeObject(testuser2);
	            objectOut.writeObject(testuser3);
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
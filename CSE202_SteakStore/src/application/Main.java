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
import steakstore.Filter;
import steakstore.Restaurant;
import steakstore.User;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

@SuppressWarnings("serial")
public class Main extends Application implements Serializable {

	Button button;
	private static final long serialVersionUID = 0;

	public static ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>(); // list of all restaurants
	public static ArrayList<User> users = new ArrayList<User>(); // list of all users
	public static ArrayList<Filter> filters = new ArrayList<Filter>(); // list of all filters
	public static ArrayList<Filter> submissions = new ArrayList<Filter>(); // list of all current submissions

	public static User currentUser; // currently logged in user
	public static User admin = new User("admin", "abc123", "admin@email.com", true);
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		File temp = new File("restaurants.dat");
		File temp2 = new File("users.dat");
		File temp3 = new File("filters.dat");
		File temp4 = new File("submissions.dat");
		if (!temp.exists())
			createRestaurantData();
		if (!temp2.exists())
			createUserData();
		if (!temp3.exists())
			createFilterData();
		if (!temp4.exists())
			createSubmissionData();

		readRestaurantData();
		readUserData();
		readFilterData();
		launch(args);
	}

	public static void readRestaurantData() throws IOException, ClassNotFoundException {
		ObjectInputStream objectData = new ObjectInputStream(new FileInputStream("restaurants.dat"));
		while (true) {
			try {
				restaurants.add((Restaurant) objectData.readObject());
			} catch (EOFException e) {
				return;
				// objectData.close();
			}
		}
	}

	public static void readUserData() throws IOException, ClassNotFoundException {
		ObjectInputStream objectData = new ObjectInputStream(new FileInputStream("users.dat"));
		while (true) {
			try {
				users.add((User) objectData.readObject());
			} catch (EOFException e) {
				return;
				// objectData.close();
			}
		}
	}

	public static void readFilterData() throws IOException, ClassNotFoundException {
		ObjectInputStream objectData = new ObjectInputStream(new FileInputStream("filters.dat"));
		while (true) {
			try {
				filters.add((Filter) objectData.readObject());
			} catch (EOFException e) {
				return;
				// objectData.close();
			}
		}
	}

	public static void addUser(User u) {
		try (FileOutputStream fileOut = new FileOutputStream("users.dat", true);
				AppendableObjectOutputStream objectOut = new AppendableObjectOutputStream(fileOut)) {
			users.add(u);
			objectOut.writeObject(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createRestaurantData() {
		try (FileOutputStream fileOut = new FileOutputStream("restaurants.dat");
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
			Restaurant test = new Restaurant("Wendy's", "5142 College Corner Pike", "6:30AM-9:30PM",
					"https://locations.wendys.com/united-states/oh/oxford/5142-college-corner-pike", "asfda",
					"https://order.wendys.com/categories?site=menu", admin,
					"https://thehill.com/sites/default/files/styles/thumb_small_article/public/article_images/wendys_012716getty_0.jpg?itok=f1BCBVqg");
			test.addTerm(new Filter("Fast Food"));
			Restaurant test2 = new Restaurant("McDonald's", "1900 University Ave,", "Open 24 Hours", "a1423423a",
					"a1423423a", "https://www.mcdonalds.com/us/en-us/full-menu.html", admin,
					"https://www.mcdonalds.com/content/dam/usa/nfl/assets/nav/arches-logo_108x108.jpg");
			test2.addTerm(new Filter("Fast Food"));
			Restaurant test3 = new Restaurant("Chipotle", "1 W High St", "10:45AM-10PM", "aasdfsa", "a1523423a",
					"https://meetatroam.com/wp-content/uploads/2019/02/Chipotle-Menu-2019-.pdf", admin,
					"https://upload.wikimedia.org/wikipedia/en/thumb/3/3b/Chipotle_Mexican_Grill_logo.svg/220px-Chipotle_Mexican_Grill_logo.svg.png");
			test3.addTerm(new Filter("Mexican"));

			objectOut.writeObject(test);
			objectOut.writeObject(test2);
			objectOut.writeObject(test3);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createUserData() {
		try (FileOutputStream fileOut = new FileOutputStream("users.dat", true);
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

			objectOut.writeObject(admin);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createFilterData() {
		try (FileOutputStream fileOut = new FileOutputStream("filters.dat");
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
			Filter term1 = new Filter("Fast Food");
			Filter term2 = new Filter("Mexican");

			objectOut.writeObject(term1);
			objectOut.writeObject(term2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void createSubmissionData() {
		try (FileOutputStream fileOut = new FileOutputStream("submissions.dat");
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
			Restaurant submission = new Restaurant("Steak 'n Shake", "9414 Civic Centre Blvd", "6:00am - 12am", "513-759-5888", "https://www.steaknshake.com/",
					"https://cos-steak-n-shake.s3-us-west-2.amazonaws.com/ISME2019/SNS_DIMNU_Web_Menu_Nov_Final%5B2%5D.pdf", admin, "https://upload.wikimedia.org/wikipedia/en/thumb/4/40/Steak_%27n_Shake_logo.svg/1200px-Steak_%27n_Shake_logo.svg.png");
			objectOut.writeObject(submission);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("steakstore.fxml"));
		Scene scene = new Scene(root, 600, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Steak Store");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

}
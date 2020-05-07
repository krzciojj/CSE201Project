package application;

import javafx.application.Application;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.stage.Stage;
import steakstore.Filter;
import steakstore.Restaurant;
import steakstore.Submission;
import steakstore.User;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
/**
 * Main class that runs entire application
 * @author Danny, Grant, Jacob, Jak
 *
 */
@SuppressWarnings("serial")
public class Main extends Application implements Serializable {

	Button button;
	private static final long serialVersionUID = 0;

	public static ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>(); // list of all restaurants
	public static ArrayList<User> users = new ArrayList<User>(); // list of all users
	public static ArrayList<Filter> filters = new ArrayList<Filter>(); // list of all filters
	public static ArrayList<Submission> submissions = new ArrayList<Submission>(); // list of all current submissions

	public static User currentUser; // currently logged in user
	public static User admin = new User("admin", "abc123", "admin@email.com", true);
	/**
	 * Calls on other methods to run application. Adds URLs to restaurants to be used in application.
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		File temp = new File("restaurants.dat");
		File temp2 = new File("users.dat");
		File temp3 = new File("filters.dat");
		File temp4 = new File("submissions.dat");

		// populate local ArrayLists with data from file or handwritten data
		if (temp.exists())
			readRestaurantData();
		else {
			Restaurant test = new Restaurant("Wendy's", "5142 College Corner Pike", "6:30AM-9:30PM",
					"https://locations.wendys.com/united-states/oh/oxford/5142-college-corner-pike", "asfda",
					"https://www.wendys.com/explore-our-food", admin,
					"https://thehill.com/sites/default/files/styles/thumb_small_article/public/article_images/wendys_012716getty_0.jpg?itok=f1BCBVqg");
			test.addTerm(new Filter("Fast Food"));
			Restaurant test2 = new Restaurant("McDonald's", "1900 University Ave,", "Open 24 Hours", "a1423423a",
					"a1423423a", "https://www.mcdonalds.com/us/en-us/full-menu.html", admin,
					"https://www.mcdonalds.com/content/dam/usa/nfl/assets/nav/arches-logo_108x108.jpg");
			test2.addTerm(new Filter("Fast Food"));
			Restaurant test3 = new Restaurant("Chipotle", "1 W High St", "10:45AM-10PM", "aasdfsa", "a1523423a",
					"https://www.chipotle.com/", admin,
					"https://upload.wikimedia.org/wikipedia/en/thumb/3/3b/Chipotle_Mexican_Grill_logo.svg/220px-Chipotle_Mexican_Grill_logo.svg.png");
			test3.addTerm(new Filter("Mexican"));
			
			restaurants.add(test);
			restaurants.add(test2);
			restaurants.add(test3);
		}
		if (temp2.exists())
			readUserData();
		else {
			users.add(admin);
		}
		if (temp3.exists())
			readFilterData();
		else {
			Filter term1 = new Filter("Fast Food");
			Filter term2 = new Filter("Mexican");
			
			filters.add(term1);
			filters.add(term2);
		}
		if (temp4.exists())
			readSubmissionData();
		else {
			Submission submission = new Submission(new Restaurant("Steak 'n Shake", "9414 Civic Centre Blvd",
					"6:00am - 12am", "513-759-5888", "https://www.steaknshake.com/",
					"https://www.steaknshake.com/select-location/",
					admin,
					"https://upload.wikimedia.org/wikipedia/en/thumb/4/40/Steak_%27n_Shake_logo.svg/1200px-Steak_%27n_Shake_logo.svg.png"));

			submissions.add(submission);
		}
		
		// create .dat files
		createRestaurantData();
		createUserData();
		createFilterData();
		createSubmissionData();
		launch(args);
	}

	/**
	 * Reads restaurant data
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
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
/**
 * Reads user data
 * @throws IOException
 * @throws ClassNotFoundException
 */
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
/**
 * Reads filter data
 * @throws IOException
 * @throws ClassNotFoundException
 */
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
/**
 * Reads submission data
 * @throws IOException
 * @throws ClassNotFoundException
 */
	private static void readSubmissionData() throws IOException, ClassNotFoundException {
		ObjectInputStream objectData = new ObjectInputStream(new FileInputStream("submissions.dat"));
		while (true) {
			try {
				submissions.add((Submission) objectData.readObject());
			} catch (EOFException e) {
				return;
				// objectData.close();
			}
		}
	}

	/**
	 * Adds user data
	 * @param u the user to be added
	 */
	public static void addUser(User u) {
		try (FileOutputStream fileOut = new FileOutputStream("users.dat", true);
				AppendableObjectOutputStream objectOut = new AppendableObjectOutputStream(fileOut)) {
			users.add(u);
			objectOut.writeObject(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
/**
 * Adds restaurant data
 * @param r the restaurant to be added
 */
	public static void addRestaurant(Restaurant r) {
		try (FileOutputStream fileOut = new FileOutputStream("restaurants.dat", true);
				AppendableObjectOutputStream objectOut = new AppendableObjectOutputStream(fileOut)) {
			restaurants.add(r);
			objectOut.writeObject(r);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
/**
 * Adds submission data
 * @param r the submission to be add
 */
	public static void addSubmission(Submission r) {
		try (FileOutputStream fileOut = new FileOutputStream("submissions.dat", true);
				AppendableObjectOutputStream objectOut = new AppendableObjectOutputStream(fileOut)) {
			submissions.add(r);
			objectOut.writeObject(r);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates and updates restaurant data
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void createRestaurantData() throws FileNotFoundException, IOException {
		new FileOutputStream("restaurants.dat").close();
		try (FileOutputStream fileOut = new FileOutputStream("restaurants.dat");
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

			for (Restaurant restaurant : restaurants) {
				objectOut.writeObject(restaurant);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
/**
 * Creates and updates user data
 * @throws FileNotFoundException
 * @throws IOException
 */
	public static void createUserData() throws FileNotFoundException, IOException {
		new FileOutputStream("users.dat").close();
		try (FileOutputStream fileOut = new FileOutputStream("users.dat", true);
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

			for (User user : users) {
				objectOut.writeObject(user);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
/**
 * Creates and updates filter data
 * @throws FileNotFoundException
 * @throws IOException
 */
	public static void createFilterData() throws FileNotFoundException, IOException {
		new FileOutputStream("filters.dat").close();
		try (FileOutputStream fileOut = new FileOutputStream("filters.dat");
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

			for (Filter filter : filters) {
				objectOut.writeObject(filter);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
/**
 * Creates and updates submission data
 * @throws FileNotFoundException
 * @throws IOException
 */
	protected static void createSubmissionData() throws FileNotFoundException, IOException {
		new FileOutputStream("submissions.dat").close();
		try (FileOutputStream fileOut = new FileOutputStream("submissions.dat");
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

			for (Submission submission : submissions) {
				objectOut.writeObject(submission);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
/**
 * Starts up application and links css
 */
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
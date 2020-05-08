package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import steakstore.Filter;
import steakstore.Restaurant;
import steakstore.Submission;
import steakstore.User;

class MainTest extends Main  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Test
	void testReadRestaurantData() throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		createRestaurantData();
		Restaurant chipotle = new Restaurant("Chipotle", "1 W High St", "10:45AM-10PM", "aasdfsa", "https://www.chipotle.com/",
				"https://www.chipotle.com/", admin,
				"https://upload.wikimedia.org/wikipedia/en/thumb/3/3b/Chipotle_Mexican_Grill_logo.svg/220px-Chipotle_Mexican_Grill_logo.svg.png");
		addRestaurant(chipotle);
		readRestaurantData();
		//restaurant data is read into array successfully if this passes
		assertTrue(restaurants.contains(chipotle));
	}

	@Test
	void testReadUserData() throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		createUserData();
		User testUser = new User("a", "a", "a");
		addUser(testUser);
		readUserData();
		//user data is read into array successfully if this passes
		assertTrue(users.contains(testUser));
	}

	@Test
	void testReadFilterData() throws FileNotFoundException, IOException, ClassNotFoundException {
		createFilterData();
		File filters = new File("filters.dat");
		readFilterData();
		assertEquals(filters.exists(), true);
	}

	@Test
	void testAddUser() throws ClassNotFoundException, IOException 
	{
		createUserData();
		User testUser = new User("a", "a", "a");
		User testUser2 = new User("1", "1", "1");
		addUser(testUser);
		readUserData();
		//user data is read into array successfully if this passes
		assertTrue(users.contains(testUser));
		addUser(testUser2);
		readUserData();
		assertTrue(users.contains(testUser2));
		
	}

	@Test
	void testAddRestaurant() throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		createRestaurantData();
		Restaurant chipotle = new Restaurant("Chipotle", "1 W High St", "10:45AM-10PM", "aasdfsa", "https://www.chipotle.com/",
				"https://www.chipotle.com/", admin,
				"https://upload.wikimedia.org/wikipedia/en/thumb/3/3b/Chipotle_Mexican_Grill_logo.svg/220px-Chipotle_Mexican_Grill_logo.svg.png");
		Restaurant steaknshake = new Restaurant("Steak 'n Shake", "9414 Civic Centre Blvd",
				"6:00am - 12am", "https://www.steaknshake.com/", "https://www.steaknshake.com/",
				"https://www.steaknshake.com/select-location/",
				admin,
				"https://upload.wikimedia.org/wikipedia/en/thumb/4/40/Steak_%27n_Shake_logo.svg/1200px-Steak_%27n_Shake_logo.svg.png");
		addRestaurant(chipotle);
		readRestaurantData();
		//restaurant data is read into array successfully if this passes
		assertTrue(restaurants.contains(chipotle));	
		
		addRestaurant(steaknshake);
		readRestaurantData();
		assertTrue(restaurants.contains(steaknshake));
	}

	@Test
	void testAddSubmission() throws FileNotFoundException, IOException {
		createSubmissionData();
		Submission submission = new Submission(new Restaurant("Steak 'n Shake", "9414 Civic Centre Blvd",
				"6:00am - 12am", "https://www.steaknshake.com/", "https://www.steaknshake.com/",
				"https://www.steaknshake.com/select-location/",
				admin,
				"https://upload.wikimedia.org/wikipedia/en/thumb/4/40/Steak_%27n_Shake_logo.svg/1200px-Steak_%27n_Shake_logo.svg.png"));
		addSubmission(submission);
		assertTrue(submissions.contains(submission));
	}

	@Test
	void testCreateRestaurantData() throws FileNotFoundException, IOException {
		createRestaurantData();
		File r = new File("restaurants.dat");
		assertTrue(r.exists());
	}

	@Test
	void testCreateUserData() throws FileNotFoundException, IOException {
		createUserData();
		File users = new File("users.dat");
		assertTrue(users.exists());
	}

	@Test
	void testCreateFilterData() throws FileNotFoundException, IOException 
	{
		createFilterData();
		File filters = new File("filters.dat");
		assertTrue(filters.exists());
	}

	@Test
	void testCreateSubmissionData() throws FileNotFoundException, IOException {
		createSubmissionData();
		File sub = new File("submissions.dat");
		assertTrue(sub.exists());
	}

}

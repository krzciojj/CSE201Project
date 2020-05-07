package steakstore;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Class used to create a restaurant as well as add reviews for the restaurant and categorize them by filters
 * @author Danny, Grant, Jacob, Jak
 *
 */
public class Restaurant implements Serializable {
	private String name;
	private String location;
	private String hours;
	private String contact;
	private String website;
	private String menu;
	private ArrayList<Filter> searchTerms;
	private ArrayList<Review> reviews;
	private User author;
	private String picture;
	/**
	 * Constructs a restaurant with all the inputs needed to function correctly
	 * @param name the name of the restaurant
	 * @param location the location of the restaurant
	 * @param hours the hours of the restaurant
	 * @param contact the phone number for the restaurant
	 * @param website the website for the restaurant
	 * @param menu the menu for the restaurant
	 * @param author the user who submitted the restaurant
	 * @param picture the picture associated with the restaurant
	 */
	public Restaurant(String name, String location, String hours, String contact, 
			String website, String menu, User author, String picture ) {
		this.name = name;
		this.location = location;
		this.hours = hours;
		this.contact = contact;
		this.website = website;
		this.menu = menu;
		this.author = author;
		this.picture = picture;

		searchTerms = new ArrayList<Filter>();
		reviews = new ArrayList<Review>();
	}
	/**
	 * adds a term (filter) to the arraylist of search terms
	 * @param term the term to be added
	 */
	public void addTerm(Filter term) {
		searchTerms.add(term);
	}
	/**
	 * Gets the search terms
	 * @return returns search terms
	 */
	public ArrayList<Filter> getSearchTerms() {
		return searchTerms;

	}
	/**
	 * Gets the user
	 * @return returns the user
	 */
	public User getAuthor() {
		return author;
	}

	/**
	 * Adds a review to the list of reviews for the Restaurant
	 * 
	 * @param r The review that is going to be added
	 */
	public void addReview(Review r) {
		reviews.add(r);
	}

	/**
	 * Returns an array containing the restuarant's information, including name,
	 * location, hours, contact, website, and menu, in this order.
	 * 
	 * @return The array containing the restuarant's information, including name,
	 *         location, contact, hours website, and menu, in this order.
	 */
	public String[] getInfo() {
		String[] info = { name, location, hours, contact, website, menu, picture };
		return info;
	}

	/**
	 * Averages all the review scores for the restaurant
	 * 
	 * @return The average of all the review scores
	 */
	double getAverageScore() {
		double avg = 0.0;
		for (int i = 0; i < reviews.size(); i++)
			avg += reviews.get(i).getScore();
		avg /= reviews.size();
		return avg;
	}
	
	public ArrayList<Review> getReviews(){
		return reviews;
	}
}
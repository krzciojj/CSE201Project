package steakstore;

import java.io.Serializable;
import java.util.ArrayList;

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
}
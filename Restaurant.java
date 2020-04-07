package steakstore;

import java.util.ArrayList;

public class Restaurant {
	private String name;
	private String location;
	private String contact;
	private String website;
	private String menu;
	private ArrayList<Filter> searchTerms;
	private ArrayList<Review> reviews;
	private User author;

	public Restaurant(String name, String location, String contact, String website, String menu, User author) {
		this.name = name;
		this.location = location;
		this.contact = contact;
		this.website = website;
		this.menu = menu;
		this.author = author;
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
	 * Returns a summary of the restuarant's information, including location, name,
	 * contact, website, and menu.
	 * 
	 * @return The summary of the restuarant's information, including location,
	 *         name, contact, website, and menu.
	 */
	public String getInfo() {
		return location + " " + name + " " + contact + " " + website + " " + menu;
	}
	
	/**
	 * Averages all the review scores for the restaurant
	 * 
	 * @return The average of all the review scores
	 */
	double getAverageScore() {
		double avg = 0.0;
		for(int i = 0; i < reviews.size(); i++)
			avg += reviews.get(i).getScore();
		avg /= reviews.size();
		return avg;
	}
}

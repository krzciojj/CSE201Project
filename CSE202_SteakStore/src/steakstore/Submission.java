package steakstore;

import java.io.Serializable;
/**
 * Assists with submitting a new restaurant to the admin for approval
 * @author Danny, Grant, Jacob, Jak
 *
 */
public class Submission implements Serializable {
	int status;
	Restaurant restaurant;
/**
 * Constructor that defaults status to 0 and implements restaurant
 * @param restaurant the restaurant to be assigned
 */
	public Submission(Restaurant restaurant) {
		this.restaurant = restaurant;
		status = 0;
	}
/**
 * Gets the restaurant submitted
 * @return returns the restaurant
 */
	public Restaurant getRestaurant() {
		return restaurant;
	}
/**
 * Gets the status of the restaurant
 * @return returns the status
 */
	public int getStatus() {
		return status;
	}
/**
 * Sets the status of the restaurant
 * @param s the status to be set
 */
	public void setStatus(int s) {
		status = s;
	}

	/**
	 * Returns the status of the submission form
	 * 
	 * @return Returns "Awaiting acceptance" if the submission form is being
	 *         reviewed, "Restaurant accepted" if the submission form was accepted,
	 *         or "Restaurant was denied" if the submission form was denied
	 */
	public String checkStatus() {
		if (status < 0)
			return "Restaurant was denied";
		else if (status == 0)
			return "Awaiting acceptance";
		else
			return "Restaurant accepted";

	}
}
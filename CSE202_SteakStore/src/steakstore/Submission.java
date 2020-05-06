package steakstore;

import java.io.Serializable;

public class Submission implements Serializable {
	int status;
	Restaurant restaurant;

	public Submission (Restaurant restaurant) {
		this.restaurant = restaurant;
		status = 0;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	
	/**
	 * Returns the status of the submission form
	 * 
	 * @return Returns "Incomplete" if the submission form is complete, "On Hold" if
	 *         the submission form is being reviewed, "Accepted" if the submission
	 *         form was accepted, or "Denied" if the submission form was denied
	 */
	String checkStatus() {
		if (restaurant == null)
			return "Restaurant does not exist";
		else
			return "Accepted";

	}
}
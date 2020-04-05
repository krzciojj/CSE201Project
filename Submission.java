package steakstore;

public class Submission {
	int status;
	Restaurant restaurant;
	User author;

	/**
	 * Adds the restaurant to the submission form
	 * 
	 * @param r The restaurant that will be added to the submission form
	 */
	void addRestaurant(Restaurant r) {
		restaurant = r;
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
			return "aaaaaa";

	}
}

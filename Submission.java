package steakstore;

public class Submission {
	int status;
	Restaurant restaurant;
	User author;

	public Submission (Restaurant restaurant, User author) {
		this.restaurant = restaurant;
		this.author = author;
		status = 0;
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

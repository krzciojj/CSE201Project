package steakstore;

public class User {
	private String username;
	private String password;
	private String email;
	private boolean isAdmin;

	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;

	}

	/**
	 * Creates a submission form for the user
	 * 
	 * @param s The submission form being created
	 * @return True if the submission form was created, false otherwise
	 */
	public boolean makeSubmission(Submission s) {
		return false;
	}
}

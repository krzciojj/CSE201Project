package steakstore;

import java.io.Serializable;
import java.util.Scanner;
/**
 * Creates a user with the correct inputs and allows user to make a restaurant subbmission
 * @author Danny, Grant, Jacob, Jak
 *
 */
public class User implements Serializable
{
	private String username;
	private String password;
	private String email;
	private boolean isAdmin;
	/**
	 * Constructs a new User
	 * @param username the user's username
	 * @param password the user's password
	 * @param email the user's email
	 */
	public User(String username, String password, String email)
	{
		this.username = username;
		this.password = password;
		this.email = email;
		isAdmin = false;
	}
	/**
	 * Constructs an administrative user
	 * @param username the user's username
	 * @param password the user's password
	 * @param email the user's email
	 * @param admin boolean that is true if the user is an admin and false otherwise
	 */
	public User(String username, String password, String email, boolean admin)
	{
		this.username = username;
		this.password = password;
		this.email = email;
		isAdmin = admin;
	}

/**
 * Allows the user to change his or her information
 * @param username the user's username
 * @param password the user's password
 * @param email the user's email
 * @return returns true if information was changed and false otherwise
 */
	public boolean changeInformation(String username, String password, String email) 
	{
		boolean flag = false;
		
		if (username != null) {
			this.username = username;
			flag = true;
		}
		if (password != null) {
			this.password = password;
			flag = true;
		}
		if (email != null) {
			this.email = email;
			flag = true;
		}
		
		return flag;

	}
/**
 * Gets the username of the user
 * @return returns the username
 */
	public String getUsername() {
		return username;
	}
/**
 * Sets the username of the user
 * @param username the username to be set
 */
	private void setUsername(String username) {
		this.username = username;
	}
/**
 * Gets the user's password
 * @return returns the password
 */
	public String getPassword() {
		return password;
	}
/**
 * Sets the user's password
 * @param password the password to be set
 */
	private void setPassword(String password) {
		this.password = password;
	}
/**
 * Gets the user's email
 * @return returns the email
 */
	public String getEmail() {
		return email;
	}
/**
 * Sets the user's email
 * @param email the email to be set
 */
	private void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Fetches whether the user is an admin or not
	 * @return returns true if user is admin and false otherwise
	 */
	public Boolean isAdmin() {
		return isAdmin;
	}
	
}

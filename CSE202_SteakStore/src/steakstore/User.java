package steakstore;

import java.io.Serializable;
import java.util.Scanner;

public class User implements Serializable
{
	private String username;
	private String password;
	private String email;
	private boolean isAdmin;
	
	public User(String username, String password, String email)
	{
		this.username = username;
		this.password = password;
		this.email = email;
		isAdmin = false;
	}
	
	public User(String username, String password, String email, boolean admin)
	{
		this.username = username;
		this.password = password;
		this.email = email;
		isAdmin = admin;
	}
	
	public boolean makeSubmission(Submission s)
	{
		return false;
	}
	

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

	public String getUsername() {
		return username;
	}

	private void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}
	
	
}

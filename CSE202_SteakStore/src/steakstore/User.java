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
		
	}
	
	public boolean makeSubmission(Submission s)
	{
		return false;
	}
	

	public void changeInformation(String item, String changed) 
	{

		if (item.equalsIgnoreCase("username")) 
		{
			username = changed;

		} else if (item.equalsIgnoreCase("password"))
		{
			password = changed;

		} else if (item.equalsIgnoreCase("email"))
		{
			email = changed;
		}


	}
}

package steakstore;

public class User 
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
}

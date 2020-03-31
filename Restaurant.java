package steakstore;

import java.util.ArrayList;

public class Restaurant 
{
	private String name;
	private String location;
	private String contact;
	private String website;
	private String menu;
	private ArrayList<Filter> searchTerms;
	private ArrayList<Review> reviews;
	private User author;
	
	public Restaurant(String name, String location, String contact, String website,
			String menu, User author)
	{
		this.name = name;
		this.location = location;
		this.contact = contact;
		this.website = website;
		this.menu = menu;
		this.author = author;
	}
	
	public void addReview(Review r)
	{
		reviews.add(r);
	}
	
	public String getInfo()
	{
		return location + " " + name + " " + contact + " " + website + " " + menu;
	}
}

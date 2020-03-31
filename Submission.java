package steakstore;

public class Submission 
{
	int status;
	Restaurant restaurant;
	User author;
	
	Restaurant makeRestaurant(String name, String location, Filter[] searchTerms)
	{
		return restaurant;
	}
	
	String checkStatus(Restaurant r)
	{
		if(r.equals(null))
			return "Restaurant does not exist";
		else
			return "aaaaaa";
		
	}
}

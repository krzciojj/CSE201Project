package steakstore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RestaurantTest {
	
	@Test
	void testAddReview() {
		User john = new User("john", "Jacob", "jingle");
		Restaurant wendys = new Restaurant("Wendys", "Oxford", "7:30AM - 10:30PM", "John", "www.wendys.com", "menu", john, "www.");

		Review r = new Review(0, john);
		wendys.addReview(r);


		assertTrue(true);
	}

	@Test
	void testGetInfo() {
		User john = new User("john", "Jacob", "jingle");
		Restaurant wendys = new Restaurant("Wendys", "Oxford", "7:30AM - 10:30PM", "John", "www.wendys.com", "menu", john, "www.");

		assertEquals("Wendys Oxford 7:30AM - 10:30PM John www.wendys.com menu", wendys.getInfo()[0] + " " + wendys.getInfo()[1] + " " + wendys.getInfo()[2] + " " + wendys.getInfo()[3] + " " + wendys.getInfo()[4] + " " + wendys.getInfo()[5]);
	}

	
	@Test
	void testaddReview() {
		
		User john = new User("john", "Jacob", "jingle");
		Review review = new Review(1, john);
		Restaurant wendys = new Restaurant("Wendys", "Oxford", "7:30AM - 10:30PM", "John", "www.wendys.com", "menu", john, "www.");
		
		wendys.addReview(review);
		
		assertTrue(wendys.getReviews().contains(review));
	}
	
	@Test
	void testaddFilter() {
		User john = new User("john", "Jacob", "jingle");
		Restaurant wendys = new Restaurant("Wendys", "Oxford", "7:30AM - 10:30PM", "John", "www.wendys.com", "menu", john, "www.");
		Filter filter = new Filter("fast-food");
		
		// not added yet
		assertFalse(wendys.getFilter().contains(filter));
		
		//added
		wendys.addTerm(filter);
		assertTrue(wendys.getFilter().contains(filter));
		
	}
	
	@Test
	void testgetAverageScore() {
		User john = new User("john", "Jacob", "jingle");
		Review review = new Review(1, john);
		Restaurant wendys = new Restaurant("Wendys", "Oxford", "7:30AM - 10:30PM", "John", "www.wendys.com", "menu", john, "www.");
		
		assertNotEquals(wendys.getAverageScore(), 1.0);
		
		wendys.addReview(review);
		
		assertEquals(wendys.getAverageScore(), 1.0);
	}
	

}

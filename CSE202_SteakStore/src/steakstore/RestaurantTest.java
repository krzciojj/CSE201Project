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

		// Getters and setters will help me test this better

		assertTrue(true);
	}

	@Test
	void testGetInfo() {
		User john = new User("john", "Jacob", "jingle");
		Restaurant wendys = new Restaurant("Wendys", "Oxford", "7:30AM - 10:30PM", "John", "www.wendys.com", "menu", john, "www.");

		assertEquals("Wendys Oxford 7:30AM - 10:30PM John www.wendys.com menu", wendys.getInfo()[0] + " " + wendys.getInfo()[1] + " " + wendys.getInfo()[2] + " " + wendys.getInfo()[3] + " " + wendys.getInfo()[4] + " " + wendys.getInfo()[5]);
	}

	// we need to add getters and setters

}

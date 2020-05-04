package steakstore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RestaurantTest {

	@Test
	void testRestaurant() {
		User john = new User("john", "Jacob", "jingle");
		Restaurant wendys = new Restaurant("Wendys", "Oxford", "John", "www.wendys.com", "menu", john);

		assertEquals("Oxford Wendys John www.wendys.com menu", wendys.getInfo());
	}

	@Test
	void testAddReview() {
		User john = new User("john", "Jacob", "jingle");
		Restaurant wendys = new Restaurant("Wendys", "Oxford", "John", "www.wendys.com", "menu", john);

		Review r = new Review(0, "null", john);
		wendys.addReview(r);

		// Getters and setters will help me test this better

		assertTrue(true);
	}

	@Test
	void testGetInfo() {
		User john = new User("john", "Jacob", "jingle");
		Restaurant wendys = new Restaurant("Wendys", "Oxford", "John", "www.wendys.com", "menu", john);

		assertEquals("Oxford Wendys John www.wendys.com menu", wendys.getInfo()[0] + " " + wendys.getInfo()[1] + " " + wendys.getInfo()[2] + " " + wendys.getInfo()[3] + " " + wendys.getInfo()[4]);
	}

	// we need to add getters and setters

}

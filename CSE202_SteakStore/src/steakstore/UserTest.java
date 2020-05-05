package steakstore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void testMakeSubmission() {
		User billybob = new User("bill", "bob", "billybob");
		Restaurant wendys = new Restaurant("hey", "there", "billy", "bob", "joe", "joe", billybob);
		Submission wendy = new Submission(wendys, billybob);
		
		assertTrue(billybob.makeSubmission(wendy));
		
	}

	@Test
	void testChangeInformation() {
		User billybob = new User("bill", "bob", "billybob");
		
		assertTrue(billybob.changeInformation(null, null, "billybilly"));
		assertEquals("billybilly", billybob.getEmail());
		
		assertEquals("bob", billybob.getPassword());
		
		assertEquals("bill", billybob.getUsername());
		
		assertFalse(billybob.changeInformation(null, null, null));
		
		
	}

}

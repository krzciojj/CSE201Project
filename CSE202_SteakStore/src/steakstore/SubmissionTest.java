package steakstore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SubmissionTest{

	@Test
	void StatusTest() {
		Submission sub = new Submission(null);
		assertEquals(sub.checkStatus(), "Restaurant does not exist");

		User u = new User("Username", "password", "u@gmail.com");
		Restaurant r = new Restaurant("Outback", "Cincinnati", "5:00AM - 9:00PM", "5555555555", "www.outback.com", "menu", u, "www.");
		sub = new Submission(r);
		assertEquals(sub.checkStatus(), "aaaaaa");
	}

}

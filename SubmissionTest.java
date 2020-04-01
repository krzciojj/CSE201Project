package steakstore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SubmissionTest extends Submission {

	@Test
	void StatusTest() {
		Restaurant a = new Restaurant(null, null, null, null, null, null);
		assertEquals(checkStatus(a), "Restaurant does not exist");
		
		User u = new User("Username", "password", "u@gmail.com");
		Restaurant r = new Restaurant("Outback", "Cincinnati", "5555555555", "www.outback.com", "menu", u);
		assertEquals(checkStatus(r), "aaaaaa");
	}

}

package steakstore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SubmissionTest{

	@Test
	void StatusTest() {
		User u = new User("Danny", "password", "danny@gmail.com");
		Restaurant r = new Restaurant("Wendy's", "Oxford", "8am-8pm", "5133471111", 
				"www.wendys.com", "www.wendys.xom/menu", u, "www.wendys.com/image" );
		Submission sub = new Submission(r);
		assertEquals(sub.checkStatus(), "Awaiting acceptance");
		sub.setStatus(-1);
		assertEquals(sub.checkStatus(), "Restaurant was denied");
		sub.setStatus(1);
		assertEquals(sub.checkStatus(), "Restaurant accepted");
		sub.setStatus(1000);
		assertEquals(sub.checkStatus(), "Restaurant accepted");
		sub.setStatus(-2);
		assertEquals(sub.checkStatus(), "Restaurant was denied");
		sub.setStatus(0);
		assertEquals(sub.checkStatus(), "Awaiting acceptance");
		
	}

}

package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import steakstore.Restaurant;
import steakstore.Submission;

public class AdminController extends Main implements Initializable {

	@FXML
	ListView<String> submissionsList;

	static Restaurant currentSubmisson;
	ArrayList<Submission> currentSubmissions;
	
	public void searchButtonClick() {
		
	}
	
	public void returnButtonClick() {
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		currentSubmissions = new ArrayList<Submission>();

		for (Submission submission : submissions) {
			submissionsList.getItems().add(submission.getRestaurant().getInfo()[0]);
			currentSubmissions.add(submission);
		}
	}

}

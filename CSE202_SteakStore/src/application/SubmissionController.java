package application;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import steakstore.Restaurant;
import steakstore.Submission;
/**
 * Controls the submission page of the application
 * @author Danny, Grant, Jacob, Jak
 *
 */
public class SubmissionController extends Main {
	@FXML
	Button goBackSubButton;
	/**
	 * Redirects user back to profile page
	 * @throws Exception
	 */
	public void goBackSubButtonClick() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("profile.fxml"));
		goBackSubButton.getScene().setRoot(root);
	}

	@FXML
	TextField name;
	@FXML
	TextField locationAddress;
	@FXML
	TextField hours;
	@FXML
	TextField contact;
	@FXML
	TextArea searchTerms;
	@FXML
	TextField website;
	@FXML
	TextField menu;
	@FXML
	TextField logo;
	@FXML
	Button submitButton;
	/**
	 * Submits entered text to admin for review of restaurant
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void submitButtonClick() throws FileNotFoundException, IOException {
		if (name.getText().equals("") && locationAddress.getText().equals("") && hours.getText().equals("")
				&& contact.getText().equals("") && searchTerms.getText().equals("") && website.getText().equals("")
				&& menu.getText().equals("") && logo.getText().equals("")) {
			// pop up prompting all fields to be filled
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Submission Error");
			alert.setHeaderText("Incomplete Submission");
			alert.setContentText("Please fill out all fields before submitting.");
			alert.showAndWait();
		} else {
			Submission newSubmission = new Submission(
					new Restaurant(name.getText(), locationAddress.getText(), hours.getText(), contact.getText(),
							website.getText(), menu.getText(), currentUser, logo.getText()));
			boolean exists = false;
			for (Restaurant restaurant : restaurants) {
				if (restaurant.getInfo()[0].equals(newSubmission.getRestaurant().getInfo()[0])
						&& restaurant.getInfo()[1].equals(newSubmission.getRestaurant().getInfo()[1])) {
					exists = true;
				}
			}
			if (exists) {
				// pop up prompting valid restaurant submission
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Submission Error");
				alert.setHeaderText("Invalid Submission");
				alert.setContentText("This restaurant already exists in our database.");
				alert.showAndWait();
			} else {
				submissions.add(newSubmission);
				createSubmissionData();
				// pop up confirming submission
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Submission Successful");
				alert.setHeaderText("Restaurant Submitted");
				alert.setContentText(
						"Your restaurant has been submitted. Returning you to your profile. Please check your profile to see the status of your submission.");
				alert.showAndWait();
				
				Parent root = FXMLLoader.load(getClass().getResource("profile.fxml"));
				submitButton.getScene().setRoot(root);
			}
		}
	}

}

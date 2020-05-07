package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import steakstore.Restaurant;
import steakstore.Submission;
/**
 * Controls the admin side of the application
 * @author Danny, Grant, Jacob, Jak
 *
 */
public class AdminController extends CatalogController implements Initializable {

	@FXML
	ListView<String> submissionsList;
	@FXML
	Button returnButton;
	@FXML
	Button preview;
	@FXML
	Button clearButton;
	@FXML
	Button searchButton;
	@FXML
	TextField searchBar;
	@FXML
	Button accept;
	@FXML
	Button deny;

	ArrayList<Submission> currentSubmissions;
/**
 * Deselects a selected item on submission list
 */
	public void clearButtonClick() {
		submissionsList.getSelectionModel().clearSelection();
	}
/**
 * Redirects to profile page once clicked
 */
	public void returnButtonClick() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("profile.fxml"));
		returnButton.getScene().setRoot(root);
	}
/**
 * Previews restaurant once clicked
 * @throws Exception
 */
	public void previewButtonClick() throws Exception {
		if(submissionsList.getSelectionModel().getSelectedIndex() >= 0) {
			Restaurant temp = currentRestaurant;
			currentRestaurant = currentSubmissions.get(submissionsList.getSelectionModel().getSelectedIndex())
					.getRestaurant();
			Parent root = FXMLLoader.load(getClass().getResource("restaurant.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Preview");
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.getScene().getStylesheets().add("application/application.css");
			stage.show();
	
			currentRestaurant = temp;
		}
	}
/**
 * Once clicked, displays restaurants that contain the text entered
 */
	public void searchButtonClick() {
		currentSubmissions.clear();
		submissionsList.getItems().clear();
		if (!searchBar.getText().equals("")) {
			for (Submission submission : submissions) {
				if (submission.getStatus() == 0) {
					if (submission.getRestaurant().getInfo()[0].toLowerCase()
							.contains(searchBar.getText().toLowerCase())
							|| (submission.getRestaurant().getAuthor().getUsername().toLowerCase()
									.contains(searchBar.getText().toLowerCase())
									|| submission.getRestaurant().getAuthor().getEmail().toLowerCase()
											.contains(searchBar.getText().toLowerCase()))) {
						submissionsList.getItems().add(submission.getRestaurant().getInfo()[0]);
						currentSubmissions.add(submission);
					}
				}
			}
		} else {
			for (Submission submission : submissions) {
				if (submission.getStatus() == 0) {
					submissionsList.getItems().add(submission.getRestaurant().getInfo()[0]);
					currentSubmissions.add(submission);
				}
			}
		}
	}
/**
 * Accepts a submission and adds to restaurant list
 * @throws FileNotFoundException
 * @throws IOException
 */
	public void acceptSubmission() throws FileNotFoundException, IOException {
		currentSubmissions.get(submissionsList.getSelectionModel().getSelectedIndex()).setStatus(1);
		addRestaurant(currentSubmissions.get(submissionsList.getSelectionModel().getSelectedIndex()).getRestaurant());
		searchButtonClick();
		createSubmissionData();
	}
/**
 * Rejects a submission
 * @throws FileNotFoundException
 * @throws IOException
 */
	public void denySubmission() throws FileNotFoundException, IOException {
		currentSubmissions.get(submissionsList.getSelectionModel().getSelectedIndex()).setStatus(-1);
		searchButtonClick();
		createSubmissionData();
	}
/**
 * Adds submission to the list of current submissions
 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		currentSubmissions = new ArrayList<Submission>();

		for (Submission submission : submissions) {
			if(submission.getStatus() == 0) {
				submissionsList.getItems().add(submission.getRestaurant().getInfo()[0]);
				currentSubmissions.add(submission);
			}
		}
	}

}

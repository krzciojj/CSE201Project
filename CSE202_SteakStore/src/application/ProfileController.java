package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import steakstore.Submission;
/**
 * Controls the profile page on the application
 * @author Danny, Grant, Jacob, Jak
 *
 */
public class ProfileController extends Main implements Initializable {
	@FXML
	Button submissionButton;
	@FXML
	Text username;
	@FXML
	Text email;
	@FXML
	Button returnToCatalogButton;
	@FXML
	Button reviewButton;
	@FXML
	ListView<String> submissionList;
	
	/**
	 * Opens an admin page to review a submission once clicked
	 * @throws Exception
	 */
	public void reviewButtonClick() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
		reviewButton.getScene().setRoot(root);
	}
	/**
	 * Redirects user to page where user can submit a new restaurant once clicked
	 * @throws Exception
	 */
	public void submissionButtonClick() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("submission page.fxml"));
		submissionButton.getScene().setRoot(root);
	}
	/**
	 * Redirects user back to catalog once clicked
	 * @throws Exception
	 */
	public void returnToCatalogButtonClick() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("catalog.fxml"));
		returnToCatalogButton.getScene().setRoot(root);
	}
/**
 * initializes review button if user is admin
 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(currentUser != null) {
			username.setText(currentUser.getUsername());
			email.setText(currentUser.getEmail());
			if(currentUser.isAdmin())
				reviewButton.setVisible(true);
			for(Submission submission : submissions) {
				if(submission.getRestaurant().getAuthor().getUsername().equals(currentUser.getUsername()))
					submissionList.getItems().add(submission.getRestaurant().getInfo()[0] + ": " + submission.checkStatus());
			}
		}
	}

}

package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;


public class SubmissionController {
	@FXML
	Button goBackSubButton;
	public void goBackSubButtonClick() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("profile.fxml"));
		goBackSubButton.getScene().setRoot(root);
	}

}

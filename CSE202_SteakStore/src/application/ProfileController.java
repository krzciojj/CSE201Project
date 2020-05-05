package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class ProfileController {
	@FXML
	Button submissionButton;
	
	public void submissionButtonClick() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("submission page.fxml"));
		submissionButton.getScene().setRoot(root);
	}

}

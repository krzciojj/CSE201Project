package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

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
	
	public void reviewButtonClick() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
		reviewButton.getScene().setRoot(root);
	}
	
	public void submissionButtonClick() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("submission page.fxml"));
		submissionButton.getScene().setRoot(root);
	}
	public void returnToCatalogButtonClick() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("catalog.fxml"));
		returnToCatalogButton.getScene().setRoot(root);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(currentUser != null) {
			username.setText(currentUser.getUsername());
			email.setText(currentUser.getEmail());
			if(currentUser.isAdmin())
				reviewButton.setVisible(true);
		}
	}

}

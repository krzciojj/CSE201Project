package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	Button loginButton;
	@FXML
	Button goBackButton;
	@FXML
	Button registerButton;

	public void registerButtonClick() throws Exception {
		Parent register = FXMLLoader.load(getClass().getResource("register.fxml"));
		registerButton.getScene().setRoot(register);
	}

	public void loginButtonClick() throws Exception {
		Parent login = FXMLLoader.load(getClass().getResource("catalog.fxml"));
		loginButton.getScene().setRoot(login);

	}

	public void goBackButtonClick() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("steakstore.fxml"));
		goBackButton.getScene().setRoot(root);
	}
}

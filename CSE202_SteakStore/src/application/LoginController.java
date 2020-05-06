package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import steakstore.User;

public class LoginController extends Main {
	@FXML
	TextField username;
	@FXML
	TextField password;
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
		if (username.getText().length() > 0 && password.getText().length() > 0) {
			for(User user : users) {
				if((user.getUsername().equals(username.getText()) || user.getEmail().equals(username.getText()) && user.getPassword().equals(password.getText()))) {
					currentUser = user;
					Parent login = FXMLLoader.load(getClass().getResource("catalog.fxml"));
					loginButton.getScene().setRoot(login);
					return;
				}
			}
			// pop up prompting valid username and/or password
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Login Error");
			alert.setHeaderText("Invalid Login");
			alert.setContentText("Please enter a valid username and password");
			alert.showAndWait();
		} else {
			// pop up prompting username and/or password
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Login Error");
			alert.setHeaderText("Invalid Login");
			alert.setContentText("Please enter a username and password");
			alert.showAndWait();
		}

	}

	public void goBackButtonClick() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("steakstore.fxml"));
		goBackButton.getScene().setRoot(root);
	}
}

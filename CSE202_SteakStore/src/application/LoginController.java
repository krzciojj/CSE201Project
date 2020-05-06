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

/**
 * 
 * @author Danny, Grant, Jacob, Jak Used to implement login functions on
 *         application
 */
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

	/**
	 * Redirects user to registration page when button is clicked
	 * 
	 * @throws Exception
	 */
	public void registerButtonClick() throws Exception {
		Parent register = FXMLLoader.load(getClass().getResource("register.fxml"));
		registerButton.getScene().setRoot(register);
	}

	/**
	 * Reads user input and checks if login credentials are valid. Populates window
	 * to take user to catalog page if correct and populate pop up instructing user
	 * on how to proceed otherwise
	 * 
	 * @throws Exception
	 */
	public void loginButtonClick() throws Exception {
		if (username.getText().length() > 0 && password.getText().length() > 0) {
			for (User user : users) {
				if ((user.getUsername().equals(username.getText()) || user.getEmail().equals(username.getText()))
						&& user.getPassword().equals(password.getText())) {
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
/**
 * Redirects user back to landing page once clicked
 * @throws Exception
 */
	public void goBackButtonClick() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("steakstore.fxml"));
		goBackButton.getScene().setRoot(root);
	}
}

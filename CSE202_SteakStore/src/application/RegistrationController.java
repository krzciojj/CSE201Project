package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.PopupBuilder;
import steakstore.User;

/**
 * Controls the registration page of the application
 * 
 * @author Danny, Grant, Jacob, Jak
 *
 */
public class RegistrationController extends Main {

	private static final long serialVersionUID = 1L;
	@FXML
	Button register;
	@FXML
	Button goBackButton;
	@FXML
	TextField name;
	@FXML
	TextField email;
	@FXML
	TextField password;

	/**
	 * Redirects user back to login screen once clicked
	 * 
	 * @throws Exception
	 */
	public void goBackButtonClick() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		goBackButton.getScene().setRoot(root);
	}

	/**
	 * Handles registration. If registration is successful outputs "successfully
	 * registered" "congratulations", and "sending you back to the login page". Then
	 * proceeds to send used back to login page. If registration is unsuccessful
	 * (not all boxed filled out), displays message to assist user with problem
	 * 
	 * @throws Exception
	 */
	public void registerButtonClick() throws Exception {
		if (!name.getText().equals("") && !email.getText().equals("") && !password.getText().equals("")) {
			User newUser = new User(name.getText(), password.getText(), email.getText());
			addUser(newUser);
			// pop up saying successfully registered and takes user back to login menu
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Sucessfully Registered");
			alert.setHeaderText("Congratulations");
			alert.setContentText("Sending you back to the login page");
			alert.showAndWait();
			Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
			goBackButton.getScene().setRoot(root);
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Registration Unsuccessful");
			alert.setHeaderText("Please exit this window and try again");
			alert.setContentText("Make sure you have filled out all of the textboxes");
			alert.showAndWait();
		}

	}

}

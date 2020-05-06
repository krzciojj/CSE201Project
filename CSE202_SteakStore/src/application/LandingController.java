package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
/**
 * Used to implement landing page of application
 * @author Danny
 *
 */
public class LandingController extends Main implements Initializable {
	@FXML
	Button openCatalogButton;
	@FXML
	Button openLoginButton;
	/**
	 * Redirects user to catalog page when button is clicked
	 * @throws Exception
	 */
	public void openCatalogButtonClick() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("catalog.fxml"));
		openCatalogButton.getScene().setRoot(root);
	}
	/**
	 * Redirects user to login page when button is clicked
	 * @throws Exception
	 */
	public void openLoginButtonClick() throws Exception
	{
		if (openLoginButton.getText().equals("Logout")) {
			currentUser = null;
		}
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		openLoginButton.getScene().setRoot(root);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (currentUser != null) {
			openLoginButton.setText("Logout");
		}
		
	}
}

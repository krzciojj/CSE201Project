package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
/**
 * Used to implement landing page of application
 * @author Danny
 *
 */
public class LandingController {
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
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		openLoginButton.getScene().setRoot(root);
	}
}

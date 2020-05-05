package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class LandingController {
	@FXML
	Button openCatalogButton;
	@FXML
	Button openLoginButton;
	
	public void openCatalogButtonClick() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("catalog.fxml"));
		openCatalogButton.getScene().setRoot(root);
	}
	
	public void openLoginButtonClick() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		openLoginButton.getScene().setRoot(root);
	}
}

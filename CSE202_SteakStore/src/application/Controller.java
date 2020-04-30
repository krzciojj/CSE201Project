package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Controller {
	@FXML
	Button testButton;
	
	public void testButtonClick() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("catalog.fxml"));
		testButton.getScene().setRoot(root);
	}
	
	@FXML
	Button b1;
	Button b2;
	
	public void catalogButtonClick() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("restaurant.fxml"));
		
		b1.getScene().setRoot(root);
	}
}

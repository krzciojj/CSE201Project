package steakstore;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController {
	@FXML
	Button loginButton;
	
	public void loginButtonClicked() throws Exception
	{
		Parent storeLayout = FXMLLoader.load(getClass().getResource("steakstore.fxml"));
		loginButton.getScene().setRoot(storeLayout);
		Scene scene = new Scene(storeLayout, 1000, 500);
		Stage window = (Stage) scene.getWindow();
		window.setScene(scene);
	}
}

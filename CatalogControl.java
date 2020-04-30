package steakstore;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CatalogControl {
	@FXML
	Button restaurantButton;
	
	public void restaurantClicked() throws Exception
	{
		Parent catalogLayout = FXMLLoader.load(getClass().getResource("restaurant.fxml"));
		restaurantButton.getScene().setRoot(catalogLayout);
		Scene scene = new Scene(catalogLayout, 1000, 500);
		Stage window = (Stage) scene.getWindow();
		window.setScene(scene);
	}
}

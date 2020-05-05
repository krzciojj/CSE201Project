package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import steakstore.Restaurant;

public class CatalogController extends Main implements Initializable {

	@FXML
	ListView<String> catalog;
	@FXML
	Button returnButton;
	
	public static Restaurant currentRestaurant;
	
	public void returnButtonClick() throws Exception {
		Parent back = FXMLLoader.load(getClass().getResource("steakstore.fxml"));
		returnButton.getScene().setRoot(back);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		currentRestaurant = null;
		
		for(Restaurant restaurant : restaurants) {
			catalog.getItems().add(restaurant.getInfo()[0]);
		}
		
		catalog.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				Parent root = null;
				try {
					if(catalog.getSelectionModel().getSelectedItem() != null) {
						currentRestaurant = restaurants.get(catalog.getSelectionModel().getSelectedIndex());
						root = FXMLLoader.load(getClass().getResource("restaurant.fxml"));
						catalog.getScene().setRoot(root);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

	}

}

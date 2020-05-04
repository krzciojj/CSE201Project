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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		for(Restaurant restaurant : restaurants) {
			System.out.println(restaurant.getInfo()[0]);
			catalog.getItems().add(restaurant.getInfo()[0]);
		}
		
		catalog.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				Parent root = null;
				try {
					root = FXMLLoader.load(getClass().getResource("restaurant.fxml"));
					catalog.getScene().setRoot(root);
					//catalog.getSelectionModel().getSelectedItem()
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

	}

}

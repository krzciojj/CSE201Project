package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import steakstore.Filter;
import steakstore.Restaurant;

public class CatalogController extends Main implements Initializable {

	@FXML
	ListView<String> catalog;
	@FXML
	Button searchButton;
	@FXML
	TextField searchBar;
	@FXML
	ListView<String> filterList;
	@FXML
	Button userProfileButton;

	static Restaurant currentRestaurant;

	ArrayList<Restaurant> currentRestaurants;

	public void userProfileButtonClick() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("profile.fxml"));
		userProfileButton.getScene().setRoot(root);
	}

	public void searchButtonClick() {
		currentRestaurants.clear();

		catalog.getItems().clear();
		for (String term : filterList.getSelectionModel().getSelectedItems()) {
			for (Restaurant restaurant : restaurants) {
				for (Filter restaurantFilter : restaurant.getSearchTerms()) {
					if (restaurantFilter.getTerm().equals(term)
							&& (restaurant.getInfo()[0].toLowerCase().contains(searchBar.getText().toLowerCase())
									|| searchBar.getText().equals(""))) {
						currentRestaurants.add(restaurant);
					}
				}
			}
		}

		if (filterList.getSelectionModel().getSelectedItems().size() == 0) {
			for (Restaurant restaurant : restaurants) {
				if (restaurant.getInfo()[0].toLowerCase().contains(searchBar.getText().toLowerCase())
						|| searchBar.getText().equals("")) {
					currentRestaurants.add(restaurant);
				}
			}
		}

		for (Restaurant restaurant : currentRestaurants) {
			catalog.getItems().add(restaurant.getInfo()[0]);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		if(currentUser == null)
			userProfileButton.setVisible(false);
		
		// Filters
		for (Filter filter : filters) {
			filterList.getItems().add(filter.getTerm());
		}

		// Catalog
		currentRestaurants = new ArrayList<Restaurant>();

		for (Restaurant restaurant : restaurants) {
			catalog.getItems().add(restaurant.getInfo()[0]);
			currentRestaurants.add(restaurant);
		}

		catalog.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				try {
					if (catalog.getSelectionModel().getSelectedItem() != null) {
						currentRestaurant = currentRestaurants.get(catalog.getSelectionModel().getSelectedIndex());

						Parent root = FXMLLoader.load(getClass().getResource("restaurant.fxml"));
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
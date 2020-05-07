package application;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import steakstore.Restaurant;
import steakstore.Review;

public class RestaurantController extends CatalogController implements Initializable {

	@FXML
	Button returnButton;
	@FXML
	Button menuButton;
	
	Restaurant currRest;

	public void returnButtonClick() throws Exception {
		Parent back = FXMLLoader.load(getClass().getResource("catalog.fxml"));
		returnButton.getScene().setRoot(back);
	}

	public void seeMenuButtonClick() throws Exception {
		if (currRest != null) {
			HBox menu = new HBox();
			WebView menus = new WebView();
			menus.getEngine().load(currRest.getInfo()[5]);
//			ImageView view = new ImageView(menus);

			menu.getChildren().add(menus);
			Stage stage = new Stage();
			stage.setTitle("Menu");
			stage.setScene(new Scene(menu, 700, 600));
			stage.show();
		}
	}

	@FXML
	Button reviewButton;
	public void addReview() throws Exception {
		Parent back = FXMLLoader.load(getClass().getResource("review.fxml"));
		Stage stage = new Stage();
		stage.setTitle("Review");
		stage.setScene(new Scene(back, 600, 300));
		stage.show();
		reviewButton.setVisible(false);
	}
	
	public void sendToContact() throws Exception {
		if (currentRestaurant != null) {
			getHostServices().showDocument(currentRestaurant.getInfo()[3]);
		}
	}

	@FXML
	Text titleText;
	@FXML
	Text locationText;
	@FXML
	Text hoursText;
	@FXML
	ImageView viewImage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for (Restaurant restaurant : restaurants) {
			if (restaurant.getInfo()[0].equals(currentRestaurant.getInfo()[0])
					&& restaurant.getInfo()[1].equals(currentRestaurant.getInfo()[1])) {
				returnButton.setVisible(true);
				if (currentUser != null){
					reviewButton.setVisible(true);
					for (Review review : currentRestaurant.getReviews()) {
						if(review.getAuthor().getUsername().equals(currentUser.getUsername())){
							reviewButton.setVisible(false);
						}
						
					}
				}
			}
		}
		
		if (currentRestaurant != null) {
			currRest = currentRestaurant;
			titleText.setText(currentRestaurant.getInfo()[0]);
			locationText.setText(currentRestaurant.getInfo()[1]);
			hoursText.setText(currentRestaurant.getInfo()[2]);
			String path = currentRestaurant.getInfo()[6];
			viewImage.setImage(new Image(path));
		}
	}
}

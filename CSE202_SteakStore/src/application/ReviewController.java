package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import steakstore.Review;

public class ReviewController extends RestaurantController{

	
	@FXML
	Button starOne;
	
	public void addReview1() {
		
		Review got = new Review(1, currentUser);
		currentRestaurant.addReview(got); 
		Stage name = (Stage)starOne.getScene().getWindow();
		name.close();
	}
	
	@FXML
	Button starTwo;
	
	public void addReview2() {
		Review got = new Review(1, currentUser);
		currentRestaurant.addReview(got); 
		Stage name = (Stage)starOne.getScene().getWindow();
		name.close();
	}
	
	@FXML
	Button starThree;
	
	public void addReview3() {
		Review got = new Review(1, currentUser);
		currentRestaurant.addReview(got); 
		Stage name = (Stage)starOne.getScene().getWindow();
		name.close();
	}
	
	@FXML
	Button starFour;
	
	public void addReview4() {
		Review got = new Review(1, currentUser);
		currentRestaurant.addReview(got); 
		Stage name = (Stage)starOne.getScene().getWindow();
		name.close();
	}
	
	@FXML
	Button starFive;
	
	public void addReview5() {
		Review got = new Review(1, currentUser);
		currentRestaurant.addReview(got); 
		Stage name = (Stage)starOne.getScene().getWindow();
		name.close();
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}

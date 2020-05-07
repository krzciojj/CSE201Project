package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import steakstore.Review;

public class ReviewController extends RestaurantController{

	
	@FXML
	Button starOne;
	
	public void addReview1() throws FileNotFoundException, IOException {
		Review got = new Review(1, currentUser);
		currentRestaurant.addReview(got); 
		Stage name = (Stage)starOne.getScene().getWindow();
		name.close();
		createRestaurantData();
	}
	
	@FXML
	Button starTwo;
	
	public void addReview2() throws FileNotFoundException, IOException {
		Review got = new Review(2, currentUser);
		currentRestaurant.addReview(got); 
		Stage name = (Stage)starTwo.getScene().getWindow();
		name.close();
		createRestaurantData();
	}
	
	@FXML
	Button starThree;
	
	public void addReview3() throws FileNotFoundException, IOException {
		Review got = new Review(3, currentUser);
		currentRestaurant.addReview(got); 
		Stage name = (Stage)starThree.getScene().getWindow();
		name.close();
		createRestaurantData();
	}
	
	@FXML
	Button starFour;
	
	public void addReview4() throws FileNotFoundException, IOException {
		Review got = new Review(4, currentUser);
		currentRestaurant.addReview(got); 
		Stage name = (Stage)starFour.getScene().getWindow();
		name.close();
		createRestaurantData();
	}
	
	@FXML
	Button starFive;
	
	public void addReview5() throws FileNotFoundException, IOException {
		Review got = new Review(5, currentUser);
		currentRestaurant.addReview(got); 
		Stage name = (Stage)starFive.getScene().getWindow();
		name.close();
		createRestaurantData();
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}

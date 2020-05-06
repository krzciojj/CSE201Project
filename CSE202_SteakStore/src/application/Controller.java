package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.Window;
/**
 * Used to implement main controls of application
 * @author Danny
 *
 */
public class Controller {
	
	
	// Landing Page Controller
	@FXML
	Button openCatalogButton;
	@FXML
	Button openLoginButton;
	/**
	 * Redirects user to catalog page when button is clicked
	 * @throws Exception
	 */
	public void openCatalogButtonClick() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("catalog.fxml"));
		openCatalogButton.getScene().setRoot(root);
	}
	/**
	 * Redirects user to login page when button is clicked
	 * @throws Exception
	 */
	public void openLoginButtonClick() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		openLoginButton.getScene().setRoot(root);
	}
	
	
	// Catalog Controller
	@FXML
	Button b1;
	@FXML
	Button b2;
	/**
	 * Redirects user to restaurant page when button is clicked
	 * @throws Exception
	 */
	public void restaurantButtonClick() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("restaurant.fxml"));
		
		b1.getScene().setRoot(root);
	}
	
	// Login Controller
	@FXML
	Button loginButton;
	@FXML
	Button goBackButton;
	@FXML
	Button returnButton;
	@FXML
	Button menuButton;
	@FXML
	Button registerButton;
	@FXML
	Button returnToLoginButton;
	/**
	 * Redirects user to rgistration page when button is clicked
	 * @throws Exception
	 */
	public void registerButtonClick() throws Exception {
		Parent register = FXMLLoader.load(getClass().getResource("register.fxml"));
		registerButton.getScene().setRoot(register);
	}
	/**
	 * Redirects user back to login page when button is clicked
	 * @throws Exception
	 */
	public void returnToLoginButtonClick() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		returnToLoginButton.getScene().setRoot(root);
	}
	/**
	 * Redirects user to catalog page when correct login credentials are entered
	 * @throws Exception
	 */
	public void loginButtonClick() throws Exception
	{
		Parent login = FXMLLoader.load(getClass().getResource("catalog.fxml"));
		loginButton.getScene().setRoot(login);
		
	}
	/**
	 * Redirects user back to landing page when button is clicked
	 * @throws Exception
	 */
	public void goBackButtonClick() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("steakstore.fxml"));
		goBackButton.getScene().setRoot(root);
	}
	/**
	 * Redirects user back to catalog when button is clicked
	 * @throws Exception
	 */
	public void returnButtonClick() throws Exception 
	{
		Parent back = FXMLLoader.load(getClass().getResource("catalog.fxml"));
		returnButton.getScene().setRoot(back);
	}
	/**
	 * Redirects user to a pdf of the menu in a new window when button is clicked
	 * @throws Exception
	 */
	public void seeMenuButtonClick() throws Exception
	{
		HBox menu = new HBox();
		Image menus = new Image("menu.jpg");
		ImageView view = new ImageView(menus);
		
		menu.getChildren().add(view);
        Stage stage = new Stage();
        stage.setTitle("Menu");
        stage.setScene(new Scene(menu, 700, 600));
        stage.show();
	}
}

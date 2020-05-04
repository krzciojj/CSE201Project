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

public class Controller {
	
	
	// Landing Page Controller
	@FXML
	Button openCatalogButton;
	@FXML
	Button openLoginButton;
	
	public void openCatalogButtonClick() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("catalog.fxml"));
		openCatalogButton.getScene().setRoot(root);
	}
	
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
	
	public void registerButtonClick() throws Exception {
		Parent register = FXMLLoader.load(getClass().getResource("register.fxml"));
		registerButton.getScene().setRoot(register);
	}
	public void returnToLoginButtonClick() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		returnToLoginButton.getScene().setRoot(root);
	}
	public void loginButtonClick() throws Exception
	{
		Parent login = FXMLLoader.load(getClass().getResource("catalog.fxml"));
		loginButton.getScene().setRoot(login);
		
	}
	
	public void goBackButtonClick() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("steakstore.fxml"));
		goBackButton.getScene().setRoot(root);
	}
	
	public void returnButtonClick() throws Exception 
	{
		Parent back = FXMLLoader.load(getClass().getResource("catalog.fxml"));
		returnButton.getScene().setRoot(back);
	}
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

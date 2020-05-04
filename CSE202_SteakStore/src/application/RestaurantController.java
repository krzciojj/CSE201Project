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

public class RestaurantController {

	@FXML
	Button returnButton;
	@FXML
	Button menuButton;

	public void returnButtonClick() throws Exception {
		Parent back = FXMLLoader.load(getClass().getResource("catalog.fxml"));
		returnButton.getScene().setRoot(back);
	}

	public void seeMenuButtonClick() throws Exception {
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

package steakstore;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GUI extends Application
{
	@FXML
	Parent layout1;
	Parent layout2;
	Scene scene;
    Scene store;
    Stage window;
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@FXML
    public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		layout1 = FXMLLoader.load(getClass().getResource("login.fxml"));
		layout2 = FXMLLoader.load(getClass().getResource("steakstore.fxml"));
        scene = new Scene(layout1, 500, 400);
        store = new Scene(layout2, 1000, 500);
        window.setTitle("SteakStore");
        window.setScene(scene);
        window.show();
    }
}

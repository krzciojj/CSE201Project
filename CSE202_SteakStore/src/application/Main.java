package application;
	
import javafx.application.Application;
import application.Controller;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class Main extends Application{
	
	Button button;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("steakstore.fxml"));
		primaryStage.setTitle("Steak Store");
		primaryStage.setScene(new Scene(root, 500, 275));
		primaryStage.show();		

	}

	
}

package steakstore;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GUI extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	/**
	 * Startup method for the GUI
	 */
	public void start(Stage primaryStage) {
		Button btn = new Button();
		btn.setText("ok");
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("SteakStore");
		primaryStage.show();
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("test");
			}
		});
	}
}

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Main extends Application{
	
	Button button;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Steak Store");
		
		button = new Button();
		button.setText("Wendys");
		
		StackPane layout = new StackPane();
		StackPane layout2 = new StackPane();
		
		layout.getChildren().add(button);
		
		Scene inside = new Scene(layout2, 1000, 800);		
		Scene restuarunt = new Scene(layout, 300, 250);
		
		primaryStage.setScene(restuarunt);
		primaryStage.show();
		
		
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setTitle("Wendys");
				primaryStage.setScene(inside);
				primaryStage.show();
				
				
			}
			
		});
		
		
		
		
		

	}

	
}

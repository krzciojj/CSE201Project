package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.PopupBuilder;
import steakstore.User;


public class RegistrationController extends Main{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@FXML
	Button register;
	@FXML
	Button goBackButton;
	@FXML
	TextField name;
	@FXML
	TextField email;
	@FXML
	TextField password;
	
	public void goBackButtonClick() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		goBackButton.getScene().setRoot(root);
	}
	
	public void registerButtonClick() throws Exception {
		if(name.getText() != null && email.getText() != null && password.getText() != null)
		{
			User newUser = new User (name.getText(), password.getText(), email.getText());
			addUser(newUser);
			System.out.println("test");
			//pop up saying successfully registered and takes user back to login menu
		}
		else
		{
			//implement error message here once i figure out how to make a pop up window
		}
			
			
	}
	
}

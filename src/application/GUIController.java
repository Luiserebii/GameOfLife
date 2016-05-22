package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GUIController implements Initializable {

	@FXML
	private TextField lengthField, widthField;

	@FXML
	private Label messageLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public int getLength(){
		return Integer.valueOf(lengthField.getText());
	}

	public int getWidth(){
		return Integer.valueOf(widthField.getText());
	}

}

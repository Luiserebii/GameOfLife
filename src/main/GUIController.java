package main;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import gameoflife.GameOfLifeLogic;
import gameoflife.GameOfLifeLoop;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GUIController implements Initializable {

	@FXML
	private TextField lengthField, widthField, colorField;

	@FXML
	private Label colorLabel, messageLabel;

	@FXML
	private ComboBox seedBox;

	@FXML
	private CheckBox rainbowBox, chaosBox;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	private void startGameOfLife(){

		int sL = getLength();
		int sW = getWidth();

		if(sL == 90000 || sW == 90000){
			messageLabel.setText("Length or width is not a number; check input");
		} else if(sL < 1 || sW < 1){
			messageLabel.setText("Number in field cannot be negative or non-zero");
		} else {

			Stage s = new Stage();
			Group root = new Group();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
			s.setScene(scene);
			s.setTitle("The Game of Life");

			GameOfLifeLogic gll = new GameOfLifeLogic(sL,sW);
			Canvas canvas = new Canvas(sL,sW); //600,400
			root.getChildren().add(canvas);
			GraphicsContext gc = canvas.getGraphicsContext2D();

			GameOfLifeLoop gl = new GameOfLifeLoop(gc,gll);
			s.setOnCloseRequest(event -> {
			    gl.setIsRunning(false);
			});
			gl.setup();
			gl.start();

			s.show();
		}

	}

	public int getLength(){
		int l;
		try {
			l = Integer.valueOf(lengthField.getText());
		} catch(Exception e){
			l = 90000; //No one will use this number, so it should be safe to use
		}
		return l;
	}

	public int getWidth(){
		int w;
		try {
			w = Integer.valueOf(widthField.getText());
		} catch(Exception e){
			w = 90000; //No one will use this number, so it should be safe to use
		}
		return w;
	}



}

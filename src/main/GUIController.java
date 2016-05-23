package main;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import gameoflife.GameOfLifeLogic;
import gameoflife.GameOfLifeLogic.LogicBuilder;
import gameoflife.GameOfLifeLoop;
import gameoflife.GameOfLifeLoop.LoopBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIController implements Initializable {

	private LoopBuilder loopbuilder;
	private LogicBuilder logicbuilder;

	private MediaPlayer mplayer;

	private final String lotOn = "music/soundfx/lensoftruth_on.mp3";
	private final String lotOff = "music/soundfx/lensoftruth_off.mp3";

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
		ObservableList<String> seedList = FXCollections.observableArrayList("Random Board", "10 Cell Seed");
		seedBox.setItems(seedList);

		loopbuilder = new LoopBuilder();
		logicbuilder = new LogicBuilder();

		colorField.setText("SPRINGGREEN");
		colorLabel.setBackground(new Background(new BackgroundFill(Color.SPRINGGREEN, CornerRadii.EMPTY, Insets.EMPTY)));

	}

	@FXML
	private void startGameOfLife(){

		int sL, sW;
		try {
			sL = getLength();
			sW = getWidth();

			if(sL < 1 || sW < 1){
				messageLabel.setText("Number in field cannot be negative or non-zero");
			} else {

				Stage s = new Stage();
				Group root = new Group();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
				s.setScene(scene);
				s.setTitle("The Game of Life");

				GameOfLifeLogic gll = new GameOfLifeLogic(sL,sW,logicbuilder);
				Canvas canvas = new Canvas(sL,sW); //600,400
				root.getChildren().add(canvas);
				GraphicsContext gc = canvas.getGraphicsContext2D();

				GameOfLifeLoop gl = new GameOfLifeLoop(gc, gll, loopbuilder);
				s.setOnCloseRequest(event -> {
				    gl.setIsRunning(false);
				});
				gl.setup();
				gl.start();

				s.show();
			}
		} catch(NumberFormatException e){
			messageLabel.setText("Length or width is not a number; check input");
		}

	}

	@FXML
	public void setSeed(){
		String seed = (String) seedBox.getSelectionModel().getSelectedItem();
		if(seed != null){ //Fixes bug with ComboBox; interesting consequence of JavaFX Combobox is that opening the box, and clicking outside it, sets SelectionModel's item to null; conditional to prevent null being set
			loopbuilder.setSeed(seed);
		}
	}

	@FXML
	public void setColor(KeyEvent e){

		if(e.getCode() == KeyCode.ENTER){

			Color color;

			try {
				color = Color.web(colorField.getText().trim().toUpperCase()); //auto uppercase for convenience
				colorLabel.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));

			} catch(IllegalArgumentException ex){
				messageLabel.setText("Not a color");
				color = (Color) colorLabel.getBackground().getFills().get(0).getFill();
			}

			loopbuilder.setColor(color);

		}
	}

	@FXML
	public void toggleRainbow(){
		if(rainbowBox.isSelected()){
			loopbuilder.setIsRainbow(true);
			System.out.println("RAINBOW: Set to true!");
			colorField.setEditable(false);
			colorLabel.setStyle("-fx-opacity: 0.5;");
			colorField.setStyle("-fx-opacity: 0.5;");
		} else {
			loopbuilder.setIsRainbow(false);
			System.out.println("RAINBOW: Set to false...");
			colorField.setEditable(true);
			colorLabel.setStyle("-fx-opacity: 1.0;");
			colorField.setStyle("-fx-opacity: 1.0;");
		}
	}

	@FXML
	public void toggleChaos(){
		if(chaosBox.isSelected()){
			logicbuilder.setIsChaos(true);
			mplayer = new MediaPlayer(new Media(new File(lotOn).toURI().toString()));
			mplayer.play();
			System.out.println("CHAOS: Set to true!");
		} else {
			logicbuilder.setIsChaos(false);
			mplayer = new MediaPlayer(new Media(new File(lotOff).toURI().toString()));
			mplayer.play();
			System.out.println("CHAOS: Set to false...");
		}
	}

	public int getLength() throws NumberFormatException{
		return Integer.valueOf(lengthField.getText());
	}

	public int getWidth() throws NumberFormatException{
		return Integer.valueOf(widthField.getText());
	}



}

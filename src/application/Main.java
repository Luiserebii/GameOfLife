package application;

import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//			Group root = new Group();
//			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.setTitle("The Game of Life");
//
//			Scanner sc = new Scanner(System.in);
//			System.out.println("Enter Length and Width");
//			int sL = sc.nextInt();
//			int sW = sc.nextInt();
//			GameOfLifeLogic gll = new GameOfLifeLogic(sL,sW);
//
//			Canvas canvas = new Canvas(sL,sW); //600,400
//			root.getChildren().add(canvas);
//
//			GraphicsContext gc = canvas.getGraphicsContext2D();
//
//			GameOfLifeLoop gl = new GameOfLifeLoop(gc,gll);
//			gl.setup();
//			gl.start();
//
//
//			primaryStage.show();

			Parent root = FXMLLoader.load(getClass().getResource("../view/GUI.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Game of Life Settings");
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

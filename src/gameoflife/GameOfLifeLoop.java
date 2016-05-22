package gameoflife;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameOfLifeLoop extends AnimationTimer{

	private GraphicsContext gc;
	private GameOfLifeLogic gl;
	private Cell[][] cellBoard;

	private boolean isRunning;

	//=========== Control variables used for settings

	private String seed;
	private Color color;
	private boolean isRainbow;

	//===========


	//Making Builder class to simplify constructor/setting; GameOfLifeLogic needs to be passed to make a GLL, and perhaps bad design to allow for constructor without necessary component
	//Utilizing similar Builder pattern from Effective Java; is this a good decision?
	public static class LoopBuilder {

		private String seed = "Random Board";
		private Color color = Color.SPRINGGREEN;
		private boolean isRainbow = false;

		public void setSeed(String inSeed) { seed = inSeed; }
		public void setColor(Color inColor) { color = inColor; }
		public void setIsRainbow(boolean inRainbow) { isRainbow = inRainbow; }

	}

	public GameOfLifeLoop(GraphicsContext inGC, GameOfLifeLogic inGL, LoopBuilder b){

		gc = inGC;
		gl = inGL;
		isRunning = true;

		seed = b.seed;
		color = b.color;
		isRainbow = b.isRainbow;
	}

	public void setup(){

		gl.clearBoard();

		if(seed.equals("Random Board")){
			gl.randomBoard();
		}
		if(seed.equals("10 Cell Seed")){
			gl.tenCellSeed();
		}
	}

	@Override
	public void handle(long now) {
		// TODO Auto-generated method stub
		if(isRunning){
			cellBoard = gl.getCellBoard();
			drawCellBoard(cellBoard);
			int[] boardSize = gl.getSize();

			gc.setStroke(Color.BLACK);
			gc.setLineWidth(2);

			for(int i = 0; i*10 < boardSize[1] + 1; i++){ //draws horizontal lines 401

				int yLine = i*10;
				gc.strokeLine(0,yLine,boardSize[0],yLine); //600

			}

			for(int i = 0; i*10 < boardSize[0] + 1; i++){ //draws vertical lines 601

				int xLine = i*10;
				gc.strokeLine(xLine,0,xLine,boardSize[1]); //400

			}

			gl.checkRulesOfLife();
			gl.setTempStates();

			try {
			    Thread.sleep(100);                 //1000 milliseconds is one second. 100 is a good speed
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
	}

	public void drawCellBoard(Cell[][] cellBoard){

		for(int i = 0; i < cellBoard.length; i++){
			for(int j = 0; j < cellBoard[0].length; j++){

				if(cellBoard[i][j].getState() == 0){

					gc.setFill(Color.BLACK); //was WHITE GREEN is so cool!!!
					gc.fillRect(j*10,i*10,10,10); //reversed b/c row/column --> y/x
				}
				if(cellBoard[i][j].getState() == 1){

					if(isRainbow){
						Random rand = new Random();
						int r = rand.nextInt(256);
						int g = rand.nextInt(256);
						int b = rand.nextInt(256);
						gc.setFill(Color.rgb(r,g,b));
					} else {
						gc.setFill(color);
					}
					gc.fillRect(j*10,i*10,10,10);
				}



			}
		}

	}

	public void setIsRunning(boolean isRun){
		isRunning = isRun;
	}

	public String getSeed(){ return seed; }

	public void setSeed(String inSeed){ seed = inSeed; }


}

package application;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameOfLifeLoop extends AnimationTimer{

	GraphicsContext gc;
	GameOfLifeLogic gl = new GameOfLifeLogic();
	Cell[][] cellBoard;

	public GameOfLifeLoop(GraphicsContext inGC){

		gc = inGC;


	}

	@Override
	public void handle(long now) {
		// TODO Auto-generated method stub
		
		gl.clearBoard();
		gl.randomBoard();
		cellBoard = gl.getCellBoard();
		drawCellBoard(cellBoard);
		
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);

		for(int i = 0; i*10 < 401; i++){ //draws horizontal lines

			int yLine = i*10;
			gc.strokeLine(0,yLine,600,yLine);

		}

		for(int i = 0; i*10 < 601; i++){ //draws vertical lines

			int xLine = i*10;
			gc.strokeLine(xLine,0,xLine,400);

		}



	}

	public void drawCellBoard(Cell[][] cellBoard){

		for(int i = 0; i < cellBoard.length; i++){
			for(int j = 0; j < cellBoard[0].length; j++){
				
				if(cellBoard[i][j].getState() == 0){
					
					gc.setFill(Color.WHITE);
					gc.fillRect(i*10,j*10,10,10);
				}
				if(cellBoard[i][j].getState() == 1){
					
					gc.setFill(Color.SPRINGGREEN);
					gc.fillRect(i*10,j*10,10,10);
				}



			}
		}

	}






}

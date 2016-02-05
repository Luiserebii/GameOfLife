package application;

import java.util.Random;

public class GameOfLifeLogic {

	public Cell[][] cellBoard = new Cell[60][40];



	public void clearBoard(){

		for(int i = 0; i < cellBoard.length; i++){
			for(int j = 0; j < cellBoard[0].length; j++){

				//System.out.println(i + " " + j + " " + cellBoard.length);
				cellBoard[i][j] = new Cell();

			}
		}

	}

	public void randomBoard(){

		Random rand = new Random();
		for(int i = 0; i < cellBoard.length; i++){
			for(int j = 0; j < cellBoard[0].length; j++){
				int randomInt = rand.nextInt(2);
				//System.out.println(i + " " + j);
				//System.out.println(cellBoard[i][j] == null);
				if(randomInt == 0){
					cellBoard[i][j].setState(0);
				}
				if(randomInt == 1){
					cellBoard[i][j].setState(1);
				}


			}
		}


	}

	public int getNeighbors(int i, int j){




		return

	}

	public Cell[][] getCellBoard(){

		return cellBoard;
	}



}

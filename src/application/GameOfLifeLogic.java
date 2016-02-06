package application;

import java.util.Random;

public class GameOfLifeLogic {

	//public Cell[][] cellBoard = new Cell[60][40];
	private Cell[][] cellBoard; //note x and y is reversed b/c row/column --> y/x

	private int sizeLength = 600;
	private int sizeWidth = 400;

	public GameOfLifeLogic(int sL, int sW){

		sizeLength = sL;
		sizeWidth = sW;
		cellBoard = new Cell[sizeWidth/10][sizeLength/10];

	}

	public int[] getSize(){

		int[] arrSize = new int[2];
		arrSize[0] = sizeLength;
		arrSize[1] = sizeWidth;
		return arrSize;

	}

	public void clearBoard(){

		for(int i = 0; i < cellBoard.length; i++){
			for(int j = 0; j < cellBoard[0].length; j++){

				//System.out.println(i + " " + j + " " + cellBoard.length);
				cellBoard[i][j] = new Cell();
				//System.out.println(j + "  " + i);

			}
		}

	}

	public void randomBoard(){

		Random rand = new Random();
		for(int i = 0; i < cellBoard.length; i++){
			for(int j = 0; j < cellBoard[0].length; j++){
				int randomInt = rand.nextInt(2); //2
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

	public void tenCellSeed(){

		for(int i = 0; i < 10; i++){

			cellBoard[((sizeWidth/10)/2)-1][i+(((sizeLength/10)/2)-5)].setState(1); //19 i+25


		}
	}

	public void checkRulesOfLife(){

		for(int i = 0; i < cellBoard.length; i++){
			for(int j = 0; j < cellBoard[0].length; j++){

				//System.out.println(i + "    " + j);
				int neighborInt = getNeighbors(i,j);

				if(cellBoard[i][j].getState() == 1){
					if(neighborInt <= 1){ //if one or no neighbors
						//cellBoard[i][j].setState(0); //dies
						cellBoard[i][j].setTempState(0);
					}
					if(neighborInt >= 4){ //if four or more neighbors TRY JUST 5 OR MORE LEAVE 2/3 TRIPPY AF, WITH 10 SEED
						//cellBoard[i][j].setState(0); //DIE
						cellBoard[i][j].setTempState(0);
					}
					if(neighborInt == 2 || neighborInt == 3){ //if two or three neighbors
						//stays alive
						cellBoard[i][j].setTempState(1);
					}
				}

				if(cellBoard[i][j].getState() == 0){ //If dead
					if(neighborInt == 3){ //if three neighbors
						//cellBoard[i][j].setState(1); //I LIIIIIIIIIIIIIIIIIIVEEE!!!!
						cellBoard[i][j].setTempState(1);
					}
				}

//For a space that is 'populated':
//    Each cell with one or no neighbors dies, as if by solitude.
//    Each cell with four or more neighbors dies, as if by overpopulation.
//    Each cell with two or three neighbors survives.
//For a space that is 'empty' or 'unpopulated'
//    Each cell with three neighbors becomes populated.
			}
		}

	}

	public void setTempStates(){

		for(int i = 0; i < cellBoard.length; i++){
			for(int j = 0; j < cellBoard[0].length; j++){

				int tempState = cellBoard[i][j].getTempState();
				cellBoard[i][j].setState(tempState);
			}
		}

	}

	public int getNeighbors(int i, int j){

		int neighborInt = 0;
		boolean isGotRight = true;
		boolean isGotLeft = true;
		boolean isGotUp = true;
		boolean isGotDown = true;

		if(j < 1){ //left boundary + 1 SOMETHING TO REFACTOR FOR HEIGHT/WIDTH
			isGotLeft = false;
		}
		if(j > ((sizeLength/10)-2)){ //right boundary - 1    58
			isGotRight = false;
		}
		if(i < 1){
			isGotUp = false;
		}
		if(i > ((sizeWidth/10)-2)){  //j is x, i is y 38
			isGotDown = false;
		}

		//System.out.println(j + " " + i + " " + (i>38));

		if(isGotLeft){ //if its got neighbors to the left of it
			if(cellBoard[i][j-1].getState() == 1){ //check the direct left
				neighborInt++;
			}
			if(isGotUp){ //if neighbor left-up
				if(cellBoard[i-1][j-1].getState() == 1){
					neighborInt++;
				}
			}
			if(isGotDown){ //if neighbor left-down
				if(cellBoard[i+1][j-1].getState() == 1){
					neighborInt++;
				}
			}

		}
		if(isGotRight){ //if its got neighbors to the right of it
			if(cellBoard[i][j+1].getState() == 1){
				neighborInt++;
			}
			if(isGotUp){ //if neighbor right-up
				if(cellBoard[i-1][j+1].getState() == 1){
					neighborInt++;
				}
			}
			if(isGotDown){ //if neighbor right-down
				if(cellBoard[i+1][j+1].getState() == 1){
					neighborInt++;
				}
			}
		}
		//So far, we have checked all left (left-direct, left-up, left-down) and all right - but could still be up and down pure
		if(isGotUp){
			if(cellBoard[i-1][j].getState() == 1){
				neighborInt++;
			}
		}
		if(isGotDown){
			if(cellBoard[i+1][j].getState() == 1){
				neighborInt++;
			}
		}



		return neighborInt;

	}

	public Cell[][] getCellBoard(){

		return cellBoard;
	}



}

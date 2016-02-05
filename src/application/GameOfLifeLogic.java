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
	
	public void tenCellSeed(){
		
		for(int i = 0; i < 10; i++){
			
			cellBoard[i + 20][19].setState(1);
			
			
		}		
	}

	public void checkRulesOfLife(){

		for(int i = 0; i < cellBoard.length; i++){
			for(int j = 0; j < cellBoard[0].length; j++){

				//System.out.println(i + "    " + j);
				int neighborInt = getNeighbors(i,j);
				if(neighborInt > 0){
				System.out.println(neighborInt);}

				if(cellBoard[i][j].getState() == 1){
					if(neighborInt <= 1){ //if one or no neighbors
						cellBoard[i][j].setState(0); //dies
					}
					if(neighborInt >= 4){ //if four or more neigbors
						cellBoard[i][j].setState(0); //DIE
					}
					if(neighborInt == 2 || neighborInt == 3){ //if two or three neighbors
						//stays alive
					}
				}

				if(cellBoard[i][j].getState() == 0){ //If dead
					if(neighborInt == 3){ //if three neighbors
						cellBoard[i][j].setState(1); //I LIIIIIIIIIIIIIIIIIIVEEE!!!!
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

	public int getNeighbors(int i, int j){

		int neighborInt = 0;
		boolean isGotRight = true;
		boolean isGotLeft = true;
		boolean isGotUp = true;
		boolean isGotDown = true;

		if(i < 1){ //left boundary + 1 SOMETHING TO REFACTOR FOR HEIGHT/WIDTH
			isGotLeft = false;
		}
		if(i > 58){ //right boundary - 1
			isGotRight = false;
		}
		if(j < 1){
			isGotUp = false;
		}
		if(j > 38){
			isGotDown = false;
		}

		if(isGotLeft){ //if its got neighbors to the left of it
			if(cellBoard[i-1][j].getState() == 1){ //check the direct left
				neighborInt++;
			}
			if(isGotUp){ //if neighbor left-up
				if(cellBoard[i-1][j-1].getState() == 1){
					neighborInt++;
				}
			}
			if(isGotDown){ //if neighbor left-down
				if(cellBoard[i-1][j+1].getState() == 1){
					neighborInt++;
				}
			}

		}
		if(isGotRight){ //if its got neighbors to the right of it
			if(cellBoard[i+1][j].getState() == 1){
				neighborInt++;
			}
			if(isGotUp){ //if neighbor right-up
				if(cellBoard[i+1][j-1].getState() == 1){
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
			if(cellBoard[i][j-1].getState() == 1){
				neighborInt++;
			}
		}
		if(isGotDown){
			if(cellBoard[i][j+1].getState() == 1){
				neighborInt++;
			}
		}



		return neighborInt;

	}

	public Cell[][] getCellBoard(){

		return cellBoard;
	}



}

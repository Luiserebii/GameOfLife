package application;

public class Cell {

	public int state;


	public Cell(){

		state = 0; //0 meaning dead, 1 being alive

	}

	public void setState(int inState){

		state = inState;

	}

	public int getState(){

		return state;

	}

	public String toString(){

		return "State: " + state;
	}

}

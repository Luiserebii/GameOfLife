package application;

public class Cell {

	public int state;
	int tempState;


	public Cell(){

		state = 0; //0 meaning dead, 1 being alive
		tempState = 0;
	}

	public void setTempState(int inTempState){

		tempState = inTempState;
	}

	public void setState(int inState){

		state = inState;
	}

	public int getTempState(){
		return tempState;
	}

	public int getState(){
		return state;
	}

	public String toString(){
		return "State: " + state;
	}

}

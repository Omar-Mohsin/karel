/*
 * File: BlankKarel.java
 * ---------------------
 * This class is a blank one that you can change at will.
*/
import stanford.karel.*;
public class BlankKarel extends SuperKarel {
	private int counterMoves = 0;
	private int X ;
	private int Y ;
	public void run() {
		System.out.println("the area of the world "+ area());
		System.out.println("the value of X = " + X);
		System.out.println("the value of Y = " + Y  );
		if(Y>X){
			System.out.println("this world cannot be divided ");
		} else {
			makeACrossLines();
			makeSquare();
			System.out.println("the moves are "+ counterMoves);
		}
	}
	private int countX(){
		int row = 1;
		while(frontIsClear()){
			move();
			row++;
			counterMoves++;
		}
		 X = row;
		return row;
	}
	private int countY(){
		turnLeft();
		int column = 1 ;
		while(frontIsClear()){
			move();
			column++;
			counterMoves++;
		}
		Y = column;
		return column;
	}
	private int area(){
		return countX() * countY();
	}
	private void middleOfX(){
		turnLeft();
		for(int i=1; i<=X/2;i++){
			move();
			counterMoves++;
		}
		turnLeft();
		while(frontIsClear()){
			putBeeper();
			move();
			counterMoves++;
		}
		putBeeper();
		if(X%2==0){
			turnLeft();
			move();
			turnLeft();
			while(frontIsClear()){
				if(!beepersPresent()) {
					putBeeper();
				}
				move();
				counterMoves++;
			}
			putBeeper();
		}
	}
	private void middleOfY(){
		turnAround();
		for(int i=1; i<=Y/2;i++){
			move();
			counterMoves++;
		}
		turnLeft();
		while(frontIsClear()){
			move();
			counterMoves++;
		}
		turnAround();
		putBeeper();
		while(frontIsClear()){
			move();
			if(!beepersPresent()){
				putBeeper();
			}
			counterMoves++;
		}
		if(Y%2==0){
			turnRight();
			move();
			turnRight();
			while(frontIsClear()){
				if(!beepersPresent()){
					putBeeper();
				}
				move();
			}
			putBeeper();
		}
	}
	private void makeACrossLines(){
		middleOfX();
		middleOfY();
	}
	private void makeSquare(){
		turnAround();

		// first section start the sq

		if(Y%2==1){
			for (int i = 0; i <= X/2-Y/2; i++) {
				move();
				counterMoves++;

			}
		} else if(Y%2==0){
			for (int i = 0; i <= X/2-Y/2; i++) {
				move();
				counterMoves++;
			}
		}


			turnLeft();
		//sec section
		if(X%2==1) {
			for (int i = 1; i <= Y / 2 - 1; i++) {
				if (!beepersPresent()) {
					putBeeper();
				}
				move();
				counterMoves++;
			}
		} else if(X%2==0){
				for (int i = 1; i < Y/2; i++) {
					if (!beepersPresent()) {
						putBeeper();
					}
					move();
					counterMoves++;
				}
		}
		if(!beepersPresent()){
			putBeeper();
		}
		turnRight();

		// third section
		if(X%2==1) {
			for(int i = 1;i<=Y-3;i++){
				move();
				if(!beepersPresent()){
					putBeeper();
				}
				counterMoves++;
			}
		} else if(X%2==0){
			for(int i = 1; i<Y/2*2-2 ; i++){

				if(!beepersPresent()){
					putBeeper();
				}

				move();
				counterMoves++;
			}
		}
		if(!beepersPresent()){
			putBeeper();
		}
		turnRight();
		//forth section
		if(X%2==1){
			for(int i = 1;i<=Y-3;i++){
				move();
				if(!beepersPresent()){
					putBeeper();
				}
				counterMoves++;
			}
		} else if(X%2 ==0){
			for(int i = 1;i<Y-2;i++){
				move();
				if(!beepersPresent()){
					putBeeper();
				}
				counterMoves++;
			}
		}
		if(!beepersPresent()){
			putBeeper();
		}
		turnRight();
		//fifth
		if(Y%2==1){
			for(int i = 1;i<=Y-3;i++){
				move();
				if(!beepersPresent()){
					putBeeper();
				}
				counterMoves++;
			}
		} else if(Y%2==0){
			for(int i = 1; i<Y-2 ; i++){
				move();
				if(!beepersPresent()){
					putBeeper();
				}
				counterMoves++;
			}
		}
		if(!beepersPresent()){
			putBeeper();
		}
		turnRight();
		for(int i = 1;i<=Y/2-2;i++){
			move();
			if(!beepersPresent()){
				putBeeper();
			}
		}


	}
}



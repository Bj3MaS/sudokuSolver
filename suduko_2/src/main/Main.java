
package main;

import java.util.ArrayList;

public class Main {
	private static int [][] board = new int [][]{
			{0,0,0,	0,0,0,	0,0,0},
			{0,0,0,	0,0,3,	0,8,5},
			{0,0,1,	0,2,0,	0,0,0},
			
			{0,0,0,	5,0,7,	0,0,0},
			{0,0,4,	0,0,0,	1,0,0},
			{0,9,0,	0,0,1,	0,0,0},
			
			{5,0,0,	0,0,2,	0,7,3},
			{0,0,2,	0,1,0,	0,0,0},
			{0,0,0,	0,4,0,	0,0,1}	
		};
	private static int[] totalNumber = new int []{
		1,2,3,4,5,6,7,8,9};

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		if(solveSuduko(0,0)){
			time = System.currentTimeMillis()-time;
			printBoard();
			System.out.println(time);
		}
		else{
			System.out.println("Dette oppsettet har ingen løsning");
			time = System.currentTimeMillis()-time;
			System.out.println(time);
		}
	}

	private static boolean solveSuduko(int x, int y){
		boolean containNumber = true;
		
		if (y > 8) {
			return true;
		}
	
		
		if (board[y][x] != 0) {
			if (x == 8) {
				y = y + 1;
				x = 0;
			} 
			else {
				x = x + 1;
			}
			
			if(solveSuduko(x, y)){
				return true;
			}
			
			else {
				return false;
			}
			
		}
		
			

		for (Integer i : possibleNumbers(x, y)) {
			board[y][x] = i;
			if (x == 8) {
				if(solveSuduko(0, y + 1)){
					return true;
				}
			}

			else {
				if(solveSuduko(x + 1, y)){
					return true;
				}
			}

		}
		board[y][x] = 0;
		return false;
	}
	private static void printBoard() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");

	}
	
	private static ArrayList<Integer> possibleNumbers(int x, int y){
		ArrayList<Integer> listOfNumbers = new ArrayList<>();
		for(Integer i: totalNumber){
			if(legalNumber(x,y,i)){
				listOfNumbers.add(i);
			}
		}
		return listOfNumbers;
	}
	
	private static boolean legalNumber(int x, int y, int a){
		for(int i = 0; i < 9; i++ ){
			if(board[i][x] == a || board[y][i] == a){
				return false;
			}
		}

		for( int i = 0; i < 3; i++ )
	         for( int j = 0; j < 3; j++ )
	         if( board[(y/3)*3+i][(x/3)*3+j] == a ){
	        	 return false;
	         }
	            
		return true;
	}
}

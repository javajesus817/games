package com.miniprojectthree.main;

public class TicTacToe {
	public char [] [] gameBoard;
	public char presentPlayer;
	
	public TicTacToe() {
		gameBoard = new char [3][3];
		presentPlayer = 'x';
		
	}
	
	public void initializeGameBoard() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				gameBoard[i][j] = '-';
			}
		}
	}
	
	public void printGameBoard() {
		System.out.println("-------");
		for(int i = 0; i < 3; i++) {
			System.out.print("|");
			for (int j = 0; j < 3; j++ ) {
				System.out.print(gameBoard[i][j] + "|");
			}
			System.out.println();
			System.out.println("-------");
		}
	}
	
	public char getPresentPlayer() {
		return presentPlayer;
	}
	
	public boolean isGameBoardFull() {
		
		boolean isFull = true;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (gameBoard[i][j] == '-') {
					isFull = false;
				}
			}
		}
		
		return isFull;
	}
	
	public boolean isWinner() {
		
		return checkRowsForWin() || checkColumnsForWin() || checkDiagonalForWin();
	}
	
	public boolean checkRowsForWin() {
		for(int i=0; i < 3; i++) {
			if(checkRowsColumns(gameBoard[i][0], gameBoard[i][1], gameBoard[i][2]) == true) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean checkColumnsForWin() {
		for(int i=0; i < 3; i++) {
			if(checkRowsColumns(gameBoard[0][i], gameBoard[1][i], gameBoard[2][i]) == true) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean checkDiagonalForWin() {
		return ((checkRowsColumns(gameBoard[0][0], gameBoard[1][1], gameBoard[2][2]) == true) || checkRowsColumns(gameBoard[0][2], gameBoard[1][1], gameBoard[2][0]) == true);
	}
	
	public boolean checkRowsColumns(char move1, char move2, char move3) {
		return ((move1 != '-') && move1 == move2 && move2 == move3);
	}
	
	public void switchToNextPlayer() {
		if(presentPlayer == 'x') {
			presentPlayer = 'o';
		} else {
			presentPlayer = 'x';
		}
	}
	
	public boolean makeMove(int row, int column) {
		if((row >= 0) && (column < 3)) {
			if(gameBoard[row][column] == '-') {
				gameBoard[row][column] = presentPlayer;
			}
		}
		return true;
		
	}
}

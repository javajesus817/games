package com.miniprojectthree.main;

import java.util.Scanner;


public class MainRunner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TicTacToe game = new TicTacToe();
		game.initializeGameBoard();
		System.out.println("Play Tic-Tac-Toe!");
		
		do {
			System.out.println("Present board:");
			game.printGameBoard();
			int row;
			int column;
			do {
				System.out.println("Player " + game.getPresentPlayer() + ", enter an empty row and column for your mark.");
				row = sc.nextInt()-1;
				column = sc.nextInt()-1;
			} 
			while (!game.makeMove(row, column));
			game.switchToNextPlayer();
		} 
		while (!game.isWinner() && !game.isGameBoardFull());
		if (game.isGameBoardFull() && !game.isWinner()) {
			System.out.println("Tie game!");
		} else {
			System.out.println("Current board layout:");
			game.printGameBoard();
			game.switchToNextPlayer();
			System.out.println(game.getPresentPlayer() + " wins the game");
		}
		
		
		sc.close();

	}

}

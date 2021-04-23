package com.TicTacToeGame;

public class TicTacToe {

	public static void main(String[] args) {

		System.out.println("Welcome to Tic Tac Toe Game");

		char[] tictactoeboard = initializeBoard();
	}

	public static char[] initializeBoard() {
		char[] tictactoeboard = new char[10];

		for (int index = 1; index < tictactoeboard.length; index++) {
			tictactoeboard[index] = ' ';
		}
		
		return tictactoeboard;
	}
}
package com.TicTacToeGame;

import java.util.Scanner;

public class TicTacToe {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to Tic Tac Toe Game");

		char[] tictactoeboard = initializeBoard();
		char userchoice = chooseLetter();
		char computerchoice;
		computerchoice = (userchoice == 'X') ? (computerchoice = 'O') : (computerchoice = 'X');
		showBoard(tictactoeboard);
		scanner.close();
	}

	/**
	 * method to create tictactoe board
	 */
	private static char[] initializeBoard() {
		char[] tictactoeboard = new char[10];

		for (int index = 1; index < tictactoeboard.length; index++) {
			tictactoeboard[index] = ' ';
		}

		return tictactoeboard;
	}

	/**
	 * method to allow player to choose letter
	 */
	private static char chooseLetter() {

		char userchoice = ' ';
		System.out.println("Please Choose a Letter\n" + "1. X\n" + "2. O");
		String str = scanner.nextLine();
		char choice = str.charAt(0);

		switch (Character.toLowerCase(choice)) {
		case 'x': {
			userchoice = 'X';
			break;
		}
		case 'o': {
			userchoice = 'O';
			break;
		}
		default: {
			System.out.println("Enter a Valid Letter");
		}
		}
		return userchoice;
	}

	private static void showBoard(char[] tictactoeboard) {
		 {
			System.out.println(tictactoeboard[1] + " | " + tictactoeboard[2] + " | " + tictactoeboard[3]+"\n---------");
			System.out.println(tictactoeboard[1] + " | " + tictactoeboard[2] + " | " + tictactoeboard[3]+"\n---------");
			System.out.println(tictactoeboard[1] + " | " + tictactoeboard[2] + " | " + tictactoeboard[3]+"\n---------");
		}
	}
}
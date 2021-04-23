package com.TicTacToeGame;

import java.util.Scanner;

public class TicTacToe {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to Tic Tac Toe Game");

		char[] tictactoeboard = initializeBoard();
		int index;
		char userchoice = chooseLetter();
		char computerchoice;
		computerchoice = (userchoice == 'X') ? (computerchoice = 'O') : (computerchoice = 'X');
		showBoard(tictactoeboard);
		index = selectIndex(tictactoeboard);
		moveBoard(index, tictactoeboard, userchoice);
		index = selectIndex(tictactoeboard);
		moveBoard(index, tictactoeboard, userchoice);
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
	 * Method for showing board
	 */
	private static void showBoard(char[] tictactoeboard) {
		{
			System.out.println(tictactoeboard[1] + " | " + tictactoeboard[2] + " | " + tictactoeboard[3] + "\n-----------");
			System.out.println(tictactoeboard[4] + " | " + tictactoeboard[5] + " | " + tictactoeboard[6] + "\n-----------");
			System.out.println(tictactoeboard[7] + " | " + tictactoeboard[8] + " | " + tictactoeboard[9] + "\n-----------");
		}
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

	/**
	 * Method for taking index from user
	 */
	private static int selectIndex(char[] tictactoeboard) {
		int index;
		int valid = 0;
		do {
			System.out.println("\nPlease Select Index from Positions 1-9");
			index = scanner.nextInt();
			if ((index < 1 || index > 9)) {
				System.out.println("invalid index");

			} else {
				if (!(tictactoeboard[index] == ' '))
					System.out.println("This Index is Not Free... Please select another...");

				else
					break;
			}

		} while (true);

		return index;
	}

	private static char[] moveBoard(int index, char[] tictactoeboard, char letter) {
		tictactoeboard[index] = letter;
		showBoard(tictactoeboard);
		return tictactoeboard;
	}

}
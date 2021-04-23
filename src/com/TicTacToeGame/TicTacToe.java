package com.TicTacToeGame;

import java.util.Scanner;

public class TicTacToe {

	static Scanner scanner = new Scanner(System.in);
	private static String user = "User";
	private static String computer = "Computer";

	public static void main(String[] args) {

		System.out.println("Welcome to Tic Tac Toe Game");

		int index;
		String turn;
		boolean check = true;
		char[] tictactoeboard = initializeBoard();

		char userchoice = chooseLetter();
		char computerchoice;
		computerchoice = (userchoice == 'X') ? (computerchoice = 'O') : (computerchoice = 'X');
		showBoard(tictactoeboard);
		if (firstPlayCheck().equals(user)) {
			System.out.println("user plays first");
			turn = user;
		} else {
			System.out.println("computer plays first");
			turn = computer;
		}
		do {
			if (turn.equals(user)) {
				index = selectIndex(tictactoeboard);
				moveBoard(index, tictactoeboard, userchoice);
				showBoard(tictactoeboard);
				check = checkWinAndTie(tictactoeboard, userchoice);
				turn = computer;
			} 
			else {
				index = 9;
			tictactoeboard[index] = computerchoice;
			showBoard(tictactoeboard);
			check = checkWinAndTie(tictactoeboard, computerchoice);
			turn = user;
			}
		} while (!check);

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
			System.out.println("Please Select Index from Positions 1-9 ");
			index = scanner.nextInt();
			if ((index < 1 || index > 9)) {
				System.out.println("Invalid index");

			} else {
				if (!(tictactoeboard[index] == ' '))
					System.out.println("This Index is not Free... Please Select another...");

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

	private static String firstPlayCheck() {
		int toss = (int) (Math.random() * 10) % 2;
		return (toss == 0) ? (user) : (computer);
	}
	
	private static boolean checkWinAndTie(char[] b, char letter) {
		boolean check;
		if ((b[1] == letter && b[2] == letter && b[3] == letter) || (b[4] == letter && b[5] == letter && b[6] == letter)
				|| (b[7] == letter && b[8] == letter && b[9] == letter)
				|| (b[1] == letter && b[4] == letter && b[7] == letter)
				|| (b[2] == letter && b[5] == letter && b[8] == letter)
				|| (b[3] == letter && b[6] == letter && b[9] == letter)
				|| (b[1] == letter && b[5] == letter && b[9] == letter)
				|| (b[3] == letter && b[5] == letter && b[7] == letter)) {
			check = true;
		} else {
			int valid = 0;
			for (int index = 1; index < b.length; index++) {
				if (b[index] == ' ')
					valid++;
			}
			check = (valid == 9) ? (true) : (false);

		}
		return check;
	}

}
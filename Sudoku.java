package com.arumugamakash.sudokuapplication;

import java.util.Scanner;

public class Sudoku {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int board[][] = { { 0, 0, 3, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 }, { 3, 0, 2, 0 } };
		System.out.println("Input is...\n");
		printBoardMatrix(board);
		inputNumber(board);
		System.out.println("Your Output is...\n");
		printBoardMatrix(board);
	}

	private static void inputNumber(int[][] board) {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length;) {
				if (board[i][j] == 0) {
					int row = i;
					int column = j;
					System.out.println("Enter the " + row + " Row and " + column + " column");
					int input = sc.nextInt();//
					sc.nextLine();
					if (checkRow(board, input, row)) {
						if (checkColumn(board, input, column)) {
							board[i][j++] = input;
							System.out.println("Value added successfully\n");
							printBoardMatrix(board);
						} else {
							count++;
							System.out.println("Invalid Number");
							checkchance(count);
						}
					} else {
						count++;
						System.out.println("Invalid Number");
						checkchance(count);
					}
				} else {
					j++;
				}
			}
		}
		System.out.println("\n-------------successfully solve the Sudoku Game----------------");
	}

	private static void checkchance(int count) {
		if (count == 3) {
			System.out.println("\n-------------Game Over------------------");
			System.exit(0);
		}
	}

	private static boolean checkRow(int[][] board, int input, int row) {
		for (int i = 0; i < board.length; i++) {
			if (board[row][i] == input) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkColumn(int[][] board, int input, int col) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == input) {// 01 11 21
				return false;
			}
		}
		return true;
	}

	private static void printBoardMatrix(int[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}

}

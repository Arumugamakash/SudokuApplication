package com.arumugamakash.sudokuapplication;

import java.util.Scanner;

public class SudokuSolver {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] board = { { 7, 0, 2, 0, 5, 0, 6, 0, 0 }, { 0, 0, 0, 0, 0, 3, 0, 0, 0 }, { 1, 0, 0, 0, 0, 9, 5, 0, 0 },
				{ 8, 0, 0, 0, 0, 0, 0, 9, 0 }, { 0, 4, 3, 0, 0, 0, 7, 5, 0 }, { 0, 9, 0, 0, 0, 0, 0, 0, 8 },
				{ 0, 0, 9, 7, 0, 0, 0, 0, 5 }, { 0, 0, 0, 2, 0, 0, 0, 0, 0 }, { 0, 0, 7, 0, 4, 0, 2, 0, 3 } };
		//////
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		inputNumber(board);
		System.out.println("Solved Successfully");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void inputNumber(int[][] board) {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 0) {
					int row = i;
					int column = j;
					System.out.println("Enter the validInput");
					int input = sc.nextInt();//
					sc.nextLine();
					if (checkRow(board, input, row)) {
						if (checkcolumn(board, input, column)) {
							if (checkSubMatrix(board, input, row, column)) {
								board[i][j] = input;
							} else {
								count++;
								System.out.println("Invalid Number 1");
								if (count == 3) {
									System.out.println("game Over");
									System.exit(0);
								}
							}
						} else {
							count++;
							System.out.println("Invalid Number 2");
							if (count == 3) {
								System.out.println("game Over");
								System.exit(0);
							}
							break;
						}
					} else {
						count++;
						System.out.println("Invalid Number 3");
						if (count == 3) {
							System.out.println("game Over");
							System.exit(0);
						}
						break;
					}
				}
			}
		}
		System.out.println();
	}

	public static boolean checkRow(int board[][], int input, int row) {
		for (int i = 0; i < board.length; i++) {
			if (board[row][i] == input) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkcolumn(int board[][], int input, int col) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == input) {// 01 11 21
				return false;
			}
		}
		return true;
	}

	public static boolean checkSubMatrix(int board[][], int input, int row, int col) {

		int subrow = row - row % 3;// 2-2%3//0
		int subcol = col - col % 3;// 0
		for (int i = subrow; i < subrow + 3; i++) {
			for (int j = subcol; j < subcol + 3; j++) {
				if (board[i][j] == input) {//
					return false;
				}
			}
		}
		return true;
	}
}

package SudokuMain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SudokuDriver {

    private static final int BOARD_SIZE = 9;

    public static void main(String args[]) {
        int[][] board = createValidBoard();
        int[][] spacedBoard = createSpaces(board, 1);

        printBoard(spacedBoard);
    }

    public static boolean inRow(int value, int row, int column, int[][] board) {

        for (int i = 0; i < BOARD_SIZE; i++) {

            if (i == column) {
                continue;
            }

            if (value == board[row][i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean inColumn(int value, int row, int column, int[][] board) {

        for (int i = 0; i < BOARD_SIZE; i++) {

            if (i == row) {
                continue;
            }

            if (value == board[i][column]) {
                return true;
            }
        }
        return false;
    }

    public static boolean inSection(int value, int row, int column, int[][] board) {

        int sectionRowStart = row - row % 3;

        int sectionColumnStart = column - column % 3;

        for (int i = sectionRowStart; i < sectionRowStart + 3; i++) {

            for (int j = sectionColumnStart; j < sectionColumnStart + 3; j++) {

                if (i == row && j == column) {
                    continue;
                }

                if (value == board[i][j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isValid(int value, int row, int column, int[][] board) {
        return !inRow(value, row, column, board) 
            && !inColumn(value, row, column, board) 
            && !inSection(value, row, column, board);
    }

    public static int[][] createValidBoard() {

        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

        for (int row = 0; row < BOARD_SIZE; row++) {
            
            Integer [] values = {1,2,3,4,5,6,7,8,9};
            List<Integer> valueList = Arrays.asList(values); 
            Collections.shuffle(Arrays.asList(values));
            valueList.toArray(values);

            for (int column = 0; column < BOARD_SIZE; column++) {

                board[row][column] = values[column];
                if (!isValid(board[row][column], row, column, board)) {

                    for (int i = 0; i <= column; i++) {
                        board[row][i] = 0;
                    }

                    row--;
                    break;
                }

            }

        }

        return board;

    }

    public static int[][] createSpaces(int[][] board, int difficulty) {

        int[][] ret = new int[BOARD_SIZE][BOARD_SIZE];

        int count = 0;

        Random random = new Random();

        int space;

        while (count < (difficulty * 3 + 11) * 3) {

            space = random.nextInt(BOARD_SIZE * BOARD_SIZE);

            int row = space / BOARD_SIZE;

            int column = space % BOARD_SIZE;

            if (ret[row][column] == -1) {
                continue;
            }

            else {
                count++;
                ret[row][column] = -1;
            }
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            
            for (int j = 0; j < BOARD_SIZE; j++) {

                if (ret[i][j] == -1) {
                    continue;
                }

                ret[i][j] = board[i][j];

            }
        }

        return ret;
    }

    public static void printBoard(int[][] board) {

        for (int i = 0; i < BOARD_SIZE; i++) {

            if (i % 3 == 0 && i != 0) {
                System.out.println(" - - - - - - - - - - -");
            }
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print(" |");
                }
                if (board[i][j] == -1) {
                    System.out.print(" .");
                }
                else {
                    System.out.print(" " + board[i][j]);
                }
            }
            System.out.println();

        }

    }

}
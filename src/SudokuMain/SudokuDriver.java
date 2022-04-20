package SudokuMain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SudokuDriver {

    private static final int BOARD_SIZE = 9;

    public static void main(String args[]) {

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
}
package SudokuMain;
public class SudokuDriver {

    private static final int BOARD_SIZE = 9;

    public static void main(String args[]) {

    }

    public static boolean inRow(int value, int row, int[][] board) {

        for (int i = 0; i < BOARD_SIZE; i++) {

            if (value == board[row][i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean inColumn(int value, int column, int[][] board) {

        for (int i = 0; i < BOARD_SIZE; i++) {

            if (value == board[i][column]) {
                return true;
            }
        }
        return false;
    }

    public static boolean inSection(int value, int row, int column, int[][] board) {
        return false;
    }

    public static boolean isValid(int value, int row, int column, int[][] board) {
        return false;
    }
}
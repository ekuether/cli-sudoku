package SudokuMain;
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
        return null;
    }
}
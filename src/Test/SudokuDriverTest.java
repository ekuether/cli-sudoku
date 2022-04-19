package Test;

import SudokuMain.SudokuDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SudokuDriverTest {

    private int[][] testBoard = {{0,0,0,2,6,0,7,0,1},
                                {6,8,0,0,7,0,0,9,0},
                                {1,9,0,0,0,4,5,0,0},
                                {8,2,0,1,0,0,0,4,0},
                                {0,0,4,6,0,2,9,0,0},
                                {0,5,0,0,0,3,0,2,8},
                                {0,0,9,3,0,0,0,7,4},
                                {0,4,0,0,5,0,0,3,6},
                                {7,0,3,0,1,8,0,0,0}};

    @Test
    public void testInRow() {
        
        assertTrue(SudokuDriver.inRow(2,0,0,testBoard));

        assertFalse(SudokuDriver.inRow(5,4,0,testBoard));
    }

    @Test
    public void testInColumn() {

        assertTrue(SudokuDriver.inColumn(1, 0, 3, testBoard));

        assertFalse(SudokuDriver.inColumn(7, 0, 3, testBoard));
    }

    @Test
    public void testInSection() {

        assertTrue(SudokuDriver.inSection(8, 1, 0, testBoard));

        assertFalse(SudokuDriver.inSection(7,0,0,testBoard));
    }

    @Test
    public void testIsValid() {

        assertFalse(SudokuDriver.isValid(7, 0, 1, testBoard));

        assertTrue(SudokuDriver.isValid(7,2,2,testBoard));
    }

    @Test
    public void testCreateValidBoard() {
        
        int[][] board = SudokuDriver.createValidBoard();

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                assertTrue(SudokuDriver.isValid(board[i][j], i, j, board));

            }

        }
    }
}
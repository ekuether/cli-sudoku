## CLI Sudoku

This is a CLI sudoku project meant to test logic before moving onto an angular application.

## Running the program

To run the program, simply download Sudoku.jar, and in the command line use:

java -jar pathtojarfile\sudoku.jar

Ex: java -jar C:\users\name\downloads\sudoku.jar

## How to play

Sudoku is a game comprised of a 9x9 grid where any given number is unique in it' row, column, and 3x3 section

This CLI has four options in total

Option 1 - Creates the board. No other option but "4" can work without a board.

Option 2 - Checks the board for incorrect placement, and removes those numbers
    NOTE: Boards may not have a unique solution, but the CLI will have one possibly solution.
          If a number is right and it dissapears, try putting the number in another possible spot.

Option 3 - Place a number on the board
    NOTE: Numbers cannot replace other numbers, so use "Option 2" to clear any incorrect numbers

Option 4 - Quit the game

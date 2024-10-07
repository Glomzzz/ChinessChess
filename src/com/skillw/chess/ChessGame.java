package com.skillw.chess;

import com.skillw.chess.chess.*;

public class ChessGame {
    public final static int MAX_COLUMN = 9;
    public final static int MAX_ROW = 10;
    private Chess[][] board = new Chess[10][9];
    private Cursor cursor = new Cursor();
    private Console console = new Console();

    public ChessGame(){
        board[0][0] = Chariot.BLACK;
        board[0][1] = Horse.BLACK;
        board[0][2] = Elephant.BLACK;
        board[0][3] = Advisor.BLACK;
        board[0][4] = General.BLACK;
        board[0][5] = Advisor.BLACK;
        board[0][6] = Elephant.BLACK;
        board[0][7] = Horse.BLACK;
        board[0][8] = Chariot.BLACK;

        board[2][1] = Cannon.BLACK;
        board[2][7] = Cannon.BLACK;

        board[3][0] = Soldier.BLACK;
        board[3][2] = Soldier.BLACK;
        board[3][4] = Soldier.BLACK;
        board[3][6] = Soldier.BLACK;
        board[3][8] = Soldier.BLACK;

        // Initialize red pieces
        board[9][0] = Chariot.RED;
        board[9][1] = Horse.RED;
        board[9][2] = Elephant.RED;
        board[9][3] = Advisor.RED;
        board[9][4] = General.RED;
        board[9][5] = Advisor.RED;
        board[9][6] = Elephant.RED;
        board[9][7] = Horse.RED;
        board[9][8] = Chariot.RED;

        board[7][1] = Cannon.RED;
        board[7][7] = Cannon.RED;

        board[6][0] = Soldier.RED;
        board[6][2] = Soldier.RED;
        board[6][4] = Soldier.RED;
        board[6][6] = Soldier.RED;
        board[6][8] = Soldier.RED;
    }


    public void show(Location... cursors) {
        console.clear();

        // Define symbols for grid edges and intersections
        String topLeft = "┌", topRight = "┐", topCenter = "┬";
        String middleLeft = "├", middleRight = "┤", middleCenter = "┼";
        String bottomLeft = "└", bottomRight = "┘", bottomCenter = "┴";
        String space = "\u3000"; // Unicode for en space
        String horizontalLine = "───"+space+"───", verticalLine = "│";
        String riverLine = "~~~"+space+"~~~";


        // Print the top border of the chessboard
        console.print(topLeft);
        for (int j = 0; j < MAX_COLUMN - 1; j++) {
            console.print(horizontalLine + topCenter);
        }
        console.print(horizontalLine + topRight);
        console.println();

        // Print each row of the chessboard, each cell being 4 characters wide and 2 rows high
        for (int i = 0; i < MAX_ROW; i++) {
            // Print each line of the row (2 lines per row for height)
            for (int line = 0; line < 2; line++) {
                for (int j = 0; j < MAX_COLUMN; j++) {
                    console.print(verticalLine);
                    if (board[i][j] != null && line == 0) {
                        String piece = board[i][j].getName();
                        // Ensure the piece string fits within 4 characters (Chinese character + 2 en spaces)
                        console.print("  " + piece + "  ");
                    } else {
                        boolean cursored = false;
                        for (Location location : cursors) {
                            if (location.getRow() == i && location.getColumn() == j) {
                                console.print(space + space +"X" + space + space );
                                cursored = true;
                                break;
                            }
                        }
                        if (!cursored)
                            console.print("   " + space + "   "); // Empty space below the river waves
                    }
                }
                console.print(verticalLine);
                console.println();
            }

            // Print the horizontal lines between rows, except after the last row
            if (i < MAX_ROW - 1) {
                console.print(middleLeft);
                if (i == 4){
                    for (int j = 0; j < MAX_COLUMN; j++) {
                        console.print(riverLine + middleCenter);
                    }
                }else for (int j = 0; j < MAX_COLUMN; j++) {
                    console.print(horizontalLine + middleCenter);
                }
                console.println();
            }
        }

        // Print the bottom border of the chessboard
        console.print(bottomLeft);
        for (int j = 0; j < MAX_COLUMN - 1; j++) {
            console.print(horizontalLine + bottomCenter);
        }
        console.print(horizontalLine + bottomRight);
        console.println();
    }


    public Color at(int row,int column){
        if(board[column][row] == null) return null;
        return board[column][row].getColor();
    }
    public Color at(Location location){
        return at(location.getRow(),location.getColumn());
    }

    public void moveChess(Location from, Location to){
        board[to.getRow()][to.getColumn()] = board[from.getRow()][from.getColumn()];
        board[from.getRow()][from.getColumn()] = null;
    }

    public void moveCursor(Action[] actions){
        cursor.move(actions);
    }
}

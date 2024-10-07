package com.skillw.chess.chess;

import com.skillw.chess.Chess;
import com.skillw.chess.ChessGame;
import com.skillw.chess.Color;
import com.skillw.chess.Location;

public class Elephant extends Chess {

    public static final Elephant BLACK = new Elephant(Color.BLACK);
    public static final Elephant RED = new Elephant(Color.RED);
    public Elephant(Color color) {
        super(color == Color.RED ? " 相 " : " 象 ", color);
    }


    private boolean isLegal(Location location) {
        return getColor() == Color.BLACK ? location.getRow() >= 0 && location.getRow() <= 4 && location.getColumn() >= 0 && location.getColumn() <= 8
                                         : location.getRow() >= 5 && location.getRow() <= 9 && location.getColumn() >= 0 && location.getColumn() <= 8;
    }

    @Override
    public Location[] possibleMoves(Location self, ChessGame board) {
        Location[] locations = new Location[4];
        int index = 0;
        int row = self.getRow();
        int column = self.getColumn();
        Location loc1 = new Location(row - 2, column - 2);
        Location loc2 = new Location(row - 2, column + 2);
        Location loc3 = new Location(row + 2, column - 2);
        Location loc4 = new Location(row + 2, column + 2);
        if (isLegal(loc1) && board.at(row - 1,column - 1) == null) locations[index++] = loc1;
        if (isLegal(loc2) && board.at(row - 1,column + 1) == null) locations[index++] = loc2;
        if (isLegal(loc3) && board.at(row + 1,column - 1) == null) locations[index++] = loc3;
        if (isLegal(loc4) && board.at(row + 1,column + 1) == null) locations[index] = loc4;
        return locations;
    }
}

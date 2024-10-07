package com.skillw.chess.chess;

import com.skillw.chess.Chess;
import com.skillw.chess.ChessGame;
import com.skillw.chess.Color;
import com.skillw.chess.Location;

public class General extends Chess {
    public static final General BLACK = new General(Color.BLACK);
    public static final General RED = new General(Color.RED);
    private General(Color color){
        super(color == Color.RED ? " 帅 " : " 将 ",color);
    }

    private boolean isLegal(Location location){
        return getColor() == Color.BLACK ? location.getRow() >= 0 && location.getRow() <= 2 && location.getColumn() >= 3 && location.getColumn() <= 5
                                         : location.getRow() >= 7 && location.getRow() <= 9 && location.getColumn() >= 3 && location.getColumn() <= 5;
    }

    @Override
    public Location[] possibleMoves(Location self, ChessGame board) {
        Location[] locations = new Location[4];
        int index = 0;
        int row = self.getRow();
        int column = self.getColumn();
        Location loc1 = new Location(row - 1, column);
        Location loc2 = new Location(row + 1, column);
        Location loc3 = new Location(row, column - 1);
        Location loc4 = new Location(row, column + 1);
        if (isLegal(loc1)) locations[index++] = loc1;
        if (isLegal(loc2)) locations[index++] = loc2;
        if (isLegal(loc3)) locations[index++] = loc3;
        if (isLegal(loc4)) locations[index] = loc4;
        return locations;
    }
}

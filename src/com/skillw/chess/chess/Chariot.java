package com.skillw.chess.chess;

import com.skillw.chess.Chess;
import com.skillw.chess.ChessGame;
import com.skillw.chess.Color;
import com.skillw.chess.Location;

public class Chariot extends Chess {


    public static final Chariot BLACK = new Chariot(Color.BLACK);
    public static final Chariot RED = new Chariot(Color.RED);

    public Chariot(Color color) {
        super(color == Color.RED ? " 车 " : " 車 ", color);
    }

    @Override
    public Location[] possibleMoves(Location self, ChessGame game) {
        Location[] locations = new Location[18];
        int index = 0;
        for (int i = self.getColumn() + 1; i < 9; i++) {
            if (game.at(i,self.getRow()) == null) {
                locations[index++] = new Location(self.getRow(), i);
            } else {
                if (game.at(i,self.getRow()) != getColor()) {
                    locations[index] = new Location(self.getRow(), i);
                }
                break;
            }
        }
        for (int i = self.getRow() - 1; i >= 0; i--) {
            if (game.at(i,self.getColumn()) == null) {
                locations[index++] = new Location(i, self.getColumn());
            } else {
                if (game.at(i,self.getColumn()) != getColor()) {
                    locations[index] = new Location(i, self.getColumn());
                }
                break;
            }
        }
        return locations;
    }
}

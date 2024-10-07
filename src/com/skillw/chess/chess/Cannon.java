package com.skillw.chess.chess;

import com.skillw.chess.Chess;
import com.skillw.chess.ChessGame;
import com.skillw.chess.Color;
import com.skillw.chess.Location;

public class Cannon extends Chess {

    public static final Cannon BLACK = new Cannon(Color.BLACK);
    public static final Cannon RED = new Cannon(Color.RED);

    public Cannon(Color color) {
        super( color == Color.RED ? " 炮 " : " 砲 ", color);
    }

    @Override
    public Location[] possibleMoves(Location self, ChessGame game) {
        Location[] locations = new Location[18];
        int index = 0;
        for (int i = self.getColumn() + 1; i < 9; i++) {
            if (game.at(i,self.getRow()) == null) {
                locations[index++] = new Location(self.getRow(), i);
            } else {
                for (int j = i + 1; j < 9; j++) {
                    if (game.at(j,self.getRow()) != null) {
                        if (game.at(j,self.getRow()) != getColor()) {
                            locations[index++] = new Location(self.getRow(), j);
                        }
                        break;
                    }
                }
            }
        }
        for (int i = self.getRow() - 1; i >= 0; i--) {
            if (game.at(i,self.getColumn()) == null) {
                locations[index++] = new Location(i, self.getColumn());
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    if (game.at(j,self.getColumn()) != null) {
                        if (game.at(j,self.getColumn()) != getColor()) {
                            locations[index++] = new Location(j, self.getColumn());
                        }
                        break;
                    }
                }
            }
        }
        return locations;
    }
}

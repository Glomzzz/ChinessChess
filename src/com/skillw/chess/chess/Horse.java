package com.skillw.chess.chess;

import com.skillw.chess.Chess;
import com.skillw.chess.ChessGame;
import com.skillw.chess.Color;
import com.skillw.chess.Location;

public class Horse extends Chess {
    public static final Horse BLACK = new Horse(Color.BLACK);
    public static final Horse RED = new Horse(Color.RED);
    public Horse(Color color) {
        super(color == Color.RED ? " 马 " : " 馬 ",color);
    }

    private boolean isLegal(Location location, ChessGame board) {
        return location.getColumn() >= 0 && location.getColumn() < 9 && location.getRow() >= 0 && location.getRow() < 10 && (board.at(location) == null || board.at(location) != getColor());
    }

    @Override
    public Location[] possibleMoves(Location self, ChessGame board) {
        Location[] locations = new Location[8];
        int[][] moves = {
            {1, 2},
            {2, 1},
            {2, -1},
            {1, -2},
            {-1, -2},
            {-2, -1},
            {-2, 1},
            {-1, 2}
        };
        for (int i = 0; i < 8; i++) {
            Location location = new Location(self.getRow() + moves[i][0], self.getColumn() + moves[i][1]);
            if (isLegal(location, board)) {
                locations[i] = location;
            }
        }
        return locations;
    }
}

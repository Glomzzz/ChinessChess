package com.skillw.chess.chess;

import com.skillw.chess.Chess;
import com.skillw.chess.ChessGame;
import com.skillw.chess.Color;
import com.skillw.chess.Location;

public class Soldier extends Chess {
    public static final Soldier BLACK = new Soldier(Color.BLACK);
    public static final Soldier RED = new Soldier(Color.RED);

    public Soldier(Color color) {
        super(color == Color.RED ? " 兵 " : " 卒 ", color);
    }


    private boolean isLegal(Location location, ChessGame board) {
        return location.getColumn() >= 0 && location.getColumn() < 9 && location.getRow() >= 0 && location.getRow() < 10 && (board.at(location) == null || board.at(location) != getColor());
    }

    private boolean isCrossRiver(Location location) {
        return (getColor() == Color.BLACK && location.getRow() >= 5) || (getColor() == Color.RED && location.getRow() < 5);
    }

    @Override
    public Location[] possibleMoves(Location self, ChessGame board) {
        Location[] locations = new Location[4];

        if (isCrossRiver(self)){
            int[][] moves = {
                {1, 0},
                {0, 1},
                {0, -1},
                {-1, 0}
            };
            for (int i = 0; i < 4; i++) {
                Location location = new Location(self.getRow() + moves[i][0], self.getColumn() + moves[i][1]);
                if (isLegal(location, board)) {
                    locations[i] = location;
                }
            }
            return locations;
        }
        int[] move = getColor() == Color.BLACK ? new int[]{1, 0} : new int[]{-1, 0};
        Location location = new Location(self.getRow() + move[0], self.getColumn() + move[1]);
        if (isLegal(location, board)) {
            locations[0] = location;
        }
        return locations;
    }
}

package com.skillw.chess;

public abstract class Chess {
    private final String name;
    private final Color color;

    public Chess(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public abstract Location[] possibleMoves(Location self, ChessGame board);

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
}

package com.skillw.chess;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello world!");
        ChessGame game = new ChessGame();
        game.show(new Location(0, 0));
    }
}
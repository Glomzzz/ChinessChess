package com.skillw.chess;

public class Cursor extends Location {

    public void move(Action[] actions){
        for (Action action : actions){
            switch (action){
                case UP:
                    setRow(getRow() - 1);
                    break;
                case DOWN:
                    setRow(getRow() + 1);
                    break;
                case LEFT:
                    setColumn(getColumn() - 1);
                    break;
                case RIGHT:
                    setColumn(getColumn() + 1);
                    break;
                case CONFIRM:
                    break;
            }
        }
    }
}

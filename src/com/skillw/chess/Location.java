package com.skillw.chess;

public class Location {

    private int column;
    private int row;

    public Location(){
        setColumn(0);
        setRow(0);
    }

    public Location(int row, int column) {
        setColumn(column);
        setRow(row);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        if (row < 0 || row >= ChessGame.MAX_ROW) return;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }


    public void setColumn(int column) {
        if (column < 0 || column >= ChessGame.MAX_ROW) return;
        this.column = column;
    }
}

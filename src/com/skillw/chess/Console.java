package com.skillw.chess;

import java.io.PrintStream;
import java.util.Scanner;

public class Console {
    private PrintStream out;
    private Scanner scanner;

    public Console(){
        this.out = System.out;
        this.scanner = new java.util.Scanner( System.in);
    }

    public void clear(){
        out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public void print(String message){
        out.print(message);
    }

    public void println(){
        out.println();
    }

    public void println(String message){
        out.println(message);
    }
    public String getNextLine(){
       return scanner.next();
    }

}

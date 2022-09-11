package main;

import main.MainGUI.GraphicalUserInterface;

import java.awt.*;

public class Main {
    public static int HEIGHT = 300;
    public static int LENGTH = 300;

    public static void main(String[] args){
        var dimension = new Dimension(HEIGHT, LENGTH);
        var gui = new GraphicalUserInterface(dimension);
    }
}
package main;
import main.MainFrame.MyFrame;
import main.MainFrame.TextArea.MyTextPane;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static int HEIGHT = 300;
    public static int LENGTH = 300;

    public static void main(String[] args){
        var dimension = new Dimension(HEIGHT, LENGTH);
        var gui = new MyFrame(new MyTextPane(new JTextArea()), dimension);
    }
}
package main;
import main.Frontend.MainFrame.MyFrame;
import main.Frontend.MainFrame.TextArea.MyTextArea;
import main.Frontend.MainFrame.TextArea.MyTextPane;

import java.awt.*;

public class Main {
    public static int HEIGHT = 300;
    public static int LENGTH = 300;

    public static void main(String[] args){
        var dimension = new Dimension(HEIGHT, LENGTH);
        var textArea = new MyTextArea();
        var gui = new MyFrame(new MyTextPane(textArea), dimension);
    }
}
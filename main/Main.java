package main;
import main.Frontend.MainFrame;
import main.Frontend.MainPanel;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args){
        Component header = new JButton("header");
        Component main = new JButton("main");
        Component footer = new JButton("footer");

        var mainPanel = new MainPanel(header, main, footer);
        var mainFrame = new MainFrame(mainPanel);
    }
}
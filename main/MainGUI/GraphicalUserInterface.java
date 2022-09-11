package main.MainGUI;

import javax.swing.*;
import java.awt.*;

public class GraphicalUserInterface {
    private JFrame frame;

    public GraphicalUserInterface(Dimension dimension) {
        frame = new MyFrame(dimension);
        frame.setLayout(new BorderLayout());

        frame.add(new MyMenuBar(), BorderLayout.PAGE_START);
        frame.add(new JTextArea(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
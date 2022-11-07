package main.Frontend.Main;

import main.Frontend.ComponentTreeOperators.ComponentTreeIterator.DFSComponentIterator;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class MainFrame extends JFrame implements Iterable<Component> {
    public static int HEIGHT = 700;
    public static int WIDTH = 700;


    public MainFrame(Component main) {
        super("Light Text Editor");

        setSize();
        setLayout(main);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setSize() {
        var dimension = new Dimension(WIDTH, HEIGHT);
        super.setSize(dimension);
    }

    private void setLayout(Component main) {
        add(main);
    }

    @Override
    public Iterator<Component> iterator() {
        return new DFSComponentIterator(this);
    }
}
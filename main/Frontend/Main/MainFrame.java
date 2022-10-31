package main.Frontend.Main;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static int HEIGHT = 700;
    public static int WIDTH = 700;


    public MainFrame(Component main) {
        super();

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
}
package main.MainGUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class MyFrame extends JFrame {
    public MyFrame(MyTextPane textPane, MyMenuBar myMenuBar, Dimension dimension) {
        super();
        setSize(dimension);
        setLayout();
        setMenuBar(myMenuBar);
        setTextPane(textPane);

        setVisible(true);
    }

    private void setLayout() {
        setLayout(new BorderLayout());
    }

    private void setMenuBar(MyMenuBar myMenuBar) {
        add(myMenuBar, BorderLayout.PAGE_START);
    }

    private void setTextPane(MyTextPane textPane) {
        add(textPane, BorderLayout.CENTER);
    }

    private MyTextPane getTextPane() throws NullPointerException {
        var components = getContentPane().getComponents();

        MyTextPane textPane = null;
        for (Component component: components) {
            if (component instanceof MyTextPane)
                textPane = (MyTextPane) component;
        }
        if (textPane == null){
            throw new NullPointerException("Pane has not been initialized");
        }
        return textPane;
    }

    public void readIntoTextPane(InputStream input) throws NullPointerException, IOException {
        MyTextPane textPane = getTextPane();

        textPane.read(input);
    }
}
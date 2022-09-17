package main.MainGUI;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyTextPane extends JScrollPane {
    private JTextArea textArea;

    //TODO: refactor this
    public MyTextPane(JTextArea textArea) {
        super(textArea);
        this.textArea = textArea;
    }

    public void read(InputStream input) throws IOException {
        var in = new InputStreamReader(input);

        textArea.read(in,"Displayed Text");
    }
}

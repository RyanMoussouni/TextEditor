package main.MainGUI;

import javax.swing.*;
import javax.swing.text.Document;
import java.io.*;

public class MyTextPane extends JScrollPane {
    private JTextArea textArea;

    //TODO: refactor this
    public MyTextPane(JTextArea textArea) {
        super(textArea);
        this.textArea = textArea;
    }

    public void read(File f) throws IOException {
        var inputStream = new FileInputStream(f);
        var reader = new InputStreamReader(inputStream);

        textArea.read(reader, f);
    }

    public File getDisplayedFile(){
        var doc = textArea.getDocument();
        return (File) doc.getProperty(Document.StreamDescriptionProperty);
    }
}

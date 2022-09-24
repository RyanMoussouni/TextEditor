package main.MainGUI;

import main.Files.IMyFile;

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

    public void read(IMyFile clickedFile) throws IOException {
        var reader = clickedFile.getInputStreamReader();

        textArea.read(reader, clickedFile);
    }

    public IMyFile getDisplayedFile(){
        var doc = textArea.getDocument();
        return (IMyFile) doc.getProperty(Document.StreamDescriptionProperty);
    }

    public void saveDisplayedTextIntoFile() throws IOException {
        var f = getDisplayedFile();
        write(f);
    }

    public void write(IMyFile f) throws IOException {
        var writer = f.getOutputStreamWriter();
        textArea.write(writer);
    }
}

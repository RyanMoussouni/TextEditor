package main.MainFrame.TextArea;

import main.Files.IMyFile;
import main.PopUps.Replace.IReplaceComponent;
import main.PopUps.Search.ISearchComponent;

import javax.swing.*;
import javax.swing.text.Document;
import java.io.*;

public class MyTextPane extends JScrollPane {
    private MyTextArea textArea;
    private ISearchComponent _seachComponent;
    private IReplaceComponent _replaceComponent;

    //TODO: refactor this
    public MyTextPane(MyTextArea textArea) {
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

    public ISearchableTextArea getSearchableTextArea(){
        return textArea;
    }
}

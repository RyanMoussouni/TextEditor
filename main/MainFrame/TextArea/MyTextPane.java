package main.MainFrame.TextArea;

import main.Actions.ReplaceAction;
import main.Actions.SearchAction;
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
    private final String SEARCH_KEY = "meta F";
    private final String REPLACE_KEY = "meta shift F";

    //TODO: refactor this
    public MyTextPane(MyTextArea textArea) {
        super(textArea);

        setTextArea(textArea);
        setKeyBindings();
        setFocusable(true);
    }

    public void setTextArea(MyTextArea textArea) {
        this.textArea = textArea;
    }
    //TODO: Has side effects
    private void setKeyBindings() {
        var inputMap = this.getInputMap(JPanel.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        var actionMap = this.getActionMap();

        setSearchKeyBinding(inputMap, actionMap);
        setReplaceKeyBinding(inputMap, actionMap);
    }

    private void setSearchKeyBinding(InputMap inputMap, ActionMap actionMap){
        var searchAction = new SearchAction(textArea);
        var searchKeyStroke = KeyStroke.getKeyStroke(SEARCH_KEY);

        actionMap.put(SEARCH_KEY, searchAction);
        inputMap.put(searchKeyStroke, SEARCH_KEY);
    }

    private void setReplaceKeyBinding(InputMap inputMap, ActionMap actionMap){
        var replaceAction = new ReplaceAction();
        var replaceKeyStroke = KeyStroke.getKeyStroke(REPLACE_KEY);

        actionMap.put(REPLACE_KEY, replaceAction);
        inputMap.put(replaceKeyStroke, REPLACE_KEY);
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

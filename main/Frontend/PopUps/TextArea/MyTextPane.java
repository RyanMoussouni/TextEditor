package main.Frontend.PopUps.TextArea;

import main.Frontend.PopUps.Replace.ReplaceAction;
import main.Frontend.PopUps.Search.SearchAction;
import main.Backend.IO.IMyFile;
import main.Frontend.PopUps.Replace.IReplaceComponent;
import main.Frontend.PopUps.Search.ISearchComponent;

import javax.swing.*;
import javax.swing.text.Document;
import java.io.*;

public class MyTextPane extends JScrollPane {
    private MyTextArea _textArea;
    private ISearchComponent _seachComponent;
    private IReplaceComponent _replaceComponent;
    //TODO: find out where the best way to put this; it seems to be configuration; i'd say in properties as it is a configuration file
    private final String SEARCH_KEY = "meta F";
    private final String REPLACE_KEY = "meta shift F";

    //TODO: refactor this
    public MyTextPane(MyTextArea textArea) {
        super(textArea);

        set_textArea(textArea);
        setKeyBindings();
        setFocusable(true);
    }

    public void set_textArea(MyTextArea _textArea) {
        this._textArea = _textArea;
    }
    //TODO: Has side effects
    private void setKeyBindings() {
        var inputMap = this.getInputMap(JPanel.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        var actionMap = this.getActionMap();

        setSearchKeyBinding(inputMap, actionMap);
        setReplaceKeyBinding(inputMap, actionMap);
    }

    private void setSearchKeyBinding(InputMap inputMap, ActionMap actionMap){
        var searchAction = new SearchAction(_textArea);
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

        _textArea.read(reader, clickedFile);
    }

    public IMyFile getDisplayedFile(){
        var doc = _textArea.getDocument();
        return (IMyFile) doc.getProperty(Document.StreamDescriptionProperty);
    }

    public void saveDisplayedTextIntoFile() throws IOException {
        var f = getDisplayedFile();
        write(f);
    }

    public void write(IMyFile f) throws IOException {
        var writer = f.getOutputStreamWriter();
        _textArea.write(writer);
    }

    public ISearchableTextArea getSearchableTextArea(){
        return _textArea;
    }
}

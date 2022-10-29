package main.Frontend.PopUps.Search;

import main.Frontend.MainFrame.TextArea.ISearchableTextArea;
import main.Frontend.PopUps.Search.JSearchPopUpFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SearchAction extends AbstractAction {
    ISearchableTextArea _textArea;
    public SearchAction(ISearchableTextArea textArea){
        _textArea = textArea;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new JSearchPopUpFrame(_textArea);
    }
}

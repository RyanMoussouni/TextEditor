package main.Actions;

import main.MainFrame.TextArea.ISearchableTextArea;
import main.PopUps.Search.JSearchPopUpFrame;

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

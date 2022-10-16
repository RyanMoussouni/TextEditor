package main.PopUps.Search;

import main.MainFrame.TextArea.ISearchableTextArea;

import javax.swing.*;

public class JSearchPopUp extends JComponent implements ISearchComponent {
    private final ISearchableTextArea _textAreaToSearch;
    private JTextArea _userInputTextArea;

    public JSearchPopUp(ISearchableTextArea textArea){
        _textAreaToSearch = textArea;

        SetUserInputTextArea();
        CreateButton();
    }

    private void SetUserInputTextArea(){
        _userInputTextArea = new JTextArea();
    }

    private void CreateButton(){
        new JSearchButton(this);
    }

    @Override
    public void OnUserSearchRequest() {
        var userInputText = _userInputTextArea.getText();
        _textAreaToSearch.Search(userInputText);
    }
}

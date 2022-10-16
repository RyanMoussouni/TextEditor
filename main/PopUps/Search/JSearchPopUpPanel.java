package main.PopUps.Search;

import main.MainFrame.TextArea.ISearchableTextArea;

import javax.swing.*;

public class JSearchPopUpPanel extends JPanel implements ISearchComponent {
    private final ISearchableTextArea _textAreaToSearch;
    private JTextArea _userInputTextArea;

    public JSearchPopUpPanel(ISearchableTextArea textArea){
        super();
        _textAreaToSearch = textArea;

        SetUserInputTextArea();
        CreateButton();
    }

    private void SetUserInputTextArea(){
        _userInputTextArea = new JTextArea();
        this.add(_userInputTextArea);
    }

    private void CreateButton(){
        var searchButton = new JSearchButton(this);
        this.add(searchButton);
    }

    @Override
    public void OnUserSearchRequest() {
        var userInputText = _userInputTextArea.getText();
        _textAreaToSearch.Search(userInputText);
    }
}

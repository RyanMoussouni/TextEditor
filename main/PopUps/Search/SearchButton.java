package main.PopUps.Search;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchButton extends JButton {
    private static final String BUTTON_TEXT = "Search";
    private ISearchComponent _searchComponent;

    SearchButton(ISearchComponent searchComponent){
        super(BUTTON_TEXT);
        _searchComponent = searchComponent;

        var searchActionListener = GetSearchActionListener();
        SetActionListener(searchActionListener);
    }

    private ActionListener GetSearchActionListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _searchComponent.OnUserSearchRequest();
            }
        };
    }

    private void SetActionListener(ActionListener searchActionListener){
        this.addActionListener(searchActionListener);
    }
}

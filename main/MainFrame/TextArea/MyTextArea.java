package main.MainFrame.TextArea;

import main.MainFrame.IMatchElement;
import main.PopUps.Search.SearchKeyListener;

import javax.swing.*;

public class MyTextArea extends JTextArea implements ISearchableTextArea{
   public MyTextArea(){
       addSearchKeyListener();
   }

    @Override
    public IMatchElement Search(String toSearch) {
        System.out.println("Unhandled");
        return null;
    }

    private void addSearchKeyListener(){
        var searchKeyListener = new SearchKeyListener(this);

        addKeyListener(searchKeyListener);
    }
}

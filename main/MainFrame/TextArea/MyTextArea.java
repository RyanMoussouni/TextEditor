package main.MainFrame.TextArea;

import main.Matches.IMatchElement;

import javax.swing.*;

public class MyTextArea extends JTextArea implements ISearchableTextArea{
   public MyTextArea(){
   }

    @Override
    public IMatchElement Search(String toSearch) {
        System.out.println("Unhandled");
        return null;
    }
}

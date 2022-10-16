package main.MainFrame.TextArea;

import main.MainFrame.IMatchElement;

import javax.swing.*;

public class MyTextArea extends JTextArea implements ISearchableTextArea{
    @Override
    public IMatchElement Search(String toSearch) {
        System.out.println("Unhandled");
        return null;
    }
}

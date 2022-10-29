package main.Frontend.PopUps.Search;

import main.Frontend.PopUps.TextArea.ISearchableTextArea;

import javax.swing.*;
import java.awt.*;

public class JSearchPopUpFrame extends JFrame {
    private ISearchableTextArea _textArea;
    private final int HEIGHT = 100;
    private final int WIDTH = 200;

    public JSearchPopUpFrame(ISearchableTextArea textArea){
        super();

        set_textArea(textArea);
        setSize();
        setLayout();
        setPanel();

        setVisible(true);
    }

    private void set_textArea(ISearchableTextArea textArea) {
        _textArea = textArea;
    }

    private void setSize() {
        var frameDimension = new Dimension(HEIGHT, WIDTH);
        setSize(frameDimension);
    }

    private void setLayout(){
        var layout = new BorderLayout();
        setLayout(layout);
    }

    private void setPanel(){
        var panel = new JSearchPopUpPanel(_textArea);
        this.add(panel);
    }
}

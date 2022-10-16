package main.PopUps.Search;

import main.MainFrame.MyFrame;
import main.MainFrame.TextArea.ISearchableTextArea;

import javax.swing.*;
import java.awt.*;

public class JSearchPopUpFrame extends JFrame {
    private ISearchableTextArea textArea;
    private final int HEIGHT = 100;
    private final int WIDTH = 200;

    public JSearchPopUpFrame(ISearchableTextArea textArea){
        super();

        setSize();
        setLayout();
        setPanel();

        setVisible(true);
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
        var panel = new JSearchPopUpPanel(textArea);
        this.add(panel);
    }
}

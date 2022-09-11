package main.PopUpGUI.Vue;


import main.Files.MyFile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PopUpFrame extends JFrame {
    private final int WIDTH = 300;
    private final int HEIGHT = 300;

    private MyTable filesTable;
    private final int numRows = 12;
    private final int numColumns = 4;

    public PopUpFrame(){
        this.setSize(new Dimension(WIDTH, HEIGHT));

        setMainPanel();
        this.setVisible(true);
    }

    private void setMainPanel(){
            JPanel mainPanel = new JPanel();
            filesTable = new MyTable();
            mainPanel.add(filesTable);

            this.add(mainPanel, BorderLayout.CENTER);
    }

    public void update(ArrayList<MyFile> files){
        filesTable.updateDisplayedFiles(files);
    }
}

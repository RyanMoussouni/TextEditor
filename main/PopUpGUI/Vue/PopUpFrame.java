package main.PopUpGUI.Vue;

import main.Files.MyFile;
import main.MainGUI.MyFrame;
import main.MainGUI.MyTextPane;
import main.PopUpGUI.Model.FileExplorer;
import main.PopUpGUI.PopUpController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PopUpFrame extends JFrame {
    private final int WIDTH = 300;
    private final int HEIGHT = 300;

    private MyTable filesTable;

    public static void main(String[] args){
        var popUpFrame = new PopUpFrame();
        var fileExplorer = new FileExplorer();
        var dimension = new Dimension(400, 400);
        var gui = new MyFrame(new MyTextPane(new JTextArea()), dimension);
        var popUpController = new PopUpController(gui, popUpFrame, fileExplorer);

        var files = new ArrayList<>(
                Arrays.asList(
                        new MyFile("/", "Users", true),
                        new MyFile("/", "blabla", true)
                )
        );
        popUpFrame.update(files);
        popUpFrame.addMouseClickEventListener(popUpController);
    }

    public PopUpFrame(){
        this.setSize(new Dimension(WIDTH, HEIGHT));

        setMainPanel();
        this.setVisible(true);
    }

    //TODO: refactor this, these operations should be (?, to confirm) the responsibility of the mainPanel
    private void setMainPanel(){
            JPanel mainPanel = new JPanel();
            filesTable = new MyTable();
            mainPanel.add(filesTable);

            this.add(mainPanel, BorderLayout.CENTER);
    }

    public void addMouseClickEventListener(MouseListener e){
        filesTable.addMouseListener(e);
    }

    public void update(List<MyFile> files)
    {
        filesTable.updateDisplayedFiles(files);
    }

    public MyFile getClickedFile() {
        return filesTable.getClickedFile();
    }

    public boolean isClickedFileDirectory() {
        var clickedFile = getClickedFile();
        return clickedFile.isDirectory();
    }
}

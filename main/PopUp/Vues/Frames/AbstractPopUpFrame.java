package main.PopUp.Vues.Frames;

import main.Files.IMyFile;
import main.PopUp.Vues.MyTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.util.List;

public abstract class AbstractPopUpFrame extends JFrame {
    private final int WIDTH = 300;
    private final int HEIGHT = 300;
    private MyTable filesTable;

    public AbstractPopUpFrame(){
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

    public void update(List<IMyFile> files)
    {
        filesTable.updateDisplayedFiles(files);
    }

    public IMyFile getClickedFile() {
        return filesTable.getClickedFile();
    }

    public boolean isClickedFileDirectory() {
        var clickedFile = getClickedFile();
        return clickedFile.isDirectory();
    }

    public void close() {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}

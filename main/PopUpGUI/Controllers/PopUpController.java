package main.PopUpGUI.Controllers;

import main.MainGUI.MyFrame;
import main.PopUpGUI.Model.IFileExplorer;
import main.PopUpGUI.Vues.Open.PopUpFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

public class PopUpController implements MouseListener {
    private MyFrame mainFrame;
    private PopUpFrame popUpFrame;
    private IFileExplorer fileExplorer;

    public PopUpController(MyFrame mainFrame, PopUpFrame popUpFrame, IFileExplorer fileExplorer){
        this.mainFrame = mainFrame;
        this.popUpFrame = popUpFrame;
        this.fileExplorer = fileExplorer;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        var doubleClick = e.getClickCount() == 2;
        var isClickedFileDirectory = popUpFrame.isClickedFileDirectory();

        if(doubleClick && isClickedFileDirectory){
            var clickedDirectory = popUpFrame.getClickedFile();
            var currentDirectorySubFiles = fileExplorer.getSubFiles(clickedDirectory);
            popUpFrame.update(currentDirectorySubFiles);
        }

        //TODO: refactor this, the MyFileObject should give the FileInputStream
        if(doubleClick && !isClickedFileDirectory){
            var clickedFile = popUpFrame.getClickedFile();
            var path = String.format("%s/%s", clickedFile.parentPath(), clickedFile.name());
            var f = new File(path);

            try {
                mainFrame.readIntoTextPane(f);
            } catch (NullPointerException | IOException ex) {
                ex.printStackTrace();
            }
            popUpFrame.close();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}

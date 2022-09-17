package main.PopUpGUI;

import main.PopUpGUI.Model.IFileExplorer;
import main.PopUpGUI.Vue.PopUpFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PopUpController implements MouseListener {
    /* TODO: imp comportement d'attente */
    private PopUpFrame popUpFrame;
    private IFileExplorer fileExplorer;

    public PopUpController(PopUpFrame popUpFrame, IFileExplorer fileExplorer){
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

        if(doubleClick && !isClickedFileDirectory){

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

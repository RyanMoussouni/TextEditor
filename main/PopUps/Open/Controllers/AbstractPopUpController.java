package main.PopUps.Open.Controllers;

import main.MainFrame.MyFrame;
import main.PopUps.Open.Model.IFileExplorer;
import main.PopUps.Open.Vues.Frames.AbstractPopUpFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class AbstractPopUpController implements MouseListener {
    protected MyFrame mainFrame;
    protected AbstractPopUpFrame popUpFrame;
    protected IFileExplorer fileExplorer;

    public AbstractPopUpController(MyFrame mainFrame, AbstractPopUpFrame abstractPopUpFrame, IFileExplorer fileExplorer){
        this.mainFrame = mainFrame;
        this.popUpFrame = abstractPopUpFrame;
        this.fileExplorer = fileExplorer;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        var doubleClick = isDoubleClick(e);
        var isClickedFileDirectory = isClickedFileDirectory();

        if(doubleClick && isClickedFileDirectory){
            updateDisplayedFiles();
        }

        if(doubleClick && !isClickedFileDirectory){
            doubleClickOnFile();
        }
    }

    protected boolean isDoubleClick(MouseEvent e){
        return e.getClickCount() == 2;
    }

    protected boolean isClickedFileDirectory(){
        return popUpFrame.isClickedFileDirectory();
    }

    protected void updateDisplayedFiles(){
        var clickedDirectory = popUpFrame.getClickedFile();
        var currentDirectorySubFiles = fileExplorer.getSubFiles(clickedDirectory);

        popUpFrame.update(currentDirectorySubFiles);
    }

    protected abstract void doubleClickOnFile();

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}

package main.PopUps.Open.Controllers;

import main.MainFrame.MyFrame;
import main.PopUps.Open.Model.IFileExplorer;
import main.PopUps.Open.Vues.Frames.OpenPopUpFrame;

import java.io.IOException;

public class OpenPopUpController extends AbstractPopUpController{

    public OpenPopUpController(MyFrame mainFrame, OpenPopUpFrame openPopUpFrame, IFileExplorer fileExplorer) {
        super(mainFrame, openPopUpFrame, fileExplorer);
    }

    @Override
    protected void doubleClickOnFile(){
        var clickedFile = popUpFrame.getClickedFile();

        try {
            mainFrame.readIntoTextPane(clickedFile);
        } catch (NullPointerException | IOException ex) {
            ex.printStackTrace();
        }
        popUpFrame.close();
    }
}

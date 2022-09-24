package main.PopUp.Controllers;

import main.MainFrame.MyFrame;
import main.PopUp.Model.IFileExplorer;
import main.PopUp.Vues.Frames.OpenPopUpFrame;

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

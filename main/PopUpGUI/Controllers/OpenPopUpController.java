package main.PopUpGUI.Controllers;

import main.MainGUI.MyFrame;
import main.PopUpGUI.Model.IFileExplorer;
import main.PopUpGUI.Vues.Frame.OpenPopUpFrame;

import java.io.File;
import java.io.IOException;

public class OpenPopUpController extends AbstractPopUpController{

    public OpenPopUpController(MyFrame mainFrame, OpenPopUpFrame openPopUpFrame, IFileExplorer fileExplorer) {
        super(mainFrame, openPopUpFrame, fileExplorer);
    }

    @Override
    protected void doubleClickOnFile() {
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

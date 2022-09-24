package main.PopUpGUI.Controllers;

import main.MainGUI.MyFrame;
import main.PopUpGUI.Model.IFileExplorer;
import main.PopUpGUI.Vues.Frames.AbstractPopUpFrame;

public class SavePopUpController extends AbstractPopUpController{

    public SavePopUpController(MyFrame mainFrame, AbstractPopUpFrame abstractPopUpFrame, IFileExplorer fileExplorer) {
        super(mainFrame, abstractPopUpFrame, fileExplorer);
    }

    @Override
    protected void doubleClickOnFile() {
        //TODO: for now, does nothing but in the future should display ....
    }
}

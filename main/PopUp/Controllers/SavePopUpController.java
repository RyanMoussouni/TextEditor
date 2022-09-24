package main.PopUp.Controllers;

import main.MainFrame.MyFrame;
import main.PopUp.Model.IFileExplorer;
import main.PopUp.Vues.Frames.AbstractPopUpFrame;

public class SavePopUpController extends AbstractPopUpController{

    public SavePopUpController(MyFrame mainFrame, AbstractPopUpFrame abstractPopUpFrame, IFileExplorer fileExplorer) {
        super(mainFrame, abstractPopUpFrame, fileExplorer);
    }

    @Override
    protected void doubleClickOnFile() {
        //TODO: for now, does nothing but in the future should display ....
    }
}

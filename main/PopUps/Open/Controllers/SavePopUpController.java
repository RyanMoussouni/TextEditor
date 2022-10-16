package main.PopUps.Open.Controllers;

import main.MainFrame.MyFrame;
import main.PopUps.Open.Model.IFileExplorer;
import main.PopUps.Open.Vues.Frames.AbstractPopUpFrame;

public class SavePopUpController extends AbstractPopUpController{

    public SavePopUpController(MyFrame mainFrame, AbstractPopUpFrame abstractPopUpFrame, IFileExplorer fileExplorer) {
        super(mainFrame, abstractPopUpFrame, fileExplorer);
    }

    @Override
    protected void doubleClickOnFile() {
        //TODO: for now, does nothing but in the future should display ....
    }
}
